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
		check();
	}

	private void check() {
		wincheck();
		
		boolean[][] isConnected = new boolean[State.getInstance().Nr][State.getInstance().Nc];
		for (int i = 0; i < isConnected[0].length; i++)
			isConnected[0][i] = State.getInstance().block[0][i];

		for (int j = 0; j < isConnected[0].length; j++) {
			for (int i = 0; i < isConnected.length; i++) {
				if (isConnected[i][j]) {
					try {
						if (State.getInstance().block[i + 1][j])
							isConnected[i + 1][j] = true;
					} catch (IndexOutOfBoundsException e) {

					}

					try {
						if (State.getInstance().block[i - 1][j])
							isConnected[i - 1][j] = true;
					} catch (IndexOutOfBoundsException e) {

					}

					try {
						if (State.getInstance().block[i][j + 1])
							isConnected[i][j + 1] = true;
					} catch (IndexOutOfBoundsException e) {

					}

					try {
						if (State.getInstance().block[i][j - 1])
							isConnected[i][j - 1] = true;
					} catch (IndexOutOfBoundsException e) {

					}
				}
			}
		}

		State.getInstance().block = isConnected;
		
		
		
	}

	private void wincheck() {
		boolean won = true;
		
		for(int i = 0; i < State.getInstance().Nr; i++)
			for(int j = 0; j < State.getInstance().Nc; j++)
				if(State.getInstance().block[i][j]) won = false;
		
		if(won){
			//TODO: won
		}
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

		for (int i = State.getInstance().Nr - 1; i >= 0; i--) {
			for (int j = State.getInstance().Nc - 1; j >= 0; j--) {
				if (State.getInstance().block[i][j])
					g.fillRect(i * State.getInstance().row + 1,
							j * State.getInstance().clom + 1,
							State.getInstance().row - 1,
							State.getInstance().clom - 1);
			}
		}
	}

	public boolean bump(Shot shot) {

		int x = ((int) shot.getX()) / State.getInstance().row;
		int y = ((int) shot.getY()) / State.getInstance().clom;
		if (x >= 0 & y >= 0 & x < State.getInstance().Nr
				& y < State.getInstance().Nc) {
			if (State.getInstance().block[x][y]) {
				State.getInstance().block[x][y] = false;
				System.out.println(x + " " + y);
				return true;
			}
		}

		return false;

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	public void line() {
		forloop:for (int i = 0; i < State.getInstance().Nr; i++) {
			int j = 0;
			while (State.getInstance().block[i][j++]) {
				if (j == State.getInstance().Nc) {
					State.getInstance().engine.end();
					break forloop;
				}
			}
			State.getInstance().block[i][j-1]= true;
		}
		State.getInstance().passTime=0;
		State.getInstance().failcount=0;
	}
}
