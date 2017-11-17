package ru.jebsuz.hackerrank.challenges.crackingthecodinginterview.algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class BFSShortestReachInAGraph {

  static {
    System.setIn(BFSShortestReachInAGraph.class.getClassLoader()
        .getResourceAsStream("BFSShortestReachInAGraph/input/input00.txt"));
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int numberOfQueries = scanner.nextInt();
    while (numberOfQueries-- > 0) {
      int numberOfVertexes = scanner.nextInt();
      int numberOfEdges = scanner.nextInt();
      Graph graph = new Graph(numberOfVertexes);
      for (int i = 0; i < numberOfEdges; i++) {
        graph.addEdge(scanner.nextInt() - 1, scanner.nextInt() - 1);
      }
      graph.printPath(scanner.nextInt() - 1);
      System.out.println();
    }
  }

  static class Graph {

    private int numberOfVertexes;
    private List<Set<Integer>> adjacency;
    private int[] distanceTo;
    private boolean[] visited;

    Graph(int numberOfVertexes) {
      this.numberOfVertexes = numberOfVertexes;
      distanceTo = new int[numberOfVertexes];
      adjacency = new ArrayList<>(numberOfVertexes);
      for (int i = 0; i < numberOfVertexes; i++) {
        adjacency.add(new HashSet<>());
      }
      for (int i = 0; i < numberOfVertexes; i++) {
        distanceTo[i] = -1;
      }
    }

    private void bfs(int s) {
      visited = new boolean[numberOfVertexes];
      distanceTo[s] = 0;
      visited[s] = true;
      Queue<Integer> queue = new LinkedList<>();
      queue.add(s);
      while (!queue.isEmpty()) {
        final Integer v = queue.poll();
        for (Integer w : adj(v)) {
          if (!visited[w]) {
            distanceTo[w] = distanceTo[v] + 6;
            visited[w] = true;
            queue.add(w);
          }
        }
      }
    }

    void addEdge(int v, int w) {
      adjacency.get(v).add(w);
      adjacency.get(w).add(v);
    }

    Iterable<Integer> adj(int v) {
      return adjacency.get(v);
    }

    void printPath(int s) {
      bfs(s);
      for (int i = 0; i < distanceTo.length; i++) {
        if (i == s) {
          continue;
        }
        if (i == distanceTo.length) {
          System.out.print(distanceTo[i]);
        } else {
          System.out.print(distanceTo[i] + " ");
        }
      }
    }

  }
}
