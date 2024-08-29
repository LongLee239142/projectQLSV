package common;

import entities.Student;
import java.sql.Date;
import java.text.ParseException;
import java.util.List;

public interface ICommon<T> {

  List<T> initiaPersonList();

  List<T> getAll();

  T getOneById(int id);

  void addNewStudent(T obj);

  boolean updateById(int id, T obj);

  boolean deleteById(int id);

  List<T> viewRankAcademicPerformance();

  void viewPercentRankAcademicPerformance();

  void saveAllListStudentToFile(List<T> obj);

  void loadListStudentFromFile(List<T> obj);

  void updateRequestById(int id, String infor, int chosen)throws ParseException;

}
