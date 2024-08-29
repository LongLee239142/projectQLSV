package standardvalidations;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class StandardValidations {
  public static final int STUDENT_CODE_LENGTH = 10;
  public static final int MAXSTUDENT_NAME_LENGTH = 100;
  public static final int MAXUNIVERSITY_NAME_LENGTH = 200;
  public static final int MAXADDRESS_LENGTH = 300;
  public static final int MIN_START_YEAR = 1900;
  public static final int MAX_START_YEAR = 2100;
  public static final double MIN_HEIGHT = 50; // in cm
  public static final double MAX_HEIGHT = 300; // in cm
  public static final double MIN_WEIGHT = 5; // in kg
  public static final double MAX_WEIGHT = 1000; // in kg
  public static final Date MIN_DATE_OF_BIRTH;
  public static final int MIN_GPA = 0;
  public static final int MAX_GPA = 10;

  static {
    try {
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
      MIN_DATE_OF_BIRTH = (Date) simpleDateFormat.parse("01-01-1900");
    } catch (ParseException e) {
      throw new RuntimeException(e);
    }
  }
}
