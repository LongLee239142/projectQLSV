package common;

import java.util.Arrays;
import java.util.Optional;

public enum EnumPerformance {
  POOR("Poor", 0, 3),
  WEAK("Weak", 3, 5),
  MEDIUM("Medium", 5, 6.5),
  GOOD("Good", 6.5, 7.5),
  VERY_GOOD("Very Good", 7.5, 9),
  EXCELLENT("Excellent", 9, 10.0);
  private final String performance;
  private final double from;
  private final double toBelow;

  EnumPerformance(String performance, double from, double toBelow) {
    this.performance = performance;
    this.from = from;
    this.toBelow = toBelow;
  }

  public String getPerformance() {
    return performance;
  }

  public double getFrom() {
    return from;
  }

  public double getToBelow() {
    return toBelow;
  }

  public static EnumPerformance ratingPerformance(double gpa) {
    Optional<EnumPerformance> performance = Arrays.stream(EnumPerformance.values())
        .filter(p -> gpa >= p.getFrom() && gpa < p.getToBelow())
        .findFirst();
    return performance.orElse(null);
  }
//  public static void main(String[] args) {
//    System.out.println(calculatePerformance(7.2));
//  }
}
