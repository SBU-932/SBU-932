package window;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

public class GameWin extends JFrame {

	private GamePanel contentPane; //This is the game panel which is the main JPanel of this window.

	public GameWin() {
		//BEGIN: Setting up window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800	, 600);
		contentPane = new GamePanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setVisible(true);
		//END: Setting up window
		
		//TODO: Game loop, must be moved to it's own class later
		while(true){
			contentPane.draw();
		}
	}

}
