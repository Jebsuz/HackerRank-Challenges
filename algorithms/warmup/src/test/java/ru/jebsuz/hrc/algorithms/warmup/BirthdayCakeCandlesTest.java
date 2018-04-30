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
public class BirthdayCakeCandlesTest extends BaseTest {

  private int[] candlesHeight;
  private int numberOfCandles;
  private int expected;

  public BirthdayCakeCandlesTest(InputStream input, File output) {
    super(input, output);
  }

  @Parameters
  public static Collection<Object[]> parameters() {
    return SamplesLoader.load(getSamplesFolderName(BirthdayCakeCandles.class));
  }

  @Before
  public void setUp() throws Exception {
    Scanner inputSample = new Scanner(input);
    numberOfCandles = Integer.parseInt(inputSample.nextLine().trim());

    candlesHeight = new int[numberOfCandles];

    String[] arItems = inputSample.nextLine().split(" ");

    for (int arItr = 0; arItr < numberOfCandles; arItr++) {
      int arItem = Integer.parseInt(arItems[arItr].trim());
      candlesHeight[arItr] = arItem;
    }

    Scanner outputSample = new Scanner(output);
    expected = outputSample.nextInt();
  }

  @Test
  public void birthdayCakeCandles() {
    final int actual = BirthdayCakeCandles.birthdayCakeCandles(numberOfCandles, candlesHeight);

    assertThat(actual).isEqualTo(expected);
  }
}