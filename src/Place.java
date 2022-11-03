public class Place extends Object{

	private Enemy placeEnemy;
	private Consumable[] placeStash = new Consumable[3];

	Place(String _name, Enemy _enemy, Consumable _consumable1, Consumable _consumable2, Consumable _consumable3){
		name = _name;
		placeEnemy = _enemy;
		placeStash[0]= _consumable1;
		placeStash[1] = _consumable2;
		placeStash[2] = _consumable3;

	}
	
	public void Discover(Explorer _player){
		System.out.println("============================================================");
		System.out.println(_player.name + " has discovered an " + name);
		System.out.println("In " + name + " there is a " + placeEnemy.GetName());
		placeEnemy.Interaction(_player);
		System.out.println("From the " + name + " " + _player.name + " has recovered");
		for(int i = 0; i < placeStash.length; i++){
			_player.StoreConsumable(placeStash[i]);
		}
	}
}
