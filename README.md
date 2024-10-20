# CS-1102

## Unit 1: Introduction to Java Programming

Develop a quiz game composed of five questions. The program should prompt the user with a series of questions and allow them to enter their answers. After the user has answered all the questions, the program should compute and display the final score based on the number of correct answers.

- The program should include five multiple-choice questions with four options.
- The four options should be labeled A, B, C, and D.
- The program should prompt the user to enter their answer by typing the corresponding letter (A, B, C, or D).
- After the user has entered their answer for each question, the program should compare it to the correct answer and keep track of the number of correct responses.
- The program should compute and display the final score as a percentage of the total number of questions.
- Use if and switch case statements to handle user input and compare it to the correct answers.
- Include comments to explain the purpose of each section of code and enhance code readability.

## Unit 2: Control Structures

You are tasked with implementing a basic library system in Java. The program should allow users to add books to the library, borrow books, and return books. The system maintains a record of the available quantity of each book.

1. Implement the following options:

- Add Books
- Borrow Books
- Return Books
- Exit

2. For "Add Books":

- Prompt the user to enter the book title, author, and quantity.
- If the book already exists in the library, update the quantity.
- If the book is new, add it to the library.

3. For "Borrow Books":

- Prompt the user to enter the book title and the number of books to borrow.
- Check if the requested number of books is available in the library.
- If the books are available, update the quantity and display a success message.
- If not, display an error message.

4. For "Return Books":

- Prompt the user to enter the book title and the number of books to return.
- Check if the books being returned belong to the library system.
- If they do, update the quantity and display a success message.
- If not, display an error message.

5. Handle invalid input and display appropriate error messages.

6. Implement an exit option to allow the user to exit the program.

## Unit 3:

Create a robust Student Record Management System in Java to empower administrators with efficient tools for handling student records. This system should encompass functionalities such as adding new students, updating student information, and viewing student details.

Requirements:

Student Data Storage:
Use individual variables to store student information

- name
- ID
- age
- grade

Student Management:

- Develop a set of logically separated methods/functions within a dedicated classless structure,
- employing static variables for storing:
  - the total number of students
  - the student list.

Administrator Interface:

- Display a menu with options
  - add a new student
  - update student information
  - view student details.

Prompt the administrator for necessary inputs and perform the requested operations using the StudentManagement logic.

Error Handling:

- Implement error handling to manage cases where:
  - the student ID is not found
  - invalid inputs are provided.

Documentation:

- Provide comprehensive documentation.

Include instructions for running the program and interacting with the administrator interface.


## Unit 4:
You are working on a data analysis project where you need to process an array of opening stock prices containing 10 days of data as float datatype.

Consider a scenario where you have been given an array of integers representing the daily stock prices of a company for a given period. You are also provided with an ArrayList of stock prices for the same period You are required to implement a program that performs the following tasks:

Calculate the average stock price:
- calculateAveragePrice, that takes the array of stock prices as input and returns the average price of the stocks.

Find the maximum stock price:
- findMaximumPrice, that takes the array of stock prices as input and returns the maximum price among all the stocks. 

Determine the occurrence count of a specific price:
- countOccurrences, that takes the array of stock prices and a target price as input and returns the number of times the target price occurs in the array. 

Compute the cumulative sum of stock prices:
- computeCumulativeSum, that takes the ArrayList of stock prices as input and returns a new ArrayList containing the cumulative sum of prices at each position.

Note:
- Assume both the array and ArrayList of stock prices is not null and contains at least one element.
- You are allowed to use loops (for, while) for array and ArrayList.
- Write the code for the above scenario, including the required methods and their implementations. 

## Unit 5:
Context: You have been assigned to develop a Course Enrollment and Grade Management System in Java for a university. The system should provide functionality to enroll students in courses, assign grades to students, and calculate overall course grades for each student. The project should demonstrate the effective utilization of static methods and variables to keep track of enrollment and grade-related information across multiple instances of the Student and Course classes. It should also showcase your ability to manipulate object state and define behavior through instance methods.

Requirements:
Student Class:


The Student class should have private instance variables to store student information such as name, ID, and enrolled courses.
Implement appropriate access modifiers and provide public getter and setter methods for accessing and updating student information.
Design a method to enroll students in courses. It should accept a Course object as a parameter and add the course to the student's enrolled courses.
Implement a method to assign grades to students. It should accept a Course object and a grade for the student and update the student's grade for that course. 
Course Class:


The Course class should have private instance variables to store course information such as course code, name, and maximum capacity.
Use appropriate access modifiers and provide public getter methods for accessing course information.
Implement a static variable to keep track of the total number of enrolled students across all instances of the Course class.
Design a static method to retrieve the total number of enrolled students.
CourseManagement Class:


The CourseManagement class should have private static variables to store a list of courses and the overall course grades for each student.
Use appropriate access modifiers to control access to the variables.
Implement static methods to add new courses, enroll students, assign grades, and calculate overall course grades for each student.
The addCourse method should accept parameters for course information and create a new Course object. It should add the course to the list of courses.
The enrollStudent method should accept a Student object and a Course object. It should enroll the student in the course by calling the appropriate method in the Student class.
The assignGrade method should accept a Student object, a Course object, and a grade. It should assign the grade to the student for that course by calling the appropriate method in the Student class.
The calculateOverallGrade method should accept a Student object and calculate the overall course grade for that student based on the grades assigned to them.
Administrator Interface:


Develop an interactive command-line interface for administrators to interact with the Course Enrollment and Grade Management System.
Display a menu with options to add a new course, enroll students, assign grades, and calculate overall course grades.
Prompt the administrator for necessary inputs and call the appropriate methods in the CourseManagement and Student classes to perform the requested operations.
Implement error handling to handle cases where invalid inputs are provided or when enrolling students in courses that have reached their maximum capacity.

## Unit 6:
Context: You are tasked with developing a software application for a car rental agency. The application needs to handle different types of vehicles, including cars, motorcycles, and trucks. To enforce a common behavior and ensure consistency among these vehicle types, you decide to utilize interfaces. Additionally, you want to incorporate various small modules into the question to make it engaging and interactive for the developers.

For this assignment, Compose a Java programming question that incorporates the following modules:

Design and implement an interface named "Vehicle" that includes methods for retrieving the vehicle's make, model, and year of manufacture.
Develop a class named "Car" that implements the Vehicle and "CarVehicle" interfaces. This interface includes additional methods for setting and retrieving the number of doors and the fuel type (petrol, diesel, or electric).
Construct a class named "Motorcycle" that also implements Vehicle and the "MotorVehicle" interfaces. This interface should have methods for setting and retrieving the number of wheels and the type of motorcycle (sport, cruiser, or off-road).
Generate a class named "Truck" that implements the Vehicle and "TruckVehicle" interfaces. This interface should include methods for setting and retrieving the cargo capacity (in tons) and the transmission type (manual or automatic).
Integrate all the classes into a main program that allows the user to create objects of different vehicle types, provide relevant information, and display the details of each vehicle.

## Unit 7 - GUI for Student Management System:
Context: You have been assigned to develop a GUI application for a Student Management System. The application should provide a user-friendly interface for administrators to interact with student records, course enrollment, and grades. The GUI should be implemented using Java's GUI frameworks such as Swing or JavaFX. Event handling mechanisms should be employed to respond to user interactions, and the interface should update dynamically to reflect changes in student records.

Requirements:
GUI Design:

Design an intuitive and user-friendly GUI interface for the Student Management System.
Implement the GUI using Java's GUI frameworks such as Swing or JavaFX.
Include appropriate components such as labels, text fields, buttons, tables, and menus to display and interact with student records, course enrollment, and grades.
Ensure that the GUI is aesthetically pleasing, easy to navigate, and logically organized.
Student Management Functionality:

Provide functionality to add new students, update student information, and view student details through the GUI interface.
Implement event handlers for relevant GUI components, such as buttons or menu items, to perform the corresponding actions.
When the "Add Student" button/menu item is clicked, display a form to enter the student's information and add the new student to the system.
When the "Update Student" button/menu item is clicked, display a form to select a student and update their information.
When the "View Student Details" button/menu item is clicked, display a table or another suitable component to show a list of students and their details.
Course Enrollment Functionality:

Include functionality to enroll students in courses through the GUI interface.
Implement event handlers to respond to actions such as selecting a course and enrolling a student.
When a course is selected from a dropdown menu or list, display a list of students eligible for enrollment.
Allow administrators to select a student from the list and enroll them in the chosen course.
Grade Management Functionality:

Incorporate functionality to assign grades to students through the GUI interface.
Implement event handlers to respond to actions such as selecting a student, selecting a course, and assigning a grade.
When a student is selected from a dropdown menu or list, display a list of courses they are enrolled in and their current grades.
Allow administrators to select a course and assign a grade to the selected student.
Dynamic Interface Updates:

Ensure that the GUI interface updates dynamically to reflect changes in student records, course enrollment, and grades.
When a new student is added or information is updated, update the student list or details display accordingly.
When a student is enrolled in a course or a grade is assigned, update the corresponding displays to reflect the changes.
Error Handling:

Implement appropriate error handling mechanisms in the GUI application.
Display error messages or dialog boxes when invalid inputs are provided or when operations cannot be completed.
Handle exceptions gracefully to ensure the application remains responsive and user-friendly.
Documentation:

Provide comprehensive documentation for the project, explaining the purpose and usage of each GUI component, event handler, and functionality.
Describe the design choices made for the GUI interface and the rationale behind them.
Include instructions for running the program and interacting with the GUI interface.