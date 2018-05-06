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
public class DiagonalDifferenceTest extends BaseTest {

  private int expected;
  private int[][] inputMatrix;

  public DiagonalDifferenceTest(Scanner input, Scanner output) {
    super(input, output);
  }

  @Parameters
  public static Collection<Object[]> parameters() {
    return SamplesLoader.load(DiagonalDifference.class);
  }

  @Before
  public void setUp() {
    int matrixSize = Integer.parseInt(input.nextLine().trim());

    inputMatrix = new int[matrixSize][matrixSize];

    for (int aRowItr = 0; aRowItr < matrixSize; aRowItr++) {
      String[] aRowItems = input.nextLine().split(" ");

      for (int aColumnItr = 0; aColumnItr < matrixSize; aColumnItr++) {
        int aItem = Integer.parseInt(aRowItems[aColumnItr].trim());
        inputMatrix[aRowItr][aColumnItr] = aItem;
      }
    }

    expected = output.nextInt();
  }

  @Test
  public void diagonalDifference() {
    final int actual = DiagonalDifference.diagonalDifference(inputMatrix);

    assertThat(actual).isEqualTo(expected);
  }
}
