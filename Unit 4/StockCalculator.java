import java.util.InputMismatchException;
import java.util.Scanner;

public class StockCalculator {
  public static double calculateAverageStockPrice(double[] priceArray) {
    double total = 0;
    int count = 0;

    for (var price : priceArray) {
      total += price;
      count++;
    }

    return total / count;
  }

  public static double findMaxStockPrice(double[] priceArray) {
    if (priceArray.length == 0) return 0;
    double max = priceArray[0];

    for (int i = 1; i < priceArray.length; i++) {
      final double CURRENT_PRICE = priceArray[i];

      if (CURRENT_PRICE > max)
        max = CURRENT_PRICE;
    }

    return max;
  }

  public static int findFrequencyOfPrice(double[] priceArray, double priceToFind) {
    int total = 0;
    
    try {

      for (var price : priceArray) {
        if (price == priceToFind) {
          total += 1;
        }
      }
      
    } catch (InputMismatchException e) {
      System.out.println(e);
    }

    return total;
  }

  public static double calculateSumOfStockPrices(double[] priceArray) {
    double sum = 0;

    for (var price : priceArray) {
      sum += price;
    }

    return sum;
  }
}
