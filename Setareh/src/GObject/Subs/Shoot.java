package GObject.Subs;

import Controler.Engine;
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
	Color color;//ball color
        Random rand = new Random();
	int counter=0;//mirror counter
	int max_mirror = 2;
        /*
	 * fixing every thing
	 */
	public Shoot(int r,double x,double y,double alpha , Color color) {
            // TODO Auto-generated constructor stub
            this.r =r;
            this.x=x;
            this.y=y;
            this.alpha=alpha;
            this.color=color;//select color for our ball 
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
		if( y<0 || y> State.instance.width){
			goout();
		}
		if(x <=0|| x>=State.instance.length){
			mirror();
		}
		
		if(State.instance.blocks.bump(this)){
			System.out.println("BoooM");
                        successful();
                        State.instance.score+=2;
			
		}
	}
	

	/*
	 * This is called when a Shot is went out of window
	 */
	private void goout() {
		Engine.remove(this);
		State.instance.canShoot=true;
		State.instance.fail_count++;
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
            g.fillOval((int)x, (int)y, r-3, r-3);
		
		
		
	}
        //this method give us random color between our 5 colors
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
        private void successful() {
		// TODO Auto-generated method stub
		Engine.remove(this);
		State.instance.canShoot=true;
		State.instance.fail_count=0;
	}
        private void mirror() {
		// TODO Auto-generated method stub
		counter ++;
		alpha = Math.PI- alpha;
		System.out.println(alpha);
		if(counter >max_mirror){
			goout();
		}
	}
}
