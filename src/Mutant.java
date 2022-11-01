public class Mutant extends Enemy{
	
	Mutant(String _name, int _baseDamage, int _health){
		SetName(_name);
		setBaseDamage(_baseDamage);
		setBaseDamage(_baseDamage);
	}

	public void Interaction(Player _player){
		System.out.println("============================================================");
		System.out.println("> You get attacked by a " + GetName() + "!");
		int damageMultiplier;
		if (_player.PlayerAttack()>getHealth()) damageMultiplier = 1;
			else damageMultiplier = _player.PlayerAttack()/getHealth();
		System.out.println("============================================================");
		System.out.println("You have defeated the " + GetName());
		int damage = getBaseDamage() * damageMultiplier;
		System.out.println("You got " + damage + " radiation");
		_player.TakeRadiation(damage);
		if (_player.GetHealth() <= 0){
			_player.Die();
		}
	}
}
