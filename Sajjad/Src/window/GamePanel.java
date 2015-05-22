package window;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class GamePanel extends JPanel {

	private BufferedImage bufferedImage; // Game is drawn here
	private Graphics g2; // The graphic for drawing on game

	private InputMap im = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW); // Looks
																			// for
																			// keyboard
																			// input
	private ActionMap am = getActionMap(); // Performs actions based on the
											// inputs

	private int picW = 800, picH = 600; // Setting up game boundaries

	private boolean[] is_down = new boolean[3];

	/**
	 * Create the panel.
	 */
	public GamePanel() {
		settupInputs();

		settupBufferedImage();
	}

	/*
	 * creates image and sets graphic
	 */
	private void settupBufferedImage() {
		// Setting up image for game graphics
		bufferedImage = new BufferedImage(picW, picH,
				BufferedImage.TYPE_INT_RGB);
		g2 = bufferedImage.getGraphics();
	}

	/*
	 * listens for input
	 */
	private void settupInputs() {

		// Making window focusable for keyboard input
		setFocusable(true);
		requestFocusInWindow();

		//This is in charge of pressed keys, sets their is_down to true
		AbstractAction press = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				switch (ae.getActionCommand()) {
				case " ":
					is_down[2] = true;
					break;
				case "a":
					is_down[0] = true;
					break;
				case "d":
					is_down[1] = true;
					break;
				}

			}
		};

		//This is in charge of released buttons, sets their is_down to false
		AbstractAction release = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				switch (ae.getActionCommand()) {
				case " ":
					is_down[2] = false;
					break;
				case "a":
					is_down[0] = false;
					break;
				case "d":
					is_down[1] = false;
					break;
				}
			}
		};

		
		//BEGIN: set up listeners for keys
		im.put(KeyStroke.getKeyStroke("released D"), "rr");
		am.put("rr", release);

		im.put(KeyStroke.getKeyStroke("released A"), "rl");
		am.put("rl", release);

		im.put(KeyStroke.getKeyStroke("pressed D"), "r");
		am.put("r", press);

		im.put(KeyStroke.getKeyStroke("pressed SPACE"), "s");
		am.put("s", press);

		im.put(KeyStroke.getKeyStroke("released SPACE"), "rs");
		am.put("rs", release);

		im.put(KeyStroke.getKeyStroke("pressed A"), "l");
		am.put("l", press);
		//END: set up listerners for keys
	}

	/*
	 * Draws the game panel
	 */
	public void draw() {
		// Clear image
		g2.clearRect(0, 0, picW, picH);

		// set background
		g2.setColor(Color.LIGHT_GRAY);
		g2.fillRect(0, 0, picW, picH);

		// BEGIN: draw on g2
		// TODO:
		g2.setColor(Color.red);
		g2.fillArc(10, 10, 150, 150, 0, 90);

		// END: draw on g2

		// draw the image on panel:
		this.getGraphics().drawImage(bufferedImage, 0, 0, this);

	}

}
