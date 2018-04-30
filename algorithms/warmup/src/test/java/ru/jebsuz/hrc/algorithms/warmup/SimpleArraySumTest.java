package ru.jebsuz.hrc.algorithms.warmup;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;
import java.util.Scanner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import ru.jebsuz.hrc.common.SamplesLoader;

@RunWith(Parameterized.class)
public class SimpleArraySumTest extends BaseTest {

  private int expected;
  private int[] inputIntegers;

  public SimpleArraySumTest(Scanner input, Scanner output) {
    super(input, output);
  }

  @Parameters
  public static Collection<Object[]> parameters() {
    return SamplesLoader.load(SimpleArraySum.class);
  }

  @Before
  public void setUp() throws Exception {
    int arCount = Integer.parseInt(input.nextLine().trim());

    inputIntegers = new int[arCount];

    String[] arItems = input.nextLine().split(" ");

    for (int arItr = 0; arItr < arCount; arItr++) {
      int arItem = Integer.parseInt(arItems[arItr].trim());
      inputIntegers[arItr] = arItem;
    }

    expected = output.nextInt();
  }

  @Test
  public void simpleArraySum() {
    int actual = SimpleArraySum.simpleArraySum(inputIntegers);

    assertThat(actual).isEqualTo(expected);
  }
}
