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
public class TimeConversionTest extends BaseTest {

  private String inputTime;
  private String expected;

  public TimeConversionTest(InputStream input, File output) {
    super(input, output);
  }

  @Parameters
  public static Collection<Object[]> parameters() {
    return SamplesLoader.load(getSamplesFolderName(TimeConversion.class));
  }

  @Before
  public void setUp() throws Exception {
    Scanner inputSample = new Scanner(input);
    inputTime = inputSample.nextLine();

    Scanner outputSample = new Scanner(output);
    expected = outputSample.nextLine();
  }

  @Test
  public void timeConversion() {
    final String actual = TimeConversion.timeConversion(inputTime);

    assertThat(actual.equals(expected)).isTrue();
  }
}
