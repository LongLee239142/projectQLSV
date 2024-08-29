package entities;

import common.EnumPerformance;
import java.io.Serializable;
import java.sql.Date;

public class Student extends Person implements Serializable {
  private String studentCode;
  private String university;
  private int startYear;
  private double gpa;
  private EnumPerformance academicPerformance;

  public Student() {
  }

  public Student(String name, Date dateOfBirth, String address, double height, double weight,
      String studentCode, String university, int startYear, double gpa) {
    super(name, dateOfBirth, address, height, weight);
    this.studentCode = studentCode;
    this.university = university;
    this.startYear = startYear;
    this.gpa = gpa;
  }

  public String getStudentCode() {
    return studentCode;
  }

  public void setStudentCode(String studentCode) {
    this.studentCode = studentCode;
  }

  public String getUniversity() {
    return university;
  }

  public void setUniversity(String university) {
    this.university = university;
  }

  public int getStartYear() {
    return startYear;
  }

  public void setStartYear(int startYear) {
    this.startYear = startYear;
  }

  public double getGpa() {
    return gpa;
  }

  public void setGpa(double gpa) {
    this.gpa = gpa;
  }

  public EnumPerformance getAcademicPerformance() {
    return EnumPerformance.ratingPerformance(getGpa());
  }


  @Override
  public String toString() {
    return "Student{" + super.toString() +'\'' +
        ", studentCode='" + studentCode + '\'' +
        ", university='" + university + '\'' +
        ", startYear=" + startYear +
        ", gpa=" + gpa +
        ", academicPerformance=" + getAcademicPerformance() +
        '}';
  }
}
