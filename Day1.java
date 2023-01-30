package adventForCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

class Advent {

  public static void main(String[] n) throws FileNotFoundException {
    ArrayList<Integer> integers = new ArrayList<>();
    Path path = Paths.get("C:\\advent.txt");
    File file = path.toFile();
    Scanner textFile = new Scanner(file);
    String line;
    int[] intermediateArray = new int[10000];
    int i = 0;

    while (textFile.hasNextLine()) {
      line = textFile.nextLine();
      if (!line.isBlank() || !line.isEmpty()) {
        intermediateArray[i] = Integer.parseInt(line);
        i++;
      } else {
        integers.add(Arrays.stream(intermediateArray).sum());
        intermediateArray = new int[10000];
      }
    }
    System.out.println(Collections.max(integers));
    integers.remove(Collections.max(integers));
    System.out.println(Collections.max(integers));
    integers.remove(Collections.max(integers));
    System.out.println(Collections.max(integers));
  }
}