package bo;

import static java.awt.SystemColor.info;

import common.ICommon;
import entities.Student;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class StudentBo implements ICommon<Student> {

  private static final int MAX_STUDENT = 100;
  private static final Student[] studentLists = new Student[MAX_STUDENT];
  private static int count = 0;

  public static int getCount() {
    return count;
  }

  @Override
  public List<Student> initiaPersonList() {
//    studentLists[0] = new Student("Bob Smith", new Date(1999, 11, 10),
//        "789 Oak St", 1.80, 75.0, "S34567",
//        "Stanford University",
//        2018, 7.8);
//    studentLists[1] = new Student("Alice Johnson", new Date(2001, 5, 20),
//        "456 Elm St", 1.68, 60.0, "S23456",
//        "Harvard University", 2019, 7.9);
//    studentLists[2] = new Student("Carol White", new Date(2002, 7, 30),
//        "101 Maple Ave", 1.65, 55.0, "S45678", "MIT",
//        2020, 4.3);
//    studentLists[3] = new Student("David Brown", new Date(2000, 3, 25),
//        "202 Pine St", 1.70, 68.0, "S56789",
//        "University of California, Berkeley", 2017, 8.5);
//    studentLists[4] = new Student("Eva Green", new Date(2003, 9, 15),
//        "303 Cedar Rd", 1.72, 62.5, "S67890",
//        "Princeton University", 2021, 9.5);
//
//    // Update count based on the number of students added
//    count = 5;
//
//    // Convert the array to a List for returning
//    return Arrays.asList(Arrays.copyOf(studentLists, count));

    return List.of();
  }

  @Override
  public List<Student> getAll() {
    return Arrays.asList(Arrays.copyOf(studentLists, count));
  }

  @Override
  public Student getOneById(int id) {
    for (int i = 0; i < count; i++) {
      if (studentLists[i].getId() == id) {
        return studentLists[i];
      }
    }
    return null;
  }

  @Override
  public void addNewStudent(Student obj) {
    if (count < MAX_STUDENT) {
      studentLists[count++] = obj;
    } else {
      System.out.println("Maximum number of students reached");
    }
  }

  @Override
  public boolean updateById(int id, Student newStudent) {
    for (int i = 0; i < count; i++) {
      if (studentLists[i].getId() == id) {
        studentLists[i].setName(newStudent.getName());
        studentLists[i].setDateOfBirth(newStudent.getDateOfBirth());
        studentLists[i].setAddress(newStudent.getAddress());
        studentLists[i].setHeight(newStudent.getHeight());
        studentLists[i].setWeight(newStudent.getWeight());
        studentLists[i].setStudentCode(newStudent.getStudentCode());
        studentLists[i].setUniversity(newStudent.getUniversity());
        studentLists[i].setStartYear(newStudent.getStartYear());
        studentLists[i].setGpa(newStudent.getGpa());
        return true;
      } else {
        System.out.println("Student not found");
        return false;
      }
    }
    return true;
  }

  @Override
  public boolean deleteById(int id) {
    for (int i = 0; i < count; i++) {
      if (studentLists[i].getId() == id) {
        studentLists[i] = studentLists[count - 1];
        studentLists[count - 1] = null;
        count--;
        System.out.println("Delete successful");
        return true;
      } else {
        System.out.println("entities.Student not found");
        return false;
      }
    }
    return false;
  }

  @Override
  public List<Student> viewRankAcademicPerformance() {
    return List.of();
  }

  @Override
  public void viewPercentRankAcademicPerformance() {
  }

  @Override
  public void saveAllListStudentToFile(List<Student> obj) {
  }

  @Override
  public void loadListStudentFromFile(List<Student> obj) {
  }

  @Override
  public void updateRequestById(int id, String infor, int chosen) throws ParseException {
    for (int i = 0; i < count; i++) {
      if (studentLists[i].getId() == id) {
        switch (chosen) {
          case 1:
            studentLists[i].setName(infor);
            System.out.println("Student name updated successfully.");
            break;
          case 2:
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            studentLists[i].setDateOfBirth((LocalDate.parse(infor, formatter)));
            System.out.println("Student birth of date updated successfully.");
            break;
          case 3:
            studentLists[i].setAddress(infor);
            System.out.println("Student address updated successfully.");
            break;
          case 4:
            studentLists[i].setHeight(Double.parseDouble(infor));
            System.out.println("Student height updated successfully.");
            break;
          case 5:
            studentLists[i].setWeight(Double.parseDouble(infor));
            System.out.println("Student weight updated successfully.");
            break;
          case 6:
            studentLists[i].setStudentCode(infor);
            System.out.println("Student student code updated successfully.");
            break;
          case 7:
            studentLists[i].setUniversity(infor);
            System.out.println("Student university updated successfully.");
            break;
          case 8:
            studentLists[i].setStartYear(Integer.parseInt(infor));
            System.out.println("Student start year updated successfully.");
            break;
          case 9:
            studentLists[i].setGpa(Double.parseDouble(String.valueOf(info)));
            System.out.println("Student GPA updated successfully.");
          default:
            System.out.println("Invalid option. Please choose a number between 1 and 9.");
        }
      } else {
        System.out.println("Student not found");
      }
    }
  }
}
