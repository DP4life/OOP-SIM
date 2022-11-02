public class Armor extends Object{
	Armor(String _name, int _effect, int _price){
		name = _name;
		effect = _effect;
		price = _price;
	}

	public void DisplayArmor(){
		System.out.println(name + " AR: " + effect + " Price: " + price);
	}
}
