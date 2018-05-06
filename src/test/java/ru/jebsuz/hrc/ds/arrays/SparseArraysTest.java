package ru.jebsuz.hrc.ds.arrays;

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
public class SparseArraysTest extends BaseTest {

  private int numberOfStrings;
  private int numberOfQueries;
  private String[] collectionOfStrings;
  private int[] expected;

  public SparseArraysTest(Scanner input, Scanner output) {
    super(input, output);
  }

  @Parameters
  public static Collection<Object[]> parameters() {
    return SamplesLoader.load(SparseArrays.class);
  }

  @Before
  public void setUp() {
    numberOfStrings = input.nextInt();
    input.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

    collectionOfStrings = new String[numberOfStrings];

    for (int stringsItr = 0; stringsItr < numberOfStrings; stringsItr++) {
      String stringsItem = input.nextLine();
      input.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");
      collectionOfStrings[stringsItr] = stringsItem;
    }

    numberOfQueries = input.nextInt();
    input.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

    expected = collectResult(output);
  }

  private int[] collectResult(Scanner scanner) {
    int[] result = new int[numberOfQueries];
    for (int i = 0; i < result.length; i++) {
      result[i] = scanner.nextInt();
    }

    return result;
  }

  @Test
  public void findSuffix() {
    try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
      System.setOut(new PrintStream(baos));

      for (int i = 0; i < numberOfQueries; i++) {
        String queryString = input.nextLine();
        input.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int result = SparseArrays.findSuffix(collectionOfStrings, queryString);

        System.out.println(result);
      }
      int[] actual = collectResult(new Scanner(baos.toString()));

      assertThat(actual).containsExactly(expected);
    } catch (IOException e) {
      fail();
    }
  }
}