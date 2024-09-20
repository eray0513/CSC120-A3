import java.util.Scanner; // Imports the scanner class

class Conversation {
  // Attributes
  private int rounds;
  private String[] converse;

  private String[] initialWords = {"I", "me", "am", "you", "my", "your",};
  private String[] replaceWords = {"you", "you", "are", "I", "your", "my",};

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

  /**
   * Allows the bot to formulate a response based on the user's input
   * @param perRes String response of person
   * @return respone of the bot
   */
  public String chat(String perRes){
      String [] separated = perRes.split(" ");
      String response = "";
      // For each word
      for(int i = 0; i<separated.length; i++){
        // For each initial word
        boolean rep = false;
        for(int s = 0; s<initialWords.length; s++){
            if(separated[i].equals(initialWords[s])){
              response += " " + replaceWords[s];
              rep = true;
            }
          }
          if(rep){
            response += " " + separated[i];
          }
        }
      response += "?";
      System.out.println(response);
      return response;
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

    for(int i = 1; i <=(totalRounds*2); i++){
      String nextRes = input.next();
      current.converse[i] = nextRes;
      current.converse[i+1] = current.chat(nextRes);
      i++;
    }

    System.out.println(current.getConverse());
  }
}
