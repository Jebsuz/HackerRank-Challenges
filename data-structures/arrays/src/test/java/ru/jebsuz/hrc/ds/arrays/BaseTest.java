package ru.jebsuz.hrc.ds.arrays;

import java.io.File;
import java.io.InputStream;
import java.util.Scanner;

public abstract class BaseTest {

  protected Scanner input;
  protected Scanner output;

  public BaseTest(InputStream input, File output) throws Exception {
    this.input = new Scanner(input);
    this.output = new Scanner(output);
  }
}

