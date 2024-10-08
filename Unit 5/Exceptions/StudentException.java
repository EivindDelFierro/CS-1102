package Exceptions;

public class StudentException extends Exception {
  public StudentException(String message) {
      super(message);
  }

  public static class StudentNotFoundException extends StudentException {
      public StudentNotFoundException(String message) {
          super(message);
      }
  }

  public static class StudentAlreadyExistsException extends StudentException {
      public StudentAlreadyExistsException(String message) {
          super(message);
      }
  }

  public static class StudentAlreadyEnrolledException extends Exception {
    public StudentAlreadyEnrolledException(String message) {
      super(message);
    }
  
  }
}