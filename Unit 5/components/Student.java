package components;
import utilities.Prompt;
import utilities.PromptException;
import java.util.ArrayList;
import Exceptions.*;
import lib.CourseGrades;

/**
 * Student Class
 * 
 * Represents a student in the Course Enrollment and Grade Management System.
 */
public class Student {
  private String name;
  private String id;
  final private ArrayList<Course> ENROLLED_COURSES = new ArrayList<Course>();
  final private ArrayList<CourseGrades> ENROLLED_COURSES_GRADES = new ArrayList<CourseGrades>();

  /**
   * Constructs a new Student with the given name and ID.
   * @param name The name of the student.
   * @param id The unique identifier for the student.
   */
  public Student (String name, String id) {
    this.name = name;
    this.id = id;
  }

  /**
   * Gets the name of the student.
   * @return The student's name.
   */
  public String getName() {
    return this.name;
  }

  /**
   * Sets a new name for the student.
   * @throws PromptException If there's an issue with user input.
   */
  public void setName() throws PromptException {
    this.name = Prompt.getValidString();
  }

  /**
   * Gets the ID of the student.
   * @return The student's ID.
   */
  public String getId() {
    return this.id;
  }

  /**
   * Sets a new ID for the student.
   * @throws PromptException If there's an issue with user input.
   */
  public void setId() throws PromptException {
    this.name = Prompt.getValidString();
  }

  /**
   * Gets the list of courses the student is enrolled in.
   * @return An ArrayList of Course objects.
   */
  public ArrayList<Course> getEnrolledCourses() {
    return ENROLLED_COURSES;
  }

  /**
   * Gets the grades for all courses the student is enrolled in.
   * @return An ArrayList of CourseGrades objects.
   */
  public ArrayList<CourseGrades> getEnrolledCoursesGrades() {
    return ENROLLED_COURSES_GRADES;
  }

  /**
   * Enrolls the student in a course.
   * @param course The Course to enroll in.
   */
  public void enrollInCourse(Course course){
    ENROLLED_COURSES.add(course);
    ENROLLED_COURSES_GRADES.add(new CourseGrades());
    course.incrementCurCapacity();
    Course.incrementTotalEnrolled();
  }


  /**
   * Assigns a grade to the student for a specific course.
   * @param course The Course to assign the grade for.
   * @param grade The grade to assign.
   * @throws CourseException.CourseNotFoundException If the course is not found.
   */
  public void assignCourseGrade(Course course, double grade) throws CourseException.CourseNotFoundException {
    final int COURSE_INDEX = getCourseIndex(course);

    final CourseGrades COURSE_GRADE = ENROLLED_COURSES_GRADES.get(COURSE_INDEX);

    COURSE_GRADE.add(grade);
  }

  /**
   * Calculates the average grade for a specific course.
   * @param course The Course to calculate the average for.
   * @return The average grade as a double.
   * @throws CourseException.CourseNotFoundException If the course is not found.
   */
  public double getCourseGradesAverage(Course course) throws CourseException.CourseNotFoundException {
    final int COURSE_INDEX = getCourseIndex(course);
    final CourseGrades TARGET_COURSE_GRADES = ENROLLED_COURSES_GRADES.get(COURSE_INDEX);
    
    if (TARGET_COURSE_GRADES.size() < 1) return 0;

    double sumGrades = 0;

    for (double grade : TARGET_COURSE_GRADES) {
      sumGrades += grade;
    }

    return sumGrades / TARGET_COURSE_GRADES.size();
  }

  /**
   * Gets the index of a course in the student's enrolled courses list.
   * @param course The Course to find.
   * @return The index of the course.
   * @throws CourseException.CourseNotFoundException If the course is not found.
   */
  public int getCourseIndex(Course course) throws CourseException.CourseNotFoundException {
    final int COURSE_INDEX = ENROLLED_COURSES.indexOf(course);

    if (COURSE_INDEX == -1) throw new CourseException.CourseNotFoundException("Course not found");

    return COURSE_INDEX;
  }

  /**
   * Gets the grades for a specific course.
   * @param course The Course to get grades for.
   * @return A CourseGrades object containing the grades.
   * @throws CourseException.CourseNotFoundException If the course is not found.
   */
  public CourseGrades getCourseGradesArrayList(Course course) throws CourseException.CourseNotFoundException {
    final int COURSE_INDEX = getCourseIndex(course);
    return ENROLLED_COURSES_GRADES.get(COURSE_INDEX);
  }
}