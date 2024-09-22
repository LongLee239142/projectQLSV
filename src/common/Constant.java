package common;


import java.util.regex.Pattern;

public class Constant {
  public static final Pattern BIRTHDAY_PATTERN = Pattern.compile("^(19[0-9]{2}|[2-9][0-9]{3})"
      + "[\\-\\s]?((((0[13578])|(1[02]))[\\-\\s]?"
      + "(([0-2][0-9])|(3[01])))|(((0[469])|(11))[\\-\\s]?(([0-2][0-9])"
      + "|(30)))|(02[\\-\\s]?[0-2][0-9]))$");
  public static final Pattern STUDENT_CODE_PATTERN = Pattern.compile("^(?!.*(.).*\1)[A-Za-z0-9]{10}$");
  public static final Pattern GPA_PATTERN = Pattern.compile("^(10(\\.0{1,2})?|[0-9](\\.\\d{1,2})?)$");
  public static final Pattern START_YEAR_PATTERN = Pattern.compile("^(19\\d{2}|[2-9]\\d{3})$");
  public static final Pattern WEIGHT_PATTERN = Pattern.compile("^(5(\\.0{1,2})?|[6-9]"
      + "(\\.\\d{1,2})?|[1-9]\\d{1,2}(\\.\\d{1,2})?|1000(\\.0{1,2})?)$");
  public static final Pattern HEIGHT_PATTERN = Pattern.compile("^(50(\\.0{1,2})?|[5-9][0-9](\\.\\d{1,2})?|1[0-9]{2}"
      + "(\\.\\d{1,2})?|2[0-9]{2}(\\.\\d{1,2})?|300(\\.0{1,2})?)$");
  public static final Pattern NAME_PATTERN = Pattern.compile("^.{1,100}$");
  public static final Pattern ADDRESS_PATTERN = Pattern.compile("^.{1,300}$");
  public static final Pattern UNIVERSAL_PATTERN = Pattern.compile("^.{1,200}$");
}
