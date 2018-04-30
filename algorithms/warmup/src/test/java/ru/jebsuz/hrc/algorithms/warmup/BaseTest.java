package ru.jebsuz.hrc.algorithms.warmup;

import java.io.File;
import java.io.InputStream;

public abstract class BaseTest {

  protected InputStream input;
  protected File output;

  public BaseTest(InputStream input, File output) {
    this.input = input;
    this.output = output;
  }

  static String getSamplesFolderName(Class clazz) {
    return clazz.getSimpleName();
  }
}
