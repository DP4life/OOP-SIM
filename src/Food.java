public class Food extends Consumable{
	Food(String _name, int _hunger, int _radiation, int _price){
		setName(_name);
		setEffect(_hunger);
		setRadiationEffect(_radiation);
		setPrice(_price);
		setType("Food");
	}
}
