package Exceptions;

/**
 * CourseException Class
 * 
 * Custom exception class for course-related exceptions.
 */
public class CourseException extends Exception{
  /**
   * Constructs a new CourseException with the specified message.
   * @param message The detail message.
   */
  public CourseException (String message) {
    super(message);
  }

  /**
   * Exception thrown when a course is not found.
   */
  public static class CourseNotFoundException extends CourseException {
    public CourseNotFoundException(String message) {
      super(message);
    }
  }

  /**
   * Exception thrown when attempting to add a course that already exists.
   */
  public static class CourseAlreadyExistsException extends CourseException{
    public CourseAlreadyExistsException (String message) {
      super(message);
    }
  }

  /**
   * Exception thrown when attempting to enroll in a course that is full.
   */
  public static class CourseFullException extends CourseException {
    public CourseFullException (String message) {
      super(message);
    }
  }


  /**
   * Exception thrown when trying to access grades for a course with no grades.
   */
  public static class NoCourseGradesException extends CourseException {
    public NoCourseGradesException (String message) {
      super(message);
    }
  }
}
