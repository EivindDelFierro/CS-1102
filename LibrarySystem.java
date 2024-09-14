// Import Scanner for reading user input. Import HashMap and Map to create library cache.
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
  // Create a catalog to store books and their count. Utilize class wrappers as because Java generics do not work with primitive types. Catalog is organized as follows:
  // {
  //   book_title: {
  //    author: String,
  //    quantity: Integer
  //   }
  // }
  private static Map<String, Map<String, Object>> CATALOG = new HashMap<>();
  private static final Scanner SCANNER = new Scanner(System.in);

  public static void main(String[] args) {
    runSystem();
  }

  // Function to run the library system. Calls showMainMenu and uses a do-while loop so that users can go back and forth between menu items. 
  private static void runSystem() {
    System.out.println("Welcome to the Data Frontier's library system!");
    String menuSelection;

    do {
      System.out.println("Please select an option from the choices below:");
      showMainMenu();
      System.out.print("Enter your choice: ");
      menuSelection = mainMenuSelect();
      switch (menuSelection) {
        case "a":
          addBooks();
          break;
        case "b":
          borrowBooks();
          break;
        case "c":
          returnBooks();
      }
    } while (!menuSelection.equals("d"));

    exit();
  }

  // Displays main menu choices to the user.
  private static void showMainMenu() {
    final String[] MAIN_MENU_CHOICES = { "A. Add Books", "B. Borrow Books", "C. Return Books", "D. Exit" };
    int i = 0;

    while (i < MAIN_MENU_CHOICES.length) {
      System.out.println("  " + MAIN_MENU_CHOICES[i]);
      i++;
    }
  }

  // Returns a menu selection option if successfully validated by isChoiceValid.
  private static String mainMenuSelect() {
    String choice;

    do {
      choice = SCANNER.nextLine().toLowerCase();
    } while (!isChoiceValid(choice));

    return choice;
  }

  // Returns a boolean value of true if the user input is either a, b, c, or d. Otherwise an error message is displayed and a boolean value of false is returned.
  private static boolean isChoiceValid(String choice) {
    switch (choice) {
      case "a":
      case "b":
      case "c":
      case "d":
        return true;

      default:
        System.out.println("Please only use the letter associated with your choice (A, B, C, or D).");
        return false;
    }
  }

  // Prompts users to add books to the library catalog. If the book exists in the catalog, adds the existing value to the added books. Otherwise creates a new book entry with a quantity based on the user input.
  private static void addBooks() {
    do { // Prompt the user to enter the book title, author, and quantity.
      System.out.print("Book author: ");
      final String BOOK_AUTHOR = SCANNER.nextLine().trim();
      final Object[] TITLE_AND_QUANTITY = getBooksAndQuantity();
      final String BOOK_TITLE = TITLE_AND_QUANTITY[0].toString();
      final Integer ADDED_QUANTITY = (Integer) TITLE_AND_QUANTITY[1];
      int totalQuantity;

      // If the book already exists in the library, 
      if (CATALOG.containsKey(BOOK_TITLE)) {
        // update quantity
        final Map<String, Object> CATALOG_BOOK = CATALOG.get(BOOK_TITLE);
        final Integer currentQuantity = (Integer) CATALOG_BOOK.get("quantity");
        totalQuantity = currentQuantity + ADDED_QUANTITY;
        CATALOG_BOOK.put("quantity", totalQuantity);

      } else {
        // If the book is new, add it to the library.
        final Map<String, Object> book = new HashMap<>();
        book.put("author", BOOK_AUTHOR);
        book.put("quantity", ADDED_QUANTITY);
        CATALOG.put(BOOK_TITLE, book);
        totalQuantity = ADDED_QUANTITY;
      }
      System.out.printf("You have added %d book(s) with the title \"%s\". There are now a total of %d in stock.", ADDED_QUANTITY, BOOK_TITLE, totalQuantity);
    } while (repeatAgain(" Do you want to add more books?"));
  }

  // Prompts the user for a book title and quantity. Returns an array [BOOK_TITLE, BOOK_QUANTITY]. Integer input validation done by getValidInteger function.
  private static Object[] getBooksAndQuantity() {
    System.out.print("Book title: ");
    final String BOOK_TITLE = SCANNER.nextLine().trim();
    System.out.print("Quantity: ");
    final Integer BOOK_QUANTITY = getValidInteger("Quantity: ");
    return new Object[]{BOOK_TITLE, BOOK_QUANTITY};
  }

  // Prompts the user for an integer input. If the user input is not a valid integer, an error is displayed to the user and it prompts again. If the user inputs a valid integer, returns the value wrapped in the Integer class.
  private static Integer getValidInteger(String prompt) {
    boolean isValidInteger = false;
    Integer input = null;
    do {
      try {
        System.out.print(prompt);
        input = Integer.valueOf(SCANNER.nextInt());
        isValidInteger = true;
      } catch (Exception error) {
        System.out.println("Please enter a valid integer.");
        SCANNER.nextLine();
      }
    } while (!isValidInteger);

    return input;
  }

  // Returns a boolean a value only if a user inputs a valid yes or no response. Otherwise asks the user for input again.
  private static boolean repeatAgain(String prompt) {
    while (true) {
      SCANNER.nextLine();
      System.out.print(prompt);
      System.out.print(" Enter (Y)es or (N)o to continue.");
      final String input = SCANNER.nextLine().toLowerCase();

      switch (input) {
        case "y":
        case "yes":
          return true;
        case "n":
        case "no":
          return false;
        default:
          System.out.println("Please enter only (Y)es or (N)o");
      }
    }
  }

  // Prompts the user for a book title and amount to be borrowed. If the requested amount is more than in stock, displays an error message. Otherwise returns a confirmation message with the number of books left.
  private static void borrowBooks() {
    do {
      // Prompt the user to enter the book title and the number of books to borrow.
      final Object[] TITLE_AND_QUANTITY = getBooksAndQuantity();
      final String BOOK_TITLE = TITLE_AND_QUANTITY[0].toString();
      final int REQUESTED_AMOUNT = (int) TITLE_AND_QUANTITY[1];

      // Check if the requested number of books is available in the library.
      if (CATALOG.containsKey(BOOK_TITLE)) {
        final Map<String, Object> CATALOG_BOOK = CATALOG.get(BOOK_TITLE);
        final Integer CURRENT_STOCK = (Integer) CATALOG_BOOK.get("quantity");
        if ((Integer) CURRENT_STOCK > REQUESTED_AMOUNT) {
          // If the books are available, update the quantity and display a success message.
          final Integer REMAINING_BOOKS = CURRENT_STOCK - REQUESTED_AMOUNT;
          CATALOG_BOOK.put("quantity", REMAINING_BOOKS);
          System.out.printf("Request Successful. There are %d book(s) with the title \"%s\" left.", REMAINING_BOOKS,
              BOOK_TITLE);
        } else {
          // If not, display an error message.
          System.out.printf(
              "Insufficient quanity found in stock. There are %d book(s) with the title \"%s\"currently in stock. ",
              CATALOG_BOOK.get("quantity"), BOOK_TITLE);
        }

      } else {
        System.out.println("Book not found in catalog.");
      }
    } while (repeatAgain(" Do you want to borrow other books?"));
  }

  // Prompts the user for a book title and amount to be returned. If the book title is not found in the catalog, displays an error message. Otherwise, updates the catalog and displays the amount now in stock.
  private static void returnBooks() {
    do {
      // Prompt the user to enter the book title and the number of books to return.
      final Object[] TITLE_AND_QUANTITY = getBooksAndQuantity();
      final String BOOK_TITLE = TITLE_AND_QUANTITY[0].toString();
      final Integer QUANTITY_RETURNED = (Integer) TITLE_AND_QUANTITY[1];

      // Check if the books being returned belong to the library system.
      if (CATALOG.containsKey(BOOK_TITLE)) {
        // If they do, update the quantity and display a success message.
        final Map<String, Object> CATALOG_BOOK = CATALOG.get(BOOK_TITLE);
        final Integer EXISTING_QUANTITY = (Integer) CATALOG_BOOK.get("quantity");
        final Integer TOTAL_IN_STOCK = EXISTING_QUANTITY + QUANTITY_RETURNED;
        CATALOG_BOOK.put("quantity", TOTAL_IN_STOCK);
        // If not, display an error message.
        System.out.printf("You have successfully returned %d book(s) with the title %s. There are now %d in stock. Thank you.", QUANTITY_RETURNED, BOOK_TITLE, TOTAL_IN_STOCK);
      } else {
        System.out.printf("The book \"%s\" was not found in the catalog. It may belong to a different library.", BOOK_TITLE);
      }
    } while (repeatAgain(" Do you want to return more books?"));
  }

  private static void exit() {
    System.out.println("Thank you for using Data Frontier's library system.");
    SCANNER.close();
  }
}
