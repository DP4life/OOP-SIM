public class Mutant extends Enemy{
	
	Mutant(String _name, int _baseDamage, int _health){
		SetName(_name);
		setHealth(_baseDamage);
		setBaseDamage(_baseDamage);
	}

	public void Interaction(Explorer _player){
		System.out.println("============================================================");
		System.out.println("> "+ _player.name+" gets attacked by a " + GetName() + "!");
		int damageMultiplier;
		if (_player.PlayerAttack()>getHealth()) damageMultiplier = 1;
			else damageMultiplier = _player.PlayerAttack()/getHealth();
		System.out.println(_player.name + " has defeated the " + GetName());
		int damage = getBaseDamage() * damageMultiplier;
		System.out.println(_player.name +" got " + damage + " radiation");
		_player.TakeRadiation(damage);
		// if (_player.getRadiation() >= 100){
		// 	_player.Die();
		// }
	}
}
