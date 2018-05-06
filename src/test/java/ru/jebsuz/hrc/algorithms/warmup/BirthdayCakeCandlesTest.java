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
public class BirthdayCakeCandlesTest extends BaseTest {

  private int[] candlesHeight;
  private int numberOfCandles;
  private int expected;

  public BirthdayCakeCandlesTest(Scanner input, Scanner output) {
    super(input, output);
  }

  @Parameters
  public static Collection<Object[]> parameters() {
    return SamplesLoader.load(BirthdayCakeCandles.class);
  }

  @Before
  public void setUp() {
    numberOfCandles = Integer.parseInt(input.nextLine().trim());

    candlesHeight = new int[numberOfCandles];

    String[] arItems = input.nextLine().split(" ");

    for (int arItr = 0; arItr < numberOfCandles; arItr++) {
      int arItem = Integer.parseInt(arItems[arItr].trim());
      candlesHeight[arItr] = arItem;
    }

    expected = output.nextInt();
  }

  @Test
  public void birthdayCakeCandles() {
    final int actual = BirthdayCakeCandles.birthdayCakeCandles(numberOfCandles, candlesHeight);

    assertThat(actual).isEqualTo(expected);
  }
}
