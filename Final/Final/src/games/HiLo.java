package games;

public class HiLo {
<<<<<<< HEAD
=======
	
	static boolean contuine = true;
	static int anti = 1500;
	
	public void game(boolean bool) {
			if(bool == true) {
				anti += 100;
				win();
			}else {
				if(bool==false) {
					anti-= 100;
					lose();
				}
			}
		}
>>>>>>> parent of 730719b... Nono

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
