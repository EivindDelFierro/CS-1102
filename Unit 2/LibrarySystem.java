import java.util.Scanner; // Import Scanner for reading user input.

public class LibrarySystem {
  private static final Scanner SCANNER = new Scanner(System.in);

  // utilize a catalog comprised of three arrays, where an index is used to locate
  // a book's title, author, and quantity in stock
  private static String[] titleArray = {};
  private static String[] authorArray = {};
  private static int[] quantityArray = {};
  private static int entryCount = 0; // counter used to track number of books in the catalog

  public static void main(String[] args) {
    System.out.println();
    System.out.println("Welcome to the Data Frontier's library system!");
    String menuInput;

    do {
      menuInput = mainMenuPrompt();
      switch (menuInput) { // matches menu selection to relevant subroutines
        case "a":
          addBook(); // run addBook subroutine
          break;
        case "b":
          borrowBooks(); // run borrowBooks subroutine
          break;
        case "c":
          returnBooks(); // run returnBooks subroutine
      }
    } while (!menuInput.equals("d")); // repeats main menu prompting after subroutine terminates unless the user
                                      // selects option "d" to exit

    exit(); // run exit function
  }

  // Displays main menu choices to the user. Returns a string after prompting a
  // user for input.
  private static String mainMenuPrompt() {
    System.out.println();
    System.out.println("Please select an option from the choices below:");

    final String[] MAIN_MENU_CHOICES = { "A. Add Books", "B. Borrow Books", "C. Return Books", "D. Exit" };

    // Print the main menu choices with each option indented for easier readability
    for (int i = 0; i < MAIN_MENU_CHOICES.length; i++) {
      System.out.println("  " + MAIN_MENU_CHOICES[i]);
    }

    return getMainMenuInput();
  }

  // Returns the user input if the user input is either a, b, c, or d. Otherwise
  // an error message is displayed and the user is prompted again.
  private static String getMainMenuInput() {
    String choice;

    while (true) {
      choice = promptForValidString("Select menu option (A, B, C, or D):"); // prompts user to select a menu option
      switch (choice) {
        case "a":
        case "b":
        case "c":
        case "d":
          return choice; // returns choice and terminates the loop
        default:
          System.out.println("Value Error: Please only use the letter associated with your choice (A, B, C, or D).");
      }
    }
  }

  // Searches through the titleArray and authorArray for matching strings. If
  // there is a match, returns the index, otherwise returns -1.
  private static int getIndexOfBook(String title, String author) {
    // format inputs to standardize seach
    final String FORMATTED_TITLE = title.trim().toLowerCase();
    final String FORMATTED_AUTHOR = author.trim().toLowerCase();

    for (int bookIndex = 0; bookIndex < entryCount; bookIndex++) {
      // format catalog title and author to standardize search
      final String CATALOG_TITLE = titleArray[bookIndex].toLowerCase();
      final String CATALOG_AUTHOR = authorArray[bookIndex].toLowerCase();

      if (CATALOG_TITLE.equals(FORMATTED_TITLE) && CATALOG_AUTHOR.equals(FORMATTED_AUTHOR)) // if the title and author
                                                                                            // match at a specific index
        return bookIndex; // return the index
    }

    return -1; // if the book is not found, return -1
  }

  // Prompts the user for a book title, author, and quantity to add. If the
  // requested book is in stock, adds the input quantity to the existing quantity.
  // If the book is not in the catalog, adds it to the catalog with the stock
  // quantity equivalent to the input quantity. If the user enters a quantity of
  // 0, cancels the request.
  private static void addBook() {
    do {
      final String INPUT_TITLE = promptForValidString("Book title:");
      final String INPUT_AUTHOR = promptForValidString("Book author:");
      final int INPUT_QUANTITY = promptForPositiveInt("Quantity:");

      if (INPUT_QUANTITY == 0) { // if the user enters 0 books, display a Request Cancellation message and jump
                                 // to loop condition evaluation
        System.out.print("Request Cancelled: Quantity must be a minimum of 1. ");
        continue; // jump to while conditional evaluation
      }

      final int BOOK_INDEX = getIndexOfBook(INPUT_TITLE, INPUT_AUTHOR); // search catalog for book
      int totalQuantity;

      if (BOOK_INDEX == -1) { // if the book is not in the catalog
        addBookToCatalog(INPUT_TITLE, INPUT_AUTHOR, INPUT_QUANTITY); // add the book to the catalog
        totalQuantity = INPUT_QUANTITY;
      } else { // if the book is found in the catalog
        totalQuantity = quantityArray[BOOK_INDEX] += INPUT_QUANTITY; // update the quantity
      }
      System.out.printf("Request Successful: You have added %d book(s) by %s titled \"%s\". In stock quantity: %d. ",
          INPUT_QUANTITY, INPUT_AUTHOR, INPUT_TITLE, totalQuantity);
    } while (isYesOrNo("Do you want to add more books?")); // repeats the loop if the user wants to add more/other books
  }

  // accepts a prompt, String, and returns the trimmed user input if the trimmed
  // string length is longer than 0.
  private static String promptForValidString(String prompt) {
    String input;

    while (true) {
      System.out.print(prompt + " ");
      input = SCANNER.nextLine().trim();
      if (input.length() > 0)
        break;
      System.out.println("Type Error: User input must have at least one non-whitespace character. ");
    }

    return input;
  }

  // accepts a prompt, String, and returns the user input if it was a positive
  // int.
  private static int promptForPositiveInt(String prompt) {
    int inputQuantity;

    while (true) {
      System.out.print(prompt + " ");

      try {
        final String USER_INPUT = SCANNER.nextLine();
        inputQuantity = Integer.parseInt(USER_INPUT);
        if (inputQuantity >= 0)
          break;
        System.out.println("Value Error: User input must be an integer with a value of 0 or more. ");
      } catch (Exception error) {
        System.out.println("Type Error: User input was not an integer. ");
      }
    }

    return inputQuantity;
  }

  // Accepts a title, String, author, String, quantity, int, and updates the
  // catalog with the new book.
  private static void addBookToCatalog(String title, String author, int quantity) {
    // Create new arrays that accepts one element more than our current arrays.
    entryCount++;
    String[] newTitleArray = new String[entryCount];
    String[] newAuthorArray = new String[entryCount];
    int[] newQuantityArray = new int[entryCount];

    // Copy existing catalog into new arrays.
    for (int i = 0; i < entryCount - 1; i++) {
      newTitleArray[i] = titleArray[i];
      newAuthorArray[i] = authorArray[i];
      newQuantityArray[i] = quantityArray[i];
    }

    // Add newest element to the last position of the new arrays.
    newTitleArray[entryCount - 1] = title;
    newQuantityArray[entryCount - 1] = quantity;
    newAuthorArray[entryCount - 1] = author;

    // Reassigns catalog arrays to new arrays.
    titleArray = newTitleArray;
    quantityArray = newQuantityArray;
    authorArray = newAuthorArray;
  }

  // accepts a string, prompt, and returns a boolean if it is a yes or no response
  private static boolean isYesOrNo(String prompt) {
    while (true) {
      System.out.println();
      System.out.println(prompt + ' ');
      System.out.print("Enter (Y)es or (N)o to continue: ");
      final String input = SCANNER.nextLine();

      switch (input.toLowerCase()) {
        case "y":
        case "yes":
          return true;
        case "n":
        case "no":
          return false;
        default:
          System.out.println("Value Error: User input must be (Y)es or (N)o. ");
      }
    }
  }

  // Prompts the user for a book title and author. If the requested book is in
  // stock, prompts for quantity. If there are not enough books, it displays a
  // request unsuccessful message and reason.
  private static void borrowBooks() {
    do {
      // Prompt the user to enter the title and author and determine if the book is in
      // the catalog
      final String INPUT_TITLE = promptForValidString("Book title:");
      final String INPUT_AUTHOR = promptForValidString("Book author:");
      final int INDEX_OF_TITLE = getIndexOfBook(INPUT_TITLE, INPUT_AUTHOR);

      if (INDEX_OF_TITLE >= 0) { // if the requested book is found in the catalog
        final String CATALOG_TITLE = titleArray[INDEX_OF_TITLE];
        final String CATALOG_AUTHOR = authorArray[INDEX_OF_TITLE];
        int booksInStock = quantityArray[INDEX_OF_TITLE];

        // Informs the user how many books are in stock
        if (booksInStock == 1) { // if there is only 1 book in stock
          System.out.printf("There is currently 1 book by %s titled \"%s\" in stock. ", CATALOG_AUTHOR, CATALOG_TITLE);
        } else { // if there are multiple books in stock
          System.out.printf("There are currently %d books by %s titled \"%s\" in stock. ", booksInStock,
              CATALOG_AUTHOR, CATALOG_TITLE);
        }

        final int INPUT_QUANTITY = promptForPositiveInt("Quantity:"); // prompt user for quantity to borrow

        if (INPUT_QUANTITY == 0) { // if the user enters 0 books, display a Request Cancellation message and jump
          // to loop condition evaluation
          System.out.print("Request Cancelled: Quantity must be a minimum of 1. ");
          continue; // jump to while conditional evaluation
        }

        if (booksInStock >= INPUT_QUANTITY) { // if there is enough stock to fulfill the request
          quantityArray[INDEX_OF_TITLE] = booksInStock -= INPUT_QUANTITY; // update the stock quantity

          switch (booksInStock) {
            case 0:
              System.out.printf("Request Successful: There are no books titled \"%s\" by %s left in stock. ",
                  CATALOG_TITLE, CATALOG_AUTHOR);
              break;
            case 1:
              System.out.printf("Request Successful: There is only 1 book titled \"%s\" by %s left in stock. ",
                  CATALOG_AUTHOR, CATALOG_TITLE);
              break;
            default:
              System.out.printf("Request Successful: There are %d book(s) by %s titled \"%s\" left. ", booksInStock,
                  CATALOG_AUTHOR, CATALOG_TITLE);
          }
        } else { // if there isn't enough stock to fulfill the request
          System.out.printf(
              "Request Unsuccessful: There are not enough books in stock. Only %d book(s) by %s titled \"%s\" in stock. ",
              quantityArray[INDEX_OF_TITLE], CATALOG_AUTHOR, CATALOG_TITLE);
        }

      } else { // if the requested book is not in the library catalog, inform the user.
        System.out.printf("Request Unsuccessful: \"%s\" by %s was not found in the catalog. ", INPUT_TITLE,
            INPUT_AUTHOR);
      }
    } while (isYesOrNo("Do you want to borrow other books?")); // repeats the loop if the user wants to borrow
                                                               // more/other books
  }

  // Prompts the user for a book title, author, and amount to be returned. If the
  // book title is not found in the catalog, displays an request unsuccessful
  // message. If the user inputs a quantity of 0, displays a Request Cancelled
  // message. Otherwise, updates the catalog and displays the amount now in stock.
  private static void returnBooks() {
    do {
      // Prompt the user to enter the book title and author.
      final String INPUT_TITLE = promptForValidString("Title:");
      final String INPUT_AUTHOR = promptForValidString("Book author:");
      final int INDEX_OF_TITLE = getIndexOfBook(INPUT_TITLE, INPUT_AUTHOR); // locate the book in the catalog.

      if (INDEX_OF_TITLE >= 0) { // if the book exists in the catalog
        final String CATALOG_TITLE = titleArray[INDEX_OF_TITLE];
        final String CATALOG_AUTHOR = authorArray[INDEX_OF_TITLE];
        final int INPUT_QUANTITY = promptForPositiveInt("Quantity:"); // prompt for quantity to return

        if (INPUT_QUANTITY == 0) { // If the user returns 0 books, cancel the return
          System.out.printf(
              "Request Cancelled: You did not return any books titled \"%s\" by %s. There are currently %d in stock. Thank you. ",
              CATALOG_TITLE, CATALOG_AUTHOR, quantityArray[INDEX_OF_TITLE]);

          continue; // terminate current loop and jump to while conditional evaluation
        }

        final int UPDATED_TOTAL_QUANTITY = quantityArray[INDEX_OF_TITLE] += INPUT_QUANTITY; // if the user returns > 0
                                                                                            // books, update the
                                                                                            // quantity in stock

        if (INPUT_QUANTITY == 1) { // if the user returns only 1 book
          System.out.printf(
              "Request Successful: You have successfully returned 1 book titled \"%s\" by %s. There are now %d in stock. Thank you. ",
              CATALOG_TITLE, CATALOG_AUTHOR, UPDATED_TOTAL_QUANTITY);

        } else { // if the user returns more than 1 book
          System.out.printf(
              "Request Successful: You have successfully returned %d book(s) titled \"%s\" by %s. There are now %d in stock. Thank you. ",
              INPUT_QUANTITY, CATALOG_TITLE, CATALOG_AUTHOR, UPDATED_TOTAL_QUANTITY);
        }

      } else { // If the book was not found in the catalog, display a request unsuccessful
               // message.
        System.out.printf(
            "Request Unsuccessful: The book \"%s\" by %s was not found in the catalog. It may belong to a different library.",
            INPUT_TITLE, INPUT_AUTHOR);
      }
    } while (isYesOrNo("Are you returning more books?")); // repeats loop if user is returning more books
  }

  // Thanks user and closes Scanner.
  private static void exit() {
    System.out.println("Thank you for using Data Frontier's library system.");
    SCANNER.close();
  }
}