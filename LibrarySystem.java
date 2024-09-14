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
  private static String[] titleArray = {};
  private static String[] authorArray = {};
  private static int[] quantityArray = {};
  private static int entryCount = 0;
  private static final Scanner SCANNER = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.println("Welcome to the Data Frontier's library system!");
    String menuSelection;

    do {
      System.out.println("Please select an option from the choices below:");
      showMainMenu();
      System.out.print("Enter your choice: ");
      menuSelection = mainMenuSelect();
      switch (menuSelection) {
        case "a":
          addBook();
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
    } while (!isABCD(choice));

    return choice;
  }

  // Returns a boolean value of true if the user input is either a, b, c, or d. Otherwise an error message is displayed and a boolean value of false is returned.
  private static boolean isABCD(String choice) {
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

  private static int getIndexOfTitle (String title) {
    final String FORMATTED_TITLE = title.trim();
    // iterate through the array to find if the title exists;
   int i = 0;
   while (i < entryCount) {
     // if the title is found return index
     if (titleArray[i].equals(FORMATTED_TITLE))
       return i;
     i++;
   }
   return -1;
  }

  // Prompts users to add books to the library catalog. If the book exists in the catalog, adds the existing value to the added books. Otherwise creates a new book entry with a quantity based on the user input.
  private static void addBook() {
    do { // Prompt the user to enter the book title, author, and quantity.
      final String INPUT_AUTHOR = promptForString("Book author: ");
      final String INPUT_TITLE = promptForString("Book tile: ");
      final int INPUT_QUANTITY = promptForValidInteger("Quantity: ");
      final int BOOK_INDEX = getIndexOfTitle(INPUT_TITLE);
      int totalQuantity;

      // If the book is not found add the book to the catalog, else update the quantity. Display to the user changes.
      if (BOOK_INDEX == -1) {
        addToCatalog(INPUT_TITLE, INPUT_AUTHOR, INPUT_QUANTITY);
        totalQuantity = INPUT_QUANTITY;
      } else {
        // update quantity
        totalQuantity = quantityArray[BOOK_INDEX] += INPUT_QUANTITY;
      }
      System.out.printf("You have added %d book(s) with the title \"%s\". There are now a total of %d in stock.",
          INPUT_QUANTITY, INPUT_TITLE, totalQuantity);
    } while (isYesOrNo(" Do you want to add more books?"));
  }
  
  // prompts the user based on the argument and returns the input string trimmed of whitespace
  private static String promptForString(String prompt) {
    System.out.println();
    System.out.print(prompt);
    final String INPUT = SCANNER.nextLine().trim();
    SCANNER.nextLine();
    return INPUT;
  }
  
  // Prompts the user for an integer input. If the user input is not a valid integer, an error is displayed to the user and it prompts again. If the user inputs a valid integer, returns the value wrapped in the Integer class.
  private static Integer promptForValidInteger(String prompt) {
    boolean isValidInteger = false;
    Integer input = null;
    do {
      try {
        System.out.println();
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

  private static void addToCatalog(String title, String author, int quantity) {
    entryCount++;
    String[] newTitleArray = new String[entryCount];
    String[] newAuthorArray = new String[entryCount];
    int[] newQuantityArray = new int[entryCount];

    int i = 0;

    while (i < entryCount) {
      newTitleArray[i] = titleArray[i];
      newAuthorArray[i] = authorArray[i];
      newQuantityArray[i] = quantityArray[i];
      i++;
    }
    
    newTitleArray[entryCount] = title;
    newQuantityArray[entryCount] = quantity;
    newAuthorArray[entryCount] = author;
    
    titleArray = newTitleArray;
    quantityArray = newQuantityArray;
    authorArray = newAuthorArray;
  }

  // Returns a boolean a value only if a user inputs a valid yes or no response. Otherwise asks the user for input again.
  private static boolean isYesOrNo(String prompt) {
    while (true) {
      System.out.print(prompt);
      System.out.print(" Enter (Y)es or (N)o to continue.");
      final String input = SCANNER.nextLine().toLowerCase();
      SCANNER.nextLine();

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
      final String INPUT_TITLE = promptForString("Book title: ");
      final int INDEX_OF_TITLE = getIndexOfTitle(INPUT_TITLE);

      // Check if the requested number of books is available in the library.
      if (INDEX_OF_TITLE > 0) {
        int booksInStock = quantityArray[INDEX_OF_TITLE];
        System.out.println("There are currently " + booksInStock + " books called " + INDEX_OF_TITLE + " in stock.");
        final int REQUESTED_AMOUNT = promptForValidInteger("Quantity: ");
        if (booksInStock > REQUESTED_AMOUNT) {
          // If the books are available, update the quantity and display a success message.
          quantityArray[INDEX_OF_TITLE] = booksInStock -= REQUESTED_AMOUNT;
          System.out.printf("Request Successful. There are %d book(s) named \"%s\" left.", booksInStock, INPUT_TITLE);
        } else {
          // If not, display an error message.
          System.out.printf(
              "Insufficient quanity found in stock. There are %d book(s) with the title \"%s\"currently in stock. ",
              quantityArray[INDEX_OF_TITLE], INPUT_TITLE);
        }

      } else {
        System.out.println("Book not found in catalog.");
      }
    } while (isYesOrNo(" Do you want to borrow other books?"));
  }

  // Prompts the user for a book title and amount to be returned. If the book title is not found in the catalog, displays an error message. Otherwise, updates the catalog and displays the amount now in stock.
  private static void returnBooks() {
    do {
      // Prompt the user to enter the book title and the number of books to return.
      final String INPUT_TITLE = promptForString("Title: ");
      final int INDEX_OF_TITLE = getIndexOfTitle(INPUT_TITLE);

      // Check if the books being returned belong to the library system.
      if (INDEX_OF_TITLE > 0) {
        // If they do, update the quantity and display a success message.
        final int INPUT_QUANTITY = promptForValidInteger("Quantity: ");

        quantityArray[INDEX_OF_TITLE] += INPUT_QUANTITY;
        
        System.out.printf("You have successfully returned %d book(s) with the title %s. There are now %d in stock. Thank you.", INPUT_QUANTITY, INPUT_TITLE, quantityArray[INDEX_OF_TITLE]);
      } else {
        // If not, display an error message.
        System.out.printf("The book \"%s\" was not found in the catalog. It may belong to a different library.", INPUT_TITLE);
      }
    } while (isYesOrNo(" Do you want to return more books?"));
  }

  private static void exit() {
    System.out.println("Thank you for using Data Frontier's library system.");
    SCANNER.close();
  }
}
