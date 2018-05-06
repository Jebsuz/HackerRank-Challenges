package ru.jebsuz.hrc.algorithms.warmup;

import java.util.stream.LongStream;

/**
 * https://www.hackerrank.com/challenges/a-very-big-sum/problem
 */
public class AVeryBigSum {

  static long aVeryBigSum(int n, long[] ar) {
    return LongStream.of(ar).sum();
  }
}
