package lib;
import java.util.ArrayList;
import Exceptions.*;
import utilities.Prompt;
import utilities.PromptException;
import components.CourseManagement;
import components.Student;

/**
 * Provides utility methods for student-related operations.
 */
public class StudentUtilities {
  /**
   * Finds a student by their ID.
   * @return The found Student object.
   * @throws StudentException.StudentNotFoundException If no student is found with the given ID.
   * @throws PromptException If there's an issue with user input.
   */
  final public static Student findStudent() throws StudentException.StudentNotFoundException, PromptException {
    final String INPUT_ID = Prompt.getValidString("Input student ID").toLowerCase();

    for (Student curStudent : CourseManagement.getStudentList()) {
      if (curStudent.getId().toLowerCase().equals(INPUT_ID)) {
        return curStudent;
      }
    }

    throw new StudentException.StudentNotFoundException("Student with ID of " + INPUT_ID + " not found.");
  }

  /**
   * Creates a new student with user-provided information.
   * @return The newly created Student object.
   * @throws PromptException If there's an issue with user input.
   * @throws StudentException.StudentAlreadyExistsException If a student with the given ID already exists.
   */
  final public static Student createStudent() throws PromptException, StudentException.StudentAlreadyExistsException {
    final String STUDENT_NAME = Prompt.getValidString("Input student name");
    final String STUDENT_ID = Prompt.getValidString("Input student ID");

    if (doesStudentExist(STUDENT_ID, CourseManagement.getStudentList())) {
      throw new StudentException.StudentAlreadyExistsException("Student with a student ID of " + STUDENT_ID + " already exists.");
    }

    return new Student(STUDENT_NAME, STUDENT_ID);
  }

  /**
   * Checks if a student with the given ID exists in the provided list.
   * @param id The ID to check.
   * @param studentList The list of students to search.
   * @return true if the student exists, false otherwise.
   */
  final public static boolean doesStudentExist(String id, ArrayList<Student> studentList) {
    for (Student curStudent : studentList) {
      if (curStudent.getId().toLowerCase().equals(id.toLowerCase())) return true;
    }
    return false;
  }
}
