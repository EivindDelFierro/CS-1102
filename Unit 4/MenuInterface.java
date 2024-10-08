/**
 * MenuInterface Class
 * Provides a reusable menu system for command-line interfaces.
 * Allows for the creation of a menu with customizable options and handles user input for menu selection.
 */

import java.util.Scanner;

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

    System.out.printf("     %d: Exit\n\n", this.options.length + 1);
  }

  /**
   * Prompts the user to select a menu option
   * @return A valid menu selection as an integer
   */

  public int selectMenuOption() {
    final int TRUE_OPTIONS_LENGTH = this.options.length + 1;
    
    System.out.printf("Select an option above or enter %d to exit\n", TRUE_OPTIONS_LENGTH);

    // loop to validate that input is valid for the current menu
    while (true) {
      try {
        System.out.print("Input: ");
        final String INPUT = SCANNER.nextLine();
        if (INPUT.isEmpty()) {
          throw new NumberFormatException();
        }

        final int SELECTION = Integer.parseInt(INPUT);

        if (SELECTION > 0 && SELECTION <= TRUE_OPTIONS_LENGTH) {
          return SELECTION;
        } else {
          System.out.printf("\nError: You must select an option from 1 to %d\n", TRUE_OPTIONS_LENGTH);
        }

      } catch (NumberFormatException e) {
        System.out.println("\nError: Please enter only numbers.\n");
      }
    }   
  }
}
