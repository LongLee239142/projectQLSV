package bo;

import static controller.Menu.MenuInputDataUpdate;

import common.ICommon;
import common.EnumPerformance;
import common.serviceFeature;
import entities.Person;
import entities.Student;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListStudentBo implements ICommon<Student>, serviceFeature {

  private static List<Student> studentLists = new ArrayList<Student>();

  @Override
  public List<Student> initiaPersonList() {
    studentLists.add(new Student("Bob Smith", new Date(1999, 11, 10),
        "789 Oak St", 1.80, 75.0, "S34567",
        "Stanford University",
        2018, 7.8));
    studentLists.add(new Student("Alice Johnson", new Date(2001, 5, 20),
        "456 Elm St", 1.68, 60.0, "S23456",
        "Harvard University", 2019, 7.9));
    studentLists.add(new Student("Carol White", new Date(2002, 7, 30),
        "101 Maple Ave", 1.65, 55.0, "S45678", "MIT",
        2020, 4.3));
    studentLists.add(new Student("David Brown", new Date(2000, 3, 25),
        "202 Pine St", 1.70, 68.0, "S56789",
        "University of California, Berkeley", 2017, 8.5));
    studentLists.add(
        new Student("Eva Green", new Date(2003, 9, 15),
            "303 Cedar Rd", 1.72, 62.5, "S67890",
            "Princeton University", 2021, 9.5));
    return studentLists;
  }

  @Override
  public List<Student> getAll() {
    return studentLists;
  }


  @Override
  public Student getOneById(int id) {
    Optional<Student> student = studentLists.stream()
        .filter(s -> s.getId() == id)
        .findFirst();
    return student.orElse(null);
  }

  @Override
  public boolean addNewStudent(Student obj) {
    studentLists.add(obj);
    return true;
  }

  @Override
  public boolean updateById(int id, Student obj) {
    Optional<Student> student = studentLists.stream()
        .filter(s -> s.getId() == id).findFirst();
    if (student.isPresent()) {
      student.get().setName(obj.getName());
      student.get().setDateOfBirth(obj.getDateOfBirth());
      student.get().setAddress(obj.getAddress());
      student.get().setHeight(obj.getHeight());
      student.get().setWeight(obj.getWeight());
      student.get().setStudentCode(obj.getStudentCode());
      student.get().setUniversity(obj.getUniversity());
      student.get().setStartYear(obj.getStartYear());
      student.get().setGpa(obj.getGpa());
      return true;
    }
    return false;
  }

  @Override
  public boolean updateByIdFollowRequest(int id ) {
    Optional<Student> student = studentLists.stream()
        .filter(s -> s.getId() == id).findFirst();
    if (student.isPresent()) {
      Student studentStudent = student.get();
      MenuInputDataUpdate(studentStudent);
      return true;
    }
    return false;
  }

  @Override
  public boolean deleteById(int id) {
    Optional<Student> student = studentLists.stream()
        .filter(s -> s.getId() == id)
        .findFirst();
    if (student.isPresent()) {
      studentLists.remove(student.get());
      List<Student> studentAfterRemove = studentLists.stream().filter(s -> s.getId() > id).toList();
      int temp = id;
      for (int i = 0; i < studentAfterRemove.size(); i++) {
        studentAfterRemove.get(i).setId(temp);
        temp++;
      }
    } else {
      System.out.println("Not found student");
    }

    return true;
  }

  @Override
  public List<Student> viewRankAcademicPerformance() {
    List<Student> sortedStudentList = studentLists.stream()
        .sorted(Comparator.comparingDouble(Student::getGpa).reversed())
        .collect(Collectors.toList());
    System.out.println("Rank Academic Performance:");
    for (int i = 0; i < sortedStudentList.size(); i++) {
      System.out.println((i + 1) + ". " + sortedStudentList.get(i).getName() +
          " (GPA: " + sortedStudentList.get(i).getGpa() + ")");
    }
    return sortedStudentList;
  }

  public Map<EnumPerformance, Double> sortMap(Map<EnumPerformance, Double> obj) {
    return obj.entrySet().stream()
        .sorted(Map.Entry.<EnumPerformance, Double>comparingByValue().reversed())
        .collect(Collectors.toMap(
            Map.Entry::getKey,
            Map.Entry::getValue,
            (e1, e2) -> e1,
            LinkedHashMap::new));
  }

  @Override
  public void viewPercentRankAcademicPerformance() {
    Map<EnumPerformance, Long> countByAcadamicPerformance = studentLists.stream()
        .collect(Collectors.groupingBy(Student::getAcademicPerformance, Collectors.counting()));
    int totalStudents = studentLists.size();
    LinkedHashMap<EnumPerformance, Double> percentOfPerformance = new LinkedHashMap<>();
    for (EnumPerformance performance : EnumPerformance.values()) {
      long amount = countByAcadamicPerformance.getOrDefault(performance, 0L);
      percentOfPerformance.put(performance, (double) amount / totalStudents * 100);
    }
    for (Map.Entry<EnumPerformance, Double> entry : sortMap(percentOfPerformance).entrySet()) {
      System.out.printf("%s: %.2f%%%n", entry.getKey(), entry.getValue());
    }
  }

  @Override
  public void saveAllListStudentToFile(List<Student> obj) {
    try (ObjectOutputStream output = new ObjectOutputStream(
        new FileOutputStream("list_student.txt"))) {
      output.writeObject(obj);
      System.out.println("All Students saved successfully!");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void loadListStudentFromFile(List<Student> obj) {
    try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("list_student.txt"))) {
      obj = (List<Student>) input.readObject();
      System.out.println("All Students: ");
      for (Student student : obj) {
        System.out.println(student);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void updateService(int id) {
    Optional<Student> student = studentLists.stream()
        .filter(s -> s.getId() == id)
        .findFirst();
    if (student.isPresent()) {
      boolean isContinueLoop = true;
      while (isContinueLoop) {
        System.out.println("----------------------------------------------------------------");
        System.out.println("Which information would you like to update?");
        System.out.println("1: Name");
        System.out.println("2: Address");
        System.out.println("3: Height");
        System.out.println("4: Weight");
        System.out.println("5: Student Code");
        System.out.println("6: School Name");
        System.out.println("7: Start Year");
        System.out.println("8: GPA");
        System.out.println("9: Date of Birth");
        System.out.println("10: Exit");
        System.out.print("Enter your choice: ");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        sc.nextLine();

//        switch (choice) {
//          case 1 -> student.setName();
//          case 2 -> student.setAddress();
//          case 3 -> student.setHeight();
//          case 4 -> student.setWeight();
//          case 5 -> {
//            String inputCode = StudentUtil.getValidStudentCode();
//            if (isUniqueStudentCode(inputCode)) {
//              student.setStudentCode(inputCode);
//            } else {
//              System.out.println("Student code is not unique.");
//            }
//          }
//          case 6 -> student.setSchoolName(StudentUtil.getValidSchool());
//          case 7 -> student.setYearStart(StudentUtil.getValidStartYear());
//          case 8 -> student.setGpa(StudentUtil.getValidGPA());
//          case 9 -> student.setDateOfBirth(StudentUtil.getValidDateOfBirth());
//          case 10 -> isContinueLoop = false;
//          default -> System.out.println("Invalid choice. Please enter a valid option.");
      }
    }
  }
}