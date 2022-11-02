import java.util.Scanner;

public class Trader implements Creature{
	private Consumable[] traderInventory = new Consumable[3];
	public String name;

	Trader(String _name, Consumable _consumable1, Consumable _consumable2, Consumable _consumable3){
		name = _name;
		traderInventory[0] = _consumable1;
		traderInventory[1] = _consumable2;
		traderInventory[2]= _consumable3;
	}


	public void Interaction(Explorer _explorer){
		System.out.println("============================================================");
		System.out.println(" > " + _explorer.getName() + " met a trader!");

		Barter(_explorer);
		
		
	}

	public void Barter(Explorer _explorer){
		System.out.println("============================================================");
		
	}
}
