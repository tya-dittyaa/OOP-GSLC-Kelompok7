package connection;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import models.User;

public class UserConnection implements Connection<User> {

  private String filePath = "src/database/user.csv";

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

    } catch (Exception e) {
      // TODO: handle exception
    }

    return data;
  }

  @Override
  public void writeFile(ArrayList<User> data) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'writeFile'");
  }

}
