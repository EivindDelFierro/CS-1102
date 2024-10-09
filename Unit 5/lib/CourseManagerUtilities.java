package lib;
import java.util.ArrayList;
import components.Course;

/**
 * CourseManagerUtilities Class
 * 
 * Provides utility methods for course-related operations.
 */
public class CourseManagerUtilities {
  /**
   * Finds the index of a course in the given list.
   * @param course The Course to find.
   * @param courseList The list of courses to search.
   * @return The index of the course if found, -1 otherwise.
   */
  final public static int findCourseIndex(Course course, ArrayList<Course> courseList) {
    for (int i = 0; i < courseList.size(); i++) {
      if (courseList.get(i).equals(course)) return i;
    }
    return -1;
  }

  /**
   * Checks if a course with the given code exists in the provided list.
   * @param code The course code to check.
   * @param courseList The list of courses to search.
   * @return true if the course exists, false otherwise.
   */
  final public static boolean doesCourseCodeExist(String code, ArrayList<Course> courseList) {
    for (Course curCourse : courseList) {
      if (curCourse.getCourseCode().toLowerCase().equals(code.toLowerCase())) return true;
    }

    return false;
  }
}
