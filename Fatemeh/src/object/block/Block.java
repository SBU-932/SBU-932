package object.block;

import game.State;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import object.GameObj;
import object.display.Shot;

public class Block implements GameObj {

	public Block() {
		// TODO Auto-generated constructor stub
		State.getInstance().blocks = this;

		// calculate length and width of block
		State.getInstance().row = (State.getInstance().length / State
				.getInstance().Nr);
		State.getInstance().clom = (State.getInstance().width / State
				.getInstance().Nc) - 10;

		// meghdar dehi be array block
		State.getInstance().block = new boolean[State.getInstance().Nr][State
				.getInstance().Nc];

		Random Rn = new Random();

		for (int i = State.getInstance().Nr - 1; i >= 0; i--) {
			int rn = Rn.nextInt(State.getInstance().clom);
			rn += 3;
			for (int j = 0; j < rn; j++) {
				State.getInstance().block[i][j] = true;
			}
		}
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see object.GameObj#draw(java.awt.Graphics) this method draw blocks
	 */
	@Override
	public void draw(Graphics g) {
		// TODO
		g.setColor(Color.RED);
	}

	public boolean bump(Shot shot) {
		return false;

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

}
