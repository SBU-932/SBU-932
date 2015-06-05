package objects.blocks;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import engine.Assets;
import objects.GameObject;
import objects.elements.Bullet;
import objects.elements.Bullet2;

public class BlockManager2 extends BlockManager implements GameObject {

	private Type[][] blocks;// This holds the blocks

	public BlockManager2() {
		Assets.blockManager = this;

		Assets.bSizeH = Assets.picH / Assets.BIC;
		Assets.bSizeW = Assets.picW / Assets.BIR;

		blocks = new Type[Assets.BIC][Assets.BIR];

		Random rnd = new Random();

		for (int i = 0; i < Assets.BIR; i++) {
			int r = rnd.nextInt(Assets.BIC - 7);
			// r = 3;
			r += 3;
			for (int j = 0; j < r; j++) {
				blocks[j][i] = Type.getType(rnd.nextInt(5));
			}
		}
	}

	@Override
	public void update() {
		// TODO: check for fall
	}

	@Override
	public void draw(Graphics g) {

		g.setColor(Color.BLUE);
		
		for (int i = 0; i < Assets.BIC; i++) {
			for (int j = 0; j < Assets.BIR; j++) {
				if (blocks[i][j] != null) {
					g.setColor(blocks[i][j].getColor());
					g.fillRect(j * Assets.bSizeW + 1, i * Assets.bSizeH + 1,
							Assets.bSizeW - 1, Assets.bSizeH - 1);
				}
			}
		}
	}

	/*
	 * Returns whether or not a bullet has hit the target
	 */
	public boolean onTarget(Bullet b) {
		int x = (int) b.getX();
		int y = (int) b.getY();
		int j = x / Assets.bSizeW;
		int i = y / Assets.bSizeH;
		try {
			if (blocks[i][j]!=null) {
				blocks[i][j] = null;
				check();
				return true;
			}
		} catch (IndexOutOfBoundsException e) {

		}

		return false;
	}

	/*
	 * On target for Bullet 2
	 */
	public int onTarget(Bullet2 b) {
		// TODO: improve for Bullet2 (if nec..)
		int x = (int) b.getX();
		int y = (int) b.getY();
		int j = x / Assets.bSizeW;
		int i = y / Assets.bSizeH;
		try {
			if (blocks[i][j]!=null && blocks[i][j].getColor().equals(b.getC())) {
				blocks[i][j] = null;
				
				//BEGIN: Check neigbours
				
				
				//END: Check neighbours
				
				check();
				return 1;
			} 
			if (blocks[i][j]!=null){
				return 2;
			}
		} catch (IndexOutOfBoundsException e) {

		}

		return 0;
	}

	/*
	 * Adds a line
	 */
	public void addLine() {
		try {
			Random rnd = new Random();
			for (int i = 0; i < Assets.BIR; i++) {
				int j = 0;
				
				if( blocks[Assets.BIC -1][i] != null) Assets.engine.gameOver();
				
				j = Assets.BIC-1;
				
				for(int k = j ; k > 0; k --){
					blocks[k][i] = blocks[k-1][i];
				}
				
				
				blocks[0][i] = Type.getType(rnd.nextInt(5));
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			Assets.engine.gameOver();
		}

		// System.out.println("Added line"); // Debug:
		Assets.failCount = 0;
		Assets.timePassed = 0;
	}

	/*
	 * Checks for falling blocks
	 */
	public void check() {
		winCheck();

		boolean[][] isConnected = new boolean[Assets.BIC][Assets.BIR];
		for (int i = 0; i < isConnected[0].length; i++)
			isConnected[0][i] = blocks[0][i]!=null;

		for (int j = 0; j < isConnected[0].length; j++) {
			for (int i = 0; i < isConnected.length; i++) {
				if (isConnected[i][j]) {
					try {
						if (blocks[i+1][j]!=null)
							isConnected[i + 1][j] = true;
					} catch (IndexOutOfBoundsException e) {

					}

					try {
						if (blocks[i-1][j]!=null)
							isConnected[i - 1][j] = true;
					} catch (IndexOutOfBoundsException e) {

					}

					try {
						if (blocks[i][j+1]!=null)
							isConnected[i][j + 1] = true;
					} catch (IndexOutOfBoundsException e) {

					}

					try {
						if (blocks[i][j-1]!=null)
							isConnected[i][j - 1] = true;
					} catch (IndexOutOfBoundsException e) {

					}
				}
			}
		}

		for (int i = 0; i < isConnected.length; i++)
			for (int j = 0; j < isConnected[i].length; j++)
				if (!isConnected[i][j])
					blocks[i][j] = null;

		// blocks = isConnected;
	}

	private void winCheck() {
		boolean win = true;
		for (Type[] boo : blocks)
			for (Type b : boo)
				if (b != null)
					win = false;
		if (win)
			Assets.engine.win();
	}
}
