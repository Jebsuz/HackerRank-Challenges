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
public class ArrayManipulationTest extends BaseTest {

  private int[][] queries;
  private int listSize;
  private long expected;

  public ArrayManipulationTest(Scanner input, Scanner output) {
    super(input, output);
  }

  @Parameters
  public static Collection<Object[]> parameters() {
    return SamplesLoader.load(ArrayManipulation.class);
  }

  @Before
  public void setUp() {
    String[] nm = input.nextLine().split(" ");

    listSize = Integer.parseInt(nm[0].trim());

    int numberOfOperations = Integer.parseInt(nm[1].trim());

    queries = new int[numberOfOperations][3];

    for (int queriesRowItr = 0; queriesRowItr < numberOfOperations; queriesRowItr++) {
      String[] queriesRowItems = input.nextLine().split(" ");

      for (int queriesColumnItr = 0; queriesColumnItr < 3; queriesColumnItr++) {
        int queriesItem = Integer.parseInt(queriesRowItems[queriesColumnItr].trim());
        queries[queriesRowItr][queriesColumnItr] = queriesItem;
      }
    }

    expected = output.nextLong();
  }

  @Test
  public void arrayManipulation() {
    long actual = ArrayManipulation.arrayManipulation(listSize, queries);

    assertThat(actual).isEqualTo(expected);
  }
}