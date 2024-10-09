package components;
import utilities.MenuInterface;
import utilities.Prompt;
import utilities.PromptException;
import Exceptions.*;
import lib.CourseManagerUtilities;
import lib.StudentUtilities;
import java.util.Arrays;

/**
 * Administrator Interface
 * 
 * Provides an interface for administrators to interact with the Course Enrollment and Grade Management System.
 */
public class AdministratorInterface {
  
  /**
   * Displays the main menu and handles user interactions.
   */
  public static void mainMenuInterface() {
    final String[] MAIN_MENU_OPTIONS = {"Add a new course", "Enroll students", "Assign Grades", "Calculate overall course grades"}; 
    final MenuInterface MAIN_MENU = new MenuInterface(MAIN_MENU_OPTIONS);

    while (true) {
      try {
        System.out.println("\nMain Menu");
        final int SELECTION = MAIN_MENU.promptMenuSelection();

        if (SELECTION == MAIN_MENU.getExitOptionInteger()) break;

        switch (SELECTION) {
          case 1:
            addCourseInterface();
            break;
          case 2:
            enrollStudentInterface();
            break;
          case 3:
            assignGradesInterface();
            break;
          case 4:
            calculateOverallGradesInterface();
            break;
        }
      } catch (Exception e) {
        System.out.println(e.getClass().getSimpleName()+ ": " + e.getMessage());
      }
    }
  }

  /**
   * Handles the process of adding a new course.
   * @throws PromptException If there's an issue with user input.
   * @throws CourseException.CourseAlreadyExistsException If the course already exists.
   */
  private static void addCourseInterface() throws PromptException, CourseException.CourseAlreadyExistsException {
    System.out.println("\nAdd Course Menu");
    final String COURSE_NAME = Prompt.getValidString("Enter course name");
    final String COURSE_CODE = Prompt.getValidString("Enter course code");

    if (CourseManagerUtilities.doesCourseCodeExist(COURSE_CODE, CourseManagement.getCourseList())) {
      throw new CourseException.CourseAlreadyExistsException("Course Code " + COURSE_CODE + " is already in use.");
    }

    final int MAX_CAPACITY = Prompt.getValidInt("Enter course maximum capacity");
    
    CourseManagement.addCourse(COURSE_NAME, COURSE_CODE, MAX_CAPACITY);
    System.out.printf("\n Course Name: %s, Course Code: %s, Max Capacity: %d Successfully added\n", COURSE_NAME, COURSE_CODE, MAX_CAPACITY);
  }

  /**
   * Handles the process of enrolling a student in a course.
   * @throws CourseException.CourseFullException If the course is at maximum capacity.
   * @throws CourseException.CourseNotFoundException If the course is not found.
   * @throws PromptException If there's an issue with user input.
   * @throws StudentException.StudentNotFoundException If the student is not found.
   * @throws StudentException.StudentAlreadyExistsException If the student already exists.
   * @throws StudentException.StudentAlreadyEnrolledException If the student is already enrolled in the course.
   */
  private static void enrollStudentInterface() throws CourseException.CourseFullException, CourseException.CourseNotFoundException, PromptException, StudentException.StudentNotFoundException, StudentException.StudentAlreadyExistsException, StudentException.StudentAlreadyEnrolledException {
    final String[] ENROLL_STUDENT_OPTIONS = {"New Student", "Existing Student"};
    final MenuInterface ENROLL_STUDENT_MENU = new MenuInterface(ENROLL_STUDENT_OPTIONS);
    Student student = null;

    while (true) {
      System.out.println("\nEnroll Student Menu");
      final int SELECTION = ENROLL_STUDENT_MENU.promptMenuSelection();
      
      if (SELECTION == ENROLL_STUDENT_MENU.getExitOptionInteger()) break;

      switch (SELECTION) {
        case 1:
          // make a new student
          student = StudentUtilities.createStudent();
          break;
        case 2:
          // existing student
          student = StudentUtilities.findStudent();
          System.out.printf("Currently selected Student: [Name: %s, ID: %s]", student.getName(), student.getId());
          break;
      }

      final Course COURSE_SELECTION = showCoursesAndGetCourse();

      if (COURSE_SELECTION == null) break;

      CourseManagement.enrollStudent(student, COURSE_SELECTION);
      System.out.printf("\n Success: %s successfully enrolled in %s\n", student.getName(), COURSE_SELECTION.getCourseName());
    }
  }

  /**
   * Handles the process of assigning grades to a student.
   * @throws CourseException.CourseNotFoundException If the course is not found.
   * @throws PromptException If there's an issue with user input.
   * @throws StudentException.StudentNotFoundException If the student is not found.
   */
  private static void assignGradesInterface() throws CourseException.CourseNotFoundException, PromptException, StudentException.StudentNotFoundException {
    System.out.println("\nAssign Grades");
    final Student STUDENT_SELECTION = StudentUtilities.findStudent();

    System.out.printf("Currently selected Student: [Name: %s, ID: %s]", STUDENT_SELECTION.getName(), STUDENT_SELECTION.getId());

    final Course COURSE_SELECTION = showCoursesAndGetCourse();
    final double INPUT_GRADE = Prompt.getValidDouble("Input grade");

    CourseManagement.assignGrade(STUDENT_SELECTION, COURSE_SELECTION, INPUT_GRADE);
  }

  /**
   * Handles the process of calculating and displaying overall grades.
   * @throws CourseException.CourseNotFoundException If a course is not found.
   * @throws StudentException.StudentNotFoundException If a student is not found.
   * @throws PromptException If there's an issue with user input.
   * @throws CourseException.NoCourseGrades If there are no grades for a course.
   */
  private static void calculateOverallGradesInterface() throws CourseException.CourseNotFoundException, StudentException.StudentNotFoundException, PromptException, CourseException.NoCourseGradesException {
    final String[] CALCULATE_GRADES_OPTIONS = {"Display overall grades for a student", "Display overall grades for all students for each course"};
    final MenuInterface OVERALL_GRADES_MENU = new MenuInterface(CALCULATE_GRADES_OPTIONS);

    while (true) {
      final int SELECTION = OVERALL_GRADES_MENU.promptMenuSelection();
      if (SELECTION == OVERALL_GRADES_MENU.getExitOptionInteger()) break;

      switch (SELECTION) {
        case 1:
          final Student STUDENT_SELECTION = StudentUtilities.findStudent();
          final double OVERALL_GRADE = CourseManagement.calculateOverallGrades(STUDENT_SELECTION);

          System.out.printf("\n%s average grade for all courses is %.2f.\n", STUDENT_SELECTION.getName(), OVERALL_GRADE);
          break;
      
        case 2:
          if (CourseManagement.getCourseList().size() < 1) {
            throw new CourseException.CourseNotFoundException("No courses have been inputted yet.");
          } else if (CourseManagement.getStudentList().size() < 1) {
            throw new StudentException.StudentNotFoundException("There are no students to get grades from.");
          } else {
            System.out.println("Displaying the average grade of each course.");
            System.out.println(Arrays.toString(CourseManagement.getCourseListStrings()));
            System.out.println(Arrays.toString(CourseManagement.calculateOverallGradesPerCourse()));
            break;
          }
      }
    }
  }

  /**
   * Displays a list of courses and prompts the user to select one.
   * @return The selected Course object.
   * @throws PromptException If there's an issue with user input.
   */
  private static Course showCoursesAndGetCourse() throws PromptException{
    final String[] COURSE_LIST_NAMES = CourseManagement.getCourseListStrings();
    final MenuInterface COURSE_LIST_SELECTION = new MenuInterface(COURSE_LIST_NAMES);
    final int COURSE_SELECTION_INDEX = COURSE_LIST_SELECTION.promptMenuSelection();
    
    if (COURSE_SELECTION_INDEX == COURSE_LIST_SELECTION.getExitOptionInteger()) return null;
    
    return CourseManagement.getCourseList().get(COURSE_SELECTION_INDEX - 1);
  }
}
