public class Enemy implements Creature{
	private String name;
	private int baseDamage;
	private int damage;
	private int health;
	private int money;

	Enemy(){
		
	}

	Enemy(String _name, int _baseDamage, int _health, int _money){
		name = _name;
		baseDamage = _baseDamage;
		health = _health;
	}
	public int getHealth() {
		return health;
	}
	public String GetName(){
		return name;
	}
	public void SetName(String _name){
		name = _name;
	}
	public int EnemyAttack(){
		return damage;
	}
	public void setBaseDamage(int baseDamage) {
		this.baseDamage = baseDamage;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public void setHealth(int health) {
		this.health = health;
	}

	public void Interaction(Player _player){
		System.out.println("============================================================");
		System.out.println("> You get attacked by a " + name + "!");
		int damageMultiplier;
		if (_player.PlayerAttack()>health) damageMultiplier = 1;
			else damageMultiplier = _player.PlayerAttack()/health;
		System.out.println("============================================================");
		System.out.println("You have defeated the " + name);
		int damage = baseDamage * damageMultiplier;
		System.out.println("You lost " + damage + " health");
		System.out.println("You got " + (money) + " caps" );
		_player.SetMoney(_player.getMoney()+money);
		_player.TakeDamage(damage);
		if (_player.GetHealth() <= 0){
			_player.Die();
		}
	}
	public int getBaseDamage() {
		return baseDamage;
	}

	public void TakeDamage(){
		
	}
}
