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
		explorer.distanceTraveled = 0;


		explorer.setHealth(100);
		explorer.setRadiation(0);
		explorer.setHunger(100);
		explorer.setThirst(100);
	}

	public void Prepare(){
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
		System.out.println(" > How will you name your first explorer?");
		

		System.out.print(" > Name: ");
		_name = scanner.nextLine();
		System.out.println();
			
		explorer.setName(_name);

		sponsor.GearUp(explorer);
		
	}

	public void Next(){
		explorer.distanceTraveled += distance;
		explorer.setHunger(explorer.getHunger() - 5);
		explorer.setThirst(explorer.getThirst() - 10);
		fate = rand.nextInt(100);

		if (fate <= 20){
			places[rand.nextInt(places.length)].Discover(explorer);
		} else if (fate <= 50){
			traders[rand.nextInt(traders.length)].Interaction(explorer);
		} else {
			enemies[rand.nextInt(enemies.length)].Interaction(explorer);
		}

		if (explorer.getHunger() <= 0 || explorer.getThirst() <=0 || explorer.getRadiation() >= 100 || explorer.GetHealth() <= 0){
			explorer.Die();
		}
	}
}