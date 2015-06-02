package object.display;

import game.State;

import java.awt.Color;
import java.awt.Graphics;

import object.GameObj;

public class Shot implements GameObj {
	int r;//radius
	double x,y;//position
	double alpha;//degree of drop
	double speed = 1;//speed of drop
	
	/*
	 * fixing every thing
	 */
	public Shot(int r,double x,double y,double alpha) {
		// TODO Auto-generated constructor stub
		this.r =r;
		this.x=x;
		this.y=y;
		this.alpha=alpha;
		
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
		//place of Shot  in per delta
		x+=speed*Math.cos(alpha)*State.getInstance().delta;
		y+=speed*Math.sin(alpha)*State.getInstance().delta;
		
		//check position of Shot
		if( x <0 || y<0 || x> State.getInstance().length || y> State.getInstance().width){
			goout();
		}
		
		if(State.getInstance().blocks.bump(this)){
			System.out.println("dfghj");
			
			
		}
	}
	

	/*
	 * This is called when a Shot is went out of window
	 */
	private void goout() {
		// TODO Auto-generated method stub
	}
	
	/*
	 * (non-Javadoc)
	 * @see object.GameObj#draw(java.awt.Graphics)
	 * this method draw Shot
	 */
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.DARK_GRAY);
		g.fillRect((int)x, (int)y, r, r);
		
		
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

}
