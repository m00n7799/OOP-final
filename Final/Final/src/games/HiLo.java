package games;

public class HiLo {
	
	static boolean contuine = true;
	static public int anti = 1500;
	
	public void game(boolean bool) {
		
			if(bool == true) {
				anti += 100;
				
			}else {
				
				if(bool==false) {
					anti-= 100;
					
				}
			}
		}

	public void lose() {
		if (anti == -100) {
			
		}
	}


	}
