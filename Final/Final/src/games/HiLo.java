package games;

public class HiLo {
<<<<<<< HEAD

	static public int anti = 1500;
=======
	
	static boolean contuine = true;
	static int anti = 1500;
	
	public void game(boolean bool) {
		
			if(bool == true) {
				anti += 100;
				
			}else {
				
				if(bool==false) {
					anti-= 100;
					
				}
			}
		}
>>>>>>> parent of a1a50eb... Added to HiLo GUI

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
