package database;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Connection {
  // team
  public void readTeam() {
    try {
      FileReader fileInput = new FileReader("src/database/teams.csv");
      BufferedReader reader = new BufferedReader(fileInput);

      reader.readLine();

      String line;

      while ((line = reader.readLine()) != null) {
          String[] splitResult = line.split(",");
          String nim = splitResult[0];
          String teamName = splitResult[1];

          // display (test)
          // System.out.printf("NIM: %s | Team Name: %s\n", nim, teamName);
      }
      reader.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
  }

  public void writeTeam(String teamName, int id) {
    try {
      FileWriter fileInput = new FileWriter("src/database/teams.csv", true);
      BufferedWriter writer = new BufferedWriter(fileInput);

      writer.write(id + "," + teamName);

      writer.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
  }

  // user
  public void readUser() {
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

        // display (test)
        // System.out.printf("NIM: %s | Name: %s | Team: %d\n", nim, name, team);
      }

      reader.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
  }

  public void writeUser(String name, String nim, int id) {
    try {
      FileWriter fileInput = new FileWriter("src/database/user.csv", true);
      BufferedWriter writer = new BufferedWriter(fileInput);

      // if the team is not full then insert user into the team
      if(checkTeamCapacity(id) == true) {
        writer.write(nim + "," + name + "," + id);
      }
      else {
        System.out.println("Team full!");
      }
      
      writer.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
  }

  public boolean checkTeamCapacity(int id) {
    try {
        FileReader fileInput = new FileReader("src/database/user.csv");
        BufferedReader reader = new BufferedReader(fileInput);

        reader.readLine();

        String line;
        int count = 0;           

        while ((line = reader.readLine()) != null) {
          String[] splitResult = line.split(",");
          String nim = splitResult[0];
          String name = splitResult[1];
          Integer teamID = Integer.parseInt(splitResult[2]);

          // check if there are 3 ppl in the team
          if(teamID == id && count < 3) {
            count++;
          }
          else if(count == 3){
            System.out.println("Team full!");
            return false;
          }          
        }
        reader.close();
    } catch (Exception e) {
        e.printStackTrace();
    }

    return true;
  }

}

