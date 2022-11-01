public class Medicine extends Consumable{
		Medicine(String _name, int _healing, int _radHeal, int _price){
		setName(_name);
		setEffect(_healing);
		setRadiationEffect(_radHeal);
		setPrice(_price);
		setType("Medicine");
	}
}
