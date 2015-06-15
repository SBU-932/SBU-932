package window;

import game.Engine;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton button = new JButton("Level1");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Level1();			
				}
			
		});
		button.setBounds(184, 111, 97, 25);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Level2");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				level2();
			}
		});
		button_1.setBounds(144, 111, 97, 25);
		contentPane.add(button_1);
	}
	protected void level2() {
		// TODO Auto-generated method stub
		
	}
	private void Level1() {
		// TODO Auto-generated method stub
		Engine eng = new Engine();
		eng.Maingame();
		this.setVisible(false);
	}

}
