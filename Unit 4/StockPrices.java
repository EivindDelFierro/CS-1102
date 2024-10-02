/**
 * StockPrices Class
 * Manages an array of double data-type values and provides methods to perform various operations on these prices.
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class StockPrices {
  double[] prices;
  
  public StockPrices() {
      this.prices = inputPrices();
  }

  // Prompts the user to input stock prices and returns an array of double data-type values.
  private static double[] inputPrices() {
    ArrayList<Double> inputPrices = new ArrayList<>(); // Utilize a ListArray to allow for dynamic resizing based on number of user inputs.
    final Scanner SCANNER = SingletonScanner.getScanner();

     // prompt user to enter inputs
     System.out.println("Enter prices. Entering a non-numerical value will terminate the input.");

    while (SCANNER.hasNext()) {
      try {
          if (SCANNER.hasNextDouble()) {
              double USER_INPUT = SCANNER.nextDouble();
              inputPrices.add(USER_INPUT);
          } else {
            SCANNER.next(); // clear scanner buffer
            break;
          }
      } catch (InputMismatchException e) { // if the user input's a non-number, terminate the input process
          System.out.println("Non-numerical value detected. Terminating input process.");
          SCANNER.next(); // clear scanner buffer
          break;
      }
    }

    // create an array based on the size of the ListArray.
    final int LIST_SIZE = inputPrices.size();
    double[] arrayOfPrices = new double[LIST_SIZE]; 

    // copy the elements of the ArrayList to the double[];
    for (int i = 0; i < LIST_SIZE; i++) {
      arrayOfPrices[i] = inputPrices.get(i);
    }
    
    return arrayOfPrices;
  }

  // Instance method returning the average stock price calculated from the provided stock prices as a double.
  public double calculateAveragePrice() {
    return StockCalculator.calculateAveragePrice(this.prices);
  }
  
  // Instance method returning the maximum stock price from the provided stock prices as a double.
  public double findMaximumPrice() {
    return StockCalculator.findMaximumPrice(this.prices);
  }

  // Instance method returning the frequency a price occurs within the provided stock prices as an integer.
  public int countOccurrences(double priceToFind) {
    return StockCalculator.countOccurrences(this.prices, priceToFind);
  }

  public double computeCumulativeSum() {
    return StockCalculator.computeCumulativeSum(this.prices);
  }
}
