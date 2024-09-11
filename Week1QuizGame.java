// import the scanner module in order to receive user input from System.in.
import java.util.Scanner;

public class Week1QuizGame {
  // Initialize a new scanner class object and the score.
  private static Scanner scanner = new Scanner(System.in);
  private static int score = 0;

  // main application where the question sets are defined and runGame is called.
  public static void main(String[] args){

    String[] question1 = {"What is the national dish of England?", "A", "A. Tikka Masala, B. Ham and Cheese, C. Fish and Chips, D. Butter Chicken"};
    String[] question2 = {"What is the most populous country on Earth?", "C", "A. Indonesia, B. China, C. India, D. United States"};
    String[] question3 = {"How many toes do cats have on their back paws?", "D", "A. Five, B. Three, C. Six, D. Four"}; 
    String[] question4 = {"What war led to the death by guillotine of Marie Antoinette?", "A", "A. The French Revolution, B. War of the First Coalition, C. Irish Rebellion, D. War of the Second Coalition"};

    String[] question5 = {"What is the national animal of Scotland?", "B", "A. Red squirrel, B. Unicorn, C. Harpy eagle, D. Brown bear"};

    String[][] questionSets = {
      question1,
      question2,
      question3,
      question4,
      question5
    };

    runGame(questionSets);
  }

  // Asks the player their name then greets the player. Then the program displays instructions to user.
  public static void introduction() {
    System.out.println("Hello! What\'s your name?");
    String name = scanner.nextLine();
    System.out.println("Hello" + (name.length() > 0 ? " " + name : "") + "!");
    System.out.println("Today we're playing a quick game. The setup is simple! You'll be prompted with a question and then you can reply with the letter associated with your answer. Let's see how high you can score!");
  };

  // Accesses a question array to display the question and choices to the user. If the user is able to answer correctly, increments the score by one.
  public static void promptQuestion(String[] questionSet) {
    String question = questionSet[0];
    String correctAnswer = questionSet[1];
    String questionChoices = questionSet[2];

    System.out.println("Here is the question...")
    System.out.println(question);
    System.out.println(questionChoices);
    System.out.println("Remember to only type the letter for your answer! And your answer is...")

    // Uses a switch case to check if the user entered a valid choice, if not, prompts again.
    String choice;
    boolean validChoice;

    do {
      choice = scanner.nextLine().toUpperCase();

      switch (choice) {
        case "A":
        case "B":
        case "C":
        case "D":
          validChoice = true;
          break;
        default:
          System.out.println("Please enter a valid Choice. Enter A, B, C, or D")
      }
    } while (!validChoice);

    if (choice.toUpperCase().equals(correctAnswer)) {
      System.out.println("...");
      System.out.println("Correct!");
      score++;
    } else {
      System.out.println("...");
      System.out.println("I'm sorry, but the correct answer was " + correctAnswer + ".")
    }

    System.out.println("Your score is now" + score + ".");
  }

  // Displays to the user the number of questions they had right and the percentage score. After displaying the score, resets the score back to 0Then asks the user if they wish to keep playing. If an invalid answer is entered, the prompt will repeat until a valid answer is submitted.
  public static boolean playAgain() {
    Double scoreDouble = score / 5.0 * 100; // Used the Double class instead of the double primitive to easily convert to an integer.
    int scorePercent = scoreDouble.intValue();
    System.out.println("You scored " + score + " out of 5! That's " + scorePercent + "%!");
    score = 0;

    System.out.println("Do you want to keep playing? Enter yes or no to continue.");

    while (true){
      String continueChoice = scanner.nextLine().toLowerCase();

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
  public static void runGame(String[][] questionSets) {
    boolean keepPlaying;

    introduction();

    do {
      for (String[] questionSet : questionSets){
        promptQuestion(questionSet);
      }

      keepPlaying = playAgain();
    } while (keepPlaying);

    System.out.println("Thank you for playing!");
    scanner.close();
  }  
}