import java.lang.Math;


public class Explorer extends Object{
	private int maxHealth = 100;
	private int health;

	private int attack;

	private int thirst;
	private int maxThirst = 100;

	private int hunger;
	private int maxHunger = 100;

	private int radiation;
	private int maxRadiation = 100;

	public int distanceTraveled = 0;

	private static int money;

	public boolean died = false;


	Explorer(){
		attack = 1;
		health = maxHealth;
		radiation = 0;
		hunger = maxHunger;
		thirst = maxThirst;
		money = 10;
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
		System.out.print(" > " +name + " stored: ");
		_consumable.DisplayConsumableDescripion();
		inventoryIndex++;

	}
	public void ConsumeConsumable(int index){
		System.out.println("---------------------------------------------------------");

		System.out.println(name + " consumed " + inventory[index].name);
		inventory[index].DisplayConsumableDescripion();


		switch (inventory[index].getType()){
			case "Food": 
				hunger += inventory[index].getEffect();
				if (hunger >= 100){
					hunger = 100;
				}
				radiation += inventory[index].getRadiationEffect();
				if (radiation <=0){
					radiation = 0;
				}
				System.out.println("Hunger: " + hunger + "/100");
				System.out.println("Radiation: " + radiation + "/100");

				break;
			case "Drink":
				thirst += inventory[index].getEffect();
				radiation += inventory[index].getRadiationEffect();
				if (thirst >= 100){
					thirst = 100;
				}
				if (radiation <=0){
					radiation = 0;
				}
				System.out.println("Thirst: " + thirst + "/100");
				System.out.println("Radiation: " + radiation + "/100");
				

				break;
			case "Medicine":
				health += inventory[index].getEffect();
				radiation += inventory[index].getRadiationEffect();
				if (health >= 100){
					health = 100;
				}
				if (radiation <=0){
					radiation = 0;
				}
				System.out.println("Health: " + health + "/100");
				System.out.println("Radiation: " + radiation + "/100");
				

		}


		inventory[index] = null;
		inventoryIndex--;
		Consumable[] temp = new Consumable[inventoryIndex];
		for (int i = 0, k = 0; i < inventoryIndex+1; i ++){
			if (i == index){
				continue;
			}
			temp[k++] = inventory[i];
		}

		EmptyInventory();
		for(int i = 0; i < inventoryIndex; i++){
			inventory[i] = temp[i];
		}
		

	}

	//gameplay
	public void TakeBreak(){

		if (hunger < 100 && inventory[0] != null){
			int min = 0;
			int minI = 0;
			int count = 0;
			boolean firstFound = false;
			for (int i = 0; i < inventoryIndex; i++){
				if (inventory[i].getType() == "Food"){
					count ++;
					if (!firstFound){
						min = inventory[i].effect;
						minI = i;
						firstFound = true;
					} else {
						if (inventory[i].effect < min){
							min = inventory[i].effect;
							minI = i;
						}
					}
				}
			}
			if (count > 0){
				ConsumeConsumable(minI);
			}	
		}

		if(died) return;

		if (thirst < 100 && inventory[0] != null){
			int min = 0;
			int minI = 0;
			int count = 0;
			boolean firstFound = false;
			for (int i = 0; i < inventoryIndex; i++){
				if (inventory[i].getType() == "Drink"){
					count ++;
					if (!firstFound){
						min = inventory[i].effect;
						minI = i;
						firstFound = true;
					} else {
						if (inventory[i].effect < min){
							min = inventory[i].effect;
							minI = i;
						}

					}
				}
			}
			if (count > 0){
				ConsumeConsumable(minI);
			}
			
		}

		if(died) return;

		if (health < 100 && inventory[0] != null){
			int min = 0;
			int minI = 0;
			int count = 0;
			boolean firstFound = false;
			for (int i = 0; i < inventoryIndex; i++){
				if (inventory[i].getType() == "Medicine"){
					count ++;
					if (!firstFound){
						min = inventory[i].effect;
						minI = i;
						firstFound = true;
					} else {
						if (inventory[i].effect < min){
							min = inventory[i].effect;
							minI = i;
						}

					}
				}
			}
			if (count > 0){
				ConsumeConsumable(minI);
			}
			
		}

		if (radiation > 0 && inventory[0] != null){
			int max = 0;
			int maxI = 0;
			int count = 0;
			boolean firstFound = false;
			for (int i = 0; i < inventoryIndex; i++){
				if (inventory[i].getType() == "Medicine"){
					count ++;
					if (!firstFound){
						max = inventory[i].getRadiationEffect();
						maxI = i;
						firstFound = true;
					} else {
						if (inventory[i].getRadiationEffect() > max){
							max = inventory[i].getRadiationEffect();
							maxI = i;
						}

					}
				}
			}
			if (count > 0){
				ConsumeConsumable(maxI);
			}
			
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
	public int PlayerAttack(){
		if (weapon == null){
			return attack;
			
		}
		else {
			return weapon.effect;
		}
			
	}

	public void TakeDamage(int damage){
		float realDamage;
		if (armor == null){
			realDamage = damage;
		}
		else {
			realDamage = (float)(100-armor.effect)/100 * (float)damage;
		}
			

		health -= (int)realDamage;

		System.out.println(name + " lost " + (int)realDamage + "HP " + "| Total HP: [" + health +"/100]");
	}
	public void TakeRadiation(int damage){
		radiation += damage;
	}
	public void Die(){
		System.out.println("============================================================");
		System.out.println(" > " +name + " is dead lol");
		died = true;
		DisplayStats();
		System.out.println(" > " + name + " has travelled " + distanceTraveled + " m");
		
		
	}

	//getters and setters

	public void setHealth(int health) {
		this.health = health;
	}

	public void setRadiation(int radiation) {
		this.radiation = radiation;
	}

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

	public void setInventoryIndex(int inventoryIndex) {
		this.inventoryIndex = inventoryIndex;
	}
}
