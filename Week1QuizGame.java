// import the scanner module in order to receive user input from System.in.
import java.util.Scanner;

public class Week1QuizGame {
    // Initialize a new scanner class object for accepting user input and the score variable for keeping track of the score.
    private static final Scanner SCANNER = new Scanner(System.in);
    private static int score = 0;

    // This is the main application where the question sets are defined. runGame is called to start the game.
    public static void main(String[] args) {
        // Arrays are formatted so that it's [question, answer, choices]
        final String[] QUESTION_1 = {
            "What is the national dish of England?",
            "A",
            "A. Tikka Masala, B. Ham and Cheese, C. Fish and Chips, D. Butter Chicken" };
        final String[] QUESTION_2 = {
            "What is the most populous country on Earth?",
            "C",
            "A. Indonesia, B. China, C. India, D. United States" };
        final String[] QUESTION_3 = {
            "How many toes do cats have on their back paws?",
            "D",
            "A. Five, B. Three, C. Six, D. Four" };
        final String[] QUESTION_4 = {
            "What war led to the death by guillotine of Marie Antoinette?",
            "A",
            "A. The French Revolution, B. War of the First Coalition, C. Irish Rebellion, D. War of the Second Coalition" };
        final String[] QUESTION_5 = {
            "What is the national animal of Scotland?",
            "B",
            "A. Red squirrel, B. Unicorn, C. Harpy eagle, D. Brown bear" };

        final String[][] questionSets = {
            QUESTION_1,
            QUESTION_2,
            QUESTION_3,
            QUESTION_4,
            QUESTION_5
        };

        runGame(questionSets);
    }
    
    // Runs introduction, then iterates through the questionSets to ask questions. When the game ends, calls playAgain to determine if the player wants to play again. If not, Thanks the player and closes the scanner.
    private static void runGame(String[][] questionSets) {
        boolean willPlayAgain;

        introduction();

        do {
            for (String[] questionSet : questionSets){
                promptQuestion(questionSet);
            }

            willPlayAgain = playAgain();
        } while (willPlayAgain);

        System.out.println("Thank you for playing!");
        SCANNER.close();
    }  

    // Asks the player their name then greets the player, then instructs the user on how to play.
    private static void introduction() {
        System.out.println("Hello! What\'s your name?");
        final String NAME = SCANNER.nextLine();
        System.out.println("Hello" + (NAME.length() > 0 ? " " + NAME : "") + "!");
        System.out.println("Today we're playing a quick game. The setup is simple! You'll be prompted with a question and then you can reply with the letter associated with your answer. Let's see how high you can score!\n");
    };

    // Accesses a question set [question, answer, choices] to display the question and choices to the user. If the user is correct, increments the score by one.
    private static void promptQuestion(String[] questionSet) {
        final String QUESTION = questionSet[0];
        final String CORRECT_ANSWER = questionSet[1];
        final String QUESTION_CHOICES = questionSet[2];

        System.out.println(QUESTION);
        System.out.println(QUESTION_CHOICES);
        System.out.println("\nRemember to only type the letter for your answer! And your answer is...");

        String choice;

        do {
            choice = SCANNER.nextLine().toUpperCase();
        } while (!isValidChoice(choice));

        if (choice.equals(CORRECT_ANSWER)) {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("I'm sorry, but the correct answer was " + CORRECT_ANSWER + ".");
        }

        System.out.println("Your score is now " + score + ".\n");
    }

    private static boolean isValidChoice(String choice) {
        // Uses a switch case to check if the user entered a valid choice, if not, prompts the user again.
        switch (choice) {
            case "A":
            case "B":
            case "C":
            case "D":
              return true;
            default:
              System.out.println("Please enter a valid Choice. Enter A, B, C, or D");
              return false;
        }
    }

    // Displays the number of correct answers and the percentage score, then asks the user if they wish to keep playing. If they answer yes, the score is reset to 0, and returns true. If no, the function returns false. If an invalid answer is entered, the prompt will repeat until a valid answer is submitted.
    private static boolean playAgain() {
        final int SCORE_PERCENT = (int) (score / 5.0 * 100);
        
        System.out.println("\nYou scored " + score + " out of 5! That's " + SCORE_PERCENT + "%!");
        System.out.println("Do you want to keep playing? Enter yes or no to continue.");

        while (true) {
            String continueChoice = SCANNER.nextLine().toLowerCase();

            switch (continueChoice) {
              case "yes":
                score = 0;
                return true;
              case "no":
                return false;
              default:
                System.out.println("I didn't get your answer. Please try again.");
            }
        }
    }
}