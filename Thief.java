public class Thief extends Adventurer{
  private int stolen, sneaky, maxSneaky;

  public Thief(String name, int hp){
    super(name, hp);
    stolen = 0;
    sneaky = 30;
    maxSneaky = 30;
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
}
