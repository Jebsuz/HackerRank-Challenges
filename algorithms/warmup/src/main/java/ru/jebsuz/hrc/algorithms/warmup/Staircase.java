package ru.jebsuz.hrc.algorithms.warmup;

/**
 * https://www.hackerrank.com/challenges/staircase/problem
 */
public class Staircase {

  static void staircase(int n) {
    StringBuilder level;
    String emptySymbol = " ";
    String stair = "#";
    for (int i = 0; i < n; i++) {
      level = new StringBuilder(n);
      int numberOfStairsOnLevel = i + 1;
      for (int j = 0; j < n - numberOfStairsOnLevel; j++) {
        level.append(emptySymbol);
      }
      for (int k = 0; k < numberOfStairsOnLevel; k++) {
        level.append(stair);
      }
      System.out.println(level);
    }
  }
}
