public class Boss extends Adventurer{
  private int mana, maxMana, sneaky, maxSneaky;

  public Boss(String name, int hp){
    super(name, hp);
    this.mana = 100;
    this.maxMana = 100;
    this.sneaky = 30;
    this.maxSneaky = 30;
  }

}
