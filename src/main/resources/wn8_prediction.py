#!/usr/bin/env python
# coding: utf-8

# In[64]:


import pandas as pd
import matplotlib.pyplot as plt
import json
import pickle


# In[65]:

plotsPath = 'plots/'
statsPath = 'statistics.json'
modelPath = 'model.pkl'
wn8FilePath = 'estimatedWN8.txt'

# In[66]:


try:
    with open(statsPath, 'r') as statsFile:
        userStatsString = statsFile.read()
    userStatsDict = json.loads(userStatsString)
except FileNotFoundError as fnfError:
    print(fnfError)
    raise FileNotFoundError


# In[67]:


statsSeries = pd.DataFrame.from_dict(data=userStatsDict, orient='index')


# In[68]:


statsSeries = statsSeries.T


# In[69]:


def addFeatures(df):
    df['win_ratio'] = df['wins']/df['battles']
    df['lose_ratio'] = df['losses']/df['battles']
    df['accuracy'] = df['hits']/df['shots']
    df['efficiency'] = df['piercings']/df['hits']
    df['frags_per_battle'] = df['frags']/df['battles']
    df['cap_points_per_battle'] = df['capture_points']/df['battles']
    df['damage_dealt_per_battle'] = df['damage_dealt']/df['battles']
    df['survival_rate'] = df['survived_battles']/df['battles']
    df['spots_per_battle'] = df['spotted']/df['battles']
    
    return df

statsSeries = addFeatures(statsSeries)
plotData = statsSeries.copy()


# In[70]:


def dropIrrelevantCols(df, cols):
    return df.drop(columns=cols)
statsSeries = dropIrrelevantCols(statsSeries, ['battles_on_stunning_vehicles', 'hits', 'draws', 'wins', 'losses', 'capture_points', 'piercings', 'shots', 'max_frags', 'max_damage', 'max_xp', 'spotted', 'damage_dealt', 'damage_received'])


# In[71]:


def convertColsToFloat(df, cols):
    for column in cols:
        try:
            df[column] = df[column].astype(float)
        except:
            df[column] = df[column].str.replace(',', '.')
            df[column] = df[column].astype(float)
            
    return df
statsSeries = convertColsToFloat(statsSeries, list(statsSeries.columns))


# In[72]:


try:
    with open(modelPath, 'rb') as modelFile:
        model = pickle.load(modelFile)
except FileNotFoundError as fnfError:
    print(fnfError)
    raise FileNotFoundError


# In[73]:


wn8_pred = model.predict(statsSeries)
try:
    with open(wn8FilePath, 'w') as wn8File:
        wn8File.write(str(round(wn8_pred[0], 2)))
except FileNotFoundError as fnfError:
    print(fnfError)
    raise FileNotFoundError


# In[74]:


wins_losses = plotData.loc[:, ['wins', 'losses', 'draws']].T
wins_losses.index = ['Wins', 'Losses', 'Draws']
wins_losses.columns = ['Battles']
wins_losses.plot(kind='pie',
                 y='Battles',
                 autopct='%.2f%%',
                 colors=['#5aa65f', '#cc4b31', '#8a8483'],
                 figsize=(10,6))
plt.savefig(plotsPath + 'fig_1.png')


# In[90]:


battles = plotData.loc[:, ['survived_battles']]
battles['fallen_battles'] = plotData['battles'] - plotData['survived_battles']
battles = battles.T
battles.index = ['Survived Battles', 'Fallen Battles']
battles.columns = ['Battles']
battles.plot(kind='pie',
             y='Battles',
             autopct='%.2f%%',
             colors=['#edbc1c', '#8a8483'],
             figsize=(10,6))
plt.savefig(plotsPath + 'fig_2.png')


# In[105]:


stats_per_battle = plotData.loc[:, ['frags_per_battle', 'spots_per_battle', 'cap_points_per_battle']]
stats_per_battle.index = ['']
stats_per_battle.columns = ['Frags per battle', 'Spots per battle', 'Cap points per battle']
stats_per_battle.plot(kind='bar',
                      color=['#c92418', '#2a751c', '#21708a'],
                      figsize=(10,6))
plt.savefig(plotsPath + 'fig_3.png')


# In[112]:


shots = plotData.loc[:, ['shots', 'hits', 'piercings']]
shots.index = ['']
shots.columns = ['Shots', 'Hits', 'Penetrations']
shots.plot(kind='bar',
           color=['#96b895', '#608f5e', '#1c4f1a'])
plt.savefig(plotsPath + 'fig_4.png')
