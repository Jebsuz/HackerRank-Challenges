package ru.jebsuz.hrc.ctcic.datastructures;

import java.util.Scanner;

public abstract class BaseTest {

  protected Scanner input;
  protected Scanner output;

  public BaseTest(Scanner input, Scanner output) {
    this.input = input;
    this.output = output;
  }
}
