package controller;

import static controller.Menu.MenuInputDataUpdate;

import bo.ListStudentBo;
import bo.StudentBo;
import entities.Student;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import validations.Validation;

public class ControllerMenuUpdate {

  public static void displayMess(String message) {
    System.out.println(message);
  }


  public static void ControllerUpdate(int id) {
    ListStudentBo listStudentBo = new ListStudentBo();
    StudentBo studentBo = new StudentBo();
    Scanner scanner = new Scanner(System.in);
    while (true) {
      try {
        System.out.println("1. Update Name");
        System.out.println("2. Update Date of Birth");
        System.out.println("3. Update Address");
        System.out.println("4. Update Height");
        System.out.println("5. Update Weight");
        System.out.println("6. Update Student Code");
        System.out.println("7. Update University");
        System.out.println("8. Update Start Year");
        System.out.println("9. Update GPA");
        System.out.println("10. Update All");
        System.out.println("11. Exit");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
          case 1:
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
            listStudentBo.updateRequestById(id, name, choice);// Dynamic
//            studentBo.updateRequestById(id, name,choice);
            System.out.println("Name updated successfully.");
            break;

          case 2:
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
            listStudentBo.updateRequestById(id, dateOfBirth, choice);
//             studentBo.updateRequestById(id, dateOfBirth ,choice);
            System.out.println("Date of birth updated successfully.");
            break;

          case 3:
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
            listStudentBo.updateRequestById(id, address, choice);
//            studentBo.updateRequestById(id, address ,choice);
            System.out.println("Address updated successfully.");
            break;

          case 4:
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
            listStudentBo.updateRequestById(id, String.valueOf(height), choice);
//            studentBo.updateRequestById(id, String.valueOf(height) ,choice);
            System.out.println("Height updated successfully.");
            break;

          case 5:
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
            listStudentBo.updateRequestById(id, String.valueOf(weight), choice);
//            studentBo.updateRequestById(id, String.valueOf(weight) ,choice);
            System.out.println("Weight updated successfully.");
            break;

          case 6:
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
            listStudentBo.updateRequestById(id, studentCode, choice);
//            studentBo.updateRequestById(id, studentCode ,choice);
            System.out.println("Student code updated successfully.");
            break;

          case 7:
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
            listStudentBo.updateRequestById(id, university, choice);
//            studentBo.updateRequestById(id, university ,choice);
            System.out.println("University updated successfully.");
            break;

          case 8:
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
            listStudentBo.updateRequestById(id, String.valueOf(startYear), choice);
//            studentBo.updateRequestById(id, String.valueOf(startYear) ,choice);
            System.out.println("Start year updated successfully.");
            break;

          case 9:
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
//            listStudentBo.updateRequestById(id, String.valueOf(gpa), choice);
            studentBo.updateRequestById(id, String.valueOf(gpa) ,choice);
            System.out.println("GPA updated successfully.");
            break;

          case 10:
            System.out.println("Updating all fields...");
//            listStudentBo.updateById(id, Menu.MenuInputDataCreate());
            System.out.println("All fields updated successfully.");
            break;

          case 11:
            System.out.println("Exiting...");
            return;

          default:
            System.out.println("Invalid choice! Please try again.");
        }
        System.out.println("---------------------------------------------------");

      } catch (InputMismatchException e) {
        System.out.println("Invalid input type! Please enter a valid number.");
        scanner.nextLine(); // Clear the buffer to avoid infinite loop
      } catch (Exception e) {
        System.out.println("An error occurred: " + e.getMessage());
      }
    }
  }
}
