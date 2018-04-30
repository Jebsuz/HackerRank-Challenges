package ru.jebsuz.hrc.algorithms.warmup;

import java.util.ArrayList;
import java.util.List;
import java.util.LongSummaryStatistics;

/**
 * https://www.hackerrank.com/challenges/mini-max-sum/problem
 */
public class MiniMaxSum {

  static void miniMaxSum(int[] arr) {
    List<Long> results = new ArrayList<>(arr.length);
    for (int i = 0; i < arr.length; i++) {
      long sum = 0;
      for (int j = 0; j < arr.length; j++) {
        if (j == i) {
          continue;
        }
        sum += arr[j];
      }
      results.add(sum);
    }

    final LongSummaryStatistics resultStatistics = results.stream().mapToLong(Long::valueOf)
        .summaryStatistics();
    System.out.println(resultStatistics.getMin() + " " + resultStatistics.getMax());
  }
}
