/**
 * SingletonScanner Class
 * Provides a single instance of a Scanner object to be shared across the application
 */

import java.util.Scanner;

public class SingletonScanner {
  // initialize single instance of Scanner
  final private static Scanner SCANNER = new Scanner(System.in);

  // getter method for getting instance
  public static Scanner getScanner() {
    return SCANNER;
  }

  // subroutine for closing instance
  public static void closeScanner() {
    SCANNER.close();
  }
}