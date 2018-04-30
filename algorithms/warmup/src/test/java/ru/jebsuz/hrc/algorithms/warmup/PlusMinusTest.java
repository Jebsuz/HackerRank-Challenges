package ru.jebsuz.hrc.algorithms.warmup;

import static junit.framework.TestCase.fail;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Collection;
import java.util.Scanner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import ru.jebsuz.hrc.common.SamplesLoader;

@RunWith(Parameterized.class)
public class PlusMinusTest extends BaseTest {

  private int[] inputIntegers;
  private Double[] expected;

  public PlusMinusTest(InputStream input, File output) {
    super(input, output);
  }

  @Parameters
  public static Collection<Object[]> parameters() {
    return SamplesLoader.load(getSamplesFolderName(PlusMinus.class));
  }

  @Before
  public void setUp() throws Exception {
    Scanner inputSample = new Scanner(input);
    int n = Integer.parseInt(inputSample.nextLine().trim());

    inputIntegers = new int[n];

    String[] arrItems = inputSample.nextLine().split(" ");

    for (int arrItr = 0; arrItr < n; arrItr++) {
      int arrItem = Integer.parseInt(arrItems[arrItr].trim());
      inputIntegers[arrItr] = arrItem;
    }
    Scanner outputSample = new Scanner(output);
    expected = getThreeDoublesFrom(outputSample);
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