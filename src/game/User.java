package game;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class User {
	ArrayList<String> materials;
	boolean weapon, shelter;
	Random random;
	Scanner scan;

	public User() {
		materials = new ArrayList<String>();
		weapon = false;
		shelter = false;
		random = new Random();
		scan = new Scanner(System.in);
	}

	public void craft() {
		System.out.println("Crafting Options");
		System.out.println(" 1 ) Wall - 15 Wood");
		System.out.println(" 2 ) Door - 10 Wood");
		System.out.println(" 3 ) Weapon - 4 Wood, 8 Stone");
		System.out.println(" 4 ) Shelter - 4 Wall, 1 Door");
		System.out.println("Please enter your choice number: ");
		int choice = scan.nextInt();
		if (choice == 1) {
			if (countMaterials("wood") >= 15) {
				for(int i=0;i<16;i++) {
					materials.remove("wood");
				}
				materials.add("wall");
			} else {
				System.out.println("You do not have enough wood to create a wall.");
			}

		} else if (choice == 2) {
			if (countMaterials("wood") >= 10) { 
				for(int i=0;i<11;i++) {
					materials.remove("wood");
				}
				materials.add("door");
			} else {
				System.out.println("You do not have enough wood to create a door.");
			}

		} else if (choice == 3) {
			if(countMaterials("wood")>=4 && countMaterials("stone")>=8) {
				for(int i=0;i<4;i++) {
					materials.remove("wood");
				}
				for(int i=0;i<8;i++) {
					materials.remove("stone");
				}
				materials.add("weapon");
				weapon = true;
			}

		} else if (choice == 4) {
			if(countMaterials("wall")>=4 && countMaterials("door")>=1) {
				for(int i=0;i<4;i++) {
					materials.remove("wall");
				}
				for(int i=0;i<1;i++) {
					materials.remove("door");
				}
				materials.add("shelter");
				shelter = true;
			}
		} else {
			System.out.println("Not a valid choice. Sorry.");
		}
	}

	public void explore() {
		int amount = random.nextInt(3)+1;
		int amount2 = random.nextInt(3)+1;

		System.out.println("You collect " + amount + " wood");
		System.out.println("You collect " + amount2 + " stone");
		for (int i = 0; i < amount; i++) {
			materials.add("wood");
		}
		for (int i = 0; i < amount2; i++) {
			materials.add("stone");
		}
		
	}

	public void collect() {
		String material = "";
		int amount = random.nextInt(5)+1;

		if (random.nextInt(100) < 51) {
			material = "wood";
		} else {
			material = "stone";
		}
		System.out.println("You collect " + amount + " " + material);
		for (int i = 0; i < amount; i++) {
			materials.add(material);
		}

	}

	public int countMaterials(String material) {
		int amount = 0;
		for (String each : materials) {
			if (each.equals(material)) {
				amount++;
			}
		}
		return amount;
	}

	public void checkCraftRequirements() {
	}
}
