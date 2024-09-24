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

  // Define Student constructor
  public Student(String firstName, String lastName, String id, int age, double grade) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.id = id;
    this.age = age;
    this.grade = grade;
  }

  // sets a property of a Student class object and returns the updated object.
  // Utilized method overloading to avoid type casting errors
  public Student setProperty(String property, String value) {
    switch (property.toUpperCase()) {
      case FIRST_NAME:
        String oldFirstName = this.firstName;
        this.firstName = value;
        System.out.printf("The property %s has been updated from %s to %s%n", property, oldFirstName, value);
        break;
      case LAST_NAME:
        String oldLastName = this.lastName;
        this.lastName = value;
        System.out.printf("The property %s has been updated from %s to %s%n", property, oldLastName, value);
        break;
      case ID:
        String oldId = this.id;
        this.id = value;
        System.out.printf("The property %s has been updated from %s to %s%n", property, oldId, value);
        break;
      default:
        throw new IllegalArgumentException("Invalid String property: " + property);
    }
    return this;
  }

  public Student setProperty(String property, Integer value) {
    if (property.toUpperCase().equals(AGE)) {
      Integer oldAge = this.age;
      this.age = value;
      System.out.printf("The property %s has been updated from %s to %s%n", property, oldAge, value);
    } else {
      throw new IllegalArgumentException("Invalid Integer property: " + property);
    }
    return this;
  }

  public Student setProperty(String property, Double value) {
    if (property.toUpperCase().equals(GRADE)) {
      Double oldGrade = this.grade;
      this.grade = value;
      System.out.printf("The property %s has been updated from %s to %s%n", property, oldGrade, value);
    } else {
      throw new IllegalArgumentException("Invalid Double property: " + property);
    }
    return this;
  }

  // getter method to access values in instance object
  public Object getProperty(String property) {
    switch (property) {
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
