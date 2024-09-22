package entities;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

public class Person implements Serializable {

  private static int staticId = 1;
  private int id;
  private String name;
  private LocalDate dateOfBirth;
  private String address;
  private double height; // in cm
  private double weight;

  public Person() {
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public static void setStaticId(int staticId) {
    Person.staticId = staticId;
  }

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public double getHeight() {
    return height;
  }

  public void setHeight(double height) {
    this.height = height;
  }

  public double getWeight() {
    return weight;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }

  public Person(String name, LocalDate dateOfBirth, String address, double height,
      double weight) {
    this.id = Person.staticId++;
    this.name = name;
    this.dateOfBirth = dateOfBirth;
    this.address = address;
    this.height = height;
    this.weight = weight;
  }

  public static int getStaticId() {
    return staticId;
  }

  @Override
  public String toString() {
    return
        "id=" + id +
            ", name='" + name + '\'' +
            ", dateOfBirth=" + dateOfBirth +
            ", address='" + address + '\'' +
            ", height=" + height +
            ", weight=" + weight;
  }
}
