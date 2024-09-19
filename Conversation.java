import java.util.Scanner; // Imports the scanner class

class Conversation {
  // Attributes
  private int rounds;
  private String[] converse;
  private int currentRound;

  /**
   * Constructs a conversation object with a number of rounds and an array to store the strings
   * @param num number of rounds
   */
  public Conversation(int num){
    this.rounds = num;
    num = (num+1)*2;
    this.converse = new String[num];
  }

  /**
   * Allows the attribute rounds to be accessed outside of the class
   * @return int rounds 
   */
  public int getRounds(){
    return this.rounds;
  }

  /**
   * Allows the String array to be accessed from outside the class
   * @return String array of conversation
   */
  public String[] getConverse(){
    return this.converse;
  }

  public String[] chat(String perRes){
    
      if(perRes.indexOf())
  }

  public static void main(String[] arguments) {
    // You will start the conversation here.

    Scanner input = new Scanner(System.in); // Creates a scanner object

    System.out.println("Hello! How many rounds would you like to have today?");
    int totalRounds = input.nextInt();

    Conversation current = new Conversation(totalRounds);

    String opener = "What are you thinking about today?";
    System.out.println(opener);
    current.converse[0] = opener;
  }
}
