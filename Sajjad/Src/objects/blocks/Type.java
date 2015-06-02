package objects.blocks;

import java.awt.Color;

public enum Type {
	red(0), green(1), yellow(2), violet(3), blue(4);

	int n;

	Type(int t) {
		n = t;
	}

	public static Type getType(int i) {
		switch (i) {
		case 0:
			return red;
		case 1:
			return green;
		case 2:
			return yellow;
		case 3:
			return violet;
		case 4:
			return blue;
		default:
			return null;
		}
	}

	public Color getColor() {
		switch (n) {
		case 0:
			return Color.RED;
		case 1:
			return Color.GREEN;
		case 2:
			return Color.YELLOW;
		case 3:
			return Color.MAGENTA;
		case 4:
			return Color.BLUE;
		default:
			return Color.WHITE;
		}
	}
}
