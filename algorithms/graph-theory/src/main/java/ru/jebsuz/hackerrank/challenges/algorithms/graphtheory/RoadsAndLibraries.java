package ru.jebsuz.hackerrank.challenges.algorithms.graphtheory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;

/*
* https://www.hackerrank.com/challenges/torque-and-development/problem
* */

@Slf4j
public class RoadsAndLibraries {

  static {
    try {
      System.setIn(new FileInputStream(
          RoadsAndLibraries.class.getClassLoader().getResource("RoadsAndLibraries_in.txt")
              .getFile()));
    } catch (FileNotFoundException e) {
      log.error(e.getMessage(), e);
    }
  }

  public static void main(String[] args) throws FileNotFoundException {

    Scanner in = new Scanner(System.in);
    int queries = in.nextInt();
    for (int a0 = 0; a0 < queries; a0++) {
      int numberOfVertexes = in.nextInt();
      int numberOfEdges = in.nextInt();
      long costOfLibrary = in.nextLong();
      long costOfRoad = in.nextLong();
      Graph graph = new Graph(numberOfVertexes, numberOfEdges);
      for (int a1 = 0; a1 < numberOfEdges; a1++) {
        int city_1 = in.nextInt() - 1;
        int city_2 = in.nextInt() - 1;
        graph.addEdge(city_1, city_2);
      }
      FindLowestCost flc = new FindLowestCost(graph, costOfLibrary, costOfRoad);
      System.out.println(flc.getLowestCost());
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

  private static class FindLowestCost {

    private long lowestCost;
    private boolean[] marked;
    private int count;
    private long libraryCost;
    private long roadCost;
    private int[] id;

    FindLowestCost(Graph graph, long costOfLibrary, long costOfRoad) {
      libraryCost = costOfLibrary;
      roadCost = costOfRoad;
      id = new int[graph.V()];
      marked = new boolean[graph.V()];
      for (int s = 0; s < graph.V(); s++) {
        if (!marked[s]) {
          dfs(graph, s);
          count++;
        }
      }
      List<Set<Integer>> components = new ArrayList<>();
      for (int i = 0; i < count; i++) {
        components.add(new HashSet<>());
      }
      for (int v = 0; v < graph.V(); v++) {
        components.get(id[v]).add(v);
      }
      for (int i = 0; i < count; i++) {
        calculateCost(components.get(i));
      }
    }

    private void dfs(Graph graph, int v) {
      marked[v] = true;
      id[v] = count;
      for (int w : graph.adj(v)) {
        if (!marked[w]) {
          dfs(graph, w);
        }
      }
    }

    private void calculateCost(Set<Integer> component) {
      long costOfAllLibraries = component.size() * libraryCost;
      long oneLibraryAllRoads = (component.size() - 1) * roadCost + libraryCost;
      if (costOfAllLibraries < oneLibraryAllRoads) {
        lowestCost += costOfAllLibraries;
      } else {
        lowestCost += oneLibraryAllRoads;
      }
    }

    long getLowestCost() {
      return lowestCost;
    }
  }
}
