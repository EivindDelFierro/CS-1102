/**
 * StockCalculator Class
 * Public methods for performing various calculations on float[] and ArrayList<Float> data types
 */

import java.util.ArrayList;

public class StockCalculator {
  /**
   * Calculates the average price from an array of stock prices.
   * @param priceArray An array of stock prices
   * @return The average price as a float
   */
  public static float calculateAveragePrice(float[] priceArray) {
    return calculateAveragePrice(convertArrayToArrayList(priceArray));
  }

  /**
   * Calculates the average price from an arrayList of stock prices.
   * @param priceArray An arrayList of stock prices
   * @return The average price as a float
   */
  public static float calculateAveragePrice(ArrayList<Float> priceArray) {
    float total = 0;

    // iterate through price array, summing all elements
    for (float price : priceArray) {
      total += price;
    }

    return total / priceArray.size();
  }

  /**
   * Calculates the maximum price in an array of stock prices
   * @param priceArray An array of stock prices
   * @return The maximum price found in an array as an integer or 0 if the array length is 0
   */
  public static float findMaximumPrice(float[] priceArray) {
    return findMaximumPrice(convertArrayToArrayList(priceArray));
  }

  /**
   * Calculates the maximum price in an arrayList of stock prices
   * @param priceArray An arrayList of stock prices
   * @return The maximum price found in an array as an integer or 0 if the array length is 0
   */
  public static float findMaximumPrice(ArrayList<Float> priceArray) {
    if (priceArray.size() == 0) return 0;

    // initialize max value to the first price value
    float max = priceArray.get(0);

    // iterate through remaining values of array
    for (int i = 1; i < priceArray.size(); i++) {
      final float CURRENT_PRICE = priceArray.get(i);

      // update max if the current price is greater than the max
      if (CURRENT_PRICE > max)
        max = CURRENT_PRICE;
    }

    return max;
  }

  /**
   * Counts the frequency of a given price in an array of stock prices
   * @param priceArray An array of stock prices
   * @param priceToFind Value to count
   * @return The frequency priceToFind is found in priceArray as an integer
   */
  public static int countOccurrences(float[] priceArray, float priceToFind) {
    return countOccurrences(convertArrayToArrayList(priceArray), priceToFind);
  }

  /**
   * Counts the frequency of a given price in an arrayList of stock prices
   * @param priceArray An array of stock prices
   * @param priceToFind Value to count
   * @return The frequency priceToFind is found in priceArray as an integer
   */
  public static int countOccurrences(ArrayList<Float> priceArray, float priceToFind) {
    int total = 0;
    
    // iterate through price array incrementing total if price is found
    for (float price : priceArray) {
      if (price == priceToFind) {
        total += 1;
      }
    }

    return total;
  }

  /**
   * Computes the cumulative sum of an ArrayList so that each element is the sum of itself and all the values before it
   * @param priceArrayList An ArrayList of stock prices
   * @return An ArrayList of Float values containing the cumulative sum at each element
   */
  public static ArrayList<Float> computeCumulativeSum(ArrayList<Float> priceArray) {
    // initialize result to accept sum values
    ArrayList<Float> result = new ArrayList<Float>();

    float sum = 0;

    // iterate through each element, summing the price and then adding the value to the result ArrayList
    for (float price : priceArray) {
      sum += price;
      result.add(sum);
    }

    return result;
  }

  /**
   * Subroutine that converts an array of prices to an ArrayList
   * @param array The float array to convert
   * @return A Array<Float> containing the elements from the array
   */
  public static ArrayList<Float> convertArrayToArrayList(float[] array) {
    final ArrayList<Float> FLOAT_ARRAY_LIST = new ArrayList<>();

    for (float price : array) {
      FLOAT_ARRAY_LIST.add(price);
    }

    return FLOAT_ARRAY_LIST;
  }
}
