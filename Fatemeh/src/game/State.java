package game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import object.GameObj;

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
	
	public ArrayList<GameObj>objects = new ArrayList<GameObj>();
	

}
