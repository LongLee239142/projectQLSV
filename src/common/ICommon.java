package common;

import entities.Student;
import java.util.List;

public interface ICommon<T> {

  List<T> initiaPersonList();

  List<T> getAll();

  T getOneById(int id);

  boolean addNewStudent(T obj);

  boolean updateById(int id, T obj);

  boolean deleteById(int id);

  List<T> viewRankAcademicPerformance();

  void viewPercentRankAcademicPerformance();

  void saveAllListStudentToFile(List<T> obj);

  void loadListStudentFromFile(List<T> obj);

  boolean updateByIdFollowRequest(int id);

}
