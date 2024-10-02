/**
 * MenuInterface Class
 * Reusable menu system
 */

import java.util.Scanner;
import java.util.InputMismatchException;

public class MenuInterface {
  final private static Scanner SCANNER = SingletonScanner.getScanner();
  private String[] options;

  // Constructor that accepts an array of Strings or a variable number of Strings
  public MenuInterface (String... options) {
    this.options = options;
  }

  // displays menu items and prompts the user for a selection
  public int promptMenuSelection() {
    showMenuOptions();
    return selectMenuOption();
  }

  // Displays the menu options
  public void showMenuOptions() {
    System.out.println();
    for (int i = 0; i < this.options.length; i++) {
      System.out.printf("     %d: %s\n", i + 1, options[i]);
    }

    System.out.printf("     %d: Exit\n", this.options.length + 1);
  }

  // Prompts the user to select a menu option
  public int selectMenuOption() {
    System.out.printf("Select an option above or enter %d to exit\n", this.options.length + 1);
    System.out.print("Input: ");

    do {
      try {
        final int selection = SCANNER.nextInt();

        if (selection > 0 && selection <= this.options.length + 1) {
          return selection;
        } else {
          System.out.printf("Error: You must select an option from 1 to %d\n", this.options.length);
        }

      } catch (InputMismatchException e) {
        System.out.println("InputMismatchException: Please enter only numbers.");
      }
    } while (true);    
  }
}
