package components;
import java.util.ArrayList;
import Exceptions.*;

/**
 * 
 * 
 */
public class CourseManagement {
  // The CourseManagement class should have private static variables to store a list of courses and the overall course grades for each student.
  final private static ArrayList<Course> COURSE_LIST = new ArrayList<Course>();
  final private static ArrayList<Double> OVERALL_COURSE_GRADES = new ArrayList<Double>();
  final private static ArrayList<Student> STUDENT_LIST = new ArrayList<Student>();

  public static ArrayList<Course> getCourseList() {
    return COURSE_LIST;
  }

  public static String[] getCourseListStrings() {
    String[] CourseListString = new String[COURSE_LIST.size()];

    for (int i = 0; i < COURSE_LIST.size(); i++) {
      CourseListString[i] = COURSE_LIST.get(i).getCourseName();
    }

    return CourseListString;
  }

  public static ArrayList<Student> getStudentList() {
    return STUDENT_LIST;
  }

  // The addCourse method should accept parameters for course information and create a new Course object. It should add the course to the list of courses.
  public static void addCourse(String courseName, String courseCode, int maxCap) {
    final Course COURSE = new Course(courseName, courseCode, maxCap);
    COURSE_LIST.add(COURSE);
    OVERALL_COURSE_GRADES.add(null);
  }

  // The enrollStudent method should accept a Student object and a Course object. It should enroll the student in the course by calling the appropriate method in the Student class.
  public static void enrollStudent(Student student, Course course) throws CourseException.CourseFullException, StudentException.StudentAlreadyEnrolledException {
    // check if student is already enrolled
    if (student.getEnrolledCourses().contains(course)) {
      throw new StudentException.StudentAlreadyEnrolledException("Student Already Enrolled in this course.");
    }

    // check if course is full
    if (course.getCurCapacity() < course.getMaxCapacity()) {
      if (!STUDENT_LIST.contains(student)) STUDENT_LIST.add(student);
      student.enrollInCourse(course);
    } else {
      throw new CourseException.CourseFullException("The selected course is full.");
    }
  }

  // The assignGrade method should accept a Student object, a Course object, and a grade. It should assign the grade to the student for that course by calling the appropriate method in the Student class.
  public static void assignGrade(Student student, Course course, double grade) throws CourseException.CourseNotFoundException, StudentException.StudentNotFoundException {
    if (!STUDENT_LIST.contains(student)) throw new StudentException.StudentNotFoundException("Student not found");

    final int COURSE_INDEX = COURSE_LIST.indexOf(course);

    if (COURSE_INDEX == -1) throw new CourseException.CourseNotFoundException("Student is not assigned to course.");

    student.assignCourseGrade(course, grade);
    System.out.printf("\nSuccess: %.2f for class %s added for %s.\n", grade, student.getName(), course.getCourseName());
  }

  // The calculateOverallGrade method should accept a Student object and calculate the overall course grade for that student based on the grades assigned to them.
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
      System.out.println("" + grade + Double.isNaN(grade));
      GRADES_ARRAY[i] = (Double.isNaN(grade)) ? 0 : grade;
    }

    return GRADES_ARRAY;
  }
}
