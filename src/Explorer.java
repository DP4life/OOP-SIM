public class Explorer extends Object{
	private int maxHealth = 100;
	private int health;

	private int attack;
	private int defaultAttack = 1;

	private int thirst;
	private int maxThirst = 100;

	private int hunger;
	private int maxHunger = 100;

	private int radiation;
	private int maxRadiation = 100;

	public int distanceTraveled = 0;

	private static int money;


	Explorer(){
		attack = defaultAttack;
		health = maxHealth;
		radiation = 0;
		hunger = maxHunger;
		thirst = maxThirst;
	}

	//Inventory
	private Consumable[] inventory = new Consumable[100];
	private int inventoryIndex = 0;
	private Weapon weapon;
	private Armor armor;


	//Inventory methods

	public void SetMoney(int newMoney){
		money = newMoney;
	}
	public void DisplayInventory(){
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
		

		for (int i = 0; i < inventoryIndex; i++){
			System.out.print(" - ");
			inventory[i].DisplayConsumableDescripion();
		}
		
	}
	
	public void EmptyInventory(){
		for(int i = 0; i < inventoryIndex; i++){
			inventory[i] = null;
		}
	}

	public void StoreConsumable(Consumable _consumable){
		inventory[inventoryIndex] = _consumable;
		System.out.println("============================================================");
		System.out.print(" > " +name + " stored: ");
		_consumable.DisplayConsumableDescripion();
		inventoryIndex++;

	}
	public void ConsumeConsumable(){
		

	}

	//gameplay
	public void TakeBreak(){

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
	public int PlayerAttack(){
		if (weapon == null)
			return attack;
		else 
			return weapon.effect;
	}

	public void TakeDamage(int damage){
		int realDamage;
		if (armor == null)
			realDamage = damage;
		else 
			realDamage = damage - damage * (armor.effect/100);
		health -= realDamage;

		System.out.println(name + " lost " + realDamage + "HP");
		System.out.println(name + " has " + health + "HP");
	}
	public void TakeRadiation(int damage){
		radiation += damage;
	}
	public void Die(){
		System.out.println(name + " is dead lol");
		System.exit(0);
	}

	//getters and setters

	public Armor getArmor() {
		return armor;
	}
	public void setArmor(Armor armor) {
		this.armor = armor;
	}
	public Weapon getWeapon() {
		return weapon;
	}
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
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
	public String getName(){
		return name;
	}

	public int getRadiation() {
		return radiation;
	}
	public void setName(String _name){
		name = _name;		
	}
}
