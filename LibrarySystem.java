// Import Scanner for reading user input. Import HashMap and Map to create library cache.
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
  // Create a catalog to store books and their count. Utilize Integer wrapper as because Java generics do not work with primitive types. Catalog is organized as follows:
  // {
  //   Author: {
  //   Book_Title: quantity
  //   }
  // }
  private static Map<String, Map<String, Integer>> CATALOG = new HashMap<>();
  private static final Scanner SCANNER = new Scanner(System.in);
  
  public static void main(String[] args) {
    runSystem();

  }
  
  // Function to run the library system. Calls showMainMenu and uses a do-while loop so that users can go back and forth between menu items. 
  private static void runSystem() {
    System.out.println("Welcome to the Data Frontier's library system!");
    System.out.println("Please select an option from the choices below:");
    showMainMenu();
    System.out.print("Enter your choice: ");

    String menuSelection;

    do {
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
    } while (menuSelection != "d");

    exit();
  }

  // Function to display main menu choices to the user an easy to read way.
  private static void showMainMenu() {
    final String[] MAIN_MENU_CHOICES = { "A. Add Books", "B. Borrow Books", "C. Return Books", "D. Exit" };
    int i = 0;

    while (i < MAIN_MENU_CHOICES.length) {
      System.out.println("  " + MAIN_MENU_CHOICES[i]);
      i++;
    }
  }

  // Function that uses a do-while loop and isChoiceValid for input validation.
  private static String mainMenuSelect() {
    String choice;

    do {
      choice = SCANNER.nextLine().toLowerCase();
    } while (!isChoiceValid(choice));

    return choice;
  }
  
  // Function that returns a boolean value of true if the user input is either a, b, c, or d. Otherwise an error message is displayed and a boolean value of false is returned..
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

  // Function that allows users to add books to the library catalog
  private static void addBooks() {
    // Prompt the user to enter the book title, author, and quantity.
    System.out.print("Book author: ");
    final String BOOK_AUTHOR = SCANNER.nextLine();
    System.out.print("Book title: ");
    final String BOOK_TITLE = SCANNER.nextLine();
    System.out.print("Quantity: ");

    // need to check if it can be converted to an integer
    final String BOOK_QUANTITY = SCANNER.nextLine();

    // If the book already exists in the library, 
    if (CATALOG.containsKey(BOOK_AUTHOR)) {
      // update quantity
      final Map<String, Integer> book = CATALOG.get(BOOK_TITLE);
      final Integer currentQuantity = book.get("Quantity");
      book.put("Quantity", currentQuantity + BOOK_QUANTITY);

    } else {
      // If the book is new, add it to the library.
    }
  }
  
  private static boolean isValidInteger() {
    // logic for validating if input is an integer
  }

  private static void borrowBooks() {
    // Prompt the user to enter the book title and the number of books to borrow.
    System.out.print("What is the name of the book you want to borrow? ");
    String bookTitle = SCANNER.nextLine();
    // Check if the requested number of books is available in the library.
    // If the books are available, update the quantity and display a success message.
    // If not, display an error message.
  }

  private static void returnBooks() {
    // Prompt the user to enter the book title and the number of books to return.
    System.out.print("What is the name of the book you want to return? ");
    String bookTitle = SCANNER.nextLine();
    // Check if the books being returned belong to the library system.
    // If they do, update the quantity and display a success message.
    // If not, display an error message.
  }

  private static void exit() {
    System.out.println("Thank you for using Data Frontier's library system.");
    SCANNER.close();
  }
}
