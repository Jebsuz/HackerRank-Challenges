package ru.jebsuz.hackerrank.challenges.crackingthecodinginterview.algorithms;

/*
* https://www.hackerrank.com/challenges/ctci-connected-cell-in-a-grid/problem
* */

import java.util.Scanner;

public class DFSConnectedCellInAGrid {

  static {
    System.setIn(DFSConnectedCellInAGrid.class.getClassLoader()
        .getResourceAsStream("Algorithms/DFSConnectedCellInAGrid/input/input00.txt"));
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int m = in.nextInt();
    int grid[][] = new int[n][m];
    for (int grid_i = 0; grid_i < n; grid_i++) {
      for (int grid_j = 0; grid_j < m; grid_j++) {
        grid[grid_i][grid_j] = in.nextInt();
      }
    }

    Graph graph = new Graph(n, m, grid);
    System.out.println(graph.getLongestRegion());
  }

  private static class Graph {

    private int numberOfRows;
    private int numberOfColumns;
    private int grid[][];
    private int counter;

    Graph(int rows, int columns, int[][] grid) {
      numberOfRows = rows;
      numberOfColumns = columns;
      this.grid = grid;
      int tmp;
      for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[i].length; j++) {
          tmp = dfs(i, j);
          if (tmp > counter) {
            counter = tmp;
          }
        }
      }
    }

    int getLongestRegion() {
      return counter;
    }

    boolean check(int n, int m) {
      return !ifIndexesAreOutOfGrid(n, m) && grid[n][m] == 1;
    }

    private boolean ifIndexesAreOutOfGrid(int n, int m) {
      return (n < 0 || m < 0) || (n >= numberOfRows || m >= numberOfColumns);
    }

    int dfs(int x, int y) {
      if (!check(x, y)) {
        return 0;
      }
      int count = 1;
      grid[x][y] = -1;
      for (int i = -1; i <= 1; i++) {
        for (int j = -1; j <= 1; j++) {
          count += dfs(x + i, y + j);
        }
      }

      return count;
    }
  }
}
