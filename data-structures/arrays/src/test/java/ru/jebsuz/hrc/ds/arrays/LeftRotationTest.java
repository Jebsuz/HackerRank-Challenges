package ru.jebsuz.hrc.ds.arrays;

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
public class LeftRotationTest extends BaseTest {

  private int[] inputArray;
  private int[] expected;
  private int arraySize;
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

    arraySize = Integer.parseInt(nd[0].trim());
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
  }
}