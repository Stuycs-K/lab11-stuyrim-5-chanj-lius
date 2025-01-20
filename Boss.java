public class Boss extends Adventurer{
  private int mana, maxMana;

  public Boss(String name, int hp){
    super(name, hp);
    this.mana = 100;
    this.maxMana = 100;
  }

  public Boss(String name){
    this(name, 100);
  }

  @Override
  public String attack(Adventurer other){
    int damage = (int)(Math.random() * 10) + 5;
    other.applyDamage(damage);
    return this + " has used their high IQ to do " + damage + " damage to " + other + "!";
  }

  public String support(Adventurer other){
    this.restoreSpecial(this.getSpecial() + 5);
    if (other.getSpecial() - 5 < 0){
      other.setSpecial(0);
      return this + " has borrowed all support from " + other "! What a steal!";
    }
    else{
      other.setSpecial(other.getSpecial() - 5);
      return this + " has borrowed 5 support from " + other "! What a steal!";
    }
  }

  public String support(){
    this.restoreSpecial(this.getSpecial() + 10);
    return this + " has studied for a second and restored 10 IQ!";
  }

  public String specialAttack(Adventurer other){

  }
}
