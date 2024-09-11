// import the scanner module in order to receive user input from System.in.
import java.util.Scanner;

public class Week1QuizGame {
  // Initialize a new scanner class object for accepting user input and the score variable for keeping track of the score.
  private static final Scanner SCANNER = new Scanner(System.in);
  private static int score = 0;

  // This is the main application where the question sets are defined. runGame is called to start the game.
  public static void main(String[] args){
    // Arrays are formatted so that it's [question, answer, choices]
    final String[] QUESTION_1 = {"What is the national dish of England?", "A", "A. Tikka Masala, B. Ham and Cheese, C. Fish and Chips, D. Butter Chicken"};
    final String[] QUESTION_2 = {"What is the most populous country on Earth?", "C", "A. Indonesia, B. China, C. India, D. United States"};
    final String[] QUESTION_3 = {"How many toes do cats have on their back paws?", "D", "A. Five, B. Three, C. Six, D. Four"}; 
    final String[] QUESTION_4 = {"What war led to the death by guillotine of Marie Antoinette?", "A", "A. The French Revolution, B. War of the First Coalition, C. Irish Rebellion, D. War of the Second Coalition"};
    final String[] QUESTION_5 = {"What is the national animal of Scotland?", "B", "A. Red squirrel, B. Unicorn, C. Harpy eagle, D. Brown bear"};

    final String[][] questionSets = {
      QUESTION_1,
      QUESTION_2,
      QUESTION_3,
      QUESTION_4,
      QUESTION_5
    };

    runGame(questionSets);
  }

  // Asks the player their name then greets the player. Then the program displays instructions to user.
  private static void introduction() {
    System.out.println("Hello! What\'s your name?");
    final String NAME = SCANNER.nextLine();
    System.out.println("Hello" + (NAME.length() > 0 ? " " + NAME : "") + "!");
    System.out.println("Today we're playing a quick game. The setup is simple! You'll be prompted with a question and then you can reply with the letter associated with your answer. Let's see how high you can score!");
  };

  // Accesses a question array to display the question and choices to the user. If the user is able to answer correctly, increments the score by one.
  private static void promptQuestion(String[] questionSet) {
    final String QUESTION = questionSet[0];
    final String CORRECT_ANSWER = questionSet[1];
    final String QUESTION_CHOICES = questionSet[2];

    System.out.println("Here is the question...");
    System.out.println(QUESTION);
    System.out.println(QUESTION_CHOICES);
    System.out.println("Remember to only type the letter for your answer! And your answer is...")

    // Uses a switch case to check if the user entered a valid choice, if not, prompts again.
    String choice;
    boolean validChoice;

    do {
      choice = SCANNER.nextLine().toUpperCase();

      switch (choice) {
        case "A":
        case "B":
        case "C":
        case "D":
          validChoice = true;
          break;
        default:
          System.out.println("Please enter a valid Choice. Enter A, B, C, or D");
      }
    } while (!validChoice);

    if (choice.equals(CORRECT_ANSWER)) {
      System.out.println("...");
      System.out.println("Correct!");
      score++;
    } else {
      System.out.println("...");
      System.out.println("I'm sorry, but the correct answer was " + CORRECT_ANSWER + ".");
    }

    System.out.println("Your score is now " + score + ".");
  }

  // Displays to the user the number of questions they had right and the percentage score. After displaying the score, resets the score back to 0Then asks the user if they wish to keep playing. If an invalid answer is entered, the prompt will repeat until a valid answer is submitted.
  private static boolean playAgain() {
    final Double SCORE_DOUBLE = score / 5.0 * 100; // Used the Double class instead of the double primitive to easily convert to an integer.
    final int SCORE_PERCENT = SCORE_DOUBLE.intValue();
    System.out.println("You scored " + score + " out of 5! That's " + SCORE_PERCENT + "%!");
    score = 0;

    System.out.println("Do you want to keep playing? Enter yes or no to continue.");

    while (true){
      String continueChoice = SCANNER.nextLine().toLowerCase();

      switch (continueChoice) {
        case "yes":
          return true;
        case "no":
          return false;
        default: System.out.println("I didn't get your answer. Please try again.");
      }
    }    
  }

  // Runs introduction, then iterates through the questionSets to ask questions. When the game ends, calls playAgain to determine if the player wants to play again. If not, Thanks the player and closes the scanner.
  private static void runGame(String[][] questionSets) {
    boolean keepPlaying;

    introduction();

    do {
      for (String[] questionSet : questionSets){
        promptQuestion(questionSet);
      }

      keepPlaying = playAgain();
    } while (keepPlaying);

    System.out.println("Thank you for playing!");
    SCANNER.close();
  }  
}