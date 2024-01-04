package wargaming_api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

import javax.swing.JOptionPane;

public class WargamingAPI {
	
    private final static Logger logger = LogManager.getLogger(WargamingAPI.class);
    
    
    private static final String [] RESPONSE_FIELDS = {
            "statistics.all.battles",
            "statistics.all.wins",
            "statistics.all.draws",
            "statistics.all.losses",
            "statistics.all.survived_battles",
            "statistics.all.frags",
            "statistics.all.spotted",
            "statistics.all.damage_dealt",
            "statistics.all.max_frags",
            "statistics.all.max_xp",
            "statistics.all.max_damage",
            "statistics.all.damage_received",
            "statistics.all.hits",
            "statistics.all.avg_damage_assisted",
            "statistics.all.battles_on_stunning_vehicles",
            "statistics.all.battle_avg_xp",
            "statistics.all.xp",
            "statistics.all.capture_points",
            "statistics.all.shots",
            "statistics.all.piercings"
            };
    
    private static final String API_URL_USER_ID = "https://api.worldoftanks.eu/wot/account/list/?application_id=636b76a3b5bd1b0812f0f34df886fe67";
    private static final String API_URL_STATISTICS = "https://api.worldoftanks.eu/wot/account/info/?application_id=636b76a3b5bd1b0812f0f34df886fe67";
    
    public static int getUserId(String username) {
    	
        try {            	
        	URL url = null;
            try {
                url = new URI(API_URL_USER_ID + "&search=" + username).toURL();
            } catch (URISyntaxException e) {
                logger.error("URI error");
                logger.error(e);
            } catch (MalformedURLException e) {
                logger.error("URI to URL error");
                logger.error(e);
            }
            
            if (url == null) {
            	return 1;
            }
            // Answer from API.
            try {
	            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	            connection.setRequestMethod("GET");
	            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	            StringBuilder response = new StringBuilder();
	            String line;
	            while ((line = reader.readLine()) != null) {
	                response.append(line);
	            }
	            
	            reader.close();
                connection.disconnect();
                
                String responseString = response.toString();
                if (responseString.contains("error")) {
                	logger.error("Error retrieving data");
                	JOptionPane.showMessageDialog(null, "Data not found.");
                	return 1;
                }
                
                logger.info("Response: " + response);
                
                //Extract account ID
                try {
    		        JSONObject jsonResponse = new JSONObject(responseString);
    		        JSONArray data = jsonResponse.getJSONArray("data");
    		        JSONObject userData = data.getJSONObject(0);
    		        int accountId = userData.getInt("account_id");
    		        	
    		        logger.info("Success retrieving accountID");
    		        return accountId;   
                } catch (JSONException e) {
                	logger.error("Data not found");
                	logger.error(e);
                	JOptionPane.showMessageDialog(null, "Data not found.");
                }
            } catch (UnknownHostException e) {
            	logger.error("Error: No internet connection");
            	logger.error(e);
            	JOptionPane.showMessageDialog(null, "No internet connection.");
            } 
        } catch (IOException e){
            logger.error("URL incorrect");
            logger.error(e);
        }
        return 1;
    }

    public static String [] getStats(int user_id) {
    	
        String [] stats = new String[RESPONSE_FIELDS.length];
        
        try {
            URL url = null;
            try {
                StringBuilder urlStringBuilder = new StringBuilder(API_URL_STATISTICS + "&account_id=" + user_id + "&fields=");

                for (int i = 0; i < RESPONSE_FIELDS.length; i++) {
                    urlStringBuilder.append(RESPONSE_FIELDS[i]);
                    if (i < RESPONSE_FIELDS.length - 1) {
                        urlStringBuilder.append("%2C");
                    }
                }
                
                URI uri = new URI(urlStringBuilder.toString());
                url = uri.toURL();
                
                logger.info("Connected to " + url);
                
            } catch (URISyntaxException e) {
                logger.error(e);
            } catch (MalformedURLException e) {
                logger.error(e);
            }
            
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();

            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            
            reader.close();
            connection.disconnect();
            
            String responseString = response.toString();
            if (responseString.contains("error")) {
            	logger.error("Error retrieving user ID");
            	JOptionPane.showMessageDialog(null, "Error retrieving user ID");
            	return null;
            }

            // Extract stats.
            try {
                JSONObject jsonResponse = new JSONObject(responseString);
                JSONObject data = jsonResponse.getJSONObject("data");
                JSONObject userData = data.getJSONObject(String.valueOf(user_id));
                JSONObject statistics = userData.getJSONObject("statistics");
                JSONObject allStats = statistics.getJSONObject("all");

                int index = 0;
                for (String parameter:RESPONSE_FIELDS) {
                    stats[index] = String.valueOf(allStats.getInt(parameter.replace("statistics.all.", "")));
                    index++;
                }

                logger.info("Success retrieving stats");
                return stats;
                
            } catch (JSONException e) {
            	logger.error(e);
            }
        } catch (IOException e) {
            logger.error(e);
        }
        return stats;
    }
}
