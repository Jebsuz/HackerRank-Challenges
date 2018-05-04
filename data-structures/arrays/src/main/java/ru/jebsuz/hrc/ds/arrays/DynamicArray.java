package ru.jebsuz.hrc.ds.arrays;

import java.util.LinkedList;
import java.util.List;

/**
 * https://www.hackerrank.com/challenges/dynamic-array/problem
 */
public class DynamicArray {

  static int[] dynamicArray(int n, int[][] queries) {
    List<Integer> result = new LinkedList<>();
    int nextResultIndex = 0;
    int lastAnswer = 0;
    List<Integer>[] sequences = new LinkedList[n];
    for (int i = 0; i < n; i++) {
      sequences[i] = new LinkedList<>();
    }
    for (int[] query : queries) {
      int queryType = query[0];
      int x = query[1];
      int y = query[2];
      int sequenceIndex = getIndex(x, lastAnswer, n);
      switch (queryType) {
        case 1:
          sequences[sequenceIndex].add(y);
          break;
        case 2:
          List<Integer> sequence = sequences[sequenceIndex];
          lastAnswer = sequence.get(y % sequence.size());
          result.add(lastAnswer);
          break;
      }
    }
    return result.stream().mapToInt(Integer::valueOf).toArray();
  }

  private static int getIndex(int first, int second, int size) {
    return (first ^ second) % size;
  }
}
