package engine;

import javax.swing.JLabel;

import objects.blocks.BlockManager;
import window.GamePanel;
import window.GameWin;

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
	
	public static BlockManager blockManager; //the system in charge of blocks
	
	public static int BIR = 13, BIC =13; //blocks in row/Column
	public static int bSizeW, bSizeH; //blocks size
	
	public static boolean canShoot = true; // You can shoot one bullet at a time
	
	public static int failCount = 0; //If equals 2, it will trigger new line
	public static double timePassed = 0; // if reach timeLimit will trigger new line
	public static final double timeLimit = 7000; // time limit of time passed

	public static final int boffset = -15;

	public static final double timeToRemove = 200;
	
	public static int score = 0;
	public static JLabel jSore; // Shows the score

	public static GameWin window;

	public static boolean[] turn;
	public static int[] scores;
}
