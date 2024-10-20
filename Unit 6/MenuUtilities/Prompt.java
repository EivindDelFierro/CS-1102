package MenuUtilities;
import java.util.Scanner;

/**
 * Prompt Class
 * Utility class for prompting users for input with built-in error handling.
 * This class provides methods to get valid integer, double, and string inputs from the user.
 * It uses a static Scanner to read input from the console.
 */

public class Prompt {
  final private static Scanner SCANNER = new Scanner(System.in);

  /**
   * Prompts the user for an integer input with a custom prompt message.
   * @param prompt The prompt message to display to the user.
   * @return A valid integer entered by the user.
   */
  public static int getValidInt(String prompt) throws PromptException {
    newLinePrompt(prompt);
    return getValidInt();
  }

  /**
   * Prompts the user for an integer input without a custom prompt message.
   * @return A valid integer entered by the user.
   */
  public static int getValidInt() throws PromptException {
    do {
      final String INPUT = askForInput();
      try {
        if (INPUT.isEmpty()) throw new PromptException("Enter an integer");
        return Integer.parseInt(INPUT);
      } catch (NumberFormatException e){
        throw new PromptException("Enter an integer.");
      }
    } while (true);
  }

  /**
   * Prompts the user for a double input with a custom prompt message.
   * @param prompt The prompt message to display to the user.
   * @return A valid double entered by the user.
   */
  public static double getValidDouble(String prompt) throws PromptException {
    newLinePrompt(prompt);
    return getValidDouble();
  }

  /**
   * Prompts the user for a double input without a custom prompt message.
   * @return A valid double entered by the user.
   */
  public static double getValidDouble() throws PromptException {
    do {
      final String INPUT = askForInput();
      try {
        if (INPUT.isEmpty()) throw new PromptException("Enter a real number.");
        return Double.parseDouble(INPUT);
      } catch (NumberFormatException e){
        throw new PromptException("Enter a real number.");
      }
    } while (true);
  }

  /**
   * Prompts the user for a string input with a custom prompt message.
   * @param prompt The prompt message to display to the user.
   * @return A valid non-empty string entered by the user.
   */
  public static String getValidString(String prompt) throws PromptException {
    newLinePrompt(prompt);
    return getValidString();
  }

  /**
   * Prompts the user for a string input without a custom prompt message.
   * @return A valid non-empty string entered by the user.
   */
  public static String getValidString() throws PromptException {
    do {
      final String INPUT = askForInput();
      try {
        if (INPUT.isEmpty()) throw new PromptException("Enter a non-empty String");
        return INPUT;
      } catch (IllegalArgumentException e){
        throw new PromptException("Enter a non-empty String");
      }
    } while (true);
  }

  /**
   * Displays a prompt message on a new line.
   * @param prompt The prompt message to display.
   */
  private static void newLinePrompt(String prompt) throws PromptException {
    System.out.printf("\n" + prompt + "\n");
  }

  /**
   * Prompts the user for input and returns the trimmed input string.
   * @return The user's input as a trimmed string.
   */
  private static String askForInput() throws PromptException {
    System.out.print("Input: ");
    return SCANNER.nextLine().trim();
  }

  public static void printPromptException(PromptException e) {
    System.out.println(e.getClass().getSimpleName() + ": " + e.getMessage());
  }
}
