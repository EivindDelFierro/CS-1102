/**
 * StockPriceAnalyzer Class
 * main entry point for the stock price analysis program. 
 * Accepts a set of numbers that a user inputs.
 * It implements a menu-driven interface allowing users to perform various operations on the supplied stock prices.
 */

import java.util.Scanner;

public class StockPriceAnalyzer {
  public static void main (String[] args) {
    final Scanner SCANNER = SingletonScanner.getScanner();

    // Create a new StockPrices Object that prompts user for inputs
    final StockPrices PRICES = new StockPrices();

    // Initialize menu options
    final String[] MENU_OPTION_PROMPTS = new String[]{"Get the average stock price", "Get the max stock price", "Get the frequency a price occurs"};

    // Create a new MenuInterface based on the menu options
    final MenuInterface MAIN_MENU = new MenuInterface(MENU_OPTION_PROMPTS);

    // Prompt user for a selection
    int selection = MAIN_MENU.promptMenuSelection();

    // While the user doesn't select the exit option...
    while (selection != MENU_OPTION_PROMPTS.length + 1) {
      switch (selection) {
        case 1: // selection case for determining the average stock price
          System.out.printf("\nThe average stock price is $%.2f\n",PRICES.getAvgStockPrice());
          break;
        case 2: // selection case for determining the max stock price
          System.out.printf("\nThe max stock price is $%.2f\n", PRICES.getMaxStockPrice());
          break;
        case 3: // selection case for finding the frequency a price occurs within the prices
          double userInput;
        
          do {
            try{
              System.out.println("Enter a value to search.");
              System.out.print("Input: ");
              final String input = SCANNER.nextLine();
              userInput = Double.parseDouble(input);
              break;
            } catch (NumberFormatException e) {
              System.out.println("Please Enter Only Numbers");
              continue;
            }
          } while (true);

          int result = PRICES.getFrequencyOfPrice(userInput);
          System.out.printf("\nThe price $%.2f occurs %d times\n",userInput, result);
          break;
        default: // for selections that are not within the menu options
          System.out.println("Please select a valid option from the menu choices.");
      }

      selection = MAIN_MENU.promptMenuSelection();
    }

    SCANNER.close();
  }
}
