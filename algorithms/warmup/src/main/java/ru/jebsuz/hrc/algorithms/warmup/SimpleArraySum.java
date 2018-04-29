package ru.jebsuz.hrc.algorithms.warmup;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/simple-array-sum/problem
 */
public class SimpleArraySum {

  static {
    System.setIn(SimpleArraySum.class.getClassLoader()
        .getResourceAsStream("SimpleArraySum/input/input00.txt"));
  }

  public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(System.in);
    int arCount = Integer.parseInt(scanner.nextLine().trim());

    int[] ar = new int[arCount];

    String[] arItems = scanner.nextLine().split(" ");

    for (int arItr = 0; arItr < arCount; arItr++) {
      int arItem = Integer.parseInt(arItems[arItr].trim());
      ar[arItr] = arItem;
    }

    System.out.println(simpleArraySum(ar));
  }

  static int simpleArraySum(int[] ar) {
    return 0;
  }
}
