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
    //steal special from other to regen mana
  }

  public String support(Adventurer other){
    //thief's support?
  }

  public String support(){
    //wizard's support?
  }

  public String specialAttack(Adventurer other){
    //wizard's special attack?
  }
}
