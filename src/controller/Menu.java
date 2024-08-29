package controller;

import entities.Student;
import java.util.Optional;
import java.util.Scanner;
import validations.Validation;

public class Menu {

  private static Student student;

  public static void displayMess(String message) {
    System.out.println(message);
  }

  public static Student MenuInputDataCreate() {
    Student student = new Student();
    try (Scanner scanner = new Scanner(System.in)) {
      String name;
      while (true) {
        displayMess("Enter student's name: ");
        name = scanner.nextLine();
        if (Validation.isValidName(name)) {
          break;
        } else {
          System.out.println();
          displayMess("Invalid name format. Please enter again.");
        }
      }

      String dateOfBirth;
      while (true) {
        displayMess("Enter student's date of birth (yyyy-mm-dd)'");
        dateOfBirth = scanner.nextLine();
        if (Validation.isValidBirthDate(dateOfBirth)) {
          break;
        } else {
          displayMess("Invalid date format. Please enter again.");
        }
      }

      String address;
      while (true) {
        displayMess("Enter student's address: ");
        address = scanner.nextLine();
        if (Validation.isValidAddress(address)) {
          break;
        } else {
          displayMess("Invalid address format. Please enter again.");
        }
      }

      double height;
      while (true) {
        displayMess("Student's height (cm): ");
        if (scanner.hasNextDouble()) {
          height = scanner.nextDouble();
          if (Validation.isValidHeight(String.valueOf(height))) {
            break;
          } else {
            displayMess("Invalid height format. Please enter again.");
          }
        } else {
          displayMess("Invalid height format. Please enter a valid number.");
          scanner.next();
        }
      }

      double weight;
      while (true) {
        displayMess("Student's weight (kg): ");
        if (scanner.hasNextDouble()) {
          weight = scanner.nextDouble();
          if (Validation.isValidWeight(String.valueOf(weight))) {
            break;
          } else {
            displayMess("Invalid weight format. Please enter again.");
          }
        } else {
          displayMess("Invalid weight format. Please enter a valid number.");
          scanner.next();
        }
      }
      scanner.nextLine();

      String studentCode;
      while (true) {
        displayMess("Enter student's student code: ");
        studentCode = scanner.nextLine();
        if (Validation.isValidStudentCode(studentCode)) {
          break;
        } else {
          displayMess("Invalid student code format. Please enter again.");
        }
      }

      String university;
      while (true) {
        displayMess("Enter student's university: ");
        university = scanner.nextLine();
        if (Validation.isValidUniversity(university)) {
          break;
        } else {
          displayMess("Invalid university format. Please enter again");
        }
      }

      int startYear;
      while (true) {
        displayMess("Enter student's start year: ");
        if (scanner.hasNextInt()) {
          startYear = scanner.nextInt();
          if (Validation.isValidStartYear(String.valueOf(startYear))) {
            break;
          } else {
            displayMess("Invalid start year format. Please enter again.");
          }
        } else {
          displayMess("Invalid start year format. Please enter a valid");
          scanner.next(); // clear invalid input
        }
      }

      double gpa;
      while (true) {
        displayMess("Enter student's GPA: ");
        if (scanner.hasNextDouble()) {
          gpa = scanner.nextDouble();
          if (Validation.isValidGPA(String.valueOf(gpa))) {
            break;
          } else {
            displayMess("Invalid GPA format. Please enter again.");
          }
        } else {
          displayMess("Invalid GPA format. Please enter a valid number.");
          scanner.next(); // clear invalid input
        }
      }

      student = new Student(name, java.sql.Date.valueOf(dateOfBirth), address,
          height, weight, studentCode, university, startYear, gpa);
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
    return student;
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
