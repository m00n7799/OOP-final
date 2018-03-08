package games;

public class HiLo {
	
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

	public void lose() {
		if (anti == -50) {
			// lose
		} else {
			// ask if they'd like to quit
		}
	}

	public void win() {
		if (contuine == false) {
			// win sorta
		} else {

		}
	}
}
