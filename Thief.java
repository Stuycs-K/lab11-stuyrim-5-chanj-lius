public class Thief extends Adventurer{
  private int stolen, maxStolen, sneaky, maxSneaky;

  public Thief(String name, int hp){
    super(name, hp);
    stolen = 0;
    sneaky = 30;
    maxSneaky = 30;
  }

  public Thief(String name){
    this(name, 70);
  }

  public Thief(){
    this("Shade");
  }

  public String getSpecialName(){
    return "sneaky";
  }

  public int getSpecial(){
    return sneaky;
  }

  public void setSpecial(int n){
    sneaky = n;
  }

  public int getSpecialMax(){
    return maxSneaky;
  }

  /*
  all adventurers must have a way to attack enemies and
  support their allys
  */
  //hurt or hinder the target adventurer
  public String attack(Adventurer other){
    int damage = (int)(Math.random() * 10) + 2;
    other.applyDamage(damage);
    restoreSpecial(5);
    setSneaky(damage/2);
    other.setSpecial(other.getSpecial() - damage/2);
    return this + "shot " + other + " with their bow and filch their energy! They retreat to the shadows.";
  }

  /*This is an example of an improvement that you can make to allow
   * for more flexible targetting.
   */
  //heal or buff the party
  //public abstract String support(ArrayList<Adventurer> others);

  //heal or buff the target adventurer
  public String support(Adventurer other){
    int refill = getSneaky();
    other.setSpecial(other.getSpecial() + refill);
    setSneaky(0);
    return this + "reinvigorated" + other + "with their \"borrowed\" energy!";
  }

  //heal or buff self
  public String support(){
    setSpecial(getSpecial() + getSneaky());
    setSneaky(0);
    return this + "gets extra sneaky and drops their stolen goods!";
  }

  //hurt or hinder the target adventurer, consume some special resource
  public String specialAttack(Adventurer other){
    int damage = (int)(Math.random() * 12) + (getSpecial() * (2/3));
    other.applyDamage(damage);
    setSpecial(0);
    return this + "surprises the enemy with a stab to the back, debilitating them for 3 turns!";
  }
}
