package window;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GamePanel extends JPanel {

	private Image offScreenImage;
	private Graphics offScreenGraphics;
	private BufferedImage bufferedImage;
	private Graphics g2;

	private int picW = 800, picH = 600;

	/**
	 * Create the panel.
	 */
	public GamePanel() {
		offScreenImage = this.createImage(picW, picH);
		offScreenGraphics = this.getGraphics();
		bufferedImage = new BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB);
		g2 = bufferedImage.getGraphics();
	}

	public void draw() {
		System.out.println("Drawing");

		g2.clearRect(0, 0, picW, picH);

		g2.setColor(Color.LIGHT_GRAY);
		g2.fillRect(0, 0, picW, picH);

		// Draw on g2

		g2.setColor(Color.red);
		g2.fillArc(10, 10, 150, 150, 0, 90);

		this.getGraphics().drawImage(bufferedImage, 0, 0, this);

	}

}
