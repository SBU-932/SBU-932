package engine;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import objects.GameObject;
import objects.blocks.BlockManager;
import objects.elements.Gun;

public class Engine implements Runnable {

	private BufferedImage bufferedImage; // Game is drawn here
	private Graphics g2; // The graphic for drawing on game

	private ArrayList<GameObject> gameObjects = new ArrayList<>();
	private ArrayList<GameObject> adds = new ArrayList<>();
	private ArrayList<GameObject> removes = new ArrayList<>();
	

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
		
		Assets.engineThread.suspend();
		
		/*while (!Assets.is_panel_read) {
			System.out.println("Engine Waiting");// Debug
		}*/
		while (Assets.is_running) {
			long cTime = System.nanoTime();
			Assets.delta = (cTime - currentTime) / 1000000.f;
			currentTime = cTime;

			//System.out.println(Assets.delta);//Debug
			
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
		
		for(GameObject go: adds)
			gameObjects.add(go);
		
		for(GameObject go: removes){
			System.out.println("Removing " + gameObjects.size() );
			gameObjects.remove(go);
			System.out.println("Removed " + gameObjects.size() );
		}

		adds.clear();
		removes.clear();
		
	}
	
	/*
	 * This is because you can't modify a gameObjects in update, so we use a cache
	 */
	public void add(GameObject o){
		adds.add(o);
	}
	

	/*
	 * Removes a game object since they can't be reomved while update is called.
	 */
	public void remove(GameObject o) {
		removes.add(o);		
		System.out.println("Removing");
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
		BlockManager bm = new BlockManager();
		gameObjects.add(bm);
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
