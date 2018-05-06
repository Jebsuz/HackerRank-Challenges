package ru.jebsuz.hrc.algorithms.warmup;

/**
 * https://www.hackerrank.com/challenges/time-conversion/problem
 */
public class TimeConversion {

  public static final String DELIMITER = ":";
  private static final String AM = "AM";
  private static final String PM = "PM";

  static String timeConversion(String s) {
    String result;
    final int delimiterPosition = s.indexOf(DELIMITER);
    String hours = s.substring(0, delimiterPosition);
    int convertedHours;
    if (s.contains(AM)) {
      result = s.replace(AM, "");
      convertedHours = convertHours(hours, 0) % 12;
    } else {
      result = s.replace(PM, "");
      convertedHours = convertHours(hours, 12);
    }
    return result.replaceFirst(hours, String.format("%02d", convertedHours));
  }

  private static int convertHours(String hours, int corneredCaseValue) {
    int intHours = Integer.parseInt(hours);
    int convertedHours;
    if (intHours == 12) {
      convertedHours = corneredCaseValue;
    } else {
      convertedHours = intHours + 12;
    }
    return convertedHours;
  }
}
