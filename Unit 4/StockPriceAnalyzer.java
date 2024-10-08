/**
 * StockPriceAnalyzer Class
 * main entry point for the stock price analysis program. 
 * Accepts a set of numbers that a user inputs.
 * Utilizes a menu-driven interface to allow users to perform operations on the supplied stock prices.
 */

import java.util.Scanner;

public class StockPriceAnalyzer {
  public static void main (String[] args) {
    final Scanner SCANNER = SingletonScanner.getScanner();

    // intro for user
    System.out.printf("\n\nWelcome to the stock analyzer program!\n");
    System.out.println("You will first be prompted to enter the number of DAYs.");
    System.out.printf("You will then be prompted to enter a list of prices for each DAY.\n\n");

    // Create a new StockPrices Object that prompts user for inputs
    final StockPrices PRICES = new StockPrices();

    // Initialize menu options
    final String[] MENU_OPTION_PROMPTS = new String[]{"Get the average stock price", "Get the max stock price", "Get the frequency a price occurs", "Get the cumulative sum of all stock prices"};

    // Create a new MenuInterface based on the menu options
    final MenuInterface MAIN_MENU = new MenuInterface(MENU_OPTION_PROMPTS);

    // loop to repeat menu prompts
    do {
      // Prompt user for a selection
      int selection = MAIN_MENU.promptMenuSelection();

      // if the user chooses to exit, break the loop
      if (selection == MENU_OPTION_PROMPTS.length + 1) break;

      // determine which DAY the user wants to analyze
      final int DAY = promptDAY(PRICES);
      final int DAY_INDEX = DAY - 1;

      switch (selection) {
        // selection case for determining the average stock price
        case 1: 
          System.out.printf("\nThe average stock price is $%.2f on DAY %d.\n", PRICES.calculateAveragePrice(DAY_INDEX), DAY);
          break;

        // selection case for determining the max stock price
        case 2: 
          System.out.printf("\nThe max stock price is $%.2f on DAY %d.\n", PRICES.findMaximumPrice(DAY_INDEX), DAY);
          break;

        // selection case for finding the frequency a price occurs within the prices
        case 3: 
          float PARSED_INPUT;
        
          // Prompt user until a valid float value is inputted
          do {
            System.out.println("Enter a value to search.");
            System.out.print("Value to search: ");
            final String INPUT = SCANNER.nextLine().trim(); 

            // try to see if the user inputs a float
            try{ 
              if (INPUT.isEmpty()) {
                throw new NumberFormatException();
              }

              PARSED_INPUT = Float.parseFloat(INPUT);
              break;

            // if not, display error message and restart loop from beginning
            } catch (NumberFormatException e) { 
              System.out.println("\nError: Please Enter Only Numbers.\n");
              continue;
            }
          } while (true);

          System.out.printf("\nThe price $%.2f occurs %d times on DAY %d.\n",PARSED_INPUT, PRICES.countOccurrences(DAY_INDEX, PARSED_INPUT), DAY);
          break;

        // selection case for finding the cumulative sum of all stocks within the prices.
        case 4: 
          System.out.printf("\nThe cumulative sum of the stock prices on DAY %d: " + PRICES.computeCumulativeSum(DAY_INDEX) + "\n", DAY);
          break;
      }
    } while (true);

    // program is finished, close the scanner
    SCANNER.close();
  }

  /**
   * Prompts the user to enter a day as an integer
   * @param stockPricesObj A stockPricesObj that has a prices property
   * @return an integer value between 1 and the prices array length, inclusive.
   */
  private static int promptDAY (StockPrices stockPricesObj) {
    final int PARENT_ARRAY_LENGTH = stockPricesObj.prices.length;

    // if there is there is only one element in the stockPricesObj
    if (PARENT_ARRAY_LENGTH == 1) return 1;

    final Scanner SCANNER = SingletonScanner.getScanner();
    
    do {
      // prompt user for a day selection
      System.out.println("\nWhich day would you like to run this function on?");
      System.out.print("Day Selection: ");
      String input = SCANNER.nextLine().trim();

      // ensure that DayString isn't an empty string
      if (input.isEmpty()) {
        System.out.println("Please enter a day to continue.");
        continue;
      }

      try {
        final int DAY = Integer.parseInt(input);

        // ensure that the day falls between 1 and the parent array's length
        if (DAY < 1 || DAY > PARENT_ARRAY_LENGTH) {
          System.out.printf("You must input a Day value between 1 and %d\n", PARENT_ARRAY_LENGTH);
        } else {
          return DAY;
        }
      
      // if the string isn't able to be parsed as an integer, throw an error
      } catch (NumberFormatException e) {
        System.out.println("Please enter only whole integer numbers.");
      }
      
    } while (true);
  }
}
