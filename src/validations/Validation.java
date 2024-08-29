package validations;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Validation {

  public static boolean isValidId(int id) {
    return id > 0;
  }

  public static boolean isValidAddress(String adress) {
    if (adress == null) {
      return false;
    }
    return adress.matches("^(?=.{1,299}$)[\\p{L} ]+$");
  }

  public static boolean isValidName(String name) {
    if (name == null) {
      return false;
    }
    return name.matches("^(?=.{1,99}$)[\\p{L} ]+$");
  }

  public static boolean isValidStudentCode(String studentCode) {
    if (studentCode == null) {
      return false;
    }
    return studentCode.matches("^(?!.*(.).*\1)[A-Za-z0-9]{10}$");
  }

  public static boolean isValidUniversity(String university) {
    if (university == null) {
      return false;
    }
    return university.matches("^(?=.{1,199}$)[\\p{L} ]+$");
  }

  public static boolean isValidHeight(String height) {
    if (height == null) {
      return false;
    }
    return height.matches(
        "^(50(\\.0{1,2})?|[5-9]\\d(\\.\\d{1,2})?|[1-2]\\d{2}(\\.\\d{1,2})?|300(\\.0{1,2})?)$");
  }

  public static boolean isValidWeight(String weight) {
    if (weight == null) {
      return false;
    }
    return weight.matches(
        "^(5(\\.0{1,2})?|[6-9](\\.\\d{1,2})?|[1-9]\\d{1,2}(\\.\\d{1,2})?|1000(\\.0{1,2})?)$");
  }

  public static boolean isValidStartYear(String YearStartStudy) {
    if (YearStartStudy == null) {
      return false;
    }
    return YearStartStudy.matches("^(19\\d{2}|[2-9]\\d{3})$");
  }

  public static boolean isValidGPA(String Gpa) {
    if (Gpa == null) {
      return false;
    }
    return Gpa.matches("^(10(\\.0{1,2})?|[0-9](\\.\\d{1,2})?)$");
  }

  public static boolean isValidBirthDate(String date) {
    if (date == null) {
      return false;
    }

    if (!date.matches("^(19[0-9]{2}|20[0-9]{2}|2100)-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$")) {
      return false;
    }

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    try {
      LocalDate parsedDate = LocalDate.parse(date, formatter);
      return !parsedDate.isBefore(LocalDate.of(1900, 1, 1));
    } catch (DateTimeParseException e) {
      return false;
    }
  }
}
