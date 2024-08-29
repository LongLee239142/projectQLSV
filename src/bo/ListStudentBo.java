package bo;

import static controller.Menu.MenuInputDataUpdate;

import common.ICommon;
import common.EnumPerformance;
import entities.Student;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListStudentBo implements ICommon<Student> {

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
  public void addNewStudent(Student obj) {
    studentLists.add(obj);
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

  public void updateRequestById(int id, String info, int chosen) throws ParseException {

    Student student = getOneById(id);

    if (student != null) {
      switch (chosen) {
        case 1:
          student.setName(info);
          System.out.println("Student name updated successfully.");
          break;
        case 2:

          SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
          student.setDateOfBirth((Date) dateFormat.parse(info));
          System.out.println("Student birth of date updated successfully.");

          break;
        case 3:

          student.setAddress(info);
          System.out.println("Student address updated successfully.");

          break;
        case 4:

          student.setHeight(Double.parseDouble(info));
          System.out.println("Student height updated successfully.");

          break;
        case 5:

          student.setWeight(Double.parseDouble(info));
          System.out.println("Student weight updated successfully.");

          break;
        case 6:
          student.setStudentCode(info);
          System.out.println("Student student code updated successfully.");
          break;
        case 7:
          student.setUniversity(info);
          System.out.println("Student university updated successfully.");
          break;
        case 8:
          student.setStartYear(Integer.parseInt(info));
          System.out.println("Student start year updated successfully.");
          break;
        case 9:
          student.setGpa(Double.parseDouble(info));
          System.out.println("Student GPA updated successfully.");
          break;
        default:
          System.out.println("Invalid option. Please choose a number between 1 and 9.");
      }
    } else {
      System.out.println("Student not found!");
    }
  }
}