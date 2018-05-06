package ru.jebsuz.hrc.algorithms.warmup;

/**
 * https://www.hackerrank.com/challenges/diagonal-difference/problem
 */
public class DiagonalDifference {

  static int diagonalDifference(int[][] a) {
    int firstDiagonal = 0;
    int secondDiagonal = 0;
    for (int i = 0, j = a.length - 1; i < a.length; i++, j--) {
      firstDiagonal += a[i][i];
      secondDiagonal += a[i][j];
    }
    return Math.abs(firstDiagonal - secondDiagonal);
  }
}
