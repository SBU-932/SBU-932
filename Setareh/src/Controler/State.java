package Controler;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import GObject.GameObj;
import GObject.Blocks.Blocks;

public class State {
	
	private State() {
		// TODO Auto-generated constructor stub
	}
	
	public static final State instance = new State();
	
	
	// This is used to change arrow position(in button[]):
		// left arrow -> 0
		// right arrow -> 1
		// space  -> 2
	public boolean []button;//change arrow
	public GameMain.Background game;//JFrame
	public BufferedImage buffered;// Game is draw here
	public Graphics g;// The graphic for drawing on game
	public int length=800;//length of game screen
	public int width=600;//width of game screen
	public double delta;
	public ArrayList<GameObj>objects = new ArrayList<GameObj>();
	public ArrayList<GameObj>add = new ArrayList<GameObj>();
	public ArrayList<GameObj>remove = new ArrayList<GameObj>();
	public boolean [][] block;//keep block that we show
	public int block_lenght;//length of block
	public int block_width;//width of block
	public int column_count = 25;//number of columns
	public int row_count = 25;//number of rows
	public Blocks blocks;
        public int radius;
        public boolean canShoot = true; // one bullet must be in game at a time
	public int fail_count = 0;//counter that count shot that fail
	public final int limited_time = 7000;//the time that pass add line
	public double passTime = 0;//this count time that pass
	public boolean win = false;
	public int score = 0 ; 
	

}
