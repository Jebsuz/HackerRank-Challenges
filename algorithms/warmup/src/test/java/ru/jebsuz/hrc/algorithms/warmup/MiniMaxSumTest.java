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
public class MiniMaxSumTest extends BaseTest {

  private int[] inputIntegers;
  private int[] expected;

  public MiniMaxSumTest(InputStream input, File output) {
    super(input, output);
  }

  @Parameters
  public static Collection<Object[]> parameters() {
    return SamplesLoader.load(getSamplesFolderName(MiniMaxSum.class));
  }

  @Before
  public void setUp() throws Exception {
    inputIntegers = new int[5];

    Scanner inputSample = new Scanner(input);
    String[] arrItems = inputSample.nextLine().split(" ");

    for (int arrItr = 0; arrItr < 5; arrItr++) {
      int arrItem = Integer.parseInt(arrItems[arrItr].trim());
      inputIntegers[arrItr] = arrItem;
    }

    Scanner outputSample = new Scanner(output);
    expected = new int[2];
    for (int i = 0; i < expected.length; i++) {
      expected[i] = outputSample.nextInt();
    }
  }

  @Test
  public void miniMaxSum() {
    try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
      System.setOut(new PrintStream(byteArrayOutputStream));

      MiniMaxSum.miniMaxSum(inputIntegers);
      Scanner scanner = new Scanner(byteArrayOutputStream.toString());
      int[] actual = new int[2];
      for (int i = 0; i < actual.length; i++) {
        actual[i] = scanner.nextInt();
      }

      assertThat(actual).containsExactly(expected);
    } catch (IOException e) {
      fail();
    }
  }
}