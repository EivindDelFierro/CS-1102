package Exceptions;

public class CourseException extends Exception{
  public CourseException (String message) {
    super(message);
  }

  public static class CourseNotFoundException extends CourseException {
    public CourseNotFoundException(String message) {
      super(message);
    }
  }

  public static class CourseAlreadyExistsException extends CourseException{
    public CourseAlreadyExistsException (String message) {
      super(message);
    }
  }

  public static class CourseFullException extends CourseException {
    public CourseFullException (String message) {
      super(message);
    }
  }

  public static class NoCourseGradesException extends CourseException {
    public NoCourseGradesException (String message) {
      super(message);
    }
  }
}
