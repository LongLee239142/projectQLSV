package bo;

import common.ICommon;
import entities.Student;
import java.util.List;

public class StudentBo implements ICommon<Student> {

  private static final int MAX_STUDENT = 100;
  private static Student[] studentLists = new Student[MAX_STUDENT];
  private int count = 0;

  @Override
  public List<Student> initiaPersonList() {
    return List.of();
  }

  @Override
  public List<Student> getAll() {
    return List.of();
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
  public boolean addNewStudent(Student obj) {
    studentLists[count++] = obj;
    return false;
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
        System.out.println("entities.Student not found");
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
  public boolean updateByIdFollowRequest(int id) {
    return false;
  }

}
