package wargaming_api;

import java.awt.Color;

public class Wn8Color {
	
	public static Color getColor (double wn8) {
	
		if (wn8 >= 300 && wn8 < 600) {
			return Color.RED;
		}
		if (wn8 >= 600 && wn8 < 900) {
			return Color.ORANGE;
		}
		if (wn8 >= 900 && wn8 < 1250) {
			return Color.YELLOW;
		}
		if (wn8 >= 1250 && wn8 < 1600) {
			return new Color(144, 238, 144);
		}
		if (wn8 >= 1600 && wn8 < 1900) {
			return Color.GREEN;
		}
		if (wn8 >= 1900 && wn8 < 2350) {
			return Color.CYAN;
		}
		if (wn8 >= 2350 && wn8 < 2900 ) {
			return new Color(177, 156, 217);
		}
		if (wn8 >= 2900) {
			return new Color (48, 25, 52);
		}
		return Color.BLACK;
		
	}
}
