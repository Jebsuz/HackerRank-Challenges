package ru.jebsuz.hrc.common;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SamplesLoader {

  private static final String PATH_DELIMITER = "/";
  private static final String INPUT = "input";
  private static final String OUTPUT = "output";

  public static Collection<Object[]> load(Class clazz) {
    final File rootFolder = getRootFolder(clazz.getSimpleName());
    validateRootFolderStructure(rootFolder);
    File inputSamples = getFolder(rootFolder, INPUT);
    if (!inputSamples.canRead()) {
      throw new RuntimeException("Can't read input samples");
    }
    File outputSamples = getFolder(rootFolder, OUTPUT);
    if (!outputSamples.canRead()) {
      throw new RuntimeException("Can't read output samples");
    }
    if (missmatchNumberOfSamples(inputSamples, outputSamples)) {
      throw new RuntimeException("Input samples count doesn't match output count");
    }
    final File[] inputs = inputSamples.listFiles();
    final File[] outputs = outputSamples.listFiles();
    Arrays.sort(inputs);
    Arrays.sort(outputs);
    List<Object[]> samples = new ArrayList<>();
    for (int i = 0; i < inputs.length; i++) {
      Scanner input = getScannerFor(inputs[i]);
      Scanner output = getScannerFor(outputs[i]);
      samples.add(new Object[]{input, output});
    }

    return samples;
  }

  private static Scanner getScannerFor(File input) {
    try {
      return new Scanner(input);
    } catch (FileNotFoundException e) {
      log.error(e.getMessage(), e);
      throw new RuntimeException(e);
    }
  }

  private static boolean missmatchNumberOfSamples(File inputSamples, File outputSamples) {
    return inputSamples.list().length != outputSamples.list().length;
  }

  private static File getFolder(File rootFolder, String folderName) {
    return new File(rootFolder.getAbsolutePath() + PATH_DELIMITER + folderName);
  }

  private static void validateRootFolderStructure(File rootFolder) {
    String[] rootFolderContent = rootFolder.list();
    if (notContainsFolder(rootFolderContent, INPUT)) {
      throw new RuntimeException("Missing input folder");
    }
    if (notContainsFolder(rootFolderContent, OUTPUT)) {
      throw new RuntimeException("Missing output folder");
    }
  }

  private static boolean notContainsFolder(String[] rootFolderContent, String folderName) {
    return Stream.of(rootFolderContent).noneMatch(s -> s.equals(folderName));
  }

  private static File getRootFolder(String folderName) {
    final URL folderURL = ClassLoader.getSystemResource(folderName);
    try {
      return new File(folderURL.toURI());
    } catch (URISyntaxException e) {
      log.error(e.getMessage(), e);
      throw new RuntimeException("Failed to load root folder");
    }
  }
}
