package lib;
import java.util.ArrayList;
import components.Course;

public class CourseManagerUtilities {
  final public static int findCourseIndex(Course course, ArrayList<Course> courseList) {
    for (int i = 0; i < courseList.size(); i++) {
      if (courseList.get(i).equals(course)) return i;
    }
    return -1;
  }

  final public static boolean doesCourseCodeExist(String code, ArrayList<Course> courseList) {
    for (Course curCourse : courseList) {
      if (curCourse.getCourseCode().toLowerCase().equals(code.toLowerCase())) return true;
    }

    return false;
  }
}
