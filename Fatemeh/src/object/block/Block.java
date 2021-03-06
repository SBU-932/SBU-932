package object.block;

import game.State;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import object.GameObj;
import object.display.Shot;

public class Block implements GameObj {
	private Random Rn;

	public Block() {
		// TODO Auto-generated constructor stub
		State.getInstance().blocks = this;

		// calculate length and width of block
		State.getInstance().row = (State.getInstance().length / State
				.getInstance().Nr);
		State.getInstance().clom = (State.getInstance().width / State
				.getInstance().Nc) - 5;

		// meghdar dehi be array block
		State.getInstance().block = new Colour[State.getInstance().Nr][State
				.getInstance().Nc];

		Rn = new Random();

		for (int i = State.getInstance().Nr - 1; i >= 0; i--) {
			int rn = Rn.nextInt(State.getInstance().Nr - 10);
			rn += 3;
			for (int j = 0; j < rn; j++) {
				State.getInstance().block[i][j] = Colour.getType(Rn.nextInt(5));
			}
		}
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		check();
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
				if (State.getInstance().block[i][j] != null) {
					g.setColor(State.getInstance().block[i][j].getColor());
					// g.fillRect(i * State.getInstance().row + 1,
					// j * State.getInstance().clom + 1,
					// State.getInstance().row - 1,
					// State.getInstance().clom - 1);

					// g.drawImage(State.getInstance().ball,
					// i * State.getInstance().row + 1,
					// j * State.getInstance().clom + 1,
					// State.getInstance().block[i][j].getColor(), null);

					g.fillArc(i * State.getInstance().row + 1,
							j * State.getInstance().clom + 1,
							State.getInstance().row - 1,
							State.getInstance().clom - 1, 0, 360);

				}

			}
		}
	}

	public int bump(Shot shot) {

		int x = ((int) shot.getX()) / State.getInstance().row;
		int y = ((int) shot.getY()) / State.getInstance().clom;

		try {
			if (State.getInstance().block[x][y] != null) {
				Colour p = null;
				for (int i = 0; i < 5; i++)
					if (shot.getcolor().equals(Colour.getType(i).getColor()))
						p = Colour.getType(i);
				double alpha = shot.getAlpha();

				int deltaX = (int) (Math.cos(alpha) * 2);
				int deltaY = (int) (Math.sin(alpha) * 2);

				if (x - deltaY > State.getInstance().block.length
						|| y - deltaX > State.getInstance().block[x].length)
					State.getInstance().engine.end();

				State.getInstance().block[x - deltaX][y - deltaY] = p;
				x -= deltaX;
				y -= deltaY;
				while (State.getInstance().block[x - 1][y] == null
						&& State.getInstance().block[x][y - 1] == null
						&& State.getInstance().block[x][y + 1] == null
						&& State.getInstance().block[x + 1][y] == null) {
					if (x == 0)
						break;
					y--;
					State.getInstance().block[x][1+y] = null;
					State.getInstance().block[x][y] = p;
				}
			}
		} catch (IndexOutOfBoundsException e) {

		}

		if (x >= 0 & y >= 0 & x < State.getInstance().Nr
				& y < State.getInstance().Nc) {
			if (State.getInstance().block[x][y] != null
					&& State.getInstance().block[x][y].getColor().equals(
							shot.getcolor())) {

				ArrayList<Pair<Integer, Integer>> check = new ArrayList<>();
				ArrayList<Pair<Integer, Integer>> remove = new ArrayList<>();

				check.add(new Pair<Integer, Integer>(x, y));

				for (int i = 0; i < check.size(); i++) {
					int I = check.get(i).first, J = check.get(i).second;

					try {
						if (State.getInstance().block[I + 1][J] != null
								&& State.getInstance().block[I + 1][J]
										.getColor().equals(shot.getcolor()))
							if (!has(check, I + 1, J))
								check.add(new Pair<Integer, Integer>(I + 1, J));
					} catch (IndexOutOfBoundsException e) {
					}

					try {
						if (State.getInstance().block[I - 1][J] != null
								&& State.getInstance().block[I - 1][J]
										.getColor().equals(shot.getcolor()))
							if (!has(check, I - 1, J))
								check.add(new Pair<Integer, Integer>(I - 1, J));
					} catch (IndexOutOfBoundsException e) {
					}

					try {
						if (State.getInstance().block[I][J + 1] != null
								&& State.getInstance().block[I][J + 1]
										.getColor().equals(shot.getcolor()))
							if (!has(check, I, J + 1))
								check.add(new Pair<Integer, Integer>(I, J + 1));
					} catch (IndexOutOfBoundsException e) {
					}

					try {
						if (State.getInstance().block[I][J - 1] != null
								&& State.getInstance().block[I][J - 1]
										.getColor().equals(shot.getcolor()))
							if (!has(check, I, J - 1))
								check.add(new Pair<Integer, Integer>(I, J - 1));
					} catch (IndexOutOfBoundsException e) {
					}

					remove.add(check.get(i));
				}

				if (remove.size() > 2)
					for (int i = 0; i < remove.size(); i++) {
						State.getInstance().block[remove.get(i).first][remove
								.get(i).second] = null;
					}

				return 0;// Hit
			}
		}
		try {
			if (State.getInstance().block[x][y] != null) {
				return 1;// Hit wrong
			}
		} catch (IndexOutOfBoundsException e) {
		}

		return 2;// Nothing
	}

	private boolean has(ArrayList<object.block.Pair<Integer, Integer>> check,
			int I, int J) {
		for (int i = 0; i < check.size(); i++) {
			if (check.get(i).first == I)
				if (check.get(i).second == J)
					return true;
		}
		return false;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	public void line() {
		forloop: for (int i = 0; i < State.getInstance().Nr; i++) {
			int j = 0;
			while (State.getInstance().block[i][j++] != null) {
				if (j == State.getInstance().Nc) {
					State.getInstance().engine.end();
					break forloop;
				}
			}
			for (j = j - 1; j >= 1; j--)
				State.getInstance().block[i][j] = State.getInstance().block[i][j - 1];
			State.getInstance().block[i][0] = Colour.getType(Rn.nextInt(5));
		}
		State.getInstance().passTime = 0;
		State.getInstance().failcount = 0;
	}

	public void check() {
		win();

		boolean[][] isConnected = new boolean[State.getInstance().Nr][State
				.getInstance().Nc];
		for (int i = 0; i < isConnected[0].length; i++)
			isConnected[0][i] = State.getInstance().block[0][i] != null;

		for (int j = 0; j < isConnected[0].length; j++) {
			for (int i = 0; i < isConnected.length; i++) {
				if (isConnected[i][j]) {
					try {
						if (State.getInstance().block[i + 1][j] != null)
							isConnected[i + 1][j] = true;
					} catch (IndexOutOfBoundsException e) {

					}

					try {
						if (State.getInstance().block[i - 1][j] != null)
							isConnected[i - 1][j] = true;
					} catch (IndexOutOfBoundsException e) {

					}

					try {
						if (State.getInstance().block[i][j + 1] != null)
							isConnected[i][j + 1] = true;
					} catch (IndexOutOfBoundsException e) {

					}

					try {
						if (State.getInstance().block[i][j - 1] != null)
							isConnected[i][j - 1] = true;
					} catch (IndexOutOfBoundsException e) {

					}
				}
			}
		}
		for (int i = 0; i < isConnected.length; i++)
			for (int j = 0; j < isConnected[i].length; j++)
				if (!isConnected[i][j])
					State.getInstance().block[i][j] = null;
	}

	private void win() {
		boolean win = true;
		for (Colour[] boo : State.getInstance().block)
			for (Colour b : boo)
				if (b != null)
					win = false;
		if (win)
			State.getInstance().engine.win();
	}
}
