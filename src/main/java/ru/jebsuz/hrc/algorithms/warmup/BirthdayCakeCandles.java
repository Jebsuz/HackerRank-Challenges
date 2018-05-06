package ru.jebsuz.hrc.algorithms.warmup;

import java.util.OptionalInt;
import java.util.stream.IntStream;

/**
 * https://www.hackerrank.com/challenges/birthday-cake-candles/problem
 */
public class BirthdayCakeCandles {

  static int birthdayCakeCandles(int n, int[] ar) {
    final OptionalInt max = IntStream.of(ar).max();
    final long result = IntStream.of(ar).filter(value -> value == max.getAsInt()).count();
    return (int) result;
  }
}
