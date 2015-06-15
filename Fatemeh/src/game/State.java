package game;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;

import object.GameObj;
import object.block.Block;
import object.block.Colour;

public class State {
	
	private State() {
		// TODO Auto-generated constructor stub
	}
	
	private static final State instance = new State();
	
	public static State getInstance() {
		return instance;
	}
	// This is used to keep track of buttons, their indexes are:
		// a->0
		// d->1
		// ' ' ->2
	public boolean []button;
	public window.Panel Panel;
	public BufferedImage buffered;// Game is draw here
	public Graphics g;// The graphic for drawing on game
	public  int length=800;//length of game screen
	public int width=600;//width of game screen
	public double delta=0;//time
	public ArrayList<GameObj>objects = new ArrayList<GameObj>();
	public ArrayList<GameObj>add = new ArrayList<GameObj>();
	public ArrayList<GameObj>remove = new ArrayList<GameObj>();
	public Colour [][] block;//keep block
	public int row;//length of block
	public int clom;//width of block
	public int Nr=15;//number of blocks in one row
	public int Nc=15;//number of blocs in one column
	public Block blocks;//saving blocks pointer for easy access
	public Engine engine;
	public boolean canShot = true; // You can shoot one bullet at a time
	public int failcount=0;//counter that count shot that fail
	public final int limited=5000;//the time that pass add line
	public double passTime=0;//this count time that pass
	public int Score=0;
	public JFrame frame;
	

}
