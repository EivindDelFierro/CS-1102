/**
 * SingletonScanner Class
 * Provides a single instance of a Scanner object to be shared across the application
 */

import java.util.Scanner;

public class SingletonScanner {
  final static Scanner SCANNER = new Scanner(System.in);

  public static Scanner getScanner() {
    return SCANNER;
  }

  public static void closeScanner() {
    SCANNER.close();
  }
}