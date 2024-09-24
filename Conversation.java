import java.util.Scanner; // Imports the scanner class

class Conversation {
  // Attributes
  private int rounds;
  private String[] converse;

  // Lists of words to replace one another and canned responses
  private String[] initialWords = {"I", "me", "am", "you", "my", "your", "I'm", "You", "Me", "My", "Your", "are"};
  private String[] replaceWords = {"you", "you", "are", "I", "your", "my", "you're", "I", "You", "Your", "My", "am"};
  private static String[] cannedWords = {"Interesting", "Mmmmhmmmm", "Wow"};

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
      boolean mirror = false; // Keeps track of whether or not mirror words were found

      // For each word
      for(int s = 0; s<separated.length; s++){
        // For each initial word
        for(int i = 0; i<initialWords.length; i++){
            if(separated[s].equals(initialWords[i])){ // If mirror word is found
              separated[s] = replaceWords[i];
              mirror = true; // Mirror words were found
              break; // Stop checking for initial words in this separated word
            }
        }
        }
      // If no mirror words were found
      if(!mirror){
        // Random canned response\
        int ranIndex = (int)(Math.random()*3);
        response += cannedWords[ranIndex];
        // if no mirror words return randomly generated canned response
        return response;
      }
      else{
        // For every word in the separated list, add it to the response string
          for(int j = 0; j < separated.length; j++){
            response += separated[j] + " ";
        }
        // returns the response with a question mark
        return response + "?";
      }
  }

  public static void main(String[] arguments) {
    // You will start the conversation here.

    Scanner input = new Scanner(System.in); // Creates a scanner object

    // Requests input for number of rounds
    System.out.println("Hello! How many rounds would you like to have today?");
    int totalRounds = input.nextInt();
    input.nextLine(); // Partially generated with ChatGPT in order to find a solution to a bug

    // Create a conversation object
    Conversation current = new Conversation(totalRounds);

    // Starts the conversation and concatenates it to the transcript
    String opener = "What are you thinking about today?";
    System.out.println(opener);
    current.converse[0] = opener;

    // For every response given by the bot or the person
    for(int i = 1; i <(totalRounds*2); i++){
      // Get the user input
      String nextRes = input.nextLine();
      // Generate a response
      String botRes = current.chat(nextRes);
      // Concatenate both
      current.converse[i] = nextRes;
      current.converse[i+1] = botRes;
      // Print response
      System.out.println(botRes);
      // Skip over the index that the bots response was concatenated to
      i++;
    }
    // Print and concatenate farewell
    System.out.println("Goodbye!");
    current.converse[current.converse.length-1] = "Goodbye!";
    
    // Leave space
    System.out.println(" ");
    System.out.println(" ");
    // Print transcript
    System.out.println(current.getConverse());

    input.close();
  }
}
