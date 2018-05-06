package ru.jebsuz.hrc.ctcic.datastructures;

/*
* https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem
* */

import java.util.Scanner;

public class ArraysLeftRotation {

  static {
    System.setIn(ArraysLeftRotation.class.getClassLoader()
        .getResourceAsStream("DataStructures/ArraysLeftRotation/input/input08.txt"));
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int numberOfIntegers = in.nextInt();
    int numberOfShifts = in.nextInt();
    int[] array = new int[numberOfIntegers];
    for (int i = 0; i < numberOfIntegers; i++) {
      array[i] = in.nextInt();
    }

    array = shift(array, numberOfShifts);

    for (int i = 0; i < array.length; i++) {
      if (i == array.length - 1) {
        System.out.print(array[i]);
      } else {
        System.out.print(array[i] + " ");
      }
    }
  }

  private static int[] shift(int[] array, int numberOfShifts) {
    int[] newArray = new int[array.length];
    System.arraycopy(array, numberOfShifts, newArray, 0, array.length - numberOfShifts);
    System.arraycopy(array, 0, newArray, newArray.length - numberOfShifts, numberOfShifts);

    return newArray;
  }
}
