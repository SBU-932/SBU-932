package GObject.Subs;

import Controler.State;

import java.awt.Color;
import java.awt.Graphics;

import GObject.GameObj;
import java.util.Random;

public class Shoot implements GameObj {
	int r;//radius
	double x,y;//position
	double alpha;//degree of drop
	double speed = 1;//speed of drop
	Color color;
	/*
	 * fixing every thing
	 */
	public Shoot(int r,double x,double y,double alpha) {
            // TODO Auto-generated constructor stub
            this.r =r;
            this.x=x;
            this.y=y;
            this.alpha=alpha;
            color=set_rand_color();
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
		x+=speed*Math.cos(alpha)*State.instance.delta;
		y+=speed*Math.sin(alpha)*State.instance.delta;
		
		//check position of Shot
		if( x <0 || y<0 || x> State.instance.length || y> State.instance.width){
			goout();
		}
		
		if(State.instance.blocks.bump(this)){
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
            g.setColor(color);
            g.fillOval((int)x, (int)y, r, r);
		
		
		
	}
        private  Color set_rand_color(){
        
        Random rand = new Random();
        int randomNum = rand.nextInt(5)+1 ;
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