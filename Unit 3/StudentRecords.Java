import java.util.Scanner; // Import SCANNER for reading user input.

public class StudentRecords {
  // constant global variable initializations  
  private static final Scanner SCANNER = new Scanner(System.in);
  private static final String FIRST_NAME = "FIRST NAME";
  private static final String LAST_NAME = "LAST NAME";
  private static final String ID = "ID";
  private static final String AGE = "AGE";
  private static final String GRADE = "GRADE";
  private static final String[] VALID_PROPERTIES = {FIRST_NAME, LAST_NAME, ID, AGE, GRADE };

  // constant variable initializations for student list/directory
  private static Student[] studentList = {};
  private static int studentCount = 0;

    public static void main(String[] arg) {
    introduction();
    mainMenu();
    exit();
  }

  private static void introduction(){
    System.out.println("Welcome to the Student Records System(SRS).");
    System.out.println("SRS allows you to add students, view student information, and update students.");
  }

  private static void exit(){
    System.out.println("Terminating application services...");
    SCANNER.close();
    System.out.println("Application services closed successfully");
    System.out.println("Thank you for using the Student Records System. Goodbye.");
  }

  // Subroutines to handle Data Storage
  // prompts user to input student information and creates a new student
  private static void addStudent() {
    final String firstName = promptForValidString("Enter the student's first name");
    final String lastName = promptForValidString("Enter the student's last name");
    final String id = promptForValidString("Enter the student's ID");
    final int age = promptForValidInt("Enter the student's age");
    final double grade = promptForValidDouble("Enter the student's grade");
    final Student student = new Student(firstName, lastName, id, age, grade);

    updateStudentList(student);
  }

  // prompts user for student ID and looks for a matching student. If there is a match, a new menu is shown, otherwise, returns to main menu.
  private static void updateStudentInformation() {
    int index = searchByStudentID();

    if (index == -1) {
      System.out.println("Student not found");
    } else {
      final Student CURR_STUDENT = studentList[index];
      updateStudentInformationMenu(CURR_STUDENT);
    }

    System.out.println("Returning to main menu");
  }

  private static void updateStudentInformationMenu(Student student) {
    final String UPDATE_FIRST_NAME = "1. Update student's first name";
    final String UPDATE_LAST_NAME = "2. Update student's last name";
    final String UPDATE_ID = "3. Update student's ID";
    final String UPDATE_AGE = "4. Update student's age";
    final String UPDATE_GRADE = "5. Update student's grade";
    final String EXIT_UPDATE = "6. Return to main menu";
    final String[] OPTIONS = {UPDATE_FIRST_NAME, UPDATE_LAST_NAME, UPDATE_ID, UPDATE_AGE, UPDATE_GRADE, EXIT_UPDATE};

    menuLoop:
    while (true) {
      showMenuOptions("Provided below are options to update a student's information.", OPTIONS);

      switch (returnValidMenuSelection(6)) {
        case 1:
          student.setProperty(FIRST_NAME, promptForValidString("Enter first name"));
          break;
        case 2:
          student.setProperty(LAST_NAME, promptForValidString("Enter last name"));
          break;
        case 3:
          student.setProperty(ID, promptForValidString("Enter ID"));
          break;
        case 4:
          student.setProperty(AGE, promptForValidInt("Enter age"));
          break;
        case 5:
          student.setProperty(GRADE, promptForValidDouble("Enter grade"));
          break;
        default:
          break menuLoop;
      }
      System.out.println("Student updated successfully. Returning to update menu.");
    }
  }

  // Prompts user for student ID and searches for specific student. If found, displays student information.
  private static void viewStudentInformation() {
    int index = searchByStudentID();

    if (index == -1) {
      System.out.println("Student not found");
    } else {
      final Student CURR_STUDENT = studentList[index];
      
      for (int i = 0; i < VALID_PROPERTIES.length; i++) {
        final String PROPERTY = VALID_PROPERTIES[i];
        switch (PROPERTY) {
          case FIRST_NAME:
          case LAST_NAME:
          case ID:
            System.out.printf("%s: %s", PROPERTY, CURR_STUDENT.getStringProperty(PROPERTY));
            break;
          case AGE:
            System.out.printf("%s: %i", PROPERTY, CURR_STUDENT.getIntegerProperty(PROPERTY));
            break;
          case GRADE:
            System.out.printf("%s: %d", PROPERTY, CURR_STUDENT.getDoubleProperty(PROPERTY));
            break;
        }
      }
    }

    System.out.println("Returning to main menu");
  }

  // Subroutine to handle Student Management

  // Subroutine for Interface
    // main menu
    private static void mainMenu() {
      final String ADD_STUDENT_MENU_OPTION = "1. Add a new student to the records";
      final String UPDATE_STUDENT_MENU_OPTION = "2.  Update an existing student's information";
      final String VIEW_ALL_STUDENTS_OPTION = "3. View student information";
      final String EXIT_OPTION = "4. Exit System";
      final String[] OPTIONS = { ADD_STUDENT_MENU_OPTION, UPDATE_STUDENT_MENU_OPTION, VIEW_ALL_STUDENTS_OPTION, EXIT_OPTION };

      menuLoop:
      while (true) {
        showMenuOptions("", OPTIONS);

        switch (returnValidMenuSelection(4)){
          case 1: 
            addStudent();
            break;
          case 2:
            updateStudentInformation();
            break;
          case 3:
            break;
          default:
            break menuLoop;
        }
      }
    }

  // Helper functions
  private static int searchByStudentID() {
    final String INPUT_ID = promptForValidString("Please enter student ID to locate record").toUpperCase();

    for (int i = 0; i < studentList.length; i++) {
      final Student CURR_STUDENT = studentList[i];
      if (INPUT_ID.equals(CURR_STUDENT.getStringProperty(ID).toUpperCase())) {
        return i;
      }
    }
    return -1;
  }

  // displays an initial text followed by formatted menu options
  private static void showMenuOptions(String displayText, String[] options) {
    System.out.println(displayText);
    for (int i = 0; i < options.length; i++) {
      System.out.println("    " + options[i]);
    }
  }

  // updates studentList array with a student object that is passed in
  private static void updateStudentList (Student student) {
    studentCount++;
    Student[] newStudentList = new Student[studentCount];

    for (int i = 0; i < studentCount; i++) {
      newStudentList[i] = studentList[i];
    }

    newStudentList[studentCount-1] = student;
    studentList = newStudentList;
  }
  

  private static int returnValidMenuSelection(int maxOptions) {
    String prompt = "Select Menu Option (";

    for (int i = 0; i < maxOptions; i++) {
      prompt += i + ", ";
    }

    prompt += maxOptions + ")";

    while (true) {
      final int input = promptForValidInt(prompt);
      if (0 < input && input <= maxOptions) {
        return input;
      } else {
        System.out.printf("Please enter a number between 1 and %i.", maxOptions);
        System.out.println("");
      }
    }
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