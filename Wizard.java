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
}
