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