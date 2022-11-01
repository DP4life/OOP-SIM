import java.util.Scanner;

public class Place implements Object{
	private String placeName;
	private Raider placeRaider;
	private Consumable[] placeStash = new Consumable[3];
	private Food placeFoodStash;
	private Drink placeDrinkStash;
	private Medicine placeMedicineStash;


	Place(String _name, Raider _raider, Food _food, Drink _drink, Medicine _medicine){
		placeName = _name;
		placeRaider = _raider;
		placeStash[0]= _food;
		placeStash[1] = _drink;
		placeStash[2] = _medicine;

	}
	public String GetName(){
		return placeName;
	}
	public void Discover(Player _player){
		Scanner scanner = new Scanner(System.in);
		System.out.println("============================================================");
		System.out.println("You have discovered " + placeName);
		System.out.println(" > What do you want to do?");
		System.out.println(" [1] Look around \n [2] Keep going");
		System.out.print(" > ");
		
		byte choice = scanner.nextByte();
		switch (choice) {
			case 1:
			if (placeRaider != null){
				System.out.println("In "+ placeName + ": ");
				placeRaider.Interaction(_player);
			}		
			System.out.println("In " + placeName + " You find some suplies ");
			for (Consumable consumable : placeStash) {
				_player.StoreConsumable(consumable);
			}
				break;
			case 2:
				System.out.println("You go past the " + placeName + " and continue on your trail");
				break;
			default:
				break;
		}
	}
}
