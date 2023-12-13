package connection;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import models.Team;

/**
 * UserConnection
 */
public class TeamConnection implements Connection<Team> {

  private String filePath = "src/database/teams.csv";

  @Override
  public ArrayList<Team> readFile() {
    ArrayList<Team> data = new ArrayList<>();

    try {
      FileReader fileInput = new FileReader(filePath);
      BufferedReader reader = new BufferedReader(fileInput);

      reader.readLine();
      String line;

      while ((line = reader.readLine()) != null) {
        String[] splitResult = line.split(",");
        int teamId = Integer.parseInt(splitResult[0]);
        String teamName = splitResult[1];

        data.add(new Team(teamId, teamName));
      }

      reader.close();

    } catch (Exception e) {
      // TODO: handle exception
    }

    return data;
  }

  @Override
  public void writeFile(ArrayList<Team> data) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'writeFile'");
  }

}