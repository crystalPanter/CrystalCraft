package game;

import java.util.Random;
/**
 * The class that will control all of the monster generation and actions
 * @author Crystal
 *
 */
public class Monsters {
	String[] monsters = {"Spider","Creeper","Skeleton","Zombie"	};
	String currentMonster = "";
	
	/**
	 * Generate a random number and decide if a monster spawns!
	 * @return monster spawning text
	 */
	public String spawn() {
		Random rand = new Random();
		int whichMonster = rand.nextInt(monsters.length*4);
		if( whichMonster < monsters.length) {
			currentMonster = monsters[whichMonster];
			return monsters[whichMonster] + " spawns";
		}
		currentMonster = "";
		return "No Monster Spawns.";
	}
	
	/**
	 * Determine if a monster destroys a shelter or not
	 * @param hasShelter
	 * @return boolean
	 */
	public boolean destroyShelter(boolean hasShelter) {
		if(currentMonster.equals("Creeper")) {
			if(hasShelter) {
				System.out.println("Your shelter is destroyed!!!");
				return true;
			}
		}
		return false;
	}
	
	/**
	 * determines if a monster successfully attacks a user
	 * @param hasWeapon
	 * @return boolean
	 */
	public boolean attackUser(boolean hasWeapon) {
		if(hasWeapon) {
			System.out.println("You have a weapon. You're protected");
			if(currentMonster.equals("Skeleton")) {
				System.out.println("But your weapon is destroyed by the Skeleton!");
			}
			return false;
		}
		return true;
	}
	
}
