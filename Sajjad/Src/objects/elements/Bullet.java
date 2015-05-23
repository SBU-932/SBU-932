package objects.elements;

import java.awt.Color;
import java.awt.Graphics;

import engine.Assets;
import objects.GameObject;

public class Bullet implements GameObject {

	double x, y;//position 
	int r;// radius

	double alpha, speed; // the degree and speed

	int modf;// This is to draw from center

	public Bullet(int x, int y, int r, double speed, double alpha) {
		this.x = x;
		this.y = y;
		this.r = r;
		this.speed = speed;
		this.alpha = Math.toRadians(alpha);

		modf = r / 2;
	}

	@Override
	public void update() {
		x += speed * Math.cos(alpha) * Assets.delta;
		y += speed * Math.sin(alpha) * Assets.delta;
		
		
		if(x < 0 || y < 0 || x > Assets.picW || y > Assets.picH)
			Assets.engine.remove(this);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillArc((int)x + modf, (int)y + modf, r, r, 0, 360);
	}

}