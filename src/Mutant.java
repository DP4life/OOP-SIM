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
			else damageMultiplier = getHealth()/_player.PlayerAttack();
		System.out.println(_player.name + " has defeated the " + GetName());
		int damage = getBaseDamage() * damageMultiplier;
		_player.TakeRadiation(damage);
		System.out.println(_player.name +" got " + damage + " radiation | Total Radiation: [" +_player.getRadiation() +"/100]");
		if (_player.getRadiation() >= 100){
			_player.Die();
			return;
		}
	}
}
