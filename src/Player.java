import java.util.Scanner;

public class Player implements Object{
	private int maxHealth = 100;
	private int health;

	private int attack;

	private int thirst;
	private int maxThirst = 100;

	private int hunger;
	private int maxHunger = 100;

	private int radiation = 0;
	private int maxRadiation = 100;

	private static int money = 0;


	Player(int _health, int _money, int _attack){
		attack = _attack;
		health = _health;
		money = _money;
		hunger = maxHunger;
		thirst = maxThirst;
	}

	//Inventory
	private Consumable[] playerInventory = new Consumable[100];
	private int inventoryIndex = 0;

	public int PlayerAttack(){
		return attack;
	}

	//Inventory methods

	public void SetMoney(int newMoney){
		money = newMoney;
	}

	public void DisplayInventory(){
		System.out.println("============================================================");
		System.out.println("Caps: " + money);
		for (int i = 0; i < inventoryIndex; i++){
			System.out.print(" [" + (i+1)  + "] ");
			playerInventory[i].DisplayConsumableDescripion();
		}
		if (inventoryIndex > 0){
			System.out.println(" [" + (inventoryIndex+1) + "] Back");
			System.out.println(" > What would you like to consume?");
			System.out.print(" > ");
			Scanner scanner = new Scanner(System.in);
			byte choice = scanner.nextByte();

			if (choice < inventoryIndex+1){
				ConsumeConsumable(choice-1);
				TakeBreak();
			} else TakeBreak();
			
		}
		
		
		
	}
	public void StoreConsumable(Consumable _consumable){
		playerInventory[inventoryIndex] = _consumable;
		System.out.println("============================================================");
		System.out.print("You stored: ");
		_consumable.DisplayConsumableDescripion();
		inventoryIndex++;

	}
	public void ConsumeConsumable(int n){
		switch (playerInventory[n].getType()){
			case "Food":
				hunger += playerInventory[n].getEffect();
				if (hunger > maxHunger){
					hunger = maxHunger;
				}
				break;
			case "Drink":
				thirst += playerInventory[n].getEffect();
				if (thirst > maxThirst){
					thirst = maxThirst;
				}
				break;
			case "Medicine":
				health += playerInventory[n].getEffect();
				if (health > maxHealth){
					health = maxHealth;
				}
				break;
			default:
				break;				
		}
		radiation += playerInventory[n].getRadiationEffect();
		if (radiation < 0){
			radiation = 0;
		}
		System.out.print("You consumed ");
		playerInventory[n].DisplayConsumableDescripion();

	}

	//gameplay
	public void TakeBreak(){
		Scanner scanner = new Scanner(System.in);
        byte mainChoice = 0;
        
		System.out.println("============================================================");
		System.out.println(" > What would you like to do?\n [1] Continue on the trail\n [2] Open Inventory \n [3] Check Stats");
		System.out.print(" > ");
		mainChoice = scanner.nextByte();

		switch (mainChoice) {
			case 1:
				System.out.println("You continue your jorney");
				break;
			case 2:
			DisplayInventory();
				break;
			case 3:
			DisplayStats();
				break;
		
			default:
				break;
		}

	}

	//stats
	public void DisplayStats(){
		System.out.println("============================================================");
		System.out.println("HP: " + health+"/"+maxHealth);
		System.out.println("RAD: " + radiation+"/"+maxRadiation);	
		System.out.println("Thirst: " + thirst+"/"+maxThirst);
		System.out.println("Hunger: " + hunger+"/"+maxHunger);
		TakeBreak();
	}

	public void TakeDamage(int damage){
		health -= damage;
	}
	public void TakeRadiation(int damage){
		radiation += damage;
	}
	public void Die(){
		System.out.println("You are dead lol");
		System.exit(0);
	}

	//getters and setters
	public int getMoney() {
		return money;
	}
	public int getHunger() {
		return hunger;
	}
	public void setHunger(int hunger) {
		this.hunger = hunger;
	}
	public int getThirst() {
		return thirst;
	}
	public void setThirst(int thirst) {
		this.thirst = thirst;
	}
	public int GetHealth(){
		return health;
	}
	public int GetMaxHealth(){
		return maxHealth;
	}
	public int getInventoryIndex() {
		return inventoryIndex;
	}
	
}
