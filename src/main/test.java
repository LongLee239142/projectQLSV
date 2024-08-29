package main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class test {

  //  static Scanner scanner = new Scanner(System.in);
////  static String mssv = scanner.nextLine();
////  static double gpa = scanner.nextDouble();
//  static String date = scanner.nextLine();
//
//  public static void main(String[] args) {
//    Validation validator = new Validation();
////    boolean isValid = validator.isValidateStudentCode(mssv);
////    System.out.println(isValid);
////    boolean result = validator.isValidGpa(String.valueOf(gpa));
////    System.out.println(result);
//    Date dateTime = new Date(); // TODO: get dateTime from user input
//    boolean isValidDateTime = validator.isValidBirthDateTime(date);
//    System.out.println(isValidDateTime);
//
//  }



  public static boolean isValidDate(String dateStr) {
    final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    try {
      LocalDate date = LocalDate.parse(dateStr, DATE_FORMATTER);

      // Check for year range
      if (date.getYear() < 1900 || date.getYear() > 2100) {
        return false;
      }
      return true;

    } catch (DateTimeParseException e) {
      return false;
    }
  }

  public static void main(String[] args) {
    String[] dates = {
        "1900-01-01", // Valid
        "1999-12-31", // Valid
        "2000-06-15", // Valid
        "2099-11-30", // Valid
        "2100-01-01", // Valid
        "1800-01-01", // Invalid (year before 1900)
        "2024-02-30", // Invalid (non-existent day)
        "2024-04-31", // Invalid (non-existent day)
        "2024-12-32"  // Invalid (non-existent day)
    };

    for (String date : dates) {
      System.out.println(date + ": " + (isValidDate(date) ? "Hợp lệ" : "Không hợp lệ"));
    }
  }

}




