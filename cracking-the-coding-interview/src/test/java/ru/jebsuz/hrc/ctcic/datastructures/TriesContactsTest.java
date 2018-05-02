package ru.jebsuz.hrc.ctcic.datastructures;

import static junit.framework.TestCase.fail;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import ru.jebsuz.hrc.common.SamplesLoader;

@RunWith(Parameterized.class)
public class TriesContactsTest extends BaseTest {

  private List<Operation> operations;
  private List<String> expected;

  public TriesContactsTest(Scanner input, Scanner output) {
    super(input, output);
  }

  @Parameters
  public static Collection<Object[]> parameters() {
    return SamplesLoader.load(TriesContacts.class);
  }

  @Before
  public void setUp() {
    operations = new ArrayList<>();
    int n = input.nextInt();
    for (int a0 = 0; a0 < n; a0++) {
      String operation = input.next();
      String contact = input.next();
      operations.add(new Operation(operation, contact));
    }

    expected = readOutputToList(output);
  }

  private List<String> readOutputToList(Scanner output) {
    List<String> listOfOutput = new ArrayList<>();
    while (output.hasNext()) {
      listOfOutput.add(output.nextLine());
    }

    return listOfOutput;
  }

  @Test
  public void solution() {
    try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
      System.setOut(new PrintStream(byteArrayOutputStream));
      for (int i = 0; i < operations.size(); i++) {
        Operation operation = operations.get(i);
        if ("add".equals(operation.operation)) {
          TriesContacts.add(operation.contact);
        }
        if ("find".equals(operation.operation)) {
          TriesContacts.find(operation.contact);
        }
      }
      List<String> actual = readOutputToList(new Scanner(byteArrayOutputStream.toString()));

      assertThat(actual).containsExactlyElementsOf(expected);
    } catch (IOException e) {
      fail();
    }
  }

  static class Operation {

    String operation;
    String contact;

    Operation(String operation, String contact) {
      this.operation = operation;
      this.contact = contact;
    }
  }
}