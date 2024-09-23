import java.util.Scanner; // Import Scanner for reading user input.

public class StudentRecords () {
  private static final Scanner SCANNER = new Scanner(System.in);
  private static Student[] studentDatabase = {};
  private static int studentCount = 0;

  public static void main(String[] args) {

  }

  // Subroutine to handle Data Storage
  // adding a student to the database
  private static addStudent() {

  }

  // Subroutine to handle Student Management

  // Subroutine for Interface
    // main menu
    private static mainMenu() {
      // add student
      // update student info
      // view student details
      // view all students
      // exit
    }
    // sub menus
    private static

  // Helper functions

  private static String promptForValidString(String prompt) {
    while (true) {
      System.out.println(prompt);
      System.out.print("Input: ")
      String input = Scanner.nextLine().trim();
      if (input.length < 1) {
        // error handling for empty strings
      } else {
        return input;
      }
    }
  }

  private static int promptForValidInt(String prompt) {
    while (true) {
      System.out.println(prompt);
      System.out.print("Input: ")
      try {
        return Scanner.nextInt();
      } except (Error e) {
        // error handling for non integers
      }
    }
  }

    private static int promptForValidInt(String prompt) {
      while (true) {
      System.out.println(prompt);
      System.out.print("Input: ")
      try {
        return Scanner.nextDouble();
      } except (Error e) {
        // error handling for non doubles
      }
    }
  }

public class Student() {
  Student(String name, String id, int age, double grade) {

  }
}