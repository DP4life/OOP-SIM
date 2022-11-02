import java.util.Random;
import java.util.Scanner;
import java.lang.Object;

public class Game{
	private int defaultDistance = 500;

	private int distance;
	private int fate;
	private Random rand;
	Scanner scanner = new Scanner(System.in);

	Sponsor sponsor;
	Explorer explorer;

	Enemy[] enemies;
	Trader[] traders;
	Place[] places;

	Weapon[] weapons;
	Armor[] armors;

	Game(Explorer _explorer, Enemy[] _enemies, Trader[] _traders, Place[] _places, Sponsor _sponsor){
		distance = defaultDistance;
		rand = new Random();

		explorer = _explorer;
		enemies = _enemies;
		traders = _traders;
		places = _places;

		sponsor = _sponsor;
	}

	
	public void Setup(){
		explorer.SetMoney(100);
		explorer.setWeapon(null);
		explorer.setArmor(null);
		explorer.EmptyInventory();
	}

	public void Prepare(){
		String _name = "-";
		System.out.println(" > How will you name your first explorer?");
		

		System.out.print(" > Name: ");
		_name = scanner.nextLine();
		System.out.println();
			
		explorer.setName(_name);

		sponsor.GearUp(explorer);
		
	}
	// 1. Attacked by Raier
	// 2. Attacked by Mutant
	// 3. Discovering a Place 
	// 4. Meeting a Traider
	// 5. Nothing
	public void Next(){
		explorer.distanceTraveled += distance;
		explorer.setHunger(explorer.getHunger() - 5);
		explorer.setThirst(explorer.getThirst() - 10);
		fate = rand.nextInt(5);

		switch (fate){
			case 0: 
				
		}
	}
}