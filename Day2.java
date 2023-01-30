package adventForCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class MainDay2 {
  public static void main(String[] args) throws FileNotFoundException {
    Day2 day2 = new Day2();
    day2.main();
  }
}

class Day2 {
  ArrayList<Integer> score = new ArrayList<>();
  List<Score> arrayList = new ArrayList<>();

  public void main() throws FileNotFoundException {
    Path path = Paths.get("C:\\day2.txt");
    File file = path.toFile();
    Scanner textFile = new Scanner(file);
    String line;

    while (textFile.hasNextLine()) {
      line = textFile.nextLine();
      String[] splited = line.split("\\s+");
      Score score = new Score(splited[0], splited[1]);
      arrayList.add(score);
    }
    System.out.println(arrayList.get(0).score);
    calculateScore();
  }

  private void calculateScore() {
    score = (ArrayList<Integer>) arrayList.stream()
        .map(Score::getScore)
        .collect(Collectors.toList());

    int sum = score.stream().mapToInt(Integer::intValue).sum();
    System.out.println(sum);
  }
}

class Score {
  String elfScore;
  String yourScore;
  int score;

  Score(String elfScore, String yourScore) {
    this.elfScore = elfScore;
    this.yourScore = yourScore;
    determineScore();
  }

  public int getScore() {
    return score;
  }

  public void determineScore() {
    if (elfScore.equals("A") && yourScore.equals("X")) {
      this.score = 0 + 3 ;
    }
    if (elfScore.equals("A") && yourScore.equals("Y")) {
      this.score = 3 + 1;
    }
    if (elfScore.equals("A") && yourScore.equals("Z")) {
      this.score = 6 + 2;
    }
    if (elfScore.equals("B") && yourScore.equals("X")) {
      this.score = 0 + 1;
    }
    if (elfScore.equals("B") && yourScore.equals("Y")) {
      this.score = 3 + 2;
    }
    if (elfScore.equals("B") && yourScore.equals("Z")) {
      this.score = 6 + 3;
    }
    if (elfScore.equals("C") && yourScore.equals("X")) {
      this.score = 0 + 2;
    }
    if (elfScore.equals("C") && yourScore.equals("Y")) {
      this.score = 3 + 3;
    }
    if (elfScore.equals("C") && yourScore.equals("Z")) {
      this.score = 6 + 1;
    }
  }

}
