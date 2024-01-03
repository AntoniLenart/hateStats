package windowBuilder.views;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import wargaming_api.WargamingAPI;
import wargaming_api.Wn8Color;
import wargaming_api.Wn8Scrapper;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;

public class Statistics extends JFrame {

	private static final long serialVersionUID = 1L;
	private final static Logger logger = LogManager.getLogger(Statistics.class);
	private JPanel contentPane;
	
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
	
	private JLabel lblHeader;
	
	private JButton btnQuit;
	private JButton btnNewPlayer;

	public Statistics(String username) {
		logger.info("Opening statistics window.");
		initComponents(username);
		createEvents();
	}
	
	private void initComponents(String username) {
		
		contentPane = new JPanel();

		// Frame settings.
		
		setTitle("hateStats");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Statistics.class.getResource("/windowBuilder/resources/stats_128.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 700);
		setResizable(false);

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		// Header label.
		lblHeader = new JLabel("hateStats for " + username);
		lblHeader.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		//=====================ICONS==========================================
		
		lblBattlesIcon = new JLabel();
		lblBattlesIcon.setIcon(new ImageIcon(Statistics.class.getResource("/windowBuilder/resources/battles_128.png")));
		
		lblBestIcon = new JLabel();
		lblBestIcon.setIcon(new ImageIcon(Statistics.class.getResource("/windowBuilder/resources/best_128.png")));
		
		lblShotsIcon = new JLabel();
		lblShotsIcon.setIcon(new ImageIcon(Statistics.class.getResource("/windowBuilder/resources/shots_128.png")));
		
		lblAverageIcon = new JLabel();
		lblAverageIcon.setIcon(new ImageIcon(Statistics.class.getResource("/windowBuilder/resources/average_128.png")));
		
		lblWn8Icon = new JLabel();
		lblWn8Icon.setIcon(new ImageIcon(Statistics.class.getResource("/windowBuilder/resources/wins_128.png")));
		
		//========================LABELS======================================
		lblBattles = new JLabel("Battles:");
		lblBattles.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		lblWins = new JLabel("Wins:");
		lblWins.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		lblDraws = new JLabel("Draws:");
		lblDraws.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		lblLoses = new JLabel("Loses:");
		lblLoses.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		lblSurvived = new JLabel("Survived:");
		lblSurvived.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		lblSpotted = new JLabel("Spotted:");
		lblSpotted.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		lblDamageDealt = new JLabel("Damage dealt:");
		lblDamageDealt.setFont(new Font("Tahoma", Font.PLAIN, 15));

		lblMaxFrags = new JLabel("Max frags:");
		lblMaxFrags.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		lblMaxXp = new JLabel("Max XP:");
		lblMaxXp.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		lblMaxDamage = new JLabel("Max damage:");
		lblMaxDamage.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		lblDamageReceived = new JLabel("Damage received:");
		lblDamageReceived.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		lblHits = new JLabel("Hits:");
		lblHits.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		lblAverageAssist = new JLabel("Average assist:");
		lblAverageAssist.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		lblArtilleryBattles = new JLabel("Artillery battles:");
		lblArtilleryBattles.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		lblAverageXp = new JLabel("Average xp:");
		lblAverageXp.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		lblShots = new JLabel("Shots:");
		lblShots.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		lblPiercings = new JLabel("Piercings:");
		lblPiercings.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		lblCapturePoints = new JLabel("Capture points:");
		lblCapturePoints.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		lblAllXp = new JLabel("All XP:");
		lblAllXp.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		lblFrags = new JLabel("Frags:");
		lblFrags.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		// Adding stats to labels.
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
		
		int ID = WargamingAPI.getUserId(username);
		if (ID == 1) {
			return;
		}
		String [] stats = WargamingAPI.getStats(ID);
		
		for (int i = 0; i < stats.length; i++) {
				String tmp = labels[i].getText();
				labels[i].setText(tmp + " " + stats[i]);
		}
		
		// Wn8 Labels.
		lblEstimatedWn8 = new JLabel("Estimated wn8:");
		lblEstimatedWn8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		lblWn8 = new JLabel("Wn8:");
		lblWn8.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		// Adding player's wn8 to label and setting adequate color.
		double wn8_raw = Wn8Scrapper.getWN8(username);
		String wn8 = Double.toString(wn8_raw);
		Color color = Wn8Color.getColor(wn8_raw);
		lblWn8.setText(lblWn8.getText() + " " + wn8);
		lblWn8.setForeground(color);
		
		// Buttons.
		btnNewPlayer = new JButton("New Player");
		btnNewPlayer.setHorizontalAlignment(SwingConstants.RIGHT);
		btnNewPlayer.setVerticalAlignment(SwingConstants.TOP);
		
		btnQuit = new JButton("Quit");
		btnQuit.setHorizontalAlignment(SwingConstants.RIGHT);
		btnQuit.setVerticalAlignment(SwingConstants.TOP);

		//===================================Auto generated code from windowBuilder================================
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblBattlesIcon, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblShotsIcon)
						.addComponent(lblAverageIcon, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblArtilleryBattles)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblDamageReceived)
										.addComponent(lblDamageDealt)
										.addComponent(lblSpotted)
										.addComponent(lblSurvived)
										.addComponent(lblDraws)
										.addComponent(lblLoses)
										.addComponent(lblWins)
										.addComponent(lblBattles)
										.addComponent(lblHits)
										.addComponent(lblShots)
										.addComponent(lblPiercings)
										.addComponent(lblAverageAssist)
										.addComponent(lblAllXp, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblAverageXp)
										.addComponent(lblFrags)
										.addComponent(lblCapturePoints))
									.addGap(180)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblBestIcon, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lblMaxFrags)
												.addComponent(lblMaxXp)
												.addComponent(lblMaxDamage)))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblWn8Icon, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lblWn8)
												.addComponent(lblEstimatedWn8)))))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(8)
							.addComponent(lblHeader, GroupLayout.PREFERRED_SIZE, 340, GroupLayout.PREFERRED_SIZE)))
					.addGap(42))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(1016, Short.MAX_VALUE)
					.addComponent(btnNewPlayer)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnQuit)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblHeader)
							.addGap(27)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblBattles, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblWins, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblLoses, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblDraws, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblSurvived, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addComponent(lblBattlesIcon)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(lblMaxFrags, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(lblMaxXp, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(lblMaxDamage, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
											.addComponent(lblBestIcon)))))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblShotsIcon)
											.addPreferredGap(ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
											.addComponent(lblAverageIcon, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblSpotted, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblDamageDealt, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
											.addGap(4)
											.addComponent(lblDamageReceived, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblHits, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblShots, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblPiercings, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblAverageAssist, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblAverageXp, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblAllXp, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblFrags, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(lblCapturePoints, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblArtilleryBattles, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
									.addGap(152))
								.addComponent(lblWn8Icon, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblEstimatedWn8, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblWn8, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnQuit)
							.addComponent(btnNewPlayer))))
		);

		contentPane.setLayout(gl_contentPane);
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
				dispose();
				new UsernameScene();
			}
		});
		
	}
}
