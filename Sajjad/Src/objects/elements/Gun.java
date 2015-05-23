package objects.elements;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import engine.Assets;
import objects.GameObject;

//TODO: Refine!
public class Gun implements GameObject {
	int x, y, r, l;// Position, radius and length of weapon
	Color c, c2;// Color of tank and the gun

	int modf; // Modifier used for gun's position to be in center

	double angl = 0; // Angel at which the gun is pointing to
	double speed = 0.1 ; // Angel's speed per second

	boolean shoot = false; // If it has shot

	String[] shoots = { "Bang!", "pew!", "Tadah!" };// Debug

	/*
	 * Assigning everything!
	 */
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
		
		//Set angle based on input
		if (Assets.buttons[0]) {
			angl -= Assets.delta * speed;
		}
		if (Assets.buttons[1]) {
			angl += Assets.delta * speed;
		}

		//shoot
		if (Assets.buttons[2] != shoot) {
			// If space statuse with current shot
			// status is different, there has been a
			// press
			shoot = Assets.buttons[2]; // Assign the current space state to
										// shoot
			if (shoot) {// If the current key state is positive, it's beginning
						// of
						// press, so shoot!
				System.out
						.println(shoots[(new Random()).nextInt(shoots.length)]);
				
				Bullet b = new Bullet(x + modf, y + modf, 5, 0.5, angl);
				Assets.engine.add(b);
				
			}
		}

		
		//Modifier so gun will always be on top
		if (angl > 0)
			angl = 0;
		if (angl < -180)
			angl = -180;

	}

	@Override
	public void draw(Graphics g) {
		g.setColor(c);
		//g.drawArc(x, y, r, r, 0, 360);
		g.fillArc(x, y, r, r, 0, 360);

		g.setColor(c2);
		double s = Math.sin(Math.toRadians(angl));
		double c = Math.cos(Math.toRadians(angl));
		g.drawLine(modf + x, modf + y, x + modf + (int) (l * c), y + modf
				+ (int) (l * s));
	}

}
