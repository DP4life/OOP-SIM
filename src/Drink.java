public class Drink extends Consumable {
	Drink(String _name, int _quenchValue, int _radiation, int _price){
		setName(_name);
		setEffect(_quenchValue);
		setRadiationEffect(_radiation);
		setPrice(_price);
		setType("Drink");
	}
}
