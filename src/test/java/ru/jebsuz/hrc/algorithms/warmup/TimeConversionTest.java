package ru.jebsuz.hrc.algorithms.warmup;

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
public class TimeConversionTest extends BaseTest {

  private String inputTime;
  private String expected;

  public TimeConversionTest(Scanner input, Scanner output) {
    super(input, output);
  }

  @Parameters
  public static Collection<Object[]> parameters() {
    return SamplesLoader.load(TimeConversion.class);
  }

  @Before
  public void setUp() {
    inputTime = input.nextLine();

    expected = output.nextLine();
  }

  @Test
  public void timeConversion() {
    final String actual = TimeConversion.timeConversion(inputTime);

    assertThat(actual.equals(expected)).isTrue();
  }
}
