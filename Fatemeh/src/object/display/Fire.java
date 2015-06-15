/**
 * 
 */
package object.display;

import game.State;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import object.GameObj;
import object.block.Colour;

/**
 * @author M
 *
 */
public class Fire implements GameObj {

	int x, y, l, r;// Position, radius and length of weapon
	boolean shoot = true; // shot one time in per tap button
	double theta,//degree of gun
	speed = 0.005;//speed of gun moving
	Color c , c1,c2;//color of shot
	private Random Rn;
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
		
		c = RnColor();
		c1 = RnColor();
		c2 =RnColor();
	}
	
	private Color RnColor() {
		// TODO Auto-generated method stub
		Rn = new Random();
		return Colour.getType(Rn.nextInt(5)).getColor();
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
				Shot Shot = new Shot(5, x + r / 2, y + r / 2, theta,c);
				State.getInstance().add.add(Shot);
				c = c1;
				c1 = c2;
				c2=RnColor();
				System.out.println("Shooooooooot");
				State.getInstance().canShot =false;
			}
		} else {
			shoot = true;
		}
		
		// Modifier so gun will always be on top
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
		g.setColor(c);
		g.fillArc(x, y, r, r, 0, 360);
		
		g.setColor(c1);
		g.fillArc(x+5 *r, y, r, r, 0, 360);
		g.setColor(c2);
		g.fillArc(x+6 *r, y, r, r, 0, 360);

		g.setColor(Color.WHITE);
		g.drawLine(x + r / 2, y + r / 2, x + r / 2
				+ (int) (l * Math.cos(theta)),
				y + r / 2 + (int) (l * Math.sin(theta)));
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
	}
}
