package components;

/**
 * Course Class
 * 
 * Represents a course in the Course Enrollment and Grade Management System.
 */
public class Course {
  private String courseCode;
  private String courseName;
  private int maxCapacity;
  private int curCapacity = 0;
  private static int totalEnrolled = 0;

  /**
   * Constructs a new Course with the given name, code, and maximum capacity.
   * @param courseName The name of the course.
   * @param courseCode The unique code for the course.
   * @param maxCapacity The maximum number of students that can enroll in the course.
   */
  public Course (String courseName, String courseCode, int maxCapacity) {
    this.courseCode = courseCode;
    this.courseName = courseName;
    this.maxCapacity = maxCapacity;
  }

  /**
   * Retrieves the total number of enrolled students across all courses.
   * @return The total number of enrolled students.
   */
  public static int getTotalEnrolled() {
    return totalEnrolled;
  }

  /**
   * Increments the total number of enrolled students by one.
   */
  public static void incrementTotalEnrolled() {
    totalEnrolled++;
  }

  /**
   * Gets the course code.
   * @return The course code.
   */
  public String getCourseCode() {
    return this.courseCode;
  }

  /**
   * Gets the course name.
   * @return The course name.
   */
  public String getCourseName() {
    return this.courseName;
  }

  /**
   * Gets the maximum capacity of the course.
   * @return The maximum capacity.
   */
  public int getMaxCapacity() {
    return this.maxCapacity;
  }

  /**
   * Gets the current number of students enrolled in the course.
   * @return The current enrollment.
   */
  public int getCurCapacity() {
    return this.curCapacity;
  }

  /**
   * Increments the current enrollment of the course by one.
   */
  public void incrementCurCapacity() {
    this.curCapacity++;
  }
}
