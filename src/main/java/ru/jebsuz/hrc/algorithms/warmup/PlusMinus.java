package ru.jebsuz.hrc.algorithms.warmup;

/**
 * https://www.hackerrank.com/challenges/plus-minus/problem
 */
public class PlusMinus {

  static void plusMinus(int[] arr) {
    int positive = 0;
    int negative = 0;
    int zero = 0;

    for (int i : arr) {
      if (i > 0) {
        positive++;
      } else if (i < 0) {
        negative++;
      } else {
        zero++;
      }
    }

    final double positiveRatio = (double) positive / arr.length;
    final double negativeRatio = (double) negative / arr.length;
    final double zeroRatio = (double) zero / arr.length;

    System.out.printf("%1.6f\n%2.6f\n%3.6f", positiveRatio, negativeRatio, zeroRatio);
  }
}
