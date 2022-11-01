import java.util.Scanner;

public class Trader implements Creature{
	private Consumable[] traderInventory = new Consumable[3];

	Trader(Food _food, Drink _drink, Medicine _medicine){
		traderInventory[0] = _food;
		traderInventory[1] = _drink;
		traderInventory[2]= _medicine;
	}


	public void Interaction(Player _player){
		System.out.println("============================================================");
		System.out.println(" > You meet a trader!");
		System.out.println(" [1] Continue on your trail\n [2] Barter ");
		System.out.print(" > ");
		Scanner scanner = new Scanner(System.in);
		byte choice = 0;

		choice = scanner.nextByte();

		switch(choice){
			case 1:
				System.out.println("You continue on your journey");
				break;
			case 2:
				Barter(_player);
				break;
			default:
				break;
		}
		
	}

	public void Barter(Player _player){
		System.out.println("============================================================");
		System.out.println(" > Trader: \"Here's what I have to offer\"");
		for (int i = 0; i < traderInventory.length; i ++){
			System.out.print(" [" + (i+1) + "] ");
			traderInventory[i].DisplayConsumableDescripion();
			System.out.println("Price: " + traderInventory[i].getPrice());
		}
		System.out.println(" [4] Nothing");
		System.out.println(" > You have " + _player.getMoney() + " caps");
		Scanner scanner = new Scanner(System.in);

		byte choice = 0;
		choice = scanner.nextByte();
		if (choice > 0 && choice < 4){
			_player.StoreConsumable(traderInventory[choice-1]);
			_player.SetMoney(_player.getMoney() - traderInventory[choice-1].getPrice());
		} 
		else if (choice == 4){
			System.out.println("Trader: \"Suit yourself\"");
		}
		else {
			System.out.println("Invalid input");
			Barter(_player);
		}
			

	}
}
