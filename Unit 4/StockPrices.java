/**
 * StockPrices Class
 * Manages an array of double data-type values and provides methods to perform various operations on these prices.
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class StockPrices {
  double[][] prices;
  int length = 0;
  
  public StockPrices() {
      this.prices = inputPrices();
  }

  // Prompts the user to input stock prices and returns an array of double data-type values.
  private static double[][] inputPrices() {
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
          SCANNER.next(); // clear scanner buffer 
        }
      }
    } while (days == 0);

    // initialize chart prices based on number of days
    double[][] chartPrices = new double[days][];

    // Receive prices for each day
    for (int day = 1; day <= days; day++) {
      final int dayIndex = day-1;
      System.out.printf("\nEnter the stock prices for day %d. Input only one price at a time. Enter a non-numerical value to terminate the input and continue.\n", day);
      ArrayList<Double> inputPrices = new ArrayList<>(); // Utilize a ListArray to allow for dynamic resizing based on number of price inputs.

      do{
        try {
          System.out.print("Price to add: ");
          final String nextPriceString = SCANNER.nextLine();
          if (nextPriceString.isEmpty()) break;
          inputPrices.add(Double.parseDouble(nextPriceString));
        } catch (InputMismatchException e) { // if the user input's a non-number, terminate the input process
            System.out.println("Non-numerical value detected. Terminating Price input process.");
            SCANNER.next(); // clear scanner buffer
            break;
        }
      } while (true);

      // create an array based on the size of the ListArray.
      final int LIST_SIZE = inputPrices.size();
      chartPrices[dayIndex] = new double[LIST_SIZE]; 

      // copy the elements of the ArrayList to the double[];
      for (int priceIndex = 0; priceIndex < LIST_SIZE; priceIndex++) {
        chartPrices[dayIndex][priceIndex] = inputPrices.get(priceIndex);
      }
    }
    
    return chartPrices;
  }

  // Instance method returning the average stock price calculated from the provided stock prices as a double.
  public double calculateAveragePrice(int dayIndex) {
    return StockCalculator.calculateAveragePrice(this.prices[dayIndex]);
  }
  
  // Instance method returning the maximum stock price from the provided stock prices as a double.
  public double findMaximumPrice(int dayIndex) {
    return StockCalculator.findMaximumPrice(this.prices[dayIndex]);
  }

  // Instance method returning the frequency a price occurs within the provided stock prices as an integer.
  public int countOccurrences(int dayIndex, double priceToFind) {
    return StockCalculator.countOccurrences(this.prices[dayIndex], priceToFind);
  }

  public double computeCumulativeSum(int dayIndex) {
    return StockCalculator.computeCumulativeSum(this.prices[dayIndex]);
  }
}
