public class Boss extends Adventurer{
  private int mana, maxMana, sneaky, maxSneaky;

  public Boss(String name, int hp){
    super(name, hp);
    this.mana = 100;
    this.maxMana = 100;
    this.sneaky = 30;
    this.maxSneaky = 30;
  }

  @Override
  public String attack(Adventurer other){
    int damage = (int)(Math.random() * 10) + 4;
    other.applyDamage(damage);
    return "Boss has done " + damage + " damage to " + other;
  }

  public String support(Adventurer other){
    this.setSpecial(this.getSpecial() - 5);
    other.setSpecial(other.getSpecial() + 5);
    return "Boss has support other";
  }

  public String support(){
    this.setSpecial(this.getSpecial() + 5);
    return "Boss has support self";
  }

  public String specialAttack(Adventurer other){
    //wizard's special attack?
  }
}
