/**
 * 
 */
package object.display;

import game.State;

import java.awt.Color;
import java.awt.Graphics;

import object.GameObj;

/**
 * @author M
 *
 */
public class Fire implements GameObj {

	int x, y, l, r;// Position, radius and length of weapon
	boolean shoot = true; // If it has shot
	double theta,//degree of gun
	speed = 0.005;//speed of gun moving
	
	/*
	 * fixing every thing
	 */
	public Fire(int x, int y, int length, int r, double theta) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		this.l = length;
		this.r = r;
		this.theta = theta;
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		//set degree to input
		if (State.getInstance().button[0]) {
			theta -= speed * State.getInstance().delta;
		}

		if (State.getInstance().button[1]) {
			theta += speed * State.getInstance().delta;
		}
		
		//shoot
		if (State.getInstance().button[2]) {
			//if space button push fire
			if (shoot&&State.getInstance().canShot) {
				shoot = false;
				// TODO: Fire kn
				Shot Shot = new Shot(5, x + r / 2, y + r / 2, theta);
				State.getInstance().add.add(Shot);
				System.out.println("Shooooooooot");
				State.getInstance().canShot =false;
			}
		} else {
			shoot = true;
			State.getInstance().canShot = true;
		}
		
		if(theta>0){
			theta=0;
		}
		if(theta<-180){
			theta =-180;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see object.GameObj#draw(java.awt.Graphics)
	 * draw gun
	 */
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.MAGENTA);
		g.fillArc(x, y, r, r, 0, 360);

		g.setColor(Color.CYAN);
		g.drawLine(x + r / 2, y + r / 2, x + r / 2
				+ (int) (l * Math.cos(theta)),
				y + r / 2 + (int) (l * Math.sin(theta)));
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
	}
}
