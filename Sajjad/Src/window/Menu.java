package window;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import engine.Assets;
import engine.Engine;
import engine.Engine2;
import engine.Engine3;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnPhase = new JButton("Phase 1");
		btnPhase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				phase1();
			}
		});
		btnPhase.setBounds(174, 62, 97, 25);
		contentPane.add(btnPhase);
		
		JButton btnPhase_1 = new JButton("Phase 2");
		btnPhase_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				phase2();
			}
		});
		btnPhase_1.setBounds(174, 111, 97, 25);
		contentPane.add(btnPhase_1);
		
		JButton button = new JButton("Phase 2-1");
		button.setBounds(174, 156, 97, 25);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				phase2_1();
			}
		});
		contentPane.add(button);
	}

	protected void phase2() {
		// Init engine thread:
		Assets.engineThread = new Thread(new Engine2());

		// Run game window
		GameWin g = new GameWin();
		Assets.engineThread.resume();
		// TODO: run main menu first later
		this.setVisible(false);
		
	}
	
	protected void phase2_1() {
		// Init engine thread:
		Assets.engineThread = new Thread(new Engine3());

		// Run game window
		GameWin g = new GameWin();
		Assets.engineThread.resume();
		// TODO: run main menu first later
		this.setVisible(false);
		
	}

	protected void phase1() {
		// Init engine thread:
		Assets.engineThread = new Thread(new Engine());

		// Run game window
		GameWin g = new GameWin();
		Assets.engineThread.resume();
		// TODO: run main menu first later
		this.setVisible(false);
	}
}
