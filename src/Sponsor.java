import java.util.Scanner;

public class Sponsor {
	Consumable[] consumables;
	Armor[] armors;
	Weapon[] weapons;

	Sponsor(Consumable[] _consumables, Armor[] _armors, Weapon[] _weapons){
		consumables = _consumables;
		armors = _armors;
		weapons = _weapons;
	}

	public void GearUp(Explorer _explorer){
		
		Scanner scanner = new Scanner(System.in);
		
		boolean done = false;


		while (done == false)
		{	
			System.out.println("============================================================");
			System.out.println(" > You have " + _explorer.getMoney() + " $");
			System.out.print(" > What would you like to browse? \n");
			System.out.println(" [1] Armor ");
			System.out.println(" [2] Weapons ");
			System.out.println(" [3] Consumables ");
			System.out.println(" [4] Display Inventory ");
			System.out.println(" [0] All Done \n");
			System.out.print(" > Choose: ");

			byte choice = scanner.nextByte();
			byte choice2;

			switch (choice){
				case 0:
					done = true;
					break;
				case 1:
					System.out.println("============================================================");
					for (int i = 0; i < armors.length; i++){
						System.out.print(" ["+i+"] ");
						armors[i].DisplayArmor();
					}
					System.out.println(" ["+armors.length+"] Back \n");
					System.out.print(" > Choose: ");
					choice2 = scanner.nextByte();
					if (choice2 == armors.length){
						break;
					} else if (choice2 < 0 || choice > armors.length){
						System.out.println(" ! Invalid input !");
						break;
					} else {
						if (_explorer.getMoney() >= armors[choice2].price){
							_explorer.setArmor(armors[choice2]);
							_explorer.SetMoney(_explorer.getMoney()-armors[choice2].price);
							break;
						} else {
							System.out.println(" > You don't have enough money!");
							break;
						}
						
					}
				case 2:
					System.out.println("============================================================");
					for (int i = 0; i < weapons.length; i++){
						System.out.print(" ["+i+"] " );
						weapons[i].DisplayWeapon();
					}
					System.out.println(" ["+weapons.length+"] Back \n");
					System.out.print(" > Choose: ");
					choice2 = scanner.nextByte();
					if (choice2 == weapons.length){
						break;
					} else if (choice2 < 0 || choice > weapons.length){
						System.out.println(" ! Invalid input !");
						break;
					} else { 
						if(_explorer.getMoney() >= weapons[choice2].price){
							_explorer.setWeapon(weapons[choice2]);
							_explorer.SetMoney(_explorer.getMoney()-weapons[choice2].price);
							break;
						} else {
							System.out.println(" > You don't have enough money!");
							break;
						}
						
					}
				case 3:
					System.out.println("============================================================");
					for (int i = 0; i < consumables.length; i++){
						System.out.print(" ["+i+"] ");
						consumables[i].DisplayConsumableDescripion();
					}
					System.out.println(" ["+consumables.length+"] Back \n");
					System.out.print(" > Choose: ");
					choice2 = scanner.nextByte();
					if (choice2 == consumables.length){
						break;
					} else if (choice2 < 0 || choice > consumables.length){
						System.out.println(" ! Invalid input !");
						break;
					} else {
						if (_explorer.getMoney() >= consumables[choice2].price){
							_explorer.StoreConsumable(consumables[choice2]);
							_explorer.SetMoney(_explorer.getMoney()-consumables[choice2].price);
							break;
						} else {
							System.out.println(" > You don't have enough money!");
							break;
						}
						
					}
				case 4:
					_explorer.DisplayInventory();
					break;
			}
		} 
	}
}
