package engine;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import objects.GameObject;
import objects.elements.Gun;

public class Engine implements Runnable {

	private BufferedImage bufferedImage; // Game is drawn here
	private Graphics g2; // The graphic for drawing on game

	public ArrayList<GameObject> gameObjects = new ArrayList<>();

	// Methods:
	public Engine() {
		// Set this object as current Engine
		Assets.engine = this;
	}

	@Override
	public void run() {
		// This is for making engine run in another thread
		game();
	}

	private void game() {
		long currentTime = System.nanoTime();
		Assets.is_running = true;
		init();
		System.out.println("Starting Engine");// Debug
		while (!Assets.is_panel_read) {
			System.out.println("Engine Waiting");// Debug
		}
		System.out.println("Engine Started");// Debug
		while (Assets.is_running) {
			long cTime = System.nanoTime();
			Assets.delta = (cTime - currentTime) / 1000.f;
			currentTime = cTime;

			update();
			draw();
		}
	}

	/*
	 * This method is run every frame for drawing purpose for drawing on game
	 * panel
	 */
	private void draw() {
		// Clear image
		g2.clearRect(0, 0, Assets.picW, Assets.picH);

		// set background
		g2.setColor(Color.LIGHT_GRAY);
		g2.fillRect(0, 0, Assets.picW, Assets.picH);

		// BEGIN: draw on g2
		// TODO:

		// Debug:
		g2.setColor(Color.red);
		g2.fillArc(10, 10, 150, 150, 0, 90);

		for (GameObject go : gameObjects)
			go.draw(g2);

		// END: draw on g2

		Assets.gamePanel.getGraphics().drawImage(bufferedImage, 0, 0,
				Assets.gamePanel);
	}

	/*
	 * This method is run every frame
	 */
	private void update() {
		for (GameObject go : gameObjects)
			go.update();

	}

	/*
	 * This method is run before game begins
	 */
	private void init() {
		settupBufferedImage();
		loadGameObjects();
	}

	/*
	 * Initializes game
	 */
	private void loadGameObjects() {
		Gun gun = new Gun(400, 570,30,50, Color.GRAY, Color.BLUE);
		gameObjects.add(gun);
		
	}

	/*
	 * creates image and sets graphic
	 */
	private void settupBufferedImage() {
		// Setting up image for game graphics
		bufferedImage = new BufferedImage(Assets.picW, Assets.picH,
				BufferedImage.TYPE_INT_RGB);
		g2 = bufferedImage.getGraphics();
	}
}
