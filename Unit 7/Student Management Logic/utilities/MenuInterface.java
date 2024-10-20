package utilities;

/**
 * MenuInterface Class
 * 
 * Provides a reusable menu system for command-line interfaces.
 * Allows for the creation of a menu with customizable options and handles user input for menu selection.
 */

 public class MenuInterface {
  private String[] options;

  /**
   * Constructs a MenuInterface with the given options.
   * @param options Variable number of strings representing menu options.
   */
  public MenuInterface (String... options) {
    this.options = options;
  }

  /**
   * Displays menu items and prompts the user for a selection.
   * @return The user's menu selection as an integer.
   * @throws PromptException If there's an issue with user input.
   */
  public int promptMenuSelection() throws PromptException{
    showMenuOptions();
    return selectMenuOption();
  }

  /**
   * Displays the menu options.
   */
  public void showMenuOptions() {
    System.out.println();
    for (int i = 0; i < this.options.length; i++) {
      System.out.printf("     %d: %s\n", i + 1, options[i]);
    }

    System.out.printf("     %d: Exit\n\n", this.options.length + 1);
  }

  /**
   * Prompts the user to select a menu option.
   * @return A valid menu selection as an integer.
   * @throws PromptException If there's an issue with user input.
   */
  public int selectMenuOption() throws PromptException {
    final int TRUE_OPTIONS_LENGTH = this.options.length + 1;
    
    System.out.printf("Select an option above or enter %d to exit\n", TRUE_OPTIONS_LENGTH);

    while (true) {
      final int SELECTION = Prompt.getValidInt();

      if (SELECTION > 0 && SELECTION <= TRUE_OPTIONS_LENGTH) {
        return SELECTION;
      } else {
        System.out.printf("\nError: You must select an option from 1 to %d\n", TRUE_OPTIONS_LENGTH);
      }
    }
  }   

  /**
   * Gets the integer for the menu exit option.
   * @return The size of options array plus one.
   */
  public int getExitOptionInteger() {
    return this.options.length + 1;
  }
}
 
 