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
    final long start = System.currentTimeMillis();
    Scanner scanner = new Scanner(System.in);
    Graph graph = new Graph(scanner.nextInt(), scanner.nextInt());
    for (int i = 0; i < graph.E(); i++) {
      graph.addEdge(scanner.nextInt(), scanner.nextInt());
    }
    System.out.println((new CountPairs(graph)).pairs());
//    System.out.println(System.currentTimeMillis() - start);
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

  private static class CountPairs {

    private boolean[] visited;
    private int[] id;
    private int pairs;
    private int components;
    private int counter;
    private List<Integer> compsSize;

    CountPairs(Graph graph) {
      visited = new boolean[graph.V()];
      id = new int[graph.V()];
      pairs = 0;
      components = 0;
      compsSize = new ArrayList<>();
      for (int v = 0; v < graph.V(); v++) {
        if (!visited[v]) {
          dfs(graph, v);
          components++;
          compsSize.add(counter);
          counter = 0;
        }
      }
      for (int i = 0; i < compsSize.size(); i++) {
        final Integer size = compsSize.get(i);
        for (int j = i + 1; j <compsSize.size(); j++) {
          pairs += size * compsSize.get(j);
        }
      }
      /*List<Set<Integer>> componentsList = new ArrayList<>();
      for (int i = 0; i < components; i++) {
        componentsList.add(new HashSet<>());
      }

      for (int v = 0; v < graph.V(); v++) {
        componentsList.get(id[v]).add(v);
      }
      for (int i = 0; i < componentsList.size(); i++) {
        final int componentSize = componentsList.get(i).size();
        for (int j = i + 1; j < componentsList.size(); j++) {
          pairs += componentSize * componentsList.get(j).size();
        }
      }*/
    }

    void dfs(Graph graph, int v) {
      visited[v] = true;
      counter++;
      id[v] = components;
      for (Integer w : graph.adj(v)) {
        if (!visited[w]) {
          dfs(graph, w);
        }
      }
    }

    int pairs() {
      return pairs;
    }

  }
}
