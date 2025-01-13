public class Wizard extends Adventurer{
  private int mana;
  private int maxMana;

  public Wizard(String name, int hp){
    super(name, hp);
    this.mana = 50;
    this.maxMana = 50;
  }

  public String getSpecialName(){
    return "mana";
  }

  public int getSpecial(){
    return mana;
  }

  public void setSpecial(int n){
    mana = n;
  }

  public int getSpecialMax(){
    return maxMana;
  }

  @Override
  public String attack(Adventurer other){
    other.applyDamage(5);
    return this.getName() + " used attack! " + other.getName() + " has suffered 5 damage from " + this.getName() + "'s magical genius!";
  }

  public String support(Adventurer other){
    if (other.HP <= other.getmaxHP() - 5){
      other.setHP(other.HP + 5);
      return this.getName() " has healed " + other.getName() + " for 5 health!";
    }
    else{
      other.setHP(other.getmaxHP());
      return this.getName() " has healed " + other.getName() + " up to full health!";
    }
  }
}
