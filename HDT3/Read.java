/**
 * @author: Sofia Garcia, Diego Duarte, Marcela Cordon 
 * @since:5/02/2023
 **/


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Read {
  private static final int values = 3000;
  private static final String filename = "3k.csv";

  
  /** Es para ver si el archivo ya existe y si sí, se lee, si no crea el archivo csv
   * @return int[]
   */
  public int[] readOrCreateFile() {
    File file = new File(filename);

    if (file.exists()) {

      return readFile(file);

    } else {

      createFile(file);
      return new int[0];
    }
  }

    /** función para leer el archivo
   * @return int[]
   */
  private int[] readFile(File file) {
    List<Integer> numbers = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = br.readLine()) != null) {
        numbers.add(Integer.parseInt(line));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return numbers.stream().mapToInt(i -> i).toArray();
  }

    /** Crea el archivo csv con los 3k random numbers en caso de que no exista 
   * 
   */
  private void createFile(File file) {
    try (FileWriter writer = new FileWriter(file)) {
      Random random = new Random();
      for (int i = 0; i < values; i++) {
        int number = random.nextInt(1,3000);
        writer.write(String.valueOf(number));
        writer.write("\n");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

