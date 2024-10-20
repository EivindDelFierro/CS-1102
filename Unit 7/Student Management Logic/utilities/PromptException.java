package utilities;

/**
 * PromptException Class
 * 
 * Custom exception class for handling prompt-related errors.
 */
public class PromptException extends Exception {
  /**
   * Constructs a new PromptException with the specified detail message.
   * @param message The detail message.
   */
  public PromptException(String message) {
    super(message);
  }
}
