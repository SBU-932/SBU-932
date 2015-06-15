package objects.elements;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import engine.Assets;
import objects.GameObject;
import objects.blocks.Type;

//TODO: Refine!
public class Gun2 implements GameObject {
	int x, y, r, l;// Position, radius and length of weapon
	Color c, c2;// Color of tank and the gun

	Color b1, b2;// Color of next balls

	private Random rnd;

	int modf; // Modifier used for gun's position to be in center

	double angl = 0; // Angel at which the gun is pointing to
	double speed = 0.1; // Angel's speed per second

	boolean shoot = false; // If it has shot

	/*
	 * Assigning everything!
	 */
	public Gun2(int x, int y, int r, int l, Color c, Color c2) {
		this.x = x;
		this.y = y;
		this.r = r;
		this.l = l;
		this.c = c;
		this.c2 = c2;

		b1 = rndColor();
		b2 = rndColor();

		modf = (int) (r / 2);
	}

	/*
	 * creates a random color
	 */
	private Color rndColor() {
		rnd = new Random();

		return Type.getType(rnd.nextInt(5)).getColor();
	}

	@Override
	public void update() {

		// Set angle based on input
		if (Assets.buttons[0]) {
			angl -= Assets.delta * speed;
		}
		if (Assets.buttons[1]) {
			angl += Assets.delta * speed;
		}

		// shoot
		if (Assets.buttons[2] != shoot) {
			// If space statuse with current shot
			// status is different, there has been a
			// press
			shoot = Assets.buttons[2]; // Assign the current space state to
										// shoot
			if (shoot && Assets.canShoot) {// If the current key state is
											// positive, it's beginning
				// of
				// press, so shoot!

				Bullet2 b = new Bullet2(x + modf, y + modf, Assets.bSizeW - 1
						+ Assets.boffset, 0.5, angl, b1);
				Assets.engine.add(b);

				b1 = b2;
				b2 = rndColor();

				Assets.canShoot = false;// You can shoot one bullet at a time

			}
		}

		// Modifier so gun will always be on top
		if (angl > 0)
			angl = 0;
		if (angl < -180)
			angl = -180;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(c);
		// g.drawArc(x, y, r, r, 0, 360);
		g.fillArc(x, y, r, r, 0, 360);

		// Draw waiting line
		g.setColor(b1);
		g.fillArc(x + 3 * r, y, r, r, 0, 360);
		g.setColor(b2);
		g.fillArc(x + 5 * r, y, r, r, 0, 360);

		g.setColor(c2);
		double s = Math.sin(Math.toRadians(angl));
		double c = Math.cos(Math.toRadians(angl));
		g.drawLine(modf + x, modf + y, x + modf + (int) (l * c), y + modf
				+ (int) (l * s));
	}

}
