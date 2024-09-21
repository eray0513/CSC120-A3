import java.util.Scanner; // Imports the scanner class

class Conversation {
  // Attributes
  private int rounds;
  private String[] converse;

  // Lists of words to replace one another and canned responses
  private String[] initialWords = {"I", "me", "am", "you", "my", "your",};
  private String[] replaceWords = {"you", "you", "are", "I", "your", "my",};
  private String[] cannedWords = {"Interesting", "Mmmmhmmmm", "Wow"};

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
  public String getConverse(){
    String convo = "";
    for(int b = 0; b<this.converse.length; b++){
      convo+= this.converse[b] + "\n";
    }
    return convo;
  }

  /**
   * Allows the bot to formulate a response based on the user's input
   * @return response of the bot
   */
  public String chat(String perRes){
      String [] separated = perRes.split(" ");
      String response = "";
      boolean mirror = false;

      // For each word
      for(int s = 0; s<separated.length; s++){
        // For each initial word
        for(int i = 0; i<initialWords.length; i++){
            if(separated[s].equals(initialWords[i])){ // If mirror word is found
              separated[s] = replaceWords[i] + " ";
              mirror = true; // Mirror words were found
              break; // Stop checking for initial words in this separated word
            }
        }
        }
      // If no mirror words were found
      if(!mirror){
        // Random canned response
        response += cannedWords[(int)Math.random()*3];
      }
      else{
        // For every word in the separated list, add it to the response string
          for(int j = 0; j < separated.length; j++){
          response += separated[j] + " ";
              return response + "?";
        
        }
      }
      return response;
  }

  public static void main(String[] arguments) {
    // You will start the conversation here.

    Scanner input = new Scanner(System.in); // Creates a scanner object

    System.out.println("Hello! How many rounds would you like to have today?");
    int totalRounds = input.nextInt();
    input.nextLine();

    Conversation current = new Conversation(totalRounds);

    String opener = "What are you thinking about today?";
    System.out.println(opener);
    current.converse[0] = opener;

    // For every response given by the bot or the person
    for(int i = 1; i <(totalRounds*2); i++){
      String nextRes = input.nextLine();
      String botRes = current.chat(nextRes);
      current.converse[i] = nextRes;
      current.converse[i+1] = botRes;
      System.out.println(botRes);
      i++;
    }
    System.out.println("Goodbye!");
    current.converse[current.converse.length-1] = "Goodbye!";
    System.out.println(" ");
    System.out.println(" ");
    System.out.println(current.getConverse());
  }
}
