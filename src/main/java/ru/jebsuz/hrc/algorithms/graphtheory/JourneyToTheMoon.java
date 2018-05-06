package ru.jebsuz.hrc.algorithms.graphtheory;

/*
* https://www.hackerrank.com/challenges/journey-to-the-moon/problem
* */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JourneyToTheMoon {

  static {
    try {
      System.setIn(new FileInputStream(
          RoadsAndLibraries.class.getClassLoader().getResource("JourneyToTheMoon/input/input11.txt")
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
    System.out.println((new CountPairs(graph)).pairs());
  }

  private static class Graph {

    private int numberOfVertexes;
    private int numberOfEdges;
    private Set<Integer>[] adj;

    Graph(int numberOfVertexes, int numberOfEdges) {
      this.numberOfVertexes = numberOfVertexes;
      this.numberOfEdges = numberOfEdges;
//      adj = new ArrayList<>(numberOfVertexes);
      adj = (Set<Integer>[])new Set[numberOfVertexes];
      for (int i = 0; i < numberOfVertexes; i++) {
        adj[i] = new HashSet<>();
      }
    }

    int V() {
      return numberOfVertexes;
    }

    int E() {
      return numberOfEdges;
    }

    Iterable<Integer> adj(int v) {
      return adj[v];
    }

    void addEdge(int v, int w) {
      adj[v].add(w);
      adj[w].add(v);
    }
  }

  private static class CountPairs {

    private boolean[] visited;
    private int[] id;
    private long pairs;
    private int components;

    CountPairs(Graph graph) {
      visited = new boolean[graph.V()];
      id = new int[graph.V()];
      pairs = 0;
      components = 0;
      for (int v = 0; v < graph.V(); v++) {
        if (!visited[v]) {
          dfs(graph, v);
          components++;
        }
      }
//      List<Set<Integer>> componentsList = new ArrayList<>(components);
      Set<Integer>[] arrayOfComponents = (Set<Integer>[]) new Set[components];
      for (int i = 0; i < components; i++) {
//        componentsList.add(new HashSet<>());
        arrayOfComponents[i] = new HashSet<>();
      }

      for (int v = 0; v < graph.V(); v++) {
//        componentsList.get(id[v]).add(v);
        arrayOfComponents[id[v]].add(v);
      }
      /*for (int i = 0; i < componentsList.size(); i++) {
        final int componentSize = componentsList.get(i).size();
        for (int j = i + 1; j < componentsList.size(); j++) {
          pairs += componentSize * componentsList.get(j).size();
        }
      }*/
      for (int i = 0; i < arrayOfComponents.length; i++) {
        final int size = arrayOfComponents[i].size();
        for (int j = i + 1; j < arrayOfComponents.length; j++) {
          pairs += size * arrayOfComponents[j].size();
        }
      }
    }

    void dfs(Graph graph, int v) {
      visited[v] = true;
      id[v] = components;
      for (Integer w : graph.adj(v)) {
        if (!visited[w]) {
          dfs(graph, w);
        }
      }
    }

    long pairs() {
      return pairs;
    }

  }
}
