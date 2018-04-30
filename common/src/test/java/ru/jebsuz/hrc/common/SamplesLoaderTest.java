package ru.jebsuz.hrc.common;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;
import org.junit.Test;

public class SamplesLoaderTest {

  @Test
  public void should_load_all_test_samples() throws Exception {
    int expected = 2;
    Collection<Object[]> samples = SamplesLoader.load("SamplesLoader");
    int actual = samples.size();

    assertThat(actual).isEqualTo(expected);
  }
}