public class Thief extends Adventurer{
  private int stolen, sneaky, maxSneaky;

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

  }

  /*This is an example of an improvement that you can make to allow
   * for more flexible targetting.
   */
  //heal or buff the party
  //public abstract String support(ArrayList<Adventurer> others);

  //heal or buff the target adventurer
  public String support(Adventurer other){

  }

  //heal or buff self
  public String support(){

  }

  //hurt or hinder the target adventurer, consume some special resource
  public String specialAttack(Adventurer other){
    
  }
}
