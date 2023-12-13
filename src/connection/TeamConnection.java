package connection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import models.Team;

/**
 * UserConnection
 */
public class TeamConnection implements Connection<Team> {

  private static TeamConnection conn; // singleton
  private File filePath = new File("src/database/teams.csv");

  public static TeamConnection getInstance() {
    if (TeamConnection.conn == null) {
      TeamConnection.conn = new TeamConnection();
    }
    return TeamConnection.conn;
  }

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
      fileInput.close();

      return data;
    } catch (Exception e) {
      // TODO: handle exception
      return null;
    }

  }

  @Override
  public boolean writeFile(Team data) {
    try {
      FileWriter fileOutput = new FileWriter(filePath, true);
      BufferedWriter writer = new BufferedWriter(fileOutput);

      String lineToInput = String.format("%d,%s\n", data.id, data.name);
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