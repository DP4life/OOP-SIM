public class Enemy implements Creature{
	private String name;
	private int baseDamage;
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
	public void setBaseDamage(int baseDamage) {
		this.baseDamage = baseDamage;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public void setHealth(int health) {
		this.health = health;
	}

	public void Interaction(Explorer _explorer){
		System.out.println("============================================================");
		System.out.println("> "+ _explorer.name +" get attacked by a " + name + "!");
		int damageMultiplier;
		if (_explorer.PlayerAttack()>health) damageMultiplier = 1;
			else damageMultiplier = _explorer.PlayerAttack()/health;
		System.out.println(_explorer.name + " has defeated the " + name);
		int damage = baseDamage * damageMultiplier;
		System.out.println(_explorer.name +" got " + (money) + " $" );
		_explorer.SetMoney(_explorer.getMoney()+money);
		_explorer.TakeDamage(damage);
		if (_explorer.GetHealth() <= 0){
			_explorer.Die();
		}
	}
	public int getBaseDamage() {
		return baseDamage;
	}

	public void TakeDamage(){
		
	}
}
