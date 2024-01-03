package hateStatsWoT;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import windowBuilder.views.Statistics;

public class mainscene {
	
	private JFrame frame;
	private ImageIcon backgroundIcon;
	private JLabel background;
	private JButton btnSubmit;
	private JButton btnQuit;
	private JTextField txtField;
	private JLabel lblUsername;
	
	
	public mainscene() {
		initComponents();
		createEvents();
	}
	
	private void initComponents() {
		frame = new JFrame();
		
		backgroundIcon = new ImageIcon(this.getClass().getResource("/windowBuilder/resources/background.png"));
		background = new JLabel(backgroundIcon);
		background.setSize(1200, 700);
		
		// Submit button.
		btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(548, 340, 110, 25);
		frame.add(btnSubmit);
		
		// Quit button.
		btnQuit = new JButton("Quit");
		btnQuit.setBounds(1050, 600, 100, 25);
		frame.add(btnQuit);
		
		// Text field.
		txtField = new JTextField();
		txtField.setBounds(548, 300, 110, 25);
		frame.add(txtField);
		
		// Label username.
		lblUsername = new JLabel("Username:");
		lblUsername.setBounds(548, 270, 150, 25);
		lblUsername.setFont(new Font ("Tahoma", Font.BOLD, 20));
		frame.add(lblUsername);

		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/windowBuilder/resources/stats_128.png")));
		frame.setTitle("hateStats");
		frame.add(background);
		frame.setResizable(false);
		frame.setBounds(100, 100, 1200, 700);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	private void createEvents() {
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = txtField.getText();
				txtField.setText("");
				
				Statistics stats = new Statistics(username);
				stats.setVisible(true);
				frame.dispose();
			}
		});
		
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
	}	
	
	public static void main (String[] args) {
		new mainscene();
	}
}
