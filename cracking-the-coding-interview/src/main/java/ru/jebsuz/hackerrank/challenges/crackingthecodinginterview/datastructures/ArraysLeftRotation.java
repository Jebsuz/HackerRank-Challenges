package ru.jebsuz.hackerrank.challenges.crackingthecodinginterview.datastructures;

/*
* https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem
* */

import java.util.Scanner;

public class ArraysLeftRotation {

  static {
    System.setIn(ArraysLeftRotation.class.getClassLoader()
        .getResourceAsStream("DataStructures/ArraysLeftRotation/input/input00.txt"));
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int numberOfIntegers = in.nextInt();
    int numberOfShifts = in.nextInt();
    int[] array = new int[numberOfIntegers];
    for (int i = 0; i < numberOfIntegers; i++) {
      array[i] = in.nextInt();
    }

    for (int i = 0; i < numberOfShifts; i++) {
      array = shift(array);
    }

    for (int i = 0; i < array.length; i++) {
      if (i == array.length - 1) {
        System.out.print(array[i]);
      } else {
        System.out.print(array[i] + " ");
      }
    }
  }

  private static int[] shift(int[] array) {
    int[] newArray = new int[array.length];
    System.arraycopy(array, 1,newArray,0, array.length - 1);
    newArray[array.length - 1] = array[0];
    return newArray;
  }
}
