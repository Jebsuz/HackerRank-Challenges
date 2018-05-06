package ru.jebsuz.hrc.algorithms.warmup;

import static junit.framework.TestCase.fail;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
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
public class PlusMinusTest extends BaseTest {

  private int[] inputIntegers;
  private Double[] expected;

  public PlusMinusTest(Scanner input, Scanner output) {
    super(input, output);
  }

  @Parameters
  public static Collection<Object[]> parameters() {
    return SamplesLoader.load(PlusMinus.class);
  }

  @Before
  public void setUp() {
    int n = Integer.parseInt(input.nextLine().trim());

    inputIntegers = new int[n];

    String[] arrItems = input.nextLine().split(" ");

    for (int arrItr = 0; arrItr < n; arrItr++) {
      int arrItem = Integer.parseInt(arrItems[arrItr].trim());
      inputIntegers[arrItr] = arrItem;
    }
    expected = getThreeDoublesFrom(output);
  }

  private Double[] getThreeDoublesFrom(Scanner scanner) {
    final Double[] doubles = new Double[3];
    for (int i = 0; i < 3; i++) {
      doubles[i] = scanner.nextDouble();
    }

    return doubles;
  }

  @Test
  public void plusMinus() {
    try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
      System.setOut(new PrintStream(byteArrayOutputStream));

      PlusMinus.plusMinus(inputIntegers);
      final Double[] actual = getThreeDoublesFrom(new Scanner(byteArrayOutputStream.toString()));

      assertThat(actual).containsExactly(expected);
    } catch (IOException e) {
      fail();
    }
  }
}
