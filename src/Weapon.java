public class Weapon extends Object{

	public Weapon(String _name, int _effect, int _price) {
		name = _name;
		effect = _effect;
		price = _price;
	}

	public void DisplayWeapon(){
		System.out.println(name + " DMG: " + effect + " Price: " + price);
	}
	
}
