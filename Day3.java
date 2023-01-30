package adventForCode;

import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

class MainDay3 {
  public static void main(String[] args) throws FileNotFoundException {
    Day3 day3 = new Day3();
    day3.main();
  }
}

class Day3 {

  public void main() throws FileNotFoundException {
    Scanner textFile = new Scanner(Paths.get("C:\\day3.txt").toFile());
    String line;
    ArrayList<Rucksack> rucksacks = new ArrayList<>();
    int score = 0;

    while (textFile.hasNextLine()) {
      line = textFile.nextLine();
      String s1a = line.substring(0, ((line.length() / 2)));
      String s1b = line.substring((line.length() / 2));
      rucksacks.add(new Rucksack(s1a, s1b));
    }

    for (Rucksack rucksack: rucksacks) {
      score = score + rucksack.score;
    }
  }
}

class Alphabet {
  int score;
  char letter;

  Alphabet(int score, String letter) {
    this.score = score;
    this.letter = letter.charAt(0);
  }

  public int getScore() {
    return score;
  }

  public char getAlphabet() {
    return letter;
  }
}

class Rucksack {
  String firstHalf;
  String secondHalf;
  char duplicateChar;
  int score;
  static ArrayList<Alphabet> alphabetArrayList = new ArrayList<>();

  static {
    for (int i = 1; i < 53; i++) {
      alphabetArrayList.add(new Alphabet(i, "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".substring(i - 1, i)));
    }
  }

  Rucksack(String firstHalf, String secondHalf) {
    this.firstHalf = firstHalf;
    this.secondHalf = secondHalf;
    determineDuplicateChar();
    determineScore();
  }

  private void determineScore() {
    if (duplicateChar == '!') {
      this.score = 0;
    }
    for (Alphabet alphabet : alphabetArrayList) {
      if (alphabet.getAlphabet() == duplicateChar) {
        this.score = alphabet.getScore();
      }
    }
  }

  private void determineDuplicateChar() {
    char duplicate = '!';
    for (char c : firstHalf.toCharArray()) {
      for (char b: secondHalf.toCharArray()) {
        if (b == c){
          duplicate = b;
        };
      }
      this.duplicateChar = duplicate;
    }
  }
}
