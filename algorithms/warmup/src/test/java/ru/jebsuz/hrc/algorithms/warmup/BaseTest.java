package ru.jebsuz.hrc.algorithms.warmup;

import java.io.File;
import java.io.InputStream;

public abstract class BaseTest {

  protected InputStream input;
  protected File output;

  public BaseTest(File output, InputStream input) {
    this.output = output;
    this.input = input;
  }

  static String getSamplesFolderName(Class clazz) {
    return clazz.getSimpleName();
  }
}
