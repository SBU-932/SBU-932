package engine;

import objects.blocks.BlockManager;
import window.GamePanel;

public class Assets {
	public static GamePanel gamePanel;
	
	public static Engine engine;
	
	public static Thread engineThread; //The thread that runs the game engine

	// This is used to keep track of buttons, their indexes are:
	// a->0
	// d->1
	// ' ' ->2
	public static boolean[] buttons;
	
	public static boolean is_running; //If the game is running
	
	public static float delta = 0; //delta Time
	
	public static int picW = 800, picH = 600; // Setting up game boundaries
	
	public static BlockManager blockManager = null; //the system in charge of blocks
	
	public static int BIR = 13, BIC =20; //blocks in row/Column
	public static int bSizeW, bSizeH; //blocks size
	
	public static boolean canShoot = true; // You can shoot one bullet at a time
	
	public static int failCount = 0;
	public static double timePassed = 0;
	public static final double timeLimit = 7000;
	
}
