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