package ru.jebsuz.hrc.ds.arrays;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://www.hackerrank.com/challenges/dynamic-array/problem
 */
public class DynamicArray {

  static int[] dynamicArray(int n, int[][] queries) {
//    List<Integer> result = new ArrayList<>(9999999);
    int[] result = new int[50_000];
    int nextResultIndex = 0;
    int lastAnswer = 0;
    SeqList[] sequences = new SeqList[n];
    for (int i = 0; i < n; i++) {
      sequences[i] = new SeqList(n);
    }
    for (int[] query : queries) {
      int queryType = query[0];
      int x = query[1];
      int y = query[2];
      int sequenceIndex = getIndex(x, lastAnswer, n);
      if (queryType == 1) {
//        try {
        sequences[sequenceIndex].add(y);
//        } catch (Exception e) {
//          System.out.println(queryType + " : " + x + " : " + y);
//        }
      }
      if (queryType == 2) {
        SeqList sequence = sequences[sequenceIndex];
        lastAnswer = sequence.get(y % sequence.size());
        result[nextResultIndex++] = lastAnswer;
      }
    }
    return Arrays.copyOfRange(result, 0, nextResultIndex);
  }

  private static int getIndex(int first, int second, int size) {
    return (first ^ second) % size;
  }

  static class SeqList {

    //    int[] store;
    List<Integer> store;
    int next;
    private int size = 0;

    public SeqList(int size) {
//      store = new int[size];
      store = new LinkedList<>();
      next = 0;
    }

    void add(int value) {
      store.add(value);
      size++;
//      store[next++ % store.length] = value;
    }

    int get(int index) {
//      return store[index];
      return store.get(index);
    }

    int size() {
      return size;
    }
  }
}
