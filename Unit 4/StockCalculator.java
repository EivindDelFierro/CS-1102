public class StockCalculator {
  public static double calculateAverageStockPrice(double[] priceArray) {
    double total = 0;

    for (var price : priceArray) {
      total += price;
    }

    return total;
  }

  public static double findMaxStockPrice(double[] priceArray) {
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

    for (var price : priceArray) {
      if (price == priceToFind) {
        total += 1;
      }
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
