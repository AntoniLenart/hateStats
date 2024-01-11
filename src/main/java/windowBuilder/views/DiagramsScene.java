package windowBuilder.views;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class DiagramsScene {

	private JFrame frame;
	private JButton btnQuit;
	private JButton btnNext;
	private JButton btnPrevious;
	
	private JLabel diagram1;
	private JLabel diagram2;
	private JLabel diagram3;
	private JLabel diagram4;

	
	public DiagramsScene() {
		initComponents();
		createEvents();
	}
	
	private void initComponents() {
		frame = new JFrame();
		
		btnQuit = new JButton("Quit");
		btnQuit.setBounds(1750, 600, 100, 30);
		frame.add(btnQuit);
		
		btnNext = new JButton("Next");
		btnNext.setBounds(1650, 600, 100, 30);
		frame.add(btnNext);
		
		btnPrevious = new JButton("Previous");
		btnPrevious.setBounds(1650, 600, 100, 30);
		
		diagram1 = new JLabel();
		diagram1.setIcon(new ImageIcon(DiagramsScene.class.getResource("/plots/fig_1.png")));
		//diagram1.setSize(600, 600);
		diagram1.setBounds(0, 0, 1000, 600);
		frame.add(diagram1);
		
		diagram2 = new JLabel();
		diagram2.setIcon(new ImageIcon(DiagramsScene.class.getResource("/plots/fig_2.png")));
		//diagram2.setSize(600, 600);
		diagram2.setBounds(1000, 0, 1000, 600);
		frame.add(diagram2);
		
		diagram3 = new JLabel();
		diagram3.setIcon(new ImageIcon(DiagramsScene.class.getResource("/plots/fig_3.png")));
		//diagram3.setSize(600,600);
		diagram3.setBounds(0, 0, 1000, 600);
		frame.add(diagram3);
		
		diagram4 = new JLabel();
		diagram4.setIcon(new ImageIcon(DiagramsScene.class.getResource("/plots/fig_4.png")));
		//diagram4.setSize(600, 600);
		diagram4.setBounds(1000, 0, 1000, 600);
		frame.add(diagram4);
		
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/windowBuilder/icons/stats_128.png")));
		frame.setTitle("hateStats");
		frame.setResizable(false);
		frame.setBounds(100, 100, 1900, 700);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);	
	}	
	
	
	private void createEvents() {
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.remove(diagram1);
				frame.remove(diagram2);
				frame.remove(btnNext);
				
				frame.add(btnPrevious);
				frame.add(diagram3);
				frame.add(diagram4);
				frame.revalidate();
				frame.repaint();
			}
		});
		
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.remove(diagram3);
				frame.remove(diagram4);
				frame.remove(btnPrevious);
				
				frame.add(diagram1);
				frame.add(diagram2);
				frame.add(btnNext);
				frame.revalidate();
				frame.repaint();
			}
		});
	}
}
