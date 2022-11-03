import java.util.Random;
import java.util.Scanner;

public class Game{
	private int defaultDistance = 500;

	private int distance;
	int winDistance = 10000;

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

	boolean won;

	Game(Explorer _explorer, Enemy[] _enemies, Trader[] _traders, Place[] _places, Sponsor _sponsor){
		distance = defaultDistance;
		rand = new Random();

		explorer = _explorer;
		enemies = _enemies;
		traders = _traders;
		places = _places;

		sponsor = _sponsor;
		won = false;
	}

	
	public void Setup(){
		explorer.setWeapon(null);
		explorer.setArmor(null);
		explorer.EmptyInventory();
		explorer.distanceTraveled = 0;
		explorer.SetMoney(explorer.getMoney()*10);

		explorer.setInventoryIndex(0);
		explorer.setHealth(100);
		explorer.setRadiation(0);
		explorer.setHunger(100);
		explorer.setThirst(100);
		explorer.died = false;
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
		System.out.println(" > How will you name your explorer?");
		
		scanner.nextLine();
		System.out.print(" > Name: ");
		_name = scanner.nextLine();
		System.out.println();
			
		explorer.setName(_name);

		sponsor.GearUp(explorer);
		System.out.println(ConsoleColors.YELLOW + "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++" + ConsoleColors.RESET);
		System.out.println(ConsoleColors.YELLOW +"++++++++++++++++++++++++++++++++++++++++++++++++++++++++++" + ConsoleColors.RESET);

		
	}

	public void Next(){
		explorer.distanceTraveled += distance;
		if (explorer.distanceTraveled >= winDistance){
			System.out.println("You won! " + explorer.name + " Has travelled " + explorer.distanceTraveled + " m and has arrived into the legenday city of Chisinau, the last haven for humanity");
			won = true;
			System.exit(0);
			return;
		}
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

		if(explorer.died){
			return;
		}

		explorer.TakeBreak();

		if (explorer.getHunger() <= 0 || explorer.getThirst() <=0 || explorer.getRadiation() >= 100 || explorer.GetHealth() <= 0 || explorer.died){
			explorer.Die();
			return;
		}
	}
}