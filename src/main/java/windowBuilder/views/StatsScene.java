package windowBuilder.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import wargaming_api.WargamingAPI;
import wargaming_api.Wn8Color;
import wargaming_api.Wn8Scrapper;

public class StatsScene {
	
	private final static Logger logger = LogManager.getLogger(StatsScene.class);
	
	private JFrame frame;
	
	private ImageIcon backgroundIcon;
	private JLabel background;
	private JLabel lblHeader;
	
	private JLabel lblBattles;
	private JLabel lblWins;
	private JLabel lblDraws;
	private JLabel lblLoses;
	private JLabel lblSurvived;
	private JLabel lblSpotted;
	private JLabel lblDamageDealt;
	private JLabel lblMaxFrags;
	private JLabel lblMaxXp;
	private JLabel lblMaxDamage;
	private JLabel lblDamageReceived;
	private JLabel lblHits;
	private JLabel lblAverageAssist;
	private JLabel lblArtilleryBattles;
	private JLabel lblAverageXp;
	private JLabel lblShots;
	private JLabel lblPiercings;
	private JLabel lblCapturePoints;
	private JLabel lblAllXp;
	private JLabel lblFrags;
	
	private JLabel lblEstimatedWn8;
	private JLabel lblWn8;
	
	private JLabel lblBattlesIcon;
	private JLabel lblBestIcon;
	private JLabel lblShotsIcon;
	private JLabel lblAverageIcon;
	private JLabel lblWn8Icon;
	
	private JButton btnNewPlayer;
	private JButton btnQuit;
	private JButton btnShowDiagrams;
	
	
	public StatsScene(String username) {
		logger.info("Opening statistics window for player" + username);
		initComponents(username);
		createEvents();
	}

	private void initComponents(String username) {
		frame = new JFrame();
		
		backgroundIcon = new ImageIcon(this.getClass().getResource("/windowBuilder/resources/background.png"));
		background = new JLabel(backgroundIcon);
		background.setSize(1200, 700);
		
		//======================ICONS=======================
		// Left side icons.
		lblBattlesIcon = new JLabel();
		lblBattlesIcon.setIcon(new ImageIcon(StatsScene.class.getResource("/windowBuilder/resources/battles_128.png")));
		lblBattlesIcon.setBounds(60, 120, 128, 128);
		frame.add(lblBattlesIcon);

		lblShotsIcon = new JLabel();
		lblShotsIcon.setIcon(new ImageIcon(StatsScene.class.getResource("/windowBuilder/resources/shots_128.png")));
		lblShotsIcon.setBounds(60, 300, 128, 128);
		frame.add(lblShotsIcon);
		
		lblAverageIcon = new JLabel();
		lblAverageIcon.setIcon(new ImageIcon(StatsScene.class.getResource("/windowBuilder/resources/average_128.png")));
		lblAverageIcon.setBounds(60, 480, 128, 128);
		frame.add(lblAverageIcon);
		
		// Right side icons.
		lblBestIcon = new JLabel();
		lblBestIcon.setIcon(new ImageIcon(StatsScene.class.getResource("/windowBuilder/resources/best_128.png")));
		lblBestIcon.setBounds(690, 120, 128, 128);
		frame.add(lblBestIcon);
		
		lblWn8Icon = new JLabel();
		lblWn8Icon.setIcon(new ImageIcon(StatsScene.class.getResource("/windowBuilder/resources/wins_128.png")));
		lblWn8Icon.setBounds(690, 300, 128, 128);
		frame.add(lblWn8Icon);
		
		// HEADER LABEL.
		int ID = WargamingAPI.getUserId(username);
		if (ID == 1) {
			return;
		}
		lblHeader = new JLabel("hateStats for " + username + " (ID: " + ID + ")");
		lblHeader.setFont(new Font("Stencil", Font.BOLD, 40));
		lblHeader.setBounds(100, 40, 1200, 40);
		lblHeader.setForeground(Color.BLACK);
		frame.add(lblHeader);
		
		//======================LABELS=======================
		
		lblBattles = new JLabel("Battles:");
		lblBattles.setBounds(220, 120, 200, 25);
		frame.add(lblBattles);
		
		lblWins = new JLabel("Wins:");
		lblWins.setBounds(220, 150, 300, 25);
		frame.add(lblWins);
		
		lblDraws = new JLabel("Draws:");
		lblDraws.setBounds(220, 180, 300, 25);
		frame.add(lblDraws);
		
		lblLoses = new JLabel("Loses:");
		lblLoses.setBounds(220, 210, 300, 25);
		frame.add(lblLoses);
		
		lblSurvived = new JLabel("Survived:");
		lblSurvived.setBounds(220, 240, 300, 25);
		frame.add(lblSurvived);
		
		lblFrags = new JLabel("Frags:");
		lblFrags.setBounds(220, 270, 300, 25);
		frame.add(lblFrags);
		
		lblSpotted = new JLabel("Spotted:");
		lblSpotted.setBounds(220, 300, 300, 25);
		frame.add(lblSpotted);
		
		lblDamageDealt = new JLabel("Damage dealt:");
		lblDamageDealt.setBounds(220, 330, 300, 25);
		frame.add(lblDamageDealt);

		lblDamageReceived = new JLabel("Damage received:");
		lblDamageReceived.setBounds(220, 360, 300, 25);
		frame.add(lblDamageReceived);

		lblHits = new JLabel("Hits:");
		lblHits.setBounds(220, 390, 300, 25);
		frame.add(lblHits);
		
		lblAverageAssist = new JLabel("Average assist:");
		lblAverageAssist.setBounds(220, 420, 300, 25);
		frame.add(lblAverageAssist);
		
		lblArtilleryBattles = new JLabel("Artillery battles:");
		lblArtilleryBattles.setBounds(220, 450, 300, 25);
		frame.add(lblArtilleryBattles);
		
		lblAverageXp = new JLabel("Average xp:");
		lblAverageXp.setBounds(220, 480, 300, 25);
		frame.add(lblAverageXp);
		
		lblAllXp = new JLabel("All XP:");
		lblAllXp.setBounds(220, 510, 300, 25);
		frame.add(lblAllXp);
		
		lblCapturePoints = new JLabel("Capture points:");
		lblCapturePoints.setBounds(220, 540, 300, 25);
		frame.add(lblCapturePoints);
		
		lblShots = new JLabel("Shots:");
		lblShots.setBounds(220, 570, 300, 25);
		frame.add(lblShots);
		
		lblPiercings = new JLabel("Piercings:");
		lblPiercings.setBounds(220, 600, 300, 25);
		frame.add(lblPiercings);
		
		// MAX LABELS (RIGHT SIDE OF THE WINDOW).
		lblMaxFrags = new JLabel("Max frags:");
		lblMaxFrags.setBounds(850, 150, 200, 25);
		frame.add(lblMaxFrags);
		
		lblMaxXp = new JLabel("Max XP:");
		lblMaxXp.setBounds(850, 180, 200, 25);
		frame.add(lblMaxXp);
		
		lblMaxDamage = new JLabel("Max damage:");
		lblMaxDamage.setBounds(850, 210, 200, 25);
		frame.add(lblMaxDamage);
		
		// WN8 LABELS
		lblWn8 = new JLabel("WN8:");
		lblEstimatedWn8 = new JLabel("Estimated WN8:");
		double wn8_raw = Wn8Scrapper.getWN8(username);
		String wn8 = Double.toString(wn8_raw);
		Color color = Wn8Color.getColor(wn8_raw);
		
		lblWn8.setText(lblWn8.getText() + " " + wn8);
		lblWn8.setFont(new Font("Stencil", Font.BOLD, 25));
		lblWn8.setForeground(color);
		lblWn8.setBounds(830, 300, 200, 25);
		frame.add(lblWn8);
		
		// ============================TO DOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO
		lblEstimatedWn8.setBounds(830, 330, 300, 25);
		lblEstimatedWn8.setFont(new Font("Stencil", Font.BOLD, 25));
		lblEstimatedWn8.setForeground(Color.BLACK);
		frame.add(lblEstimatedWn8);
		
		// Create labels array for adding stats purpose.
		JLabel[] labels = new JLabel []{
			 	lblBattles,
			    lblWins,
			    lblDraws,
			    lblLoses,
			    lblSurvived,
			    lblFrags,
			    lblSpotted,
			    lblDamageDealt,
			    lblMaxFrags,
			    lblMaxXp,
			    lblMaxDamage,
			    lblDamageReceived,
			    lblHits,
			    lblAverageAssist,
			    lblArtilleryBattles,
			    lblAverageXp,
			    lblAllXp,
			    lblCapturePoints,
			    lblShots,
			    lblPiercings, 
		};
		
		// Setting font for all statistic labels.
		for (int i = 0; i < labels.length; i++) {
			labels[i].setFont(new Font("Stencil", Font.PLAIN, 20));
			labels[i].setForeground(Color.BLACK);
		}
		
		// Retrieve stats.
		String [] stats = WargamingAPI.getStats(ID);
		
		// Adding stats to labels.
		for (int i = 0; i < stats.length; i++) {
			String tmp = labels[i].getText();
			labels[i].setText(tmp + " " + stats[i]);
		}
		
		// Buttons.
		btnShowDiagrams = new JButton("Show diagrams");
		btnShowDiagrams.setBounds(760, 600, 150, 30);
		frame.add(btnShowDiagrams);
		
		btnNewPlayer = new JButton("New player");
		btnNewPlayer.setBounds(930, 600, 100, 30);
		frame.add(btnNewPlayer);
		
		btnQuit = new JButton("Quit");
		btnQuit.setBounds(1050, 600, 100, 30);
		frame.add(btnQuit);
		
		// Frame settings.
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/windowBuilder/resources/stats_128.png")));
		frame.setTitle("hateStats");
		frame.add(background);
		frame.setResizable(false);
		frame.setBounds(100, 100, 1200, 700);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);	
	}	
	
	private void createEvents() {
		
		if (btnNewPlayer == null || btnNewPlayer == null) {
			return;
		}
		
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		btnNewPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new UsernameScene();
			}
		});	
	}
	
	public static void setVisible() {
		
	}
	public static void main(String[] args) {
		new StatsScene("szachit");
	}
}
