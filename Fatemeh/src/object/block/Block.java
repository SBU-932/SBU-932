package object.block;

import game.State;

import java.awt.Color;
import java.awt.Graphics;

import object.GameObj;

public class Block implements GameObj {

	public Block() {
		// TODO Auto-generated constructor stub
		State.getInstance().blocks = this;
		State.getInstance().Nr = (State.getInstance().width / State
				.getInstance().clom) - 10;
		State.getInstance().Nc = (State.getInstance().heigth / State
				.getInstance().row) - 10;
		State.getInstance().block = new boolean[State.getInstance().Nr][State
				.getInstance().Nc];

		for (int i = State.getInstance().Nr; i < 0; i--) {
			for (int j = State.getInstance().Nc; j < 0; j--) {

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

		State.getInstance().g.setColor(Color.RED);

		for (int i = State.getInstance().Nr; i < 0; i--) {
			for (int j = State.getInstance().Nc; j < 0; j--) {
				if (State.getInstance().block[i][j]) {
					State.getInstance().g.fillRect(j, i,
							State.getInstance().row, State.getInstance().clom);

				}
			}
		}

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

}
