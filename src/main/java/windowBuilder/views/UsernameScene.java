package windowBuilder.views;


import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UsernameScene {
	
	private final static Logger logger = LogManager.getLogger(UsernameScene.class);
	
	private JFrame frame;
	private ImageIcon backgroundIcon;

	private JButton btnSubmit;
	private JButton btnQuit;
	
	private JTextField txtField;
	
	private JLabel background;
	private JLabel lblHeader;
	
	private BorderedLabel lblUsername;
	
	
	public UsernameScene() {
		logger.info("Opening username scene.");
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
		lblUsername = new BorderedLabel("Username:");
		lblUsername.setBounds(548, 270, 150, 25);
		lblUsername.setFont(new Font ("Tahoma", Font.BOLD, 20));
		frame.add(lblUsername);
		
		// Label header.
		lblHeader = new JLabel("hateStats");
		lblHeader.setBounds(510, 120, 200, 200);
		lblHeader.setFont(new Font("Tahoma", Font.BOLD, 40));
		frame.add(lblHeader);

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
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = txtField.getText();
				txtField.setText("");
				
				new StatsScene(username);
				frame.dispose();
			}
		});
		
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
	}	
}
