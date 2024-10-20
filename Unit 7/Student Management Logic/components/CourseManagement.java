package components;
import java.util.ArrayList;
import Exceptions.*;

/**
 * CourseManagement Class
 * 
 * Manages courses, students, and grades in the Course Enrollment and Grade Management System.
 */
public class CourseManagement {
  final private static ArrayList<Course> COURSE_LIST = new ArrayList<Course>();
  final private static ArrayList<Double> OVERALL_COURSE_GRADES = new ArrayList<Double>();
  final private static ArrayList<Student> STUDENT_LIST = new ArrayList<Student>();

  /**
   * Gets the list of all courses.
   * @return An ArrayList of Course objects.
   */
  public static ArrayList<Course> getCourseList() {
    return COURSE_LIST;
  }

  /**
   * Gets an array of course names.
   * @return An array of Strings containing course names.
   */
  public static String[] getCourseListStrings() {
    String[] CourseListString = new String[COURSE_LIST.size()];

    for (int i = 0; i < COURSE_LIST.size(); i++) {
      CourseListString[i] = COURSE_LIST.get(i).getCourseName();
    }

    return CourseListString;
  }

  /**
   * Gets the list of all students.
   * @return An ArrayList of Student objects.
   */
  public static ArrayList<Student> getStudentList() {
    return STUDENT_LIST;
  }

  /**
   * Adds a new course to the system.
   * @param courseName The name of the course.
   * @param courseCode The code for the course.
   * @param maxCap The maximum capacity of the course.
   */
  public static void addCourse(String courseName, String courseCode, int maxCap) {
    final Course COURSE = new Course(courseName, courseCode, maxCap);
    COURSE_LIST.add(COURSE);
    OVERALL_COURSE_GRADES.add(null);
  }

  /**
   * Enrolls a student in a course.
   * @param student The Student to enroll.
   * @param course The Course to enroll in.
   * @throws CourseException.CourseFullException If the course is at maximum capacity.
   * @throws StudentException.StudentAlreadyEnrolledException If the student is already enrolled in the course.
   */
  public static void enrollStudent(Student student, Course course) throws CourseException.CourseFullException, StudentException.StudentAlreadyEnrolledException {
    if (student.getEnrolledCourses().contains(course)) {
      throw new StudentException.StudentAlreadyEnrolledException("Student Already Enrolled in this course.");
    }

    if (course.getCurCapacity() < course.getMaxCapacity()) {
      if (!STUDENT_LIST.contains(student)) STUDENT_LIST.add(student);
      student.enrollInCourse(course);
    } else {
      throw new CourseException.CourseFullException("The selected course is full.");
    }
  }

  /**
   * Assigns a grade to a student for a specific course.
   * @param student The Student to assign the grade to.
   * @param course The Course the grade is for.
   * @param grade The grade to assign.
   * @throws CourseException.CourseNotFoundException If the course is not found.
   * @throws StudentException.StudentNotFoundException If the student is not found.
   */
  public static void assignGrade(Student student, Course course, double grade) throws CourseException.CourseNotFoundException, StudentException.StudentNotFoundException {
    if (!STUDENT_LIST.contains(student)) throw new StudentException.StudentNotFoundException("Student not found");

    final int COURSE_INDEX = COURSE_LIST.indexOf(course);

    if (COURSE_INDEX == -1) throw new CourseException.CourseNotFoundException("Student is not assigned to course.");

    student.assignCourseGrade(course, grade);
    System.out.printf("\nSuccess: %.2f for class %s added for %s.\n", grade, student.getName(), course.getCourseName());
  }

  /**
   * Calculates the overall grade for a student across all courses.
   * @param student The Student to calculate grades for.
   * @return The overall grade as a double.
   * @throws StudentException.StudentNotFoundException If the student is not found.
   * @throws CourseException.CourseNotFoundException If a course is not found.
   */
  public static double calculateOverallGrades(Student student) throws StudentException.StudentNotFoundException, CourseException.CourseNotFoundException {
    if (!STUDENT_LIST.contains(student)) throw new StudentException.StudentNotFoundException("Student not found");
    if (STUDENT_LIST.size() < 1) throw new StudentException.StudentNotFoundException("There are no students to get grades from.");

    final ArrayList<Course> ENROLLED_COURSES = student.getEnrolledCourses();

    double overallAverage = 0;

    for (Course course : ENROLLED_COURSES){
      overallAverage += student.getCourseGradesAverage(course);
    }

    if (overallAverage == 0) return 0;
    return overallAverage / ENROLLED_COURSES.size();
  }

  /**
   * Calculates the overall grades for each course.
   * @return An array of doubles representing the overall grade for each course.
   * @throws CourseException.CourseNotFoundException If a course is not found.
   */
  public static double[] calculateOverallGradesPerCourse() throws CourseException.CourseNotFoundException {

    for (Course course : COURSE_LIST) {
      final int COURSE_INDEX = COURSE_LIST.indexOf(course);
      double sumOfStudentGrades = 0;
      int totalStudentsWithCourse = 0;

      for (Student student: STUDENT_LIST) {
        if (student.getEnrolledCourses().contains(course)) {
          totalStudentsWithCourse++;
          sumOfStudentGrades = student.getCourseGradesAverage(course);     
        }
      }

      OVERALL_COURSE_GRADES.set(COURSE_INDEX, sumOfStudentGrades / totalStudentsWithCourse);
    }

    final double[] GRADES_ARRAY = new double[OVERALL_COURSE_GRADES.size()];

    for (int i = 0; i < OVERALL_COURSE_GRADES.size(); i++) {
      double grade = OVERALL_COURSE_GRADES.get(i);
      GRADES_ARRAY[i] = (Double.isNaN(grade)) ? 0 : grade;
    }

    return GRADES_ARRAY;
  }
}
