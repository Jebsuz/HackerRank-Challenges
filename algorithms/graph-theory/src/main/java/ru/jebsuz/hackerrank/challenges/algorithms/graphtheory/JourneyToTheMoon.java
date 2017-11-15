package ru.jebsuz.hackerrank.challenges.algorithms.graphtheory;

/*
* https://www.hackerrank.com/challenges/journey-to-the-moon/problem
* */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JourneyToTheMoon {

  static {
    try {
      System.setIn(new FileInputStream(
          RoadsAndLibraries.class.getClassLoader().getResource("JourneyToTheMoon/input/input00.txt")
              .getFile()));
    } catch (FileNotFoundException e) {
      log.error(e.getMessage(), e);
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Graph graph = new Graph(scanner.nextInt(), scanner.nextInt());
    for (int i = 0; i < graph.E(); i++) {
      graph.addEdge(scanner.nextInt(), scanner.nextInt());
    }
  }

  private static class Graph {

    private int numberOfVertexes;
    private int numberOfEdges;
    private List<Set<Integer>> adj;

    Graph(int numberOfVertexes, int numberOfEdges) {
      this.numberOfVertexes = numberOfVertexes;
      this.numberOfEdges = numberOfEdges;
      adj = new ArrayList<>();
      for (int i = 0; i < numberOfVertexes; i++) {
        adj.add(new HashSet<>());
      }
    }

    int V() {
      return numberOfVertexes;
    }

    int E() {
      return numberOfEdges;
    }

    Iterable<Integer> adj(int v) {
      return adj.get(v);
    }

    void addEdge(int v, int w) {
      adj.get(v).add(w);
      adj.get(w).add(v);
    }
  }
}
