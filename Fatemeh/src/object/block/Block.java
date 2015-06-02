package object.block;

import game.State;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import object.GameObj;

public class Block implements GameObj {

	public Block() {
		// TODO Auto-generated constructor stub
		State.getInstance().blocks = this;
		State.getInstance().row = (State.getInstance().width / State
				.getInstance().Nr);
		State.getInstance().clom = (State.getInstance().heigth / State
				.getInstance().Nc) - 10;
		Random Rn = new Random();
		State.getInstance().block = new boolean[State.getInstance().Nr][State
				.getInstance().Nc];

		for (int i = State.getInstance().Nr - 1; i >= 0; i--) {
			int rn = Rn.nextInt(State.getInstance().clom);
			rn += 3;
			for (int j = 0; j<rn; j++) {
				
				State.getInstance().block[i][j] = true;
			}
		}
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub

		g.setColor(Color.RED);

		for (int i = State.getInstance().Nr - 1; i >= 0; i--) {
			for (int j = State.getInstance().Nc - 1; j >= 0; j--) {
				if (State.getInstance().block[i][j]) {

					g.fillRect(i * State.getInstance().row + 1,
							j * State.getInstance().clom + 1,
							State.getInstance().row - 1,
							State.getInstance().clom - 1);

				}
			}
		}

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

}
