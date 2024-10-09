package Exceptions;

/**
 * StudentException Class
 * 
 * Custom exception class for student-related exceptions.
 */
public class StudentException extends Exception {
  /**
   * Constructs a new StudentException with the specified message.
   * @param message The detail message.
   */
  public StudentException(String message) {
    super(message);
  }

  /**
   * Exception thrown when a student is not found.
   */
  public static class StudentNotFoundException extends StudentException {
    public StudentNotFoundException(String message) {
        super(message);
    }
  }

  /**
   * Exception thrown when attempting to add a student that already exists.
   */
  public static class StudentAlreadyExistsException extends StudentException {
    public StudentAlreadyExistsException(String message) {
        super(message);
    }
  }


  /**
   * Exception thrown when attempting to enroll a student in a course they're already enrolled in.
   */
  public static class StudentAlreadyEnrolledException extends Exception {
    public StudentAlreadyEnrolledException(String message) {
      super(message);
    }
  }
}