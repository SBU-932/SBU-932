/**
 * 
 */
package GObject.Subs;

import GObject.Subs.Shoot;
import Controler.State;

import java.awt.Color;
import java.awt.Graphics;

import GObject.GameObj;

/**
 * @author M
 *
 */
public class Arrow implements GameObj {

    int x, y, l, r;// Position, radius and length of weapon
    boolean shoot = true; // If it has shot
    double theta,//degree of gun
    speed = 0.005;//speed of gun moving
	
    /*
     * fixing every thing
     */
    public Arrow(int x, int y, int length, int r, double theta) {
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
	if (State.instance.button[0]) {
            theta -= speed * State.instance.delta;
	}

	if (State.instance.button[1]) {
            theta += speed * State.instance.delta;
	}
		
	//shoot
	if (State.instance.button[2]) {
	//if space button push fire
	if (shoot) {
            shoot = false;
            // TODO: Fire kn
            Shoot ball = new Shoot(10 , x + r / 2, y + r / 2, theta);
            State.instance.add.add(ball);
            System.out.println("Shoot!!");
        }
	}
        else {
            shoot = true;
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
	g.setColor(Color.PINK);
	g.fillArc(x, y, r, r, 0, 180);

	g.setColor(Color.DARK_GRAY);
	g.drawLine(x + r / 2, y + r / 2, x + r / 2+ (int) (l * Math.cos(theta)),y + r / 2 + (int) (l * Math.sin(theta)));
    }


}
