public class Wizard extends Adventurer{
  private int mana;
  private int maxMana;

  public Wizard(String name, int hp){
    super(name, hp);
    this.mana = 50;
    this.maxMana = 50;
  }

  public Wizard(String name){
    this(name, 100);
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
    if (other.getHP() <= other.getmaxHP() - 5){
      other.setHP(other.getHP() + 5);
      return this.getName() + " has healed " + other.getName() + " for 5 health!";
    }
    else{
      other.setHP(other.getmaxHP());
      return this.getName() + " has healed " + other.getName() + " up to full health!";
    }
  }

  public String support(){
    super.restoreSpecial(20);
    if (this.getHP() <= this.getmaxHP() - 5){
      this.setHP(this.getHP() + 5);
      return this.getName() + " did nothing, but supported themselves with 20 mana and 5 health.";
    }
    else{
      this.setHP(this.getmaxHP());
      return this.getName() + " did nothing, but supported themselves with 20 mana and full health.";
    }
  }

}
