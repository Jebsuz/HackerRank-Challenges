package ru.jebsuz.hrc.ds.arrays;

/**
 * https://www.hackerrank.com/challenges/arrays-ds/problem
 */
public class ArraysDS {

  static int[] reverseArray(int[] a) {
    int[] reversedInput = new int[a.length];
    for (int i = 0, j = a.length - 1; i < a.length; i++, j--) {
      reversedInput[i] = a[j];
    }
    return reversedInput;
  }
}
