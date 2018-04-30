package ru.jebsuz.hrc.algorithms.warmup;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.jebsuz.hrc.algorithms.warmup.DiagonalDifference.diagonalDifference;

import java.io.File;
import java.io.InputStream;
import java.util.Collection;
import java.util.Scanner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import ru.jebsuz.hrc.common.SamplesLoader;

@RunWith(Parameterized.class)
public class DiagonalDifferenceTest extends BaseTest {

  private int expected;
  private int[][] inputMatrix;

  public DiagonalDifferenceTest(InputStream input, File output) {
    super(input, output);
  }

  @Parameters
  public static Collection<Object[]> parameters() {
    return SamplesLoader.load(getSamplesFolderName(DiagonalDifference.class));
  }

  @Before
  public void setUp() throws Exception {
    Scanner inputSample = new Scanner(input);
    int matrixSize = Integer.parseInt(inputSample.nextLine().trim());

    inputMatrix = new int[matrixSize][matrixSize];

    for (int aRowItr = 0; aRowItr < matrixSize; aRowItr++) {
      String[] aRowItems = inputSample.nextLine().split(" ");

      for (int aColumnItr = 0; aColumnItr < matrixSize; aColumnItr++) {
        int aItem = Integer.parseInt(aRowItems[aColumnItr].trim());
        inputMatrix[aRowItr][aColumnItr] = aItem;
      }
    }

    Scanner outputSample = new Scanner(output);
    expected = outputSample.nextInt();
  }

  @Test
  public void diagonalDifference() {
    final int actual = DiagonalDifference.diagonalDifference(inputMatrix);

    assertThat(actual).isEqualTo(expected);
  }
}