import java.util.Scanner;

public class View {
	
	static Scanner scanner = new Scanner(System.in);

	public static void DisplayExplorerInventory(Weapon weapon, Armor armor,Consumable[] inventory, int invIndex){
		System.out.println("============================================================");
		System.out.println(" > Inventory: ");
		if (weapon != null) {
			System.out.print(" - Weapon: ");
			weapon.DisplayWeapon();
		}
		if (armor != null){
			System.out.print(" - Armor: ");
			armor.DisplayArmor();
		}
		
		for (int i = 0; i < invIndex; i++){
			System.out.print(" - ");
			inventory[i].DisplayConsumableDescripion();
		}
	}

	public static void DisplayExplorerStats(int health, int radiation, int thirst, int hunger){
		System.out.println("============================================================");
		System.out.println("HP: " + health+"/"+100);
		System.out.println("RAD: " + radiation+"/"+100);	
		System.out.println("Thirst: " + thirst+"/"+100);
		System.out.println("Hunger: " + hunger+"/"+100);
	}

	public static String ViewPrepare(Game game){
		System.out.println(" > Send an explorer?");
		System.out.println(" [0] Exit");
		System.out.println(" [1] Yes");

		byte choice0 = scanner.nextByte();

		switch (choice0){
			case 0:
				System.out.println(" > Exiting...");
				System.exit(0);
				break;
			case 1:
				break;
		}

		String _name = "-";
		System.out.println(" > How will you name your explorer?");
		
		scanner.nextLine();
		System.out.print(" > Name: ");
		_name = scanner.nextLine();
		System.out.println();
			
		game.explorer.setName(_name);
		return (_name);
	}

	public static void ViewEndPrepare(){
		System.out.println(ConsoleColors.YELLOW + "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++" + ConsoleColors.RESET);
		System.out.println(ConsoleColors.YELLOW + "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++" + ConsoleColors.RESET);
	}
}
