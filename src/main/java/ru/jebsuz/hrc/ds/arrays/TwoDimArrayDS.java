package ru.jebsuz.hrc.ds.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.hackerrank.com/challenges/2d-array/problem
 */
public class TwoDimArrayDS {

  static int array2D(int[][] arr) {
    List<Integer> results = new ArrayList<>();
    for (int i = 0; i < arr.length; i++) {
      if (i + 3 > arr.length) {
        continue;
      }
      for (int j = 0; j < arr[i].length; j++) {
        if (j + 2 < arr[i].length) {
          results.add(calc(arr, i, j));
        }
      }
    }
    return results.stream().mapToInt(Integer::valueOf).max().getAsInt();
  }

  private static int calc(int[][] arr, int height, int width) {
    int sum = 0;
    sum += calcRow(arr, height, width);
    sum += arr[height + 1][width + 1];
    sum += calcRow(arr, height + 2, width);
    return sum;
  }

  private static int calcRow(int[][] arr, int height, int width) {
    int sum = 0;
    for (int i = 0; i < 3; i++) {
      sum += arr[height][width++];
    }
    return sum;
  }
}
