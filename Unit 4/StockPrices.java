/**
 * StockPrices Class
 * Manages an array of double data-type values and provides methods to perform various operations on these prices.
 */

import java.util.ArrayList;
import java.util.Scanner;
public class StockPrices {
  float[][] prices;
  
  public StockPrices() {
      this.prices = inputPrices();
  }

  /**
   * subroutine that prompts the user to input stock prices
   * @return An array of double data-type values
   */
  private static float[][] inputPrices() {
    final Scanner SCANNER = SingletonScanner.getScanner();

    // prompt user to enter inputs
    System.out.println("Enter how many days of stock prices to enter. Entering a non-numerical value will terminate the input.");

    int days = 0;

    // get the number of days
    do {
      try {
        System.out.print("Number of days: ");
        final String USER_INPUT = SCANNER.nextLine();
        days = Integer.parseInt(USER_INPUT);
      } catch (NumberFormatException e) { // if the user input's a non-number, terminate the input process
        if (days == 0) {
          System.out.println("Please enter at least 1 day.");
        } else {
          System.out.println("Please enter a number corresponding to the number of days of prices to store.");
        }
      }
    } while (days == 0);

    // initialize chart prices based on number of days
    float[][] chartPrices = new float[days][];

    // Receive prices for each day
    for (int day = 1; day <= days; day++) {
      final int dayIndex = day-1;
      System.out.printf("\nEnter the stock prices for day %d. Input only one price at a time. Enter a non-numerical value to terminate the input and continue.\n", day);
      ArrayList<Float> inputPrices = new ArrayList<>(); // Utilize a ListArray to allow for dynamic resizing based on number of price inputs.

      do{
        try {
          System.out.print("Price to add: ");
          final String nextPriceString = SCANNER.nextLine();
          if (nextPriceString.isEmpty()) break;
          inputPrices.add(Float.parseFloat(nextPriceString));
        // if the user input's a non-number, terminate the input process
        } catch (NumberFormatException e) {
          System.out.println("Non-numerical value detected. Terminating Price input process.");
            break;
        }
      } while (true);

      // create an array based on the size of the ListArray.
      final int LIST_SIZE = inputPrices.size();
      chartPrices[dayIndex] = new float[LIST_SIZE]; 

      // copy the elements of the ArrayList to the float[];
      for (int priceIndex = 0; priceIndex < LIST_SIZE; priceIndex++) {
        chartPrices[dayIndex][priceIndex] = inputPrices.get(priceIndex);
      }
    }
    
    return chartPrices;
  }

  /**
   * Instance method that returns the average stock price on a given day
   * @param dayIndex Index of an array of prices to evaluate
   * @return The average price as a float
   */
  public float calculateAveragePrice(int dayIndex) {
    return StockCalculator.calculateAveragePrice(this.prices[dayIndex]);
  }
  
  /**
   * Instance method that calculates the maximum price of a stock on a given day
   * @param dayIndex Index of an array of prices to evaluate
   * @return The maximum price found in an array as an integer or 0 if the array length is 0
   */
  public float findMaximumPrice(int dayIndex) {
    return StockCalculator.findMaximumPrice(this.prices[dayIndex]);
  }

  /**
   * Instance method that counts the frequency of a given price of a stock on a given day
   * @param dayIndex Index of an array of prices to evaluate
   * @param priceToFind Price to find
   * @return The frequency a given price occurs in priceArray as an integer
   */
  public int countOccurrences(int dayIndex, float priceToFind) {
    return StockCalculator.countOccurrences(this.prices[dayIndex], priceToFind);
  }

  /**
   * Instance method that computes the cumulative sum of an ArrayList so that each element is the sum of itself and all the values before it
   * @param dayIndex Index of an array of prices to evaluate
   * @return An ArrayList of Float values containing the cumulative sum at each element
   */
  public ArrayList<Float> computeCumulativeSum(int dayIndex) {
    return StockCalculator.computeCumulativeSum(StockCalculator.convertArrayToArrayList(this.prices[dayIndex]));
  }
}