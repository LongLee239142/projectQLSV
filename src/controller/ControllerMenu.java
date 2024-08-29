package controller;

import bo.ListStudentBo;
import bo.StudentBo;
import entities.Student;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ControllerMenu {

  public void controllerMenu() {
    ListStudentBo listStudentBo = new ListStudentBo();
    StudentBo studentBo = new StudentBo();
    studentBo.initiaPersonList();
    listStudentBo.initiaPersonList();
    Scanner scanner = new Scanner(System.in);

    while (true) {
      try {
        System.out.println("1. Add new student");
        System.out.println("2. Update student information");
        System.out.println("3. Find student by id");
        System.out.println("4. Delete student");
        System.out.println("5. View academic performance: ");
        System.out.println("6. View Percent Rank Academic Performance:");
        System.out.println("7. View all students");
        System.out.println("8. Save all students to list");
        System.out.println("9. Load all students from list");
        System.out.println("10. Exit");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
          case 1:
            listStudentBo.addNewStudent(Menu.MenuInputDataCreate());
              System.out.println("Student added successfully!");
//            StudentBo.addNewStudent(Menu.MenuInputDataCreate());
            System.out.println("---------------------------------------------------");
            break;

          case 2:
            System.out.println("Enter Id Student you want to update: ");
            int updateId = scanner.nextInt();
            scanner.nextLine(); // Clear the buffer
            ControllerMenuUpdate.ControllerUpdate(updateId);//DynamicArray
            System.out.println("---------------------------------------------------");
            break;

          case 3:
            System.out.println("Enter Id Student you want to find: ");
            int findId = scanner.nextInt();
            Student student = listStudentBo.getOneById(findId);
            if (student != null) {
              System.out.println(student);
            } else {
              System.out.println("Student not found!");
            }
            System.out.println("---------------------------------------------------");
            break;

          case 4:
            System.out.println("Enter Id Student you want to delete: ");
            int deleteId = scanner.nextInt();
            listStudentBo.deleteById(deleteId);
            System.out.println("---------------------------------------------------");
            break;

          case 5:
            System.out.println("View academic performance: ");
            listStudentBo.viewRankAcademicPerformance();
            System.out.println("---------------------------------------------------");
            break;

          case 6:
            System.out.println("View Percent Rank Academic Performance: ");
            listStudentBo.viewPercentRankAcademicPerformance();
            System.out.println("---------------------------------------------------");
            break;

          case 7:
            listStudentBo.getAll().forEach(System.out::println);
//            studentBo.getAll().forEach(System.out::println);

            System.out.println("---------------------------------------------------");
            break;

          case 8:
            System.out.println("Enter the file path to save list students: ");
            listStudentBo.saveAllListStudentToFile(listStudentBo.getAll());
            System.out.println("List students saved successfully!");
            System.out.println("---------------------------------------------------");
            break;

          case 9:
            System.out.println("Enter the file path to load list students: ");
            listStudentBo.loadListStudentFromFile(listStudentBo.getAll());
            System.out.println("List students loaded successfully!");
            System.out.println("---------------------------------------------------");
            break;

          case 10:
            System.out.println("Exiting...");
            return;

          default:
            System.out.println("Invalid choice! Please try again.");
        }
      } catch (InputMismatchException e) {
        System.out.println("Invalid input type! Please enter a valid number.");
        scanner.nextLine(); // Clear the buffer to avoid infinite loop
      } catch (Exception e) {
        System.out.println("An error occurred: " + e.getMessage());
      }
    }
  }
}
