package window;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import engine.Assets;

public class GamePanel extends JPanel {

	private InputMap im = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW); // Looks
																			// for
																			// keyboard
																			// input
	private ActionMap am = getActionMap(); // Performs actions based on the
											// inputs

	/**
	 * Create the panel.
	 */
	public GamePanel() {
		// Set this as current game panel
		Assets.gamePanel = this;
		// initialize buttons
		Assets.buttons = new boolean[3];

		Assets.engineThread.start();// Start engine

		settupInputs();
		settupGUI();

		System.out.println("Finished GUI");// Debug
	}

	/*
	 * Adds Restart, Quit, Score
	 */
	private void settupGUI() {
		// TODO
		setLayout(null);

		JButton jRestart = new JButton("Restart");
		jRestart.setLocation(800, 0);
		jRestart.setSize(200, 100);
		jRestart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				restart();
			}

		});
		add(jRestart);

		JButton jQuit = new JButton("Quit");
		jQuit.setLocation(800, 500);
		jQuit.setSize(200, 100);
		jQuit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				quit();

			}

		});
		add(jQuit);
	}

	/*
	 * OnPressQuit
	 */
	protected void quit() {
		System.exit(0);
	}

	/*
	 * OnPressRestart
	 */
	protected void restart() {
		// TODO: go back to menu
		System.out.println("Debug: restart");
	}

	/*
	 * listens for input
	 */
	private void settupInputs() {

		// Making window focusable for keyboard input
		setFocusable(true);
		requestFocusInWindow();

		// This is in charge of pressed keys, sets their is_down to true
		AbstractAction press = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				switch (ae.getActionCommand()) {
				case " ":
					Assets.buttons[2] = true;
					break;
				case "a":
					Assets.buttons[0] = true;
					break;
				case "d":
					Assets.buttons[1] = true;
					break;
				}

			}
		};

		// This is in charge of released buttons, sets their is_down to false
		AbstractAction release = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				switch (ae.getActionCommand()) {
				case " ":
					Assets.buttons[2] = false;
					break;
				case "a":
					Assets.buttons[0] = false;
					break;
				case "d":
					Assets.buttons[1] = false;
					break;
				}
			}
		};

		// BEGIN: set up listeners for keys
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
		// END: set up listerners for keys
	}

}
