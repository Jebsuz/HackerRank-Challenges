package ru.jebsuz.hrc.ds.linkedlists;

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
import ru.jebsuz.hrc.ds.arrays.BaseTest;
import ru.jebsuz.hrc.ds.linkedlists.PrintElementsOfLinkedList.Node;

@RunWith(Parameterized.class)
public class PrintElementsOfLinkedListTest extends BaseTest {

  private String[] expected;
  private List<Node> inputSample;
  private PrintElementsOfLinkedList printer;
  private int numberOfElements;

  public PrintElementsOfLinkedListTest(Scanner input, Scanner output) {
    super(input, output);
  }

  @Parameters
  public static Collection<Object[]> data() {
    return SamplesLoader.load(PrintElementsOfLinkedList.class);
  }

  @Before
  public void setUp() {
    inputSample = new ArrayList<>();
    numberOfElements = 0;
    while (input.hasNextLine()) {
      Node node = new Node();
      inputSample.add(node);
      Node previousNode = null;
      for (String s : input.nextLine().split(" ")) {
        numberOfElements++;
        node.data = Integer.parseInt(s);
        node.next = new Node();
        previousNode = node;
        node = node.next;
      }
      if (previousNode != null) {
        previousNode.next = null;
      }
    }

    expected = new String[numberOfElements];
    int i = 0;
    while (i < numberOfElements) {
      expected[i++] = output.nextLine();
    }

    printer = new PrintElementsOfLinkedList();
  }

  @Test
  public void Print() {
    try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
      System.setOut(new PrintStream(baos));

      for (Node node : inputSample) {
        printer.Print(node);
      }

      String[] actual = new String[numberOfElements];
      Scanner scanner = new Scanner(baos.toString());
      int i = 0;
      while (i < numberOfElements) {
        actual[i++] = scanner.nextLine();
      }

      assertThat(actual).containsExactly(expected);
    } catch (IOException e) {
      fail();
    }
  }
}