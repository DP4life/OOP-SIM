public class Consumable implements Object{
	private String name;
	private int effect;
	private int radiationEffect;
	private int price;
	private String type;

	Consumable(){

	}
	Consumable(String _name, int _effect, int _radiationEffect, int _price){
		name = _name;
		effect = _effect;
		radiationEffect = _radiationEffect;
		price = _price;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEffect() {
		return effect;
	}
	public void setEffect(int effect) {
		this.effect = effect;
	}
	public int getRadiationEffect() {
		return radiationEffect;
	}
	public void setRadiationEffect(int radiationEffect) {
		this.radiationEffect = radiationEffect;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public void DisplayConsumableDescripion(){
		switch (type){
			case "Food":
				System.out.println(getName() + " Hunger: +" + Integer.toString(getEffect())  + " RAD: +" + Integer.toString(getRadiationEffect()));
				break;

			case "Drink":
				System.out.println(getName() + " Thirst: +" + Integer.toString(getEffect()) + " RAD: +" + Integer.toString(getRadiationEffect()));
				break;
			
			case "Medicine":
				System.out.println(getName() + " HP: +" + Integer.toString(getEffect()) + " RAD: -" + Integer.toString(getRadiationEffect()));
				break;
			default:
				System.out.println("what the fuck even is this consumable");
				break;
		}
	}

}
