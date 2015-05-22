package objects.elements;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import engine.Assets;
import objects.GameObject;

//TODO: Refine!
public class Gun implements GameObject {
	int x, y, r, l;
	Color c, c2;

	int modf;

	double angl = 0;

	int speed = 3;
	boolean shoot = false;

	String[] shoots = { "Bang!", "pew!", "Tadah!" };

	public Gun(int x, int y, int r, int l, Color c, Color c2) {
		this.x = x;
		this.y = y;
		this.r = r;
		this.l = l;
		this.c = c;
		this.c2 = c2;

		modf = (int) (r / 2);
	}

	@Override
	public void update() {
		float delta = Assets.delta; 
		boolean[] keys = Assets.buttons;
		
		if (keys[0]) {// l
			// x -= (int)speed*delta/1000;
			angl -= delta / 1000;
		}
		if (keys[1]) {// r
			// x += (int)speed*delta/1000;
			angl += delta / 1000;
		}
		if (keys[2] != shoot) {
			shoot = keys[2];
			if (shoot)
				System.out
						.println(shoots[(new Random()).nextInt(shoots.length)]);
		}
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(c);
		g.drawArc(x, y, r, r, 0, 360);

		g.setColor(c2);
		double s = Math.sin(Math.toRadians(angl));
		double c = Math.cos(Math.toRadians(angl));
		g.drawLine(modf + x, modf + y, x + modf + (int) (l * c), y + modf
				+ (int) (l * s));
	}


}
