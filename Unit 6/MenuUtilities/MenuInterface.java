package MenuUtilities;

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
  public int promptMenuSelection(boolean includeExit) throws PromptException{
    showMenuOption(includeExit);
    System.out.println();
    return selectMenuOption(includeExit);
  }

  /**
   * Displays the menu options without an exit option.
   */
  public void showMenuOption(boolean includeExit) {
    System.out.println();
    for (int i = 0; i < this.options.length; i++) {
      System.out.printf("     %d: %s\n", i + 1, options[i]);
    }

    if (includeExit) System.out.printf("     %d: Exit\n\n", this.options.length + 1);
  }
  

  public int selectMenuOption(boolean includeExit) throws PromptException {
    int maxOption = includeExit ? this.options.length + 1 : this.options.length;
    
    System.out.printf("Select an option above%s\n", 
        includeExit ? String.format(" or enter %d to exit", maxOption) : "");

    while (true) {
        int selection = Prompt.getValidInt();
        if (selection > 0 && selection <= maxOption) {
            return selection;
        }
        System.out.printf("\nError: You must select an option from 1 to %d\n", maxOption);
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
 
 