/**
 * StockPriceAnalyzer Class
 * main entry point for the stock price analysis program. 
 * Accepts a set of numbers that a user inputs.
 * It implements a menu-driven interface allowing users to perform various operations on the supplied stock prices.
 */

import java.util.Scanner;
import java.util.InputMismatchException;

public class StockPriceAnalyzer {
  public static void main (String[] args) {
    final Scanner SCANNER = SingletonScanner.getScanner();

    // intro for user
    System.out.printf("\n\nWelcome to the stock analyzer program!\n");
    System.out.println("You will first be prompted to enter the number of days.");
    System.out.printf("You will then be prompted to enter a list of prices for each day.\n\n");

    // Create a new StockPrices Object that prompts user for inputs
    final StockPrices PRICES = new StockPrices();

    // Initialize menu options
    final String[] MENU_OPTION_PROMPTS = new String[]{"Get the average stock price", "Get the max stock price", "Get the frequency a price occurs", "Get the cumulative sum of all stock prices"};

    // Create a new MenuInterface based on the menu options
    final MenuInterface MAIN_MENU = new MenuInterface(MENU_OPTION_PROMPTS);

    // Prompt user for a selection
    int selection = MAIN_MENU.promptMenuSelection();

    // While the user doesn't select the exit option...
    while (selection != MENU_OPTION_PROMPTS.length + 1) {
      // determine which day the user wants to analyze
      final int day = promptDays(PRICES);
      final int dayIndex = day - 1;

      switch (selection) {
        case 1: // selection case for determining the average stock price
          System.out.printf("\nThe average stock price is $%.2f on day %d.\n\n", PRICES.calculateAveragePrice(dayIndex), day);
          break;
        case 2: // selection case for determining the max stock price
          System.out.printf("\nThe max stock price is $%.2f on day %d.\n\n", PRICES.findMaximumPrice(dayIndex), day);
          break;
        case 3: // selection case for finding the frequency a price occurs within the prices
          double userInput;
        
          // keep prompting a value to search 
          do {
            try{ // try to see if the user inputs a double
              System.out.println("Enter a value to search.");
              System.out.print("Value to search: ");
              userInput = SCANNER.nextDouble();
              break;
            } catch (NumberFormatException e) { // if not, display error message and restart loop from beginning
              System.out.println("Please Enter Only Numbers.");
              continue;
            }
          } while (true);

          System.out.printf("\nThe price $%.2f occurs %d times on day %d.\n\n",userInput, PRICES.countOccurrences(dayIndex, userInput), day);
          break;
        case 4: // selection case for finding the cumulative sum of all stocks within the prices.
          System.out.printf("\nThe cumulative sum of the stock prices is $%.2f on day %d.\n\n", PRICES.computeCumulativeSum(dayIndex), day);
          break;
        default: // for selections that are not within the menu options
          System.out.println("Please select a valid option from the menu choices.");
      }

      selection = MAIN_MENU.promptMenuSelection();
    }

    SCANNER.close();
  }

  private static int promptDays (StockPrices stockpricesObj) {
    final Scanner SCANNER = SingletonScanner.getScanner();
    final int parentArrayLength = stockpricesObj.prices.length;

    do {
      try {
        System.out.println("Which day would you like to run this function on?");
        System.out.print("Day Selection: ");
        final int day = SCANNER.nextInt();

        if (day < 1 || day > parentArrayLength) {
          System.out.printf("You must input a day value between 1 and %d\n", parentArrayLength);
        } else {
          return day;
        }
      } catch (InputMismatchException e) {
        System.out.println("Please enter only whole integer numbers.");
      }
    } while (true);
  }
}
