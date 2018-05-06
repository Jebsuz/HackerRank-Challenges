package ru.jebsuz.hrc.ds.arrays;

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
public class ArraysDSTest extends BaseTest {

  private int[] expected;
  private int[] inputSample;

  public ArraysDSTest(Scanner input, Scanner output) {
    super(input, output);
  }

  @Parameters
  public static Collection<Object[]> parameters() {
    return SamplesLoader.load(ArraysDS.class);
  }

  @Before
  public void setUp() {
    int arrCount = Integer.parseInt(input.nextLine().trim());

    inputSample = new int[arrCount];

    String[] arrItems = input.nextLine().split(" ");

    for (int arrItr = 0; arrItr < arrCount; arrItr++) {
      int arrItem = Integer.parseInt(arrItems[arrItr].trim());
      inputSample[arrItr] = arrItem;
    }

    expected = new int[inputSample.length];
    for (int i = 0; i < expected.length; i++) {
      expected[i] = output.nextInt();
    }
  }

  @Test
  public void name() {
    final int[] actual = ArraysDS.reverseArray(inputSample);

    assertThat(actual).containsExactly(expected);
  }
}
