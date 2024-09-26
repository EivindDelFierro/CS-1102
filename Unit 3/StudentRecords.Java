
/**
 * Student Records System
 * 
 * This is a program to manage Student records in java.
 * The program can record a student's first name, last name, student id, age, and their current course grade.
 * The program also allows viewing of an individual student's profile and editing a student's profile
 * 
 * To run the application: 
 * 1. Place Student.java nd StudentRecords.java in the same folder, which we'll reference as "target folder."
 * 2. Using the terminal navigate to the target folder and compile the files by entering "javac Student.java" and hitting enter. Do the same StudentRecords.java.
 * 3. Once compiled, you can run the program by navigating to the target folder and entering "java StudentRecords" into the terminal
 * 
 * Application instructions:
 * Select menu options by typing one of the available options and hitting enter.
 * The application will then prompt you for further information as needed. To submit a response to a prompt, type in your response and hit enter.
*/

import java.text.DecimalFormat; // Used for formatting grades into #.## format if grades have decimals
import java.util.Scanner; // Import SCANNER for reading user input

public class StudentRecords {
  // Constant global variable initializations
  private static final Scanner SCANNER = new Scanner(System.in);
  private static final String FIRST_NAME = "FIRST NAME";
  private static final String LAST_NAME = "LAST NAME";
  private static final String ID = "ID";
  private static final String AGE = "AGE";
  private static final String GRADE = "GRADE";
  private static final String[] VALID_PROPERTIES = { FIRST_NAME, LAST_NAME, ID, AGE, GRADE };
  private static final String STRING_TYPE = "STRING";
  private static final String INT_TYPE = "INT";
  private static final String DOUBLE_TYPE = "DOUBLE";
  private static final String FIRST_NAME_PROMPT = "Enter the student's first name";
  private static final String LAST_NAME_PROMPT = "Enter the student's last name";
  private static final String ID_PROMPT = "Enter the student's ID";
  private static final String AGE_PROMPT = "Enter the student's age";
  private static final String GRADE_PROMPT = "Enter the student's course grade";
  private static final String NOT_FOUND_MESSAGE = "Student not found";
  private static final String RETURN_TO_MAIN_MENU_MESSAGE = "Returning to Main Menu...";

  // Variable initializations for student list/directory and student count
  private static Student[] studentList = {};
  private static int studentCount = 0;

  // Main application to run
  public static void main(String[] arg) {
    introduction();
    mainMenu();
    exit();
  }

  // Subroutine that introduces software to user
  private static void introduction() {
    System.out.println("Welcome to the Student Records System(SRS).");
    System.out.println("SRS allows you to add students, view student information, and update students.");
  }

  // Subroutine that cleans up services and informs the user the application is
  // shutting down.
  private static void exit() {
    System.out.println("Terminating application services...");
    SCANNER.close();
    System.out.println("Application services closed successfully.");
    System.out.println("Thank you for using the Student Records System. Goodbye.");
  }

  // Subroutines that handle Data Storage
  // Prompts user to input student information and creates a new student
  private static void addStudent() {
    final String FIRST_NAME = promptForValidInput(FIRST_NAME_PROMPT, STRING_TYPE).toString();
    final String LAST_NAME = promptForValidInput(LAST_NAME_PROMPT, STRING_TYPE).toString();

    // determine if there is already a matching id;
    boolean isIDfree;
    String id;

    do {
      id = promptForValidInput(ID_PROMPT, STRING_TYPE).toString();
      isIDfree = searchByStudentID(id) == -1;
      if (!isIDfree)
        System.out.println("ID already exists. Please enter a different ID number.");
    } while (!isIDfree);

    final int AGE = getValidAge();
    final double GRADE = getValidGrade();
    final Student student = new Student(FIRST_NAME, LAST_NAME, id, AGE, GRADE);

    updateStudentList(student);
  }

  // Prompts user for student ID and looks for a matching student. If there is a
  // match, a menu to update properties is shown, otherwise, returns to main menu.
  private static void updateStudentInformation() {
    int index = searchByStudentID(promptForValidInput(ID_PROMPT, STRING_TYPE).toString().toUpperCase());

    if (index == -1) {
      System.out.println(NOT_FOUND_MESSAGE);
    } else {
      final Student CURR_STUDENT = studentList[index];
      updateStudentInformationMenu(CURR_STUDENT);
    }
    System.out.printf("\n%s\n", RETURN_TO_MAIN_MENU_MESSAGE);
  }

  // Subroutine that displays update options and allows the user to update an
  // existing student.
  private static void updateStudentInformationMenu(Student student) {
    // Define menu options for updating student information
    final String UPDATE_FIRST_NAME = "A. Update student's first name";
    final String UPDATE_LAST_NAME = "B. Update student's last name";
    final String UPDATE_ID = "C. Update student's ID";
    final String UPDATE_AGE = "D. Update student's age";
    final String UPDATE_GRADE = "E. Update student's course grade (0-100)";
    final String EXIT_UPDATE = "F. Return to main menu";
    final String[] OPTIONS = { UPDATE_FIRST_NAME, UPDATE_LAST_NAME, UPDATE_ID, UPDATE_AGE, UPDATE_GRADE, EXIT_UPDATE };

    // Main loop for the update menu
    menuLoop: while (true) {
      // Display the update options to the user
      showMenuOptions("Provided below are options to update a student's information.", OPTIONS);

      // Get the user's menu selection
      switch (returnValidMenuSelection(6)) {
        case 'A':
          // Update first name
          student.setProperty(FIRST_NAME, promptForValidInput(FIRST_NAME_PROMPT, STRING_TYPE).toString());
          break;
        case 'B':
          // Update last name
          student.setProperty(LAST_NAME, promptForValidInput(LAST_NAME_PROMPT, STRING_TYPE).toString());
          break;
        case 'C':
          // Update student ID
          student.setProperty(ID, promptForValidInput(ID_PROMPT, STRING_TYPE).toString());
          break;
        case 'D':
          // Update age, ensuring it's a valid integer
          student.setProperty(AGE, getValidAge());
          break;
        case 'E':
          // Update grade, ensuring it's a valid double between 0 and 100
          student.setProperty(GRADE, getValidGrade());
          break;
        default:
          // Exit the update menu
          break menuLoop;
      }
      // Confirm successful update to the user
      System.out.println("Student updated successfully. " + RETURN_TO_MAIN_MENU_MESSAGE);
    }
    // Note: The loop continues, allowing multiple updates unless the user chooses
    // to exit

  }

  // Prompts user for a student ID and searches for the specific student. If
  // found, displays student information. If not found, displays a not found
  // message. Subroutine then returns user to the main menu.
  private static void viewStudentInformation() {
    int index = searchByStudentID(promptForValidInput(ID_PROMPT, STRING_TYPE).toString().toUpperCase());

    if (index == -1) {
      System.out.println(NOT_FOUND_MESSAGE);
    } else {
      final Student CURR_STUDENT = studentList[index];
      System.out.println();

      for (int i = 0; i < VALID_PROPERTIES.length; i++) {
        final String PROPERTY = VALID_PROPERTIES[i];
        switch (PROPERTY) {
          case FIRST_NAME:
          case LAST_NAME:
          case ID:
            System.out.printf("%s: %s\n", PROPERTY, CURR_STUDENT.getStringProperty(PROPERTY));
            break;
          case AGE:
            System.out.printf("%s: %d\n", PROPERTY, CURR_STUDENT.getIntegerProperty(PROPERTY));
            break;
          case GRADE:
            DecimalFormat df = new DecimalFormat("#.##");
            System.out.printf("%s: %s\n", PROPERTY, df.format(CURR_STUDENT.getDoubleProperty(PROPERTY)));
            break;
        }
      }
    }

    System.out.println(RETURN_TO_MAIN_MENU_MESSAGE);
  }

  // Subroutine for displaying the main menu. If a valid option is selected, the
  // associated subroutine is executed.
  private static void mainMenu() {
    final String ADD_STUDENT_MENU_OPTION = "A. Add a new student to the records";
    final String UPDATE_STUDENT_MENU_OPTION = "B. Update an existing student's information";
    final String VIEW_ALL_STUDENTS_OPTION = "C. View student information";
    final String EXIT_OPTION = "D. Exit System";
    final String[] OPTIONS = { ADD_STUDENT_MENU_OPTION, UPDATE_STUDENT_MENU_OPTION, VIEW_ALL_STUDENTS_OPTION,
        EXIT_OPTION };

    menuLoop: while (true) {
      showMenuOptions("Main Menu:", OPTIONS);

      switch (returnValidMenuSelection(4)) {
        case 'A':
          addStudent();
          break;
        case 'B':
          updateStudentInformation();
          break;
        case 'C':
          viewStudentInformation();
          break;
        default:
          break menuLoop; // breaks loop, terminating main menu subroutine
      }
    }
  }

  // Helper functions
  // Subroutine that accepts a string, INPUT_ID, and searches studentList for a
  // student with a matching ID. If the ID is found, returns the index of the
  // student, otherwise returns -1 if not found.
  private static int searchByStudentID(String INPUT_ID) {
    // Iterate through the studentList array
    for (int i = 0; i < studentList.length; i++) {
      final Student CURR_STUDENT = studentList[i];
      // Compare the input ID with the current student's ID
      if (INPUT_ID.toUpperCase().equals(CURR_STUDENT.getStringProperty(ID).toUpperCase())) {
        return i; // Student found, return the index
      }
    }
    return -1; // Student not found, return -1
  }

  // Subroutine that accepts a String, displayText, and an array of strings,
  // options. The function displays displayText followed by the formatted menu
  // options
  private static void showMenuOptions(String displayText, String[] options) {
    System.out.printf("\n%s\n", displayText);
    for (int i = 0; i < options.length; i++) {
      System.out.println("    " + options[i]);
    }
  }

  // Subroutine that accepts a Student object and then increments studentCount and
  // replaces studentList with a new array that includes the new Student object.
  private static void updateStudentList(Student student) {
    studentCount++; // Increment the total number of students

    // Create a new array with increased size
    Student[] newStudentList = new Student[studentCount];

    // Copy existing students to the new array
    for (int i = 0; i < studentCount - 1; i++) {
      newStudentList[i] = studentList[i];
    }

    // Add the new student to the end of the new array
    newStudentList[studentCount - 1] = student;

    // Replace the old studentList with the new one
    studentList = newStudentList;
  }

  // Subroutine that accepts an integer, maxOptions. The function displays the
  // valid options and prompts the user for a menu selection. If the user enters
  // more than a single character or an invalid menu selection, it displays an
  // error. If the user selects a valid option within the range, returns input
  // char.
  private static char returnValidMenuSelection(int maxOptions) {
    // Construct the prompt string with available options
    String prompt = "Select Menu Option (";
    char start = 'A';
    char end = (char) ('A' + maxOptions - 1);

    // Build the prompt string with comma-separated options (e.g., "A, B, C")
    for (int i = 0; i < maxOptions - 1; i++) {
      char letter = (char) ('A' + i);
      prompt += letter + ", ";
    }

    prompt += end + ")";

    boolean inputIsASingleChar = false;
    char input = '\0';

    // Main loop for getting and validating user input
    while (true) {
      // Get user input and convert to uppercase
      final String USER_INPUT = promptForValidInput(prompt, STRING_TYPE).toString().toUpperCase();

      // Validate that the input is a single character
      if (USER_INPUT.length() == 1) {
        inputIsASingleChar = true;
        input = USER_INPUT.charAt(0);

        // Check if the input is within the valid range of options
        if (input >= start && input <= end) {
          return input; // Valid input, return the selected option
        } else {
          // Input is a single character but out of valid range
          System.out.printf("Please enter a letter between \"%c\" through \"%c.\"\n", start, end);
        }
      } else {
        // Input is not a single character
        System.out.printf("\nData Type Error: Please enter a single alphabetical character.\n");
      }
    }
    // If we reach here, the input was invalid, so the loop continues
  }

  // Subroutine that accepts a string, prompt, that will be displayed as a prompt
  // to the user and a string, type, that selects which data type to output. If
  // the user inputs an empty string, the subroutine prompts again until the user
  // inputs a string with a length greater than 1, after trimming, is entered. It
  // then returns an object based on the type argument.
  private static Object promptForValidInput(String prompt, String type) {
    do {
      // Display prompt and get user input
      System.out.print(prompt + ": ");
      String input = SCANNER.nextLine().trim();

      // Check for empty input
      if (input.isEmpty()) {
        System.out.printf("\nInput Error: Please enter a non-empty value.\n");
        continue;
      }

      try {
        // Attempt to parse input based on expected type
        switch (type) {
          case INT_TYPE:
            return Integer.parseInt(input); // Parse as integer
          case DOUBLE_TYPE:
            return Double.parseDouble(input); // Parse as double
          default:
            return input; // Return as string for any other type
        }
      } catch (NumberFormatException e) {
        // Handle parsing errors for numeric types
        System.out.println("\nData Type Error: Please enter a valid "
            + (type.equals(INT_TYPE) ? "whole number." : "number."));
      }
    } while (true); // Continue prompting until valid input is received

  }

  // Subroutine that prompts the user for a grade. If grade is between 0 to 100,
  // returns the double value, otherwise prompts the user again.
  private static double getValidGrade() {
    while (true) {
      final double GRADE = (double) promptForValidInput(GRADE_PROMPT, DOUBLE_TYPE);

      if (GRADE >= 0 && GRADE <= 100) {
        return GRADE;
      } else {
        System.out.println("Range Value Error: Grade can be any whole or decimal number between 0 to 100.");
      }
    }
  }

  // Subroutine that prompts the user for an integer. If it is a valid integer
  // greater than 0, returns the integer, otherwise prompts the user again.
  private static int getValidAge() {
    while (true) {
      final int AGE = (int) promptForValidInput(AGE_PROMPT, INT_TYPE);

      if (AGE > 0) {
        return AGE;
      } else {
        System.out.println("Range Value Error: Age can be any whole number greater than 0.");
      }
    }
  }
}