public class Wizard extends Adventurer{
  private int mana;
  private int maxMana;

  public Wizard(String name, int hp){
    super(name, hp);
    this.mana = 50;
    this.maxMana = 50;
  }
}
