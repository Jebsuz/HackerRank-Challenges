package ru.jebsuz.hrc.algorithms.warmup;

/**
 * https://www.hackerrank.com/challenges/compare-the-triplets/problem
 */
public class CompareTheTriplets {

  static int[] solve(int a0, int a1, int a2, int b0, int b1, int b2) {
    int[] points = new int[2];
    awardPoints(a0, b0, points);
    awardPoints(a1, b1, points);
    awardPoints(a2, b2, points);
    return points;
  }

  private static void awardPoints(int a, int b, int[] points) {
    if (a > b) {
      points[0]++;
    } if (b > a) {
      points[1]++;
    }
  }
}
