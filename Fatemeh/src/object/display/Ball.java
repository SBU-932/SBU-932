package object.display;

import game.State;

import java.awt.Color;
import java.awt.Graphics;

import object.GameObj;

public class Ball implements GameObj {
	int r;
	double x,y;
	double alpha;
	double speed = 1;
	

	public Ball(int r,double x,double y,double alpha) {
		// TODO Auto-generated constructor stub
		this.r =r;
		this.x=x;
		this.y=y;
		this.alpha=alpha;
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		x+=speed*Math.cos(alpha)*State.getInstance().delta;
		y+=speed*Math.sin(alpha)*State.getInstance().delta;
		
		
		
	}

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
