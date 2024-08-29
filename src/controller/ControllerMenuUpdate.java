package controller;

import bo.ListStudentBo;
import entities.Student;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ControllerMenuUpdate {
  public static void ControllerUpdate(int id){
    ListStudentBo listStudentBo = new ListStudentBo();
    listStudentBo.initiaPersonList();
    Scanner scanner = new Scanner(System.in);

    while (true) {
      try {
        System.out.println("1. Update Name" );
        System.out.println("2. Update date of birth" );
        System.out.println("3. Update address");
        System.out.println("4. Update height");
        System.out.println("5. Update weight");
        System.out.println("6. Update student code");
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
            listStudentBo.updateByIdFollowRequest(id);
            System.out.println("---------------------------------------------------");
            break;

          case 2:
            System.out.println("Enter Id Student you want to update: ");
            int updateId = scanner.nextInt();
            scanner.nextLine(); // Clear the buffer
            listStudentBo.updateById(updateId, Menu.MenuInputDataCreate());
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
