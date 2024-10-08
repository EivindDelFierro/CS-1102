package lib;
import java.util.ArrayList;
import Exceptions.*;
import components.CourseManagement;
import components.Student;
import utilities.Prompt;
import utilities.PromptException;

public class StudentUtilities {
  final public static Student findStudent() throws StudentException.StudentNotFoundException, PromptException {
    final String INPUT_ID = Prompt.getValidString("Input student ID").toLowerCase();
      for (Student curStudent : CourseManagement.getStudentList()) {
        if (curStudent.getId().toLowerCase().equals(INPUT_ID)) {
          return curStudent;
        }
      }

    throw new StudentException.StudentNotFoundException("Student with ID of " + INPUT_ID + " not found.");
  }

  final public static Student createStudent() throws PromptException, StudentException.StudentAlreadyExistsException {
    final String STUDENT_NAME = Prompt.getValidString("Input student name");
    final String STUDENT_ID = Prompt.getValidString("Input student ID");
    if (doesStudentExist(STUDENT_ID, CourseManagement.getStudentList())) {
      throw new StudentException.StudentAlreadyExistsException("Student with a student ID of " + STUDENT_ID + " already exists.");
    }
    return new Student(STUDENT_NAME, STUDENT_ID);
  }

  final public static boolean doesStudentExist(String id, ArrayList<Student> studentList) {
    for (Student curStudent : studentList) {
      if (curStudent.getId().toLowerCase().equals(id.toLowerCase())) return true;
    }
    return false;
  }
}
