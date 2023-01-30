package adventForCode;

import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class main {

  public static void main(String[] args) throws FileNotFoundException {
    Day5 day5 = new Day5();
    day5.moveCrates();
  }
}

class Day5 {
  static List<String> elf1 = new ArrayList<>(Arrays.asList("V", "N", "F", "S", "M", "P", "H", "J"));
  static List<String> elf2 = new ArrayList<>(Arrays.asList("Q", "D", "J", "M", "L", "R", "S"));
  static List<String> elf3 = new ArrayList<>(Arrays.asList("B", "W", "S", "C", "H", "D", "Q", "N"));
  static List<String> elf4 = new ArrayList<>(Arrays.asList("L", "C", "S", "R"));
  static List<String> elf5 = new ArrayList<>(Arrays.asList("B", "F", "P", "T", "V", "M"));
  static List<String> elf6 = new ArrayList<>(Arrays.asList("C", "N", "Q", "R", "T"));
  static List<String> elf7 = new ArrayList<>(Arrays.asList("R", "V", "G"));
  static List<String> elf8 = new ArrayList<>(Arrays.asList("R", "L", "D", "P", "S", "Z", "C"));
  static List<String> elf9 = new ArrayList<>(Arrays.asList("F", "B", "P", "G", "V", "J", "S", "D"));

  public void moveCrates() throws FileNotFoundException {

    ArrayList<Instruction> instruction = new ArrayList<>();

    try (Scanner textFile = new Scanner(Paths.get("C:git\\AdventForCode\\resources\\day5.txt")
        .toFile())) {
      String line;
      int count = 0;
      while (textFile.hasNextLine()) {
        line = textFile.nextLine();
        String[] array = line.split(" ");
        instruction.add(new Instruction(array[1], array[3], array[5]));
        doMoveCrates(instruction.get(count));
        count++;
      }
      System.out.println(elf1.get(0) +
          elf2.get(0) +
          elf3.get(0) +
          elf4.get(0) +
          elf5.get(0) +
          elf6.get(0) +
          elf7.get(0) +
          elf8.get(0) +
          elf9.get(0));
    }
  }

  private void doMoveCrates(Instruction instruction) {
    for (String moveable : instruction.getReferenceSource().subList(0, instruction.getAmount())) {
      instruction.getReferenceDestination().add(0, moveable);
    }
    for (int i = 0; i < instruction.getAmount(); i++) {
      instruction.getReferenceSource().remove(0);
    }
  }

}

class Instruction {

  private Integer amount;
  private List<String> referenceSource;
  private List<String> referenceDestination;

  public Instruction(String amount, String source, String destination) {
    this.amount = Integer.parseInt(amount);
    setSource(source);
    setDestination(destination);
  }

  private void setDestination(String destination) {
    switch (destination) {
      case "1":
        this.referenceDestination = Day5.elf1;
        break;
      case "2":
        this.referenceDestination = Day5.elf2;
        break;
      case "3":
        this.referenceDestination = Day5.elf3;
        break;
      case "4":
        this.referenceDestination = Day5.elf4;
        break;
      case "5":
        this.referenceDestination = Day5.elf5;
        break;
      case "6":
        this.referenceDestination = Day5.elf6;
        break;
      case "7":
        this.referenceDestination = Day5.elf7;
        break;
      case "8":
        this.referenceDestination = Day5.elf8;
        break;
      case "9":
        this.referenceDestination = Day5.elf9;
        break;
    }
  }

  private void setSource(String source) {
    switch (source) {
      case "1":
        this.referenceSource = Day5.elf1;
        break;
      case "2":
        this.referenceSource = Day5.elf2;
        break;
      case "3":
        this.referenceSource = Day5.elf3;
        break;
      case "4":
        this.referenceSource = Day5.elf4;
        break;
      case "5":
        this.referenceSource = Day5.elf5;
        break;
      case "6":
        this.referenceSource = Day5.elf6;
        break;
      case "7":
        this.referenceSource = Day5.elf7;
        break;
      case "8":
        this.referenceSource = Day5.elf8;
        break;
      case "9":
        this.referenceSource = Day5.elf9;
        break;
    }
  }

  public List<String> getReferenceSource() {
    return this.referenceSource;
  }

  public Integer getAmount() {
    return amount;
  }

  public List<String> getReferenceDestination() {
    return this.referenceDestination;
  }
}