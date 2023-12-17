package connection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import models.User;

public class UserConnection implements Connection<User> {

  private static UserConnection conn; // singleton
  private File filePath = new File("src/database/user.csv");

  public static UserConnection getInstance() {
    if (UserConnection.conn == null) {
      UserConnection.conn = new UserConnection();
    }
    return UserConnection.conn;
  }

  @Override
  public ArrayList<User> readFile() {
    ArrayList<User> data = new ArrayList<>();

    try {
      FileReader fileInput = new FileReader(filePath);
      BufferedReader reader = new BufferedReader(fileInput);

      reader.readLine();
      String line;

      while ((line = reader.readLine()) != null) {
        String[] splitResult = line.split(",");
        String nim = splitResult[0];
        String name = splitResult[1];
        Integer teamId = Integer.parseInt(splitResult[2]);

        data.add(new User(nim, name, teamId));
      }

      reader.close();
      return data;
    } catch (Exception e) {
      // TODO: handle exception
      return null;
    }

  }

  @Override
  public boolean writeFile(User data) {
    try {
      FileWriter fileOutput = new FileWriter(filePath, true);
      BufferedWriter writer = new BufferedWriter(fileOutput);

      String lineToInput = String.format("%s,%s,%d\n", data.nim, data.name, data.id);
      writer.write(lineToInput);

      writer.close();
      fileOutput.close();

      return true;

    } catch (Exception e) {
      // TODO: handle exception
      return false;
    }
  }

}
