package ru.jebsuz.hrc.ds.arrays;

import static junit.framework.TestCase.fail;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

import java.io.BufferedOutputStream;
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
import ru.jebsuz.hrc.common.SamplesLoader;

@RunWith(Parameterized.class)
public class LeftRotationTest extends BaseTest {

  private int[] inputArray;
  private int[] expected;
  private int numberOfRotations;

  public LeftRotationTest(Scanner input, Scanner output) {
    super(input, output);
  }

  @Parameters
  public static Collection<Object[]> parameters() {
    return SamplesLoader.load(LeftRotation.class);
  }

  @Before
  public void setUp() {
    String[] nd = input.nextLine().split(" ");

    numberOfRotations = Integer.parseInt(nd[1].trim());
    inputArray = convertToInt(input.nextLine().split(" "));
    expected = convertToInt(output.nextLine().split(" "));
  }

  private int[] convertToInt(String[] strings) {
    int[] result = new int[strings.length];
    for (int i = 0; i < strings.length; i++) {
      int aItem = Integer.parseInt(strings[i].trim());
      result[i] = aItem;
    }

    return result;
  }

  @Test
  public void rotateLeft() {
    int[] actual = LeftRotation.rotateLeft(inputArray, numberOfRotations);

    assertThat(actual).containsExactly(expected);

    // gotta learn more about JUnit 4 parametrized tests
    // should revert SampleLoader and BaseTest to File...
    try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
      System.setOut(new PrintStream(baos));

      LeftRotation.printRotated(inputArray, numberOfRotations);

      int[] printRotatedActual = convertToInt(new Scanner(baos.toString()).nextLine().split(" "));

      assertThat(printRotatedActual).containsExactly(expected);
    } catch (IOException e) {
      fail();
    }
  }
}