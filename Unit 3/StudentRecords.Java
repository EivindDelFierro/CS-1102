import java.util.Scanner; // Import SCANNER for reading user input.

public class StudentRecords {
  // constant global variable declarations  
  private static final Scanner SCANNER = new Scanner(System.in);
  private static final String FIRST_NAME = "FIRSTNAME";
  private static final String LAST_NAME = "LASTNAME";
  private static final String ID = "ID";
  private static final String AGE = "AGE";
  private static final String GRADE = "GRADE";

  private static Student[] studentList = {};
  private static int studentCount = 0;

    public static void main(String[] arg) {
    mainMenu();
  }

  // Subroutine to handle Data Storage
  // Access Student by StudentID
  
  // prompts user to input student information and creates a new student
  private static void addStudent() {
    final String firstName = promptForValidString("Enter the student's first name");
    final String lastName = promptForValidString("Enter the student's last name");
    final String id = promptForValidString("Enter the student's ID");
    final int age = promptForValidInt("Enter the student's age");
    final double grade = promptForValidDouble("Enter the student's grade");
    final Student student = new Student(firstName, lastName, id, age, grade);
  }
  

  // updates studentList array with a student object that is passed in
  private static void updatestudentList (Student student) {
    studentCount++;
    Student[] newStudentList = new Student[studentCount];

    for (int i = 0; i < studentCount; i++) {
      newStudentList[i] = studentList[i];
    }

    newStudentList[studentCount-1] = student;
  }


  // Subroutine to handle Student Management

  // Subroutine for Interface
    // main menu
    private static void mainMenu() {
      final String ADD_STUDENT_MENU_OPTION = "1. Add a new student to the records";
      final String UPDATE_STUDENT_MENU_OPTION = "2.  Update an existing student's records";
      final String VIEW_ALL_STUDENTS_OPTION = "3. View all students and records in database";
      final String EXIT_OPTION = "4. Exit System";
      final String[] OPTIONS = {ADD_STUDENT_MENU_OPTION, UPDATE_STUDENT_MENU_OPTION, VIEW_ALL_STUDENTS_OPTION, EXIT_OPTION};

      for (int i = 0; i < OPTIONS.length; i++) {
        System.out.println("    " + OPTIONS[i]);
      }
    }

  // Helper functions
  private static int isValidMenuSelection() {
    return 0;
  }

  private static String promptForValidString(String prompt) {
    while (true) {
      System.out.print(prompt + ": ");
      String input = SCANNER.nextLine().trim();
      if (input.length() < 1) {
        System.out.println("Input Error: Please enter a non-empty string");
      } else {
        return input;
      }
    }
  }

  private static int promptForValidInt(String prompt) {
    while (true) {
      System.out.println(prompt);
      System.out.print("Input: ");
      try {
        return SCANNER.nextInt();
      } catch (Exception e) {
        System.out.println("Data Type Error: Please enter only whole numbers");
      }
    }
  }

    private static double promptForValidDouble(String prompt) {
      while (true) {
        System.out.println(prompt);
        System.out.print("Input: ");
        try {
          return SCANNER.nextDouble();
        } catch (Exception e) {
          System.out.println("Data Type Error: Please enter number digits");
        }
      }
    }
}