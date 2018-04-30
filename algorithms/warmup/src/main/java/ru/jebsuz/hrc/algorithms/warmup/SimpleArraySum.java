package ru.jebsuz.hrc.algorithms.warmup;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/simple-array-sum/problem
 */
public class SimpleArraySum {

  static int simpleArraySum(int[] ar) {
    return Arrays.stream(ar).sum();
  }
}
