package engine;

import window.GamePanel;

public class Assets {
	public static GamePanel gamePanel;
	public static Engine engine;
	
	public static Thread engineThread;

	// This is used to keep track of buttons, their indexes are:
	// a->0
	// d->1
	// ' ' ->2
	public static boolean[] buttons;
	
	public static boolean is_running;
	
	public static int picW = 800, picH = 600; // Setting up game boundaries
	
	public static boolean is_panel_read = false;
}
