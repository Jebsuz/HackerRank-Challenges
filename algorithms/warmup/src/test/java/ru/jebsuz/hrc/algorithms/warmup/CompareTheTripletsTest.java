package ru.jebsuz.hrc.algorithms.warmup;

import static org.assertj.core.api.Assertions.assertThat;

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
public class CompareTheTripletsTest {

  public static final String SPACE_SYMBOL = " ";
  private int a0;
  private int a1;
  private int a2;
  private int b0;
  private int b1;
  private int b2;
  private InputStream inputSample;
  private File outputSample;
  private int[] expected;

  public CompareTheTripletsTest(InputStream inputSample, File outputSample) {
    this.inputSample = inputSample;
    this.outputSample = outputSample;
  }

  @Parameters
  public static Collection<Object[]> parameters() {
    return SamplesLoader.load("CompareTheTriplets");
  }

  @Before
  public void setUp() throws Exception {
    Scanner input = new Scanner(inputSample);
    String[] a0A1A2 = input.nextLine().split(SPACE_SYMBOL);

    a0 = Integer.parseInt(a0A1A2[0].trim());
    a1 = Integer.parseInt(a0A1A2[1].trim());
    a2 = Integer.parseInt(a0A1A2[2].trim());

    String[] b0B1B2 = input.nextLine().split(SPACE_SYMBOL);

    b0 = Integer.parseInt(b0B1B2[0].trim());
    b1 = Integer.parseInt(b0B1B2[1].trim());
    b2 = Integer.parseInt(b0B1B2[2].trim());

    expected = new int[2];
    Scanner output = new Scanner(outputSample);
    String outputString = output.nextLine();
    String[] splitedOutput = outputString.split(SPACE_SYMBOL);
    for (int i = 0; i < splitedOutput.length; i++) {
      expected[i] = Integer.parseInt(splitedOutput[i]);
    }
  }

  @Test
  public void solve() {
    int[] actual = CompareTheTriplets.solve(a0, a1, a2, b0, b1, b2);

    assertThat(actual).containsExactlyInAnyOrder(expected);
  }
}