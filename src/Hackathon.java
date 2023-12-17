import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import connection.Connection;
import connection.TeamConnection;
import connection.UserConnection;
import models.User;
import models.Team;
import repository.TeamRepository;
import repository.UserRepository;

public class Hackathon {
  private UserConnection uc = UserConnection.getInstance(); // singleton
  private TeamConnection tc = TeamConnection.getInstance();
  private UserRepository ur = new UserRepository();
  private TeamRepository tr = new TeamRepository();
  private Scanner scanner = new Scanner(System.in);

  

  // TODO: find one 1 user
    public User findUser(String column, String[] condition, Boolean joinTable, String joinTableName, Connection<User> conn) {
        
        return ur.findOne(column, condition, joinTable, joinTableName, conn);
    }

    public void findUsers(String column, String[] condition, boolean joinTable, String joinTableName, Connection<User> conn) {

        ArrayList<User> userList = ur.find(column, condition, joinTable, joinTableName, conn);

        if (userList != null && !userList.isEmpty()) {
            for (User user : userList) {
                System.out.println("nim: " + user.nim);
                System.out.println("name: " + user.name);
                System.out.println("id: " + user.id);
                System.out.println("-------------");
            }
        } else {
            System.out.println("Data not found");
        }
    }

    // TODO: insert one user
public void insertUser() {
  System.out.print("Enter user name: ");
  String name = scanner.nextLine();
  boolean isValidNIM = false;
  String nim = null;
  do {
      System.out.print("Enter user NIM: ");
      nim = scanner.nextLine();
      if (nim.matches("^[1-9]\\d*$")) {
          isValidNIM = true;
      } else {
          System.out.println("Invalid NIM. Please enter a valid numeric value.");
      }
  } while (!isValidNIM);

  System.out.print("Enter team ID for the user: ");
  int teamId = scanner.nextInt();
  ur.insert(new String[] { nim, name, String.valueOf(teamId) }, uc);
  System.out.println("User inserted successfully.");
}


    // TODO: find one team
    public void findTeam() {
        System.out.print("Enter team ID: ");
        int teamId = scanner.nextInt();
        Team team = tr.findOne("id", new String[] { String.valueOf(teamId) }, false, null, tc);
        
        
        if (team != null) {
            System.out.println("Found Team: " + team.name);
        } else {
            System.out.println("Team not found");
        }
    }

    // TODO: find many teams
    public void findTeams() {
        List<Team> teamList = tr.find("column", new String[] { "condition" }, false, null, tc);
        

        
        for (Team team : teamList) {
            System.out.println("Team: " + team.name);
        }
    }

    // TODO: insert one team
    public void insertTeam() {
        System.out.print("Enter team name: ");
        String name = scanner.nextLine();
        tr.insert(new String[] { name }, tc);
        System.out.println("Team inserted successfully.");
    }
}
