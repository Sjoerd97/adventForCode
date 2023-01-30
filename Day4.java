package adventForCode;

import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;

class MainDay4 {

  public static void main(String[] args) throws FileNotFoundException {
    Day4 day4 = new Day4();
    day4.calculate();
  }

}

class Day4 {

  public void calculate() throws FileNotFoundException {
    try (Scanner textFile = new Scanner(Paths.get("C:\\day4.txt").toFile())) {
      String line;
      ArrayList<Cleaning> cleaning = new ArrayList<>();
      int overlapCounter = 0;
      while (textFile.hasNextLine()) {
        line = textFile.nextLine();
        String[] array = line.split(",");
        cleaning.add(new Cleaning(array[0], array[1]));
      }

      for (Cleaning cleaningObj : cleaning) {
        if (cleaningObj.overlap) {
          overlapCounter++;
        }
      }

      System.out.println(overlapCounter);
    }
  }
}

class Cleaning {

  String firstRangeStr;
  String secondRangeStr;
  int[] firstRange;
  int[] secondRange;
  boolean overlap;

  Cleaning(String firstRangeStr, String secondRangeStr) {
    this.firstRangeStr = firstRangeStr;
    this.secondRangeStr = secondRangeStr;
    calculateRange();
    calculateOverlap();
  }

  private void calculateRange() {
    String[] arrayFirstRange = firstRangeStr.split("-");
    String[] arraySecondRange = secondRangeStr.split("-");

    this.firstRange = IntStream.rangeClosed(Integer.parseInt(arrayFirstRange[0]),
        Integer.parseInt(arrayFirstRange[1])).toArray();

    this.secondRange = IntStream.rangeClosed(Integer.parseInt(arraySecondRange[0]),
        Integer.parseInt(arraySecondRange[1])).toArray();
  }

  private void calculateOverlap() {
    int overlapCount = 0;
    for (int firstRangeCount : firstRange) {
      for (int secondRangeCount : secondRange) {
        if (secondRangeCount == firstRangeCount) {
          overlapCount++;
        }
      }
    }
    if (overlapCount == firstRange.length || overlapCount == secondRange.length) {
      this.overlap = true;
    }
  }
}