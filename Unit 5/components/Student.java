package components;
import utilities.Prompt;
import utilities.PromptException;
import java.util.ArrayList;
import Exceptions.*;
import lib.CourseGrades;

public class Student {
  // The Student class should have private instance variables to store student information such as name, ID, and enrolled courses.
  private String name;
  private String id;
  final private ArrayList<Course> ENROLLED_COURSES = new ArrayList<Course>();
  final private ArrayList<CourseGrades> ENROLLED_COURSES_GRADES = new ArrayList<CourseGrades>();

  public Student (String name, String id) {
    this.name = name;
    this.id = id;
  }

  // Implement appropriate access modifiers and provide public getter and setter methods for accessing and updating student information.
  public String getName() {
    return this.name;
  }

  public void setName() throws PromptException {
    this.name = Prompt.getValidString();
  }

  public String getId() {
    return this.id;
  }

  public void setId() throws PromptException {
    this.name = Prompt.getValidString();
  }

  public ArrayList<Course> getEnrolledCourses() {
    return ENROLLED_COURSES;
  }

  public ArrayList<CourseGrades> getEnrolledCoursesGrades() {
    return ENROLLED_COURSES_GRADES;
  }

  // Design a method to enroll students in courses. It should accept a Course object as a parameter and add the course to the student's enrolled courses.
  public void enrollInCourse(Course course){
    ENROLLED_COURSES.add(course);
    ENROLLED_COURSES_GRADES.add(new CourseGrades());
    course.incrementCurCapacity();
    Course.incrementTotalEnrolled();
  }

  // Implement a method to assign grades to students. It should accept a Course object and a grade for the student and update the student's grade for that course. 
  public void assignCourseGrade(Course course, double grade) throws CourseException.CourseNotFoundException {
    final int COURSE_INDEX = getCourseIndex(course);

    final CourseGrades COURSE_GRADE = ENROLLED_COURSES_GRADES.get(COURSE_INDEX);

    COURSE_GRADE.add(grade);
  }

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

  public int getCourseIndex(Course course) throws CourseException.CourseNotFoundException {
    final int COURSE_INDEX = ENROLLED_COURSES.indexOf(course);

    if (COURSE_INDEX == -1) throw new CourseException.CourseNotFoundException("Course not found");

    return COURSE_INDEX;
  }

  public CourseGrades getCourseGradesArrayList(Course course) throws CourseException.CourseNotFoundException {
    final int COURSE_INDEX = getCourseIndex(course);
    return ENROLLED_COURSES_GRADES.get(COURSE_INDEX);
  }
}