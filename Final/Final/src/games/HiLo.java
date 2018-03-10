package games;

public class HiLo {
	
	static public int anti = 0;

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
