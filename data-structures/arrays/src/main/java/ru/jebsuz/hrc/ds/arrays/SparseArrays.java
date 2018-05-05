package ru.jebsuz.hrc.ds.arrays;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * https://www.hackerrank.com/challenges/sparse-arrays/problem
 */
public class SparseArrays {

  static int findSuffix(String[] collections, String queryString) {
    Map<String, Integer> occurrences = Arrays.stream(collections)
        .collect(Collectors.toMap(Function.identity(), s -> 1, (a, b) -> a + b));
    return occurrences.getOrDefault(queryString, 0);
  }
}
