package ru.jebsuz.hrc.algorithms.warmup;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.io.InputStream;
import java.util.Collection;
import java.util.Scanner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import ru.jebsuz.hrc.common.SamplesLoader;

@RunWith(Parameterized.class)
public class AVeryBigSumTest extends BaseTest {

  private long expected;
  private long[] inputLongs;
  private int times;

  public AVeryBigSumTest(InputStream input, File output) {
    super(input, output);
  }

  @Parameters
  public static Collection<Object[]> parameters() {
    return SamplesLoader.load(getSamplesFolderName(AVeryBigSum.class));
  }

  @Before
  public void setUp() throws Exception {

    Scanner inputSample = new Scanner(input);
    times = Integer.parseInt(inputSample.nextLine().trim());

    inputLongs = new long[times];

    String[] arItems = inputSample.nextLine().split(" ");

    for (int arItr = 0; arItr < times; arItr++) {
      long arItem = Long.parseLong(arItems[arItr].trim());
      inputLongs[arItr] = arItem;
    }

    Scanner outputSample = new Scanner(output);
    expected = outputSample.nextLong();
  }

  @Test
  public void aVeryBigSum() {
    final long actual = AVeryBigSum.aVeryBigSum(times, inputLongs);

    assertThat(actual).isEqualTo(expected);
  }
}