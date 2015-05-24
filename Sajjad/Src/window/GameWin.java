package window;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

import engine.Assets;

public class GameWin extends JFrame {

	private GamePanel contentPane; //This is the game panel which is the main JPanel of this window.

	public GameWin() {		
		
		Assets.window = this;
		
		//BEGIN: Setting up window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 1000, 600);
		setSize(1000,600+38); //Got +38 using Insets
		contentPane = new GamePanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setVisible(true);
		//END: Setting up window
	}

}
