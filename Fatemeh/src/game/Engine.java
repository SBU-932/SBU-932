package game;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import object.GameObj;
import object.block.Block;
import object.display.Fire;
import window.Frame;

public class Engine {

	public boolean start = true;// If the game is running

	public Engine() {
		// TODO Auto-generated constructor stub
		State.getInstance().engine = this;
	}

	public void Maingame() {
		init();
		start = true;
		long currentTime = System.nanoTime();
		while (start) {
			// TODO
			long updatedTime = System.nanoTime();
			State.getInstance().delta = (updatedTime - currentTime) / 1000000;
			currentTime = updatedTime;
			update();
			draw();
		}
		end();

	}

	/*
	 * This method is run every frame for drawing purpose for drawing on game
	 * panel
	 */

	private void draw() {
		// set background
		State.getInstance().g.setColor(Color.BLACK);
		State.getInstance().g.fillRect(0, 0, State.getInstance().length,
				State.getInstance().width);

		// BEGIN: draw on g2
		for (GameObj go : State.getInstance().objects)
			go.draw(State.getInstance().g);

		// END: draw on g2
		State.getInstance().Panel.getGraphics().drawImage(
				State.getInstance().buffered, 0, 0, State.getInstance().Panel);
	}

	/*
	 * this method run before game begin
	 */

	private void init() {
		if (State.getInstance().frame == null)
			new Frame();
		settupBuffered();
		Block b = new Block();
		State.getInstance().objects.add(b);
		Fire s = new Fire(400, 500, 25, 30, 0);
		State.getInstance().objects.add(s);

		State.getInstance().ball = new ImageIcon("C://ball.png").getImage()
				.getScaledInstance(State.getInstance().row,
						State.getInstance().clom, Image.SCALE_SMOOTH);
	}

	/*
	 * this method is run every frame
	 */
	private void update() {
		// TODO
		State.getInstance().passTime += State.getInstance().delta;

		if (State.getInstance().failcount >= 2
				|| State.getInstance().passTime >= State.getInstance().limited) {
			State.getInstance().blocks.line();
		}
		for (GameObj go : State.getInstance().objects)
			go.update();

		for (GameObj go : State.getInstance().add)
			State.getInstance().objects.add(go);

		for (GameObj go : State.getInstance().remove)
			State.getInstance().objects.remove(go);

		State.getInstance().add.clear();
		State.getInstance().remove.clear();
	}

	public void remove(GameObj o) {
		State.getInstance().remove.add(o);
	}

	/*
	 * this method is for end of game
	 */
	public void end() {
		// TODO
		State.getInstance().canShot = false;
		synchronized (State.getInstance()) {
			State.getInstance().notifyAll();
		}
		// JOptionPane.showMessageDialog(State.getInstance().frame, "Game Over",
		// "Game Over",
		// JOptionPane.OK_OPTION);
	}

	/*
	 * creates image and sets graphic
	 */
	private void settupBuffered() {
		State.getInstance().buffered = new BufferedImage(
				State.getInstance().length, State.getInstance().width,
				BufferedImage.TYPE_INT_RGB);
		State.getInstance().g = State.getInstance().buffered.getGraphics();
	}

	public void win() {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "You win!");
	}

	public void reset() {
		// TODO Auto-generated method stub
		start = false;

		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				// synchronized (State.getInstance()) {

				while (State.getInstance().engine.start)
					;
				State.getInstance().objects.clear();
				State.getInstance().canShot = true;
				System.out.println("Here");

				Engine tmp = new Engine();

				tmp.Maingame();
			}

		});

		t.start();
	}

}
