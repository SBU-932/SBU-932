/**
 * 
 */
package GObject.Subs;

import GObject.Subs.Shoot;
import Controler.State;

import java.awt.Color;
import java.awt.Graphics;

import GObject.GameObj;
import java.util.Random;

/**
 * @author M
 *
 */
public class Arrow implements GameObj {

    int x, y, l, r;// Position, radius and length of weapon
    boolean shoot = true; // If it has shot
    double theta,//degree of gun
    speed = 0.005;//speed of gun moving
    Color[] c = new Color [3];
    Random rand = new Random();
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
        for (int i=0 ; i<3 ; i++){
            c[i]=set_rand_color();
        } 
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
		

	if (State.instance.button[2]) {
	//if space button push shoot
            if ( shoot && State.instance.canShoot ) {
                shoot = false;
                State.instance.canShoot = false;
                Shoot ball = new Shoot(State.instance.radius , x + r / 2, y + r / 2, theta , c[0]);
                State.instance.add.add(ball);
                System.out.println("Shoot!!");
                c[0]=c[1];
                c[1]=c[2];
            }   c[2]=set_rand_color();
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
	g.setColor(c[0]);
	g.fillArc(x, y, r+5, r+5, 0, 180);
        g.setColor(c[1]);
	g.fillArc(x+5 *r, y, r, r, 0, 360);
	g.setColor(c[2]);
	g.fillArc(x+6 *r, y, r, r, 0, 360);
	g.setColor(Color.DARK_GRAY);
	g.drawLine(x + r / 2, y + r / 2, x + r / 2+ (int) (l * Math.cos(theta)),y + r / 2 + (int) (l * Math.sin(theta)));
    }

    private  Color set_rand_color(){
        int randomNum = rand.nextInt(5)+1 ;
        System.out.println(randomNum);
        switch(randomNum){
            case(1):
                return Color.RED;
            case(2):
                return Color.GREEN;
            case(3):
                return Color.YELLOW;
            case(4):
                return Color.MAGENTA;
            case(5):
                return Color.CYAN;
        }
        return Color.WHITE;
    }
}
