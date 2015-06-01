package engine;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import objects.GameObject;
import objects.blocks.BlockManager;
import objects.blocks.BlockManager2;
import objects.elements.Gun;
import objects.elements.Gun2;

public class Engine2 extends Engine implements Runnable {

	private BufferedImage bufferedImage; // Game is drawn here
	private Graphics g2; // The graphic for drawing on game

	private ArrayList<GameObject> gameObjects = new ArrayList<>();
	private ArrayList<GameObject> adds = new ArrayList<>();
	private ArrayList<GameObject> removes = new ArrayList<>();

	// Methods:
	public Engine2() {
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

		Assets.engineThread.suspend();

		/*
		 * while (!Assets.is_panel_read) {
		 * System.out.println("Engine Waiting");// Debug }
		 */
		while (Assets.is_running) {
			long cTime = System.nanoTime();
			Assets.delta = (cTime - currentTime) / 1000000.f;
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
		
		Assets.timePassed += Assets.delta;
		
		if(Assets.failCount >= 2 || Assets.timePassed >= Assets.timeLimit)
			Assets.blockManager.addLine();
		
		for (GameObject go : gameObjects)
			go.update();

		for (GameObject go : adds)
			gameObjects.add(go);

		for (GameObject go : removes)
			gameObjects.remove(go);

		adds.clear();
		removes.clear();

	}

	/*
	 * This is because you can't modify a gameObjects in update, so we use a
	 * cache
	 */
	public void add(GameObject o) {
		adds.add(o);
	}

	/*
	 * Removes a game object since they can't be reomved while update is called.
	 */
	public void remove(GameObject o) {
		removes.add(o);
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
		BlockManager2 bm = new BlockManager2();
		gameObjects.add(bm);
		Gun2 gun = new Gun2(400, 570, 30, 50, Color.GRAY, Color.BLUE);
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

	/*
	 * Restarts the game
	 */
	public void restart(){
		Assets.is_running = false;
		Assets.canShoot = true;
		Assets.delta = 0;
		Assets.timePassed = 0;
		Assets.score = 0;
		
		
		Assets.window.dispose();
		
		new Thread(new Runnable(){

			@Override
			public void run() {
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				run.MainRunner.main(null);
			}
			
		}).start();
	}
	
	/*
	 * Called when the user is lost
	 */
	public void gameOver() {
		//TODO
		JOptionPane.showMessageDialog(null, "Game Over");
		restart();
	}

	/*
	 * Called when the user wins
	 */
	public void win() {
		// TODO 
		JOptionPane.showMessageDialog(null, "You win!");
		
		restart();
	}

}
