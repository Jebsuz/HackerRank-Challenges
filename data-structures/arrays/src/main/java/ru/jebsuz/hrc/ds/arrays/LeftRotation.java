package ru.jebsuz.hrc.ds.arrays;

import java.util.Arrays;

/**
 * https://www.hackerrank.com/challenges/array-left-rotation/problem
 */
public class LeftRotation {

  static int[] rotateLeft(int[] array, int times) {
    int[] result = new int[array.length];
    int rotationIndex = times % array.length;
    System.arraycopy(array, rotationIndex, result, 0, array.length - rotationIndex);
    System.arraycopy(array, 0, result, array.length - rotationIndex, rotationIndex);
    return result;
  }

  static void printRotated(int[] array, int times) {
    for (int i = times % array.length, j = 0; j < array.length; i = ++i % array.length, j++) {
      System.out.print(array[i] + " ");
    }
  }

  static void printResult(int[] result) {
    Arrays.stream(result).boxed().forEachOrdered(integer -> System.out.print(integer + " "));
  }
}
