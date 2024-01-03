package windowBuilder.views;

import java.awt.Dimension;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import wargaming_api.WargamingAPI;

import javax.swing.JLabel;


import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

public class MainScene extends JFrame {

	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JTextField txtUsername;
	private JButton btnQuit;
	private JButton btnGetStats;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScene window = new MainScene();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainScene() {
		initComponents();
		createEvents();
	}

	private void initComponents() {
		
		// Frame options.
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(MainScene.class.getResource("/windowBuilder/resources/stats_128.png")));
		frame.setBounds(100, 100, 1200, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("hateStats");
		
		// Setting frame in the middle of a screen.
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(screenSize.width / 2 - frame.getSize().width / 2,
				screenSize.height / 2 - frame.getSize().height / 2);
		
		
		// Username input field.
		txtUsername = new JTextField();
		txtUsername.setColumns(10);
		
		
		// Label username.
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		// Buttons.
		btnGetStats = new JButton("Get stats");
		btnQuit = new JButton("Quit");

		//===========================Auto generated code from window builder.=================================
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(422)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtUsername, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnGetStats, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(1091, Short.MAX_VALUE)
					.addComponent(btnQuit)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(321)
					.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(txtUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(btnGetStats)
					.addPreferredGap(ComponentPlacement.RELATED, 217, Short.MAX_VALUE)
					.addComponent(btnQuit)
					.addContainerGap())
		);
		frame.getContentPane().setLayout(groupLayout);
		
	}
	
	private void createEvents() {
		
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		btnGetStats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = txtUsername.getText();
				txtUsername.setText("");
				
				Statistics stats = new Statistics(username);
				stats.setVisible(true);
				
				dispose();
			}
		});
		
	}
}
