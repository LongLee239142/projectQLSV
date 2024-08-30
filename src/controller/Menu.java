package controller;

import bo.ListStudentBo;
import bo.StudentBo;
import entities.Student;
import java.text.ParseException;
import java.util.Optional;
import java.util.Scanner;
import validations.Validation;

public class Menu {

  public static void displayMess(String message) {
    System.out.println(message);
  }

  public static void MenuInputDataCreate() {
    ListStudentBo listStudentBo = new ListStudentBo();
    StudentBo studentBo = new StudentBo();
    Student student = new Student();
    Scanner scanner = new Scanner(System.in);

    try {
      // Input student's name
      String name = null;
      while (true) {
        try {
          displayMess("Enter student's name: ");
          name = scanner.nextLine();
          if (Validation.isValidName(name)) {
            break;
          } else {
            displayMess("Invalid name format. Please enter again.");
          }
        } catch (Exception e) {
          System.out.println("Error in name input: " + e.getMessage());
        }
      }

      // Input student's date of birth
      String dateOfBirth = null;
      while (true) {
        try {
          displayMess("Enter student's date of birth (yyyy-mm-dd): ");
          dateOfBirth = scanner.nextLine();
          if (Validation.isValidBirthDate(dateOfBirth)) {
            break;
          } else {
            displayMess("Invalid date format. Please enter again.");
          }
        } catch (Exception e) {
          System.out.println("Error in date of birth input: " + e.getMessage());
        }
      }

      // Input student's address
      String address = null;
      while (true) {
        try {
          displayMess("Enter student's address: ");
          address = scanner.nextLine();
          if (Validation.isValidAddress(address)) {
            break;
          } else {
            displayMess("Invalid address format. Please enter again.");
          }
        } catch (Exception e) {
          System.out.println("Error in address input: " + e.getMessage());
        }
      }

      // Input student's height
      double height = 0;
      while (true) {
        try {
          displayMess("Student's height (cm): ");
          if (scanner.hasNextDouble()) {
            height = scanner.nextDouble();
            scanner.nextLine(); // Clear the buffer
            if (Validation.isValidHeight(String.valueOf(height))) {
              break;
            } else {
              displayMess("Invalid height. Please enter again.");
            }
          } else {
            displayMess("Invalid height. Please enter a valid number.");
            scanner.next(); // Clear invalid input
          }
        } catch (Exception e) {
          System.out.println("Error in height input: " + e.getMessage());
        }
      }

      // Input student's weight
      double weight = 0;
      while (true) {
        try {
          displayMess("Student's weight (kg): ");
          if (scanner.hasNextDouble()) {
            weight = scanner.nextDouble();
            scanner.nextLine(); // Clear the buffer
            if (Validation.isValidWeight(String.valueOf(weight))) {
              break;
            } else {
              displayMess("Invalid weight. Please enter again.");
            }
          } else {
            displayMess("Invalid weight. Please enter a valid number.");
            scanner.next(); // Clear invalid input
          }
        } catch (Exception e) {
          System.out.println("Error in weight input: " + e.getMessage());
        }
      }

      // Input student's code
      String studentCode = null;
      while (true) {
        try {
          displayMess("Enter student's student code: ");
          studentCode = scanner.nextLine();
          if (Validation.isValidStudentCode(studentCode)) {
            break;
          } else {
            displayMess("Invalid student code format. Please enter again.");
          }
        } catch (Exception e) {
          System.out.println("Error in student code input: " + e.getMessage());
        }
      }

      // Input student's university
      String university = null;
      while (true) {
        try {
          displayMess("Enter student's university: ");
          university = scanner.nextLine();
          if (Validation.isValidUniversity(university)) {
            break;
          } else {
            displayMess("Invalid university format. Please enter again.");
          }
        } catch (Exception e) {
          System.out.println("Error in university input: " + e.getMessage());
        }
      }

      // Input student's start year
      int startYear = 0;
      while (true) {
        try {
          displayMess("Enter student's start year: ");
          if (scanner.hasNextInt()) {
            startYear = scanner.nextInt();
            scanner.nextLine(); // Clear the buffer
            if (Validation.isValidStartYear(String.valueOf(startYear))) {
              break;
            } else {
              displayMess("Invalid start year. Please enter again.");
            }
          } else {
            displayMess("Invalid start year. Please enter a valid number.");
            scanner.next(); // Clear invalid input
          }
        } catch (Exception e) {
          System.out.println("Error in start year input: " + e.getMessage());
        }
      }

      // Input student's GPA
      double gpa = 0;
      while (true) {
        try {
          displayMess("Enter student's GPA: ");
          if (scanner.hasNextDouble()) {
            gpa = scanner.nextDouble();
            scanner.nextLine(); // Clear the buffer
            if (Validation.isValidGPA(String.valueOf(gpa))) {
              break;
            } else {
              displayMess("Invalid GPA. Please enter again.");
            }
          } else {
            displayMess("Invalid GPA. Please enter a valid number.");
            scanner.next(); // Clear invalid input
          }
        } catch (Exception e) {
          System.out.println("Error in GPA input: " + e.getMessage());
        }
      }

      // Create and add student to the list
      student = new Student(name, java.sql.Date.valueOf(dateOfBirth), address,
          height, weight, studentCode, university, startYear, gpa);
//      listStudentBo.addNewStudent(student);
      studentBo.addNewStudent(student);

    } catch (Exception e) {
      System.out.println("General error: " + e.getMessage());
    }
  }

    public static Student MenuInputDataUpdate(Student student) {
    try (Scanner scanner = new Scanner(System.in)) {
      String name;
      while (true) {
        displayMess("Enter student's name: ");
        name = scanner.nextLine();
        if (Validation.isValidName(name)) {
          student.setName(name);
          break;
        } else {
          System.out.println();
          displayMess("Invalid name format. Please enter again.");
        }
      }
    }
    return student;
  }
}
