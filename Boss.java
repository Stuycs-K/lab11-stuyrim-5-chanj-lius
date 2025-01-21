public class Boss extends Adventurer{
  private int iq, maxiq;

  public Boss(String name, int hp){
    super(name, hp);
    this.iq = 100;
    this.maxiq = 100;
  }

  public Boss(String name){
    this(name, 100);
  }

  public String getSpecialName(){
    return "iq";
  }

  public int getSpecial(){
    return iq;
  }

  public void setSpecial(int n){
    iq = n;
  }

  public int getSpecialMax(){
    return maxiq;
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
      return this + " has borrowed all support from " + other + "! What a steal!";
    }
    else{
      other.setSpecial(other.getSpecial() - 5);
      return this + " has borrowed 5 support from " + other + "! What a steal!";
    }
  }

  public String support(){
    this.restoreSpecial(this.getSpecial() + 10);
    return this + " has studied for a second and restored 10 IQ!";
  }

  public String specialAttack(Adventurer other){
    int damage = (int)(this.getSpecial() / 4);
    other.applyDamage(damage);
    this.setSpecial(0);
    return this + " harnessed their knowledge to deal " + damage + " damage to " + other + "!";
  }
}
