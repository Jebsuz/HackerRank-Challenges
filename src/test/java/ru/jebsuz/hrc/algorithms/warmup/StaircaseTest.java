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
public class StaircaseTest extends BaseTest {

  private int numberOfStairs;
  private String[] expected;

  public StaircaseTest(Scanner input, Scanner output) {
    super(input, output);
  }

  @Parameters
  public static Collection<Object[]> parameters() {
    return SamplesLoader.load(Staircase.class);
  }

  @Before
  public void setUp() {
    numberOfStairs = Integer.parseInt(input.nextLine().trim());

    expected = new String[numberOfStairs];
    for (int i = 0; i < numberOfStairs; i++) {
      expected[i] = output.nextLine();
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
