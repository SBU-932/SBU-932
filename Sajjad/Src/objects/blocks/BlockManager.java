package objects.blocks;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import engine.Assets;
import objects.GameObject;

public class BlockManager implements GameObject {

	private boolean[][] blocks;// This holds the blocks

	public BlockManager() {
		Assets.blockManager = this;

		Assets.bSizeH = Assets.picH / Assets.BIC;
		Assets.bSizeW = Assets.picW / Assets.BIR;

		blocks = new boolean[Assets.BIC][Assets.BIR];

		Random rnd = new Random();

		for (int i = 0; i < Assets.BIR; i++) {
			int r = rnd.nextInt(Assets.BIC- 7);
			//r = 3;
			r+=3;
			for (int j = 0; j < r; j++) {
				blocks[j][i] = true;
			}
		}
	}

	@Override
	public void update() {
		//TODO: check for fall
	}

	@Override
	public void draw(Graphics g) {
		
		g.setColor(Color.BLUE);
		
		for (int i = 0; i < Assets.BIC; i++) {
			for (int j = 0; j < Assets.BIR; j++) {
				if (blocks[i][j]) {
					g.fillRect(j * Assets.bSizeW + 1, i * Assets.bSizeH + 1,
							Assets.bSizeW - 1, Assets.bSizeH - 1);
				}
			}
		}
	}

}
