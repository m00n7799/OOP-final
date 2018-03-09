package games;

public class HiLo {
	
	static public int anti = 1500;

	public static void game(boolean bool) {

		if (bool == true) {
			anti += 100;
		} else {

			if (bool == false) {
				anti -= 100;
			}
		}
	}
}
