package run;

import engine.Assets;
import engine.Engine;
import window.GameWin;

public class MainRunner {

	public static void main(String[] args) {
		//Init engine thread:
		Assets.engineThread = new Thread(new Engine());
		
		//Run game window
		GameWin g = new GameWin();
		Assets.engineThread.resume();
		//TODO: run main menu first later
	}

}
