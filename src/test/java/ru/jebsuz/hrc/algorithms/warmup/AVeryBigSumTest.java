package ru.jebsuz.hrc.algorithms.warmup;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;
import java.util.Scanner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import ru.jebsuz.hrc.common.BaseTest;
import ru.jebsuz.hrc.common.SamplesLoader;

@RunWith(Parameterized.class)
public class AVeryBigSumTest extends BaseTest {

  private long expected;
  private long[] inputLongs;
  private int times;

  public AVeryBigSumTest(Scanner input, Scanner output) {
    super(input, output);
  }

  @Parameters
  public static Collection<Object[]> parameters() {
    return SamplesLoader.load(AVeryBigSum.class);
  }

  @Before
  public void setUp() {
    times = Integer.parseInt(input.nextLine().trim());

    inputLongs = new long[times];

    String[] arItems = input.nextLine().split(" ");

    for (int arItr = 0; arItr < times; arItr++) {
      long arItem = Long.parseLong(arItems[arItr].trim());
      inputLongs[arItr] = arItem;
    }

    expected = output.nextLong();
  }

  @Test
  public void aVeryBigSum() {
    final long actual = AVeryBigSum.aVeryBigSum(times, inputLongs);

    assertThat(actual).isEqualTo(expected);
  }
}
