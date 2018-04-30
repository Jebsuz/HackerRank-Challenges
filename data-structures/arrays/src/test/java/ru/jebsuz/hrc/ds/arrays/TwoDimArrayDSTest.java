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
public class TwoDimArrayDSTest extends BaseTest {

  private int[][] inputMatrix;
  private int expected;

  public TwoDimArrayDSTest(Scanner input, Scanner output) {
    super(input, output);
  }

  @Parameters
  public static Collection<Object[]> parameters() {
    return SamplesLoader.load(TwoDimArrayDS.class);
  }

  @Before
  public void setUp() {
    inputMatrix = new int[6][6];

    for (int arrRowItr = 0; arrRowItr < 6; arrRowItr++) {
      String[] arrRowItems = input.nextLine().split(" ");

      for (int arrColumnItr = 0; arrColumnItr < 6; arrColumnItr++) {
        int arrItem = Integer.parseInt(arrRowItems[arrColumnItr].trim());
        inputMatrix[arrRowItr][arrColumnItr] = arrItem;
      }
    }

    expected = output.nextInt();
  }

  @Test
  public void array2D() {
    int actual = TwoDimArrayDS.array2D(inputMatrix);

    assertThat(actual).isEqualTo(expected);
  }
}
