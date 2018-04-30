package ru.jebsuz.hrc.common;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;
import java.util.Scanner;
import org.junit.Test;

public class SamplesLoaderTest {

  @Test
  public void should_load_all_test_samples() {
    int expected = 3;
    Collection<Object[]> samples = SamplesLoader.load(SamplesLoader.class);
    int actual = samples.size();

    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void should_load_in_correct_pairs() {
    Collection<Object[]> samples = SamplesLoader.load(SamplesLoader.class);

    for (Object[] sample : samples) {
      Scanner input = (Scanner) sample[0];
      String inputLine = input.nextLine();
      Scanner output = (Scanner) sample[1];
      String outputLine = output.nextLine();

      assertThat(inputLine.equals(outputLine)).isTrue();
    }
  }
}