package ru.jebsuz.hrc.algorithms.warmup;

import java.util.Scanner;

public abstract class BaseTest {

  protected Scanner input;
  protected Scanner output;

  public BaseTest(Scanner input, Scanner output) {
    this.input = input;
    this.output = output;
  }
}
