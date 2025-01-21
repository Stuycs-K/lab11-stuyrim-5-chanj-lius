import java.util.*;
public class Game{
  private static final int WIDTH = 80;
  private static final int HEIGHT = 30;
  private static final int BORDER_COLOR = Text.BLACK;
  private static final int BORDER_BACKGROUND = Text.WHITE + Text.BACKGROUND;

  public static void main(String[] args) {
    run();
  }

  //Display the borders of your screen that will not change.
  //Do not write over the blank areas where text will appear or parties will appear.
  public static void drawBackground(){
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    for (int i = 0; i < WIDTH; i++){
      Text.go(0, i);
      System.out.print("-");
      Text.go(6, i);
      System.out.print("-");
      Text.go(24, i);
      System.out.print("-");
      Text.go(30, i);
      System.out.print("-");
    }
    for (int i = 0; i < HEIGHT; i++){
      Text.go(i, 0);
      System.out.print(".");
      Text.go(i, 80);
      System.out.print(".");
    }
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
  }

  //Display a line of text starting at
  //(columns and rows start at 1 (not zero) in the terminal)
  //use this method in your other text drawing methods to make things simpler.
  public static void drawText(String s,int startRow, int startCol){
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    //YOUR CODE HERE
    Text.go(startRow, startCol);
    System.out.print(s);
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
  }

  /*Use this method to place text on the screen at a particular location.
  *When the length of the text exceeds width, continue on the next line
  *for up to height lines.
  *All remaining locations in the text box should be written with spaces to
  *clear previously written text.
  *@param row the row to start the top left corner of the text box.
  *@param col the column to start the top left corner of the text box.
  *@param width the number of characters per row
  *@param height the number of rows
  */
  public static void TextBox(int row, int col, int width, int height, String text){
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    //YOUR CODE HERE
    int start = row;
    int end = width;
    while(!text.equals("")){
      drawText(text, row, col);
      if (text.length() > end){
        text = text.substring(end, text.length());
        row++;
      }
    }
    while ((row - start) < height){
      for (int i = 0; i < width; i++){
        System.out.print(" ");
      }
      row++;
    }
    System.out.println();
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
  }




    //return a random adventurer (choose between all available subclasses)
    //feel free to overload this method to allow specific names/stats.
    public static Adventurer createRandomAdventurer(){
      int random = (int)(Math.random() * 3);
      int name = (int)(Math.random() * 5);
      String[] wizardNames = new String[]{"Dangalf Gumbledore", "Parry Potter", "Hermione Ranger", "Won Reasley", "Mraco Dalfoy"};
      String[] thiefNames = new String[]{"Shade", "Lootar", "Black Phantom", "Pockpucket", "Gru"};
      if (random == 0){
        return new Wizard(wizardNames[name]);
      }
      else if (random == 1){
        return new Thief(thiefNames[name]);
      }
      return new CodeWarrior("CS Major #"+(int)(Math.random()*10000));
    }

    /*Display a List of 2-4 adventurers on the rows row through row+3 (4 rows max)
    *Should include Name HP and Special on 3 separate lines.
    *Note there is one blank row reserved for your use if you choose.
    *Format:
    *Bob          Amy        Jun
    *HP: 10       HP: 15     HP:19
    *Caffeine: 20 Mana: 10   Snark: 1
    * ***THIS ROW INTENTIONALLY LEFT BLANK***
    */
    public static void drawParty(ArrayList<Adventurer> party,int startRow){

      /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
      //YOUR CODE HERE
      int advWidth = WIDTH / party.size();
      for (int i = 0; i < party.size(); i++){
        drawText(party.get(i).getName(), startRow, advWidth * i);
        System.out.println();
        drawText("HP: " + party.get(i).getHP(), startRow + 1, advWidth * i);
        System.out.println();
        drawText(party.get(i).getSpecialName() + ": "+ party.get(i).getSpecial(), startRow + 2, advWidth * i);
      }
      /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
    }


  //Use this to create a colorized number string based on the % compared to the max value.
  public static String colorByPercent(int hp, int maxHP){
    String output = String.format("%2s", hp+"")+"/"+String.format("%2s", maxHP+"");
    //COLORIZE THE OUTPUT IF HIGH/LOW:
    // under 25% : red
    // under 75% : yellow
    // otherwise : white
    if ((double)(hp/maxHP) <= 0.25){
      Text.colorize(output, Text.RED);
    }
    else if ((double)(hp/maxHP) <= 0.75){
      Text.colorize(output, Text.YELLOW);
    }
    return output;
  }





  //Display the party and enemies
  //Do not write over the blank areas where text will appear.
  //Place the cursor at the place where the user will by typing their input at the end of this method.
  public static void drawScreen(ArrayList<Adventurer> party, ArrayList<Adventurer> enemies){

    drawBackground();

    //draw player party
    drawParty(party, 2);

    //draw enemy party
    drawParty(enemies, 25);
  }

  public static String userInput(Scanner in){
      //Move cursor to prompt location

      Text.go(13, 2);

      //show cursor

      String input = in.nextLine();

      //clear the text that was written

      Text.clear();

      return input;
  }

  public static void quit(){
    Text.reset();
    Text.showCursor();
    Text.go(32,1);
  }

  public static void run(){
    //Clear and initialize
    Text.hideCursor();
    Text.clear();


    //Things to attack:
    //Make an ArrayList of Adventurers and add 1-3 enemies to it.
    //If only 1 enemy is added it should be the boss class.
    //start with 1 boss and modify the code to allow 2-3 adventurers later.
    ArrayList<Adventurer>enemies = new ArrayList<Adventurer>();
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    //YOUR CODE HERE
    int howMany = (int)(Math.random() * 3) + 1;
    //int howMany = 1;
    if (howMany == 1){
      enemies.add(new Boss("The Voices", 150));
    }
    else{
      for (int i = 0; i < howMany; i++){
        enemies.add(createRandomAdventurer());
      }
    }
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
    //enemies.add(new Wizard("Bob", 70));

    //Adventurers you control:
    //Make an ArrayList of Adventurers and add 2-4 Adventurers to it.
    ArrayList<Adventurer> party = new ArrayList<>();
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    //YOUR CODE HERE
    int allies = (int)(Math.random() * 3) + 2;
    for (int i = 0; i < allies; i++){
      party.add(createRandomAdventurer());
    }
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
    //party.add(new Wizard("player1", 50));
    //party.add(new Thief("player2", 50));

    boolean partyTurn = true;
    int whichPlayer = 0;
    int whichOpponent = 0;
    int turn = 0;
    String input = "";//blank to get into the main loop.
    Scanner in = new Scanner(System.in);
    //Draw the window border

    //You can add parameters to draw screen!
    drawScreen(party, enemies);//initial state.

    //Main loop

    //display this prompt at the start of the game.
    Text.go(10,2);
    String preprompt = "Enter command for "+party.get(whichPlayer)+": attack/special/quit";
    System.out.println(preprompt);

    while(! (input.equalsIgnoreCase("q") || input.equalsIgnoreCase("quit"))){
      //Read user input
      input = userInput(in);

      //example debug statment
      //TextBox(24,2,1,78,"input: "+input+" partyTurn:"+partyTurn+ " whichPlayer="+whichPlayer+ " whichOpp="+whichOpponent );

      //display event based on last turn's input
      if(partyTurn){

        //Process user input for the last Adventurer:
        Text.go(7,2);
        if(input.equals("attack") || input.equals("a")){
          /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
          //YOUR CODE HERE
          /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
          System.out.print(party.get(whichPlayer).attack(enemies.get(0)));
        }
        else if(input.equals("special") || input.equals("sp")){
          /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
          //YOUR CODE HERE
          /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
          System.out.print(party.get(whichPlayer).specialAttack(enemies.get(0)));
        }
        else if(input.startsWith("su ") || input.startsWith("support ")){
          //"support 0" or "su 0" or "su 2" etc.
          //assume the value that follows su  is an integer.
          /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
          //YOUR CODE HERE
          /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
          if (input.charAt(input.length() - 1) == '0'){
            System.out.print(party.get(whichPlayer).support(party.get(0)));
          }
          else if (input.charAt(input.length() - 1) == '1'){
            System.out.print(party.get(whichPlayer).support());
          }
        }

        //You should decide when you want to re-ask for user input
        //If no errors:
        /*
        if (party.get(whichPlayer).getHP() <= 0){
          System.out.print("Oh noes!" + party.get(whichPlayer));
          party.remove(whichPlayer);
          if (party.size() == 0){
            System.out.print("You lose.");
            quit();
          }
        }
        else{
          whichPlayer++;
        }*/
        whichPlayer++;
        for (int i = 0; i < enemies.size(); i++){
          if (enemies.get(i).getHP() <= 0){
            Text.go(15,2);
            System.out.print("You have defeated an enemy.");
            enemies.remove(i);
            i--;
          }
        }
        if (enemies.size() == 0){
          Text.go(16,2);
          System.out.print("WINNER!");
          quit();
        }/*
        if (enemies.get(whichOpponent).getHP() <= 0){
          System.out.print("Yippee!" + party.get(whichOpponent));
          enemies.remove(whichOpponent);
          if (enemies.size() == 0){
            System.out.print("You win.");
            quit();
          }
        }*/


        if(whichPlayer < party.size()){
          //This is a player turn.
          //Decide where to draw the following prompt:
          Text.go(10,2);
          String prompt = "Enter command for "+party.get(whichPlayer)+": attack/special/quit";
          System.out.print(prompt);


        }else{
          //This is after the player's turn, and allows the user to see the enemy turn
          //Decide where to draw the following prompt:
          Text.go(10,2);
          String prompt = "press enter to see monster's turn";
          System.out.print(prompt);
          partyTurn = false;
          whichOpponent = 0;
        }
        //done with one party member
      }else{
        //not the party turn!


        //enemy attacks a randomly chosen person with a randomly chosen attack.z`
        //Enemy action choices go here!
        /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
        //YOUR CODE HERE
        /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
        Text.go(7,2);
        int enemyInput = (int)(Math.random() * 4), randoPlayer = (int)(Math.random() * party.size());
        System.out.print("enemy input: " + enemyInput + ", rando: " + randoPlayer);
        Text.go(8,2);
        if (enemyInput == 0){
          System.out.print(enemies.get(whichOpponent).attack(party.get(randoPlayer)));
        }
        else if (enemyInput == 1){
          System.out.print(enemies.get(whichOpponent).support(party.get(randoPlayer)));
        }
        else if (enemyInput == 2){
          System.out.print(enemies.get(whichOpponent).support());
        }
        else{
          System.out.print(enemies.get(whichOpponent).specialAttack(party.get(randoPlayer)));
        }

        whichOpponent++;
        for (int i = 0; i < party.size(); i++){
          if (party.get(i).getHP() <= 0){
            Text.go(15,2);
            System.out.print("You suck.");
            party.remove(i);
            i--;
          }
        }
        if (party.size() == 0){
          Text.go(16,2);
          System.out.print("LOSER!");
          quit();
        }

        //Decide where to draw the following prompt:
        if (whichOpponent < enemies.size()){
          Text.go(10,2);
          String prompt = "press enter to see next turn";
          System.out.print(prompt);
        }

      }//end of one enemy.

      //modify this if statement.
      if(!partyTurn && whichOpponent >= enemies.size()){
        //THIS BLOCK IS TO END THE ENEMY TURN
        //It only triggers after the last enemy goes.
        whichPlayer = 0;
        turn++;
        partyTurn=true;
        //display this prompt before player's turn
        String prompt = "Enter command for "+party.get(whichPlayer)+": attack/special/quit";
        Text.go(10,2);
        System.out.print(prompt);
      }

      //display the updated screen after input has been processed.
      if (party.size() == 0){
        drawBackground();
        Text.go(16,2);
        System.out.print("LOSER!");
        input = "quit";
      }
      else if (enemies.size() == 0){
        drawBackground();
        Text.go(16,2);
        System.out.print("WINNER!");
        input = "quit";
      }
      else{
        drawScreen(party, enemies);
      }


    }//end of main game loop


    //After quit reset things:
    quit();
  }
}
