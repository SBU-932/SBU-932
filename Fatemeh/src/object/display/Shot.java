package object.display;

import game.State;

import java.awt.Color;
import java.awt.Graphics;

import object.GameObj;

public class Shot implements GameObj {
	int r;// radius
	double x, y;// position
	double alpha;// degree of drop
	double speed = 1;// speed of drop
	int counter = 0;// mirror counter
	int max = 3;// max of mirror
	Color col;

	/*
	 * fixing every thing
	 */
	public Shot(int r, double x, double y, double alpha, Color col) {
		// TODO Auto-generated constructor stub
		this.r = r;
		this.x = x;
		this.y = y;
		this.alpha = alpha;
		this.col = col;

	}

	public Color getcolor() {
		return col;
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

		// place of Shot in per delta
		x += speed * Math.cos(alpha) * State.getInstance().delta;
		y += speed * Math.sin(alpha) * State.getInstance().delta;

		// check position of Shot
		if (y < 0 || y > State.getInstance().width) {
			goout();
		}
		if (x <= 0 || x >= State.getInstance().length) {
			mirror();
		}

		int tmp = State.getInstance().blocks.bump(this);
		if (tmp == 0) {
			System.out.println("dfghj");
			successful();
		} else if (tmp == 1) {
			hitWrong();
		}
	}

	private void hitWrong() {
		// TODO Auto-generated method stub
		State.getInstance().Score--;
		State.getInstance().frame.setTitle("Score: "
				+ State.getInstance().Score);

		State.getInstance().engine.remove(this);
		State.getInstance().canShot = true;
		State.getInstance().failcount++;
	}

	private void mirror() {
		// TODO Auto-generated method stub
		counter++;
		alpha = Math.PI - alpha;
		System.out.println(alpha);
		if (counter > max) {
			goout();
		}
	}

	private void successful() {
		// TODO Auto-generated method stub
		State.getInstance().Score += 2;
		State.getInstance().frame.setTitle("Score: "
				+ State.getInstance().Score);

		State.getInstance().engine.remove(this);
		State.getInstance().canShot = true;
		State.getInstance().failcount = 0;
	}

	/*
	 * This is called when a Shot is went out of window
	 */
	private void goout() {
		// TODO Auto-generated method stub
		State.getInstance().Score--;
		State.getInstance().frame.setTitle("Score: "
				+ State.getInstance().Score);

		State.getInstance().engine.remove(this);
		State.getInstance().canShot = true;
		State.getInstance().failcount++;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see object.GameObj#draw(java.awt.Graphics) this method draw Shot
	 */
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.WHITE);
		g.fillRect((int) x, (int) y, r, r);

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}
	
	public double getAlpha() {
		return alpha;
	}

}
