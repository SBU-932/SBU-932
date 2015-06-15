package objects.elements;

import java.awt.Color;
import java.awt.Graphics;

import engine.Assets;
import objects.GameObject;

public class Bullet2 implements GameObject {

	double x, y;// position
	int r;// radius
	int count = 0; // Mirror count
	int maxCount = 3;// Maximum mirror count

	double alpha, speed; // the degree and speed

	int modf;// This is to draw aafrom center

	Color c;

	public Color getC() {
		return c;
	}

	public Bullet2(int x, int y, int r, double speed, double alpha, Color c) {
		this.x = x;
		this.y = y;
		this.r = r;
		this.speed = speed;
		this.alpha = Math.toRadians(alpha);
		this.c = c;
		//modf = r / 2;
	}

	@Override
	public void update() {
		x += speed * Math.cos(alpha) * Assets.delta;
		y += speed * Math.sin(alpha) * Assets.delta;

		if (y < 0 || y > Assets.picH) {
			out();
		} else if (x <= 0 || x >= Assets.picW) {
			mirror();
		} else {
			int tmp = Assets.blockManager.onTarget(this);
			if (tmp > 0) {
				if(tmp == 1)
					hit();
				if(tmp == 2)
					out();
			}
		}
	}

	/*
	 * Mirrors the movement
	 */
	private void mirror() {
		count++;
		alpha = Math.PI - alpha;
		System.out.println(alpha);
		if (count > maxCount)
			out();
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(c);
		g.fillArc((int) x + modf, (int) y + modf, r, r, 0, 360);
	}

	/*
	 * This is called when a bullet is went out of window
	 */
	private void out() {
		Assets.engine.remove(this);
		Assets.canShoot = true;

		Assets.failCount++;
	}

	/*
	 * This is called when a bullet has hit the target
	 */
	private void hit() {
		// System.out.println("Hit");
		Assets.score++;
		Assets.jSore.setText("Score: " + Assets.score);

		Assets.engine.remove(this);
		Assets.canShoot = true;

		Assets.failCount = 0;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getSpeed() {
		return speed;
	}

	public double getAlpha() {
		// TODO Auto-generated method stub
		return alpha;
	}

}
