package game;

public class Game {
	int nightsPassed;
	boolean day, night, win, lose;
	int actionCount;

	public static void main(String[] args) {
		Game game = new Game();
		while(!game.checkCondition()) {
			
		}

	}

	public Game() {
		nightsPassed = 0;
		day = true;
		night = false;
		win = false;
		lose = false;
		actionCount = 0;
	}
	
	public boolean checkCondition() {
		if(win) {
			System.out.println("YOU WIN");
			return true;
		}
		else {
			if(lose) {
				System.out.println("YOU LOSE");
				return true;
			}
		}
		return false;
	}

	public void dayAndNightCycle() {
		if(day && !night) {
			day = false;
			night = true;
		}
		else {
			day = true;
			night = false;
		}
	}

	public void action() {
		actionCount++;
	}

	public void encounterMonsters() {
		
	}

}
