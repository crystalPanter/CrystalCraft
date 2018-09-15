package game;

import java.util.ArrayList;
import java.util.Random;

public class User {
	ArrayList<String> materials;
	boolean weapon, shelter;
	Random random;

	public User() {
		materials = new ArrayList<String>();
		weapon = false;
		shelter = false;
		random = new Random();
	}

	public void craft() {
	}

	public void explore() {
	}

	public void collect() {
		String material = "";
		int amount = random.nextInt(5);
		
		if(random.nextInt(100)<51) {
			material = "wood";
			}
		else {
			material = "stone";
		}
		System.out.println("You collect " + amount + " " + material);
		for(int i = 0;i<amount;i++) {
			materials.add(material);
		}
		
	}

	public ArrayList<Integer> countMaterials() {
		ArrayList<Integer> amounts = new ArrayList<Integer>();
		int woodAmount = 0;
		int stoneAmount = 0;
		for(String each: materials) {
			if(each.equals("wood")) {
				woodAmount++;
			}
			if(each.equals("stone")) {
				stoneAmount++;
			}
		}
		
		System.out.println("Wood count: " + woodAmount);
		System.out.println("Stone count: " + stoneAmount);
		System.out.println();
		return amounts;
	}

	public void checkCraftRequirements() {
	}
}
