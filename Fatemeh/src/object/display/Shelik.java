/**
 * 
 */
package object.display;

import java.awt.Color;
import java.awt.Graphics;

import object.GameObj;

/**
 * @author M
 *
 */
public class Shelik implements GameObj {
	
	int x,y,l,r;
	double alpha;
	public Shelik(int x,int y,int length,int r,double alpha) {
		// TODO Auto-generated constructor stub
		this.x=x;
		this.y=y;
		this.l=length;
		this.r=r;
		this.alpha=alpha;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.MAGENTA);
		g.fillArc(x, y, r, r, 0, 360);
		
		g.setColor(Color.YELLOW);
		g.drawLine(x+r/2, y+r/2, x+r/2 + (int)l*(int)Math.cos(alpha), y+r/2+(int)l*(int)Math.sin(alpha));
		
		
		System.out.println("Here");
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

}
