// Student class for creating instance objects of students

public class Student {
  // global variable declarations
  private String firstName;
  private String lastName;
  private String id;
  private Integer age;
  private Double grade;

  // constant global variable declarations
  private static final String FIRST_NAME = "FIRSTNAME";
  private static final String LAST_NAME = "LASTNAME";
  private static final String ID = "ID";
  private static final String AGE = "AGE";
  private static final String GRADE = "GRADE";

  public Student(String firstName, String lastName, String id, int age, double grade) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.id = id;
    this.age = age;
    this.grade = grade;
  }

  // sets a property of a Student class object and returns the updated object
  public Student setProperty(String property, Object value) {
    boolean isValidProperty = true;
    Object oldValue = null;
    switch (property.toUpperCase()) {
      case FIRST_NAME:
        oldValue = this.firstName;
        this.firstName = (String) value;
        break;
      case LAST_NAME:
        oldValue = this.lastName;
        this.lastName = (String) value;
        break;
      case ID:
        oldValue = this.id;
        this.id = (String) value;
        break;
      case AGE:
        oldValue = this.age;
        this.age = (Integer) value;
        break;
      case GRADE:
        oldValue = this.grade;
        this.grade = (Double) value;
        break;
      default:
        isValidProperty = false;
    }
    if (isValidProperty) {
      System.out.printf("The property %s has been updated from %s to %s", property, oldValue, value);
    } else {
      System.out.printf("The property %s was not found and cannot be updated.", property);
    }
    return this;
  }

  // accesses
  public Object getProperty(String property) {
    switch (property.toUpperCase()) {
      case FIRST_NAME:
        return (String) this.firstName;
      case LAST_NAME:
        return (String) this.lastName;
      case ID:
        return (String) this.id;
      case AGE:
        return (Integer) this.age;
      case GRADE:
        return (Double) this.grade;
    }
    System.out.printf("The property %s was not found.", property);
    return null;
  }

}
