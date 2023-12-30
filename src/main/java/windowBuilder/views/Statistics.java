package windowBuilder.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import wargaming_api.WargamingAPI;

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
import javax.swing.SwingConstants;

public class Statistics extends JFrame {

	private static final long serialVersionUID = 1L;
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

	private JLabel lblBattlesIcon;
	private JLabel lblBestIcon;
	private JLabel lblHeader;
	
	private JButton btnQuit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Statistics frame = new Statistics("szachit");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Statistics(String username) {

		initComponents(username);
		createEvents();
	}
	
	private void initComponents(String username) {
		
		contentPane = new JPanel();

		
		setTitle("hateStats");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Statistics.class.getResource("/windowBuilder/resources/stats_128.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 700);

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		lblHeader = new JLabel("hateStats for " + username);
		lblHeader.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		lblBattlesIcon = new JLabel("");
		lblBattlesIcon.setIcon(new ImageIcon(Statistics.class.getResource("/windowBuilder/resources/battles_128.png")));
		
		lblBestIcon = new JLabel();
		lblBestIcon.setIcon(new ImageIcon(Statistics.class.getResource("/windowBuilder/resources/wins_128.png")));
		
		//======================================================================================
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
		lblSpotted.setHorizontalAlignment(SwingConstants.LEFT);
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

		btnQuit = new JButton("Quit");
		
		// Adding stats to laybels.
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
		String [] stats = WargamingAPI.getStats(ID);
		
		for (int i = 0; i < stats.length; i++) {
				String tmp = labels[i].getText();
				labels[i].setText(tmp + stats[i]);
		}
		
		//===================================Auto generated code from windowBuilder================================
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblBattlesIcon, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblAllXp, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 446, Short.MAX_VALUE))
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
										.addComponent(lblPiercings))
									.addGap(180)
									.addComponent(lblBestIcon, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblMaxFrags)
										.addComponent(lblMaxXp)
										.addComponent(lblMaxDamage, Alignment.LEADING))
									.addGap(573))
								.addComponent(lblAverageXp, Alignment.LEADING)
								.addComponent(lblAverageAssist, Alignment.LEADING)
								.addComponent(lblCapturePoints, Alignment.LEADING)
								.addComponent(lblArtilleryBattles, Alignment.LEADING)
								.addComponent(lblFrags, Alignment.LEADING)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(8)
							.addComponent(lblHeader, GroupLayout.PREFERRED_SIZE, 340, GroupLayout.PREFERRED_SIZE)))
					.addGap(1176))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(1079)
					.addComponent(btnQuit)
					.addContainerGap(1332, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblHeader)
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblMaxFrags, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblMaxXp, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblMaxDamage, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
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
									.addGroup(gl_contentPane.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(lblBestIcon))
									.addComponent(lblBattlesIcon)))
							.addPreferredGap(ComponentPlacement.RELATED)
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
							.addComponent(lblAllXp, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblFrags, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lblCapturePoints, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblArtilleryBattles, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addGap(129)
					.addComponent(btnQuit)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	private void createEvents() {
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
	}
}
