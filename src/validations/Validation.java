package validations;

import static common.Constant.ADDRESS_PATTERN;
import static common.Constant.BIRTHDAY_PATTERN;
import static common.Constant.GPA_PATTERN;
import static common.Constant.HEIGHT_PATTERN;
import static common.Constant.NAME_PATTERN;
import static common.Constant.START_YEAR_PATTERN;
import static common.Constant.STUDENT_CODE_PATTERN;
import static common.Constant.UNIVERSAL_PATTERN;
import static common.Constant.WEIGHT_PATTERN;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Validation {

  public static boolean isValidAddress(String adress) {
    return isValid(adress.trim(),ADDRESS_PATTERN);
  }

  public static boolean isValidUniversity(String university) {
    return isValid(university.trim(),UNIVERSAL_PATTERN);
  }

  public static boolean isValidName(String name) {
    return isValid(name.trim(),NAME_PATTERN);
  }

  public static boolean isValidStudentCode(String studentCode) {
    return isValid(studentCode.trim(),STUDENT_CODE_PATTERN);
  }


  public static boolean isValidHeight(String height) {
    return isValid(height.trim(),HEIGHT_PATTERN);
  }

  public static boolean isValidWeight(String weight) {
    return  isValid(weight.trim(),WEIGHT_PATTERN);
  }

  public static boolean isValidStartYear(String YearStartStudy) {
    return isValid(YearStartStudy.trim(),START_YEAR_PATTERN);
  }

  public static boolean isValidGPA(String Gpa) {
    return isValid(Gpa.trim(),GPA_PATTERN);
  }

  public static boolean isValidBirthDate(String date) {
    return isValid(date.trim(), BIRTHDAY_PATTERN);
  }

  public static boolean isValid(String object, Pattern regex) {
    if (object == null || object.isEmpty()) {
      return false;
    }
    Matcher matcher = regex.matcher(object);
    return matcher.matches();
  }
}

