package ru.jebsuz.hrc.ds.arrays;

import java.util.Arrays;

/**
 * https://www.hackerrank.com/challenges/crush/problem
 */
public class ArrayManipulation {

  static long arrayManipulation(int n, int[][] queries) {
    long[] valuesList = new long[n + 1];
    for (int[] query : queries) {
      int from = query[0];
      int to = query[1];
      int valueToAdd = query[2];
      for (int i = from; i <= to; i++) {
        valuesList[i] += valueToAdd;
      }
    }
    return Arrays.stream(valuesList).max().getAsLong();
  }
}
