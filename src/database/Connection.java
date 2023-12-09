package database;

import java.io.BufferedReader;
import java.io.FileReader;

public class Connection {
  public static void testing() {
    try {
      FileReader fileInput = new FileReader("src/database/user.csv");
      BufferedReader reader = new BufferedReader(fileInput);

      reader.readLine();

      String line;
      while ((line = reader.readLine()) != null) {
        String[] splitResult = line.split(",");
        String nim = splitResult[0];
        String name = splitResult[1];
        Integer team = Integer.parseInt(splitResult[2]);
        System.out.printf("NIM: %s | Name: %s | Team: %d\n", nim, name, team);
      }

      reader.close();
    } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
    }
  }
}
