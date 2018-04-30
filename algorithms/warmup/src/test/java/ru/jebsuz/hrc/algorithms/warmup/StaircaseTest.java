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
public class StaircaseTest extends BaseTest {

  private int numberOfStairs;
  private String[] expected;

  public StaircaseTest(InputStream input, File output) {
    super(input, output);
  }

  @Parameters
  public static Collection<Object[]> parameters() {
    return SamplesLoader.load(getSamplesFolderName(Staircase.class));
  }

  @Before
  public void setUp() throws Exception {
    Scanner inputSample = new Scanner(input);
    numberOfStairs = Integer.parseInt(inputSample.nextLine().trim());

    Scanner outputSample = new Scanner(output);
    expected = new String[numberOfStairs];
    for (int i = 0; i < numberOfStairs; i++) {
      expected[i] = outputSample.nextLine();
    }
  }

  @Test
  public void staircase() {
    try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
      System.setOut(new PrintStream(byteArrayOutputStream));

      Staircase.staircase(numberOfStairs);

      Scanner output = new Scanner(byteArrayOutputStream.toString());
      String[] actual = new String[numberOfStairs];
      for (int i = 0; i < numberOfStairs; i++) {
        actual[i] = output.nextLine();
      }

      assertThat(actual).containsExactly(expected);
    } catch (IOException e) {
      fail();
    }
  }
}