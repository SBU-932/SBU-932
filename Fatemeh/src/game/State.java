package game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import object.GameObj;
import object.block.Block;

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
	public BufferedImage buffered;
	public Graphics g;
	public  int width=800;
	public int heigth=600;
	public double delta;
	public ArrayList<GameObj>objects = new ArrayList<GameObj>();
	public ArrayList<GameObj>add = new ArrayList<GameObj>();
	public ArrayList<GameObj>remove = new ArrayList<GameObj>();
	public boolean [][] block;
	public int row;
	public int clom;
	public int Nr=25;
	public int Nc=25;
	public Block blocks;


	
	
	

}
