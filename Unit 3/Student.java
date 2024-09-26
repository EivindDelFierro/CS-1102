/**
*  Student Class
*  This class represents individual student records. It contains:
*  1. Private instance vraribles for student information including their:
*    - First name
*    - Last name
*    - Student ID
*    - Age
*    - Grade
*  2. Getter and setter methods to access and modify student information
*/

public class Student {
  // Global variable declarations
  private String firstName;
  private String lastName;
  private String id;
  private Integer age;
  private Double grade;

  // Constant global variable declarations
  private static final String FIRST_NAME = "FIRST NAME";
  private static final String LAST_NAME = "LAST NAME";
  private static final String ID = "ID";
  private static final String AGE = "AGE";
  private static final String GRADE = "GRADE";

  // Define Student constructor
  public Student(String firstName, String lastName, String id, int age, double grade) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.id = id;
    this.age = age;
    this.grade = grade;
  }

  // Setter and Getter methods utilizing function overloading to avoid type casting errors
  // Setter method to change Student instance properties with a string value
  public Student setProperty(String property, String value) {
    switch (property.toUpperCase()) {
      case FIRST_NAME:
        String oldFirstName = this.firstName;
        this.firstName = value;
        System.out.printf("\nThe field value for %s has been updated from \"%s\" to \"%s\"%n", property, oldFirstName, value);
        break;
      case LAST_NAME:
        String oldLastName = this.lastName;
        this.lastName = value;
        System.out.printf("\nThe field value for %s has been updated from \"%s\" to \"%s\"%n", property, oldLastName, value);
        break;
      case ID:
        String oldId = this.id;
        this.id = value;
        System.out.printf("\nThe field value for %s has been updated from \"%s\" to \"%s\"%n", property, oldId, value);
        break;
      default:
        throw new IllegalArgumentException("Invalid String property: " + property);
    }
    return this;
  }

  // Setter method to change Student instance properties with an integer value
  public Student setProperty(String property, Integer value) {
    if (property.toUpperCase().equals(AGE)) {
      Integer oldAge = this.age;
      this.age = value;
      System.out.printf("\nThe field value for %s has been updated from \"%s\" to \"%s\"%n", property, oldAge, value);
    } else {
      throw new IllegalArgumentException("Invalid Integer property: " + property);
    }
    return this;
  }

  // Setter method to change Student instance properties with a double value
  public Student setProperty(String property, Double value) {
    if (property.toUpperCase().equals(GRADE)) {
      Double oldGrade = this.grade;
      this.grade = value;
      System.out.printf("\nThe field value for %s has been updated from \"%s\" to \"%s\"%n", property, oldGrade, value);
    } else {
      throw new IllegalArgumentException("Invalid Double property: " + property);
    }
    return this;
  }

  // Getter method to access string values in instance object
  public String getStringProperty(String property) {
    switch (property.toUpperCase()) {
        case FIRST_NAME: 
          return this.firstName;
        case LAST_NAME: 
          return this.lastName;
        case ID: 
          return this.id;
        default:
            throw new IllegalArgumentException("Invalid String property: " + property);
      }
  }

  // Getter method to access integer values in instance object
  public Integer getIntegerProperty(String property) {
      if (property.toUpperCase().equals(AGE)) {
          return this.age;
      }
      throw new IllegalArgumentException("Invalid Integer property: " + property);
  }

  // Getter method to access double values in instance object
  public Double getDoubleProperty(String property) {
      if (property.toUpperCase().equals(GRADE)) {
          return this.grade;
      }
      throw new IllegalArgumentException("Invalid Double property: " + property);
  }

}
