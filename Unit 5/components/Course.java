package components;
public class Course {
  // The Course class should have private instance variables to store course information such as course code, name, and maximum capacity.
  private String courseCode;
  private String courseName;
  private int maxCapacity;
  private int curCapacity = 0;

  public Course (String courseName, String courseCode, int maxCapacity) {
    this.courseCode = courseCode;
    this.courseName = courseName;
    this.maxCapacity = maxCapacity;
  }

  // Implement a static variable to keep track of the total number of enrolled students across all instances of the Course class.
  private static int totalEnrolled = 0;

  // Design a static method to retrieve the total number of enrolled students.
  public static int getTotalEnrolled() {
    return totalEnrolled;
  }

  public static void incrementTotalEnrolled() {
    totalEnrolled++;
  }

  // Use appropriate access modifiers and provide public getter methods for accessing course information.
  public String getCourseCode() {
    return this.courseCode;
  }

  public String getCourseName() {
    return this.courseName;
  }

  public int getMaxCapacity() {
    return this.maxCapacity;
  }

  public int getCurCapacity() {
    return this.curCapacity;
  }

  public void incrementCurCapacity() {
    this.curCapacity++;
  }
}
