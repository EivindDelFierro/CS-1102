import java.util.Scanner;

public class Week1QuizGame {
  public static void main(String[] args){
    // Scanner object in order to receive input from user via System.in
    Scanner scanner = new Scanner(System.in)

    String[] question1 = new String[]{"What is the national dish of England?", "A", "A. Tikka Masala, B. Ham and Cheese, C. Fish and Chips, D. Butter Chicken"};
    String[] question2 = new String[]{"What is the most populous country on Earth?", "C", "A. Indonesia, B. China, C. India, D. United States"};
    String[] question3 = new String[]{"How many toes do cats have on their back paws?", "D", "A. Five, B. Three, C. Six, D. Four"}; 
    String[] question4 = new String[]{"What war led to the death by guillotine of Marie Antoinette?", "A", "A. The French Revolution, B. War of the First Coalition, C. Irish Rebellion, D. War of the Second Coalition"};

    String[] question5 = new String[]{"What is the national animal of Scotland?", "B", "A. Red squirrel, B. Unicorn, C. Harpy eagle, D. Brown bear"};

    String[][] questionSets = new []{
      question1,
      question2,
      question3,
      question4,
      question5
    };

    int score = 0;

    public static void introduction() {
      System.out.println("Hello! What\'s your name?");
      String name = scanner.nextLine();
      System.out.println("Hello" + (name.length > 0 ? " " + name : "") + "!")
      // welcome, only type the first letter
    };

    public static void promptQuestion(string[][] questionSet) {
      String question = questionSet[0];
      String correctAnswer = questionSet[1];
      String questionChoices = questionSet[2]

      System.out.println("Here is our next question...")
      System.out.println(question)
      System.out.println(questionChoices);
      System.out.println("Remember to only type the letter for your answer! And your answer is...")
      String choice = scanner.nextln();
      if (choice.toUpperCase().equals(correctAnswer)) {
        
        score++
      }
    }
  }
}