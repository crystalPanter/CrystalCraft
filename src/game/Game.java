package game;

import java.util.Scanner;

public class Game {
	int nightsPassed;
	boolean day, night, win, lose;
	int actionCount;

	public static void main(String[] args) {
		Game game = new Game();
		User user = new User();
		Monsters monsters = new Monsters();
		Scanner scan = new Scanner(System.in);
		while (!game.checkCondition()) {
			
			if (game.day) {
				System.out.println("******A new day has dawned. What will you do?*****");
				System.out.println(" 1 ) Collect");
				System.out.println(" 2 ) Craft");
				System.out.println(" 3 ) Explore");
				System.out.println("Please enter your choice number: ");
				int choice = scan.nextInt();
				if (choice == 1) {
					user.collect();
					game.dayAndNightCycle();
				} else if (choice == 2) {
					user.craft();
					game.dayAndNightCycle();
				} else if (choice == 3) {
					user.explore();
					game.dayAndNightCycle();
				} else {
					System.out.println("That's not a valid option");
				}
			} else {
				System.out.println("It is now night. Good night.");
				if (!monsters.spawn().equals("No Monster Spawns.")) {
					System.out.println(monsters.currentMonster + " attempts to destroy your shelter");
					if (!user.shelter) {
						System.out.println("Oh no! You don't have a shelter!");
						if(!user.weapon) {
							game.lose = true;
							break;
						}
						else {
							System.out.println("Good thing you had a weapon to chase the monster away");
						}
					} else {
						if (monsters.destroyShelter(user.shelter)) {
							user.shelter = false;
						}
					}
					System.out.println(monsters.currentMonster + " attempts to attack!");

					if (monsters.attackUser(user.weapon)) {
						if (monsters.currentMonster.equals("Skeleton")) {
							user.weapon = false;
							user.materials.remove("weapon");
						}
						if (user.shelter) {
							System.out.println("Your shelter protected you from a monster!");
						}
						if (!user.shelter) {
							System.out.println("You don't have a shelter!! The monster attacks you");
							game.lose = true;
							break;
						}
					}
					
				}
				game.dayAndNightCycle();
				System.out.println("At the end of the night, you  have:");
				System.out.println("* Weapon: "+ user.weapon);
				System.out.println("* Shelter: "+ user.shelter);
				System.out.println("* Wood: "+ user.countMaterials("wood"));
				System.out.println("* Stone: "+ user.countMaterials("stone"));
				System.out.println("* Door: "+ user.countMaterials("door"));
				System.out.println("* Wall: "+ user.countMaterials("wall"));
			}
			if(game.nightsPassed == 2 && user.shelter && user.weapon) {
				game.win = true;
			}
		}
		
		game.checkCondition();
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
		if (win) {
			System.out.println("YOU WIN");
			return true;
		} else {
			if (lose) {
				System.out.println("YOU LOSE");
				return true;
			}
		}
		return false;
	}

	public void dayAndNightCycle() {
		if (day && !night) {
			day = false;
			night = true;
		} else {
			day = true;
			night = false;
			nightsPassed++;
		}
	}

	public void action() {
		actionCount++;
	}

	public void encounterMonsters() {

	}

}
