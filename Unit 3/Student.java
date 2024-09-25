// Student class for creating instance objects of students

public class Student {
  // global variable declarations
  private String firstName;
  private String lastName;
  private String id;
  private Integer age;
  private Double grade;

  // constant global variable declarations
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

  // getter methods to access values in instance object
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

  public Integer getIntegerProperty(String property) {
      if (property.toUpperCase().equals(AGE)) {
          return this.age;
      }
      throw new IllegalArgumentException("Invalid Integer property: " + property);
  }

  public Double getDoubleProperty(String property) {
      if (property.toUpperCase().equals(GRADE)) {
          return this.grade;
      }
      throw new IllegalArgumentException("Invalid Double property: " + property);
  }

}
