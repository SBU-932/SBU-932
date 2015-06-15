package object.block;

import java.awt.Color;


public enum Colour {
	red(0),blue(1),yellow(2),green(3),magenta(4);
	int n;
	private Colour(int t) {
		// TODO Auto-generated constructor stub
		n = t;
	}
	
	
	
	public static Colour getType(int i) {
		switch (i) {
		case 0:
			return red;
		case 1:
			return blue;
		case 2:
			return yellow;
		case 3:
			return green;
		case 4:
			return magenta;
		default:
			return null;
		}
	}
	
	
	
	public Color getColor() {
		switch (n) {
		case 0:
			return Color.RED;
		case 1:
			return Color.BLUE;
		case 2:
			return Color.YELLOW;
		case 3:
			return Color.GREEN;
		case 4:
			return Color.MAGENTA;
		default:
			return Color.WHITE;
		}
	}

}
