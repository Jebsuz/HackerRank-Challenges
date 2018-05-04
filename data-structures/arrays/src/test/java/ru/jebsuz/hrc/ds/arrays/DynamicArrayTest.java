package ru.jebsuz.hrc.ds.arrays;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import ru.jebsuz.hrc.common.SamplesLoader;

@RunWith(Parameterized.class)
public class DynamicArrayTest extends BaseTest {

  private int numberOfSequences;
  private int[][] queries;
  private int[] expected;

  public DynamicArrayTest(Scanner input, Scanner output) {
    super(input, output);
  }

  @Parameters
  public static Collection<Object[]> parameters() {
    return SamplesLoader.load(DynamicArray.class);
  }

  @Before
  public void setUp() {

    String[] nq = input.nextLine().split(" ");

    numberOfSequences = Integer.parseInt(nq[0].trim());

    int numberOfQueries = Integer.parseInt(nq[1].trim());

    queries = new int[numberOfQueries][3];

    for (int queriesRowItr = 0; queriesRowItr < numberOfQueries; queriesRowItr++) {
      String[] queriesRowItems = input.nextLine().split(" ");

      for (int queriesColumnItr = 0; queriesColumnItr < 3; queriesColumnItr++) {
        int queriesItem = Integer.parseInt(queriesRowItems[queriesColumnItr].trim());
        queries[queriesRowItr][queriesColumnItr] = queriesItem;
      }
    }

    List<Integer> tempList = new ArrayList<>();
    while (output.hasNextInt()) {
      tempList.add(output.nextInt());
    }
    expected = tempList.stream().mapToInt(Integer::valueOf).toArray();
  }

  @Test
  public void dynamicArray() {
    int[] actual = DynamicArray.dynamicArray(numberOfSequences, queries);

    assertThat(actual).containsExactly(expected);
  }
}