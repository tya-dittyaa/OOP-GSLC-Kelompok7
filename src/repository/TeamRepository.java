package repository;

import java.util.ArrayList;

import connection.Connection;
import connection.TeamConnection;
import connection.UserConnection;
import models.Team;
import models.User;

public class TeamRepository implements Repository<Team> {
  UserConnection uc = new UserConnection();
  TeamConnection ut = new TeamConnection();

  ArrayList<User> userData = uc.readFile();
  ArrayList<Team> teamData = ut.readFile();
  ArrayList<Team> res = new ArrayList<>();

  @Override
  public ArrayList<Team> find(String column, String[] condition, boolean joinTable, String joinTableName, Connection<Team> conn) {
    if (column == null && condition != null) {
      System.err.println("Error: Kolom filter null, tapi ada kondisi filter.");
      return null;
    }

    if (column != null && condition == null) {
      System.err.println("Error: Kondisi filter tidak null, tapi kolom filter null.");
      return null;
    }

    if (joinTableName == null && joinTable != false && joinTable) {
      System.err.println("Error: Nama table join null, tapi boolean kondisi join true.");
      return null;
    }

    if (joinTableName != null && joinTable == false) {
      System.err.println("Error: Nama table join ada, tapi boolean kondisi join null.");
      return null;
    }

    if (column != null && column.isEmpty()) {
      System.err.println("Error: Nama kolom filter tidak boleh kosong.");
      return null;
    }

    if (joinTableName != null && joinTableName.isEmpty()) {
      System.err.println("Error: Nama table join tidak boleh kosong.");
      return null;
    }

    String firstCond = condition[1]; // operation =, <>
    String secCond = condition[2]; // where op. 
  
    switch (column) {
      case "id":
        if(firstCond.equals("=")) { // equal operator
          for (Team team : teamData) {
            if(team.id == Integer.parseInt(secCond)) {
              res.add(team);
            }
          }
        }

        break;
    
      case "team name":
        if(firstCond.equals("=")) { // equal operator
          for (Team team : teamData) {
            if(team.name.equals(secCond) == true) {
              res.add(team);
            }
          }
        }

        break;
      }

      return res;
  }

  @Override
  public Team findOne(String column, String[] condition, boolean joinTable, String joinTableName, Connection<Team> conn) {
    Team res = null;

    if (column == null && condition != null) {
      System.err.println("Error: Kolom filter null, tapi ada kondisi filter.");
      return null;
    }

    if (column != null && condition == null) {
      System.err.println("Error: Kondisi filter tidak null, tapi kolom filter null.");
      return null;
    }

    if (joinTableName == null && joinTable != false && joinTable) {
      System.err.println("Error: Nama table join null, tapi boolean kondisi join true.");
      return null;
    }

    if (joinTableName != null && joinTable == false) {
      System.err.println("Error: Nama table join ada, tapi boolean kondisi join null.");
      return null;
    }

    if (column != null && column.isEmpty()) {
      System.err.println("Error: Nama kolom filter tidak boleh kosong.");
      return null;
    }

    if (joinTableName != null && joinTableName.isEmpty()) {
      System.err.println("Error: Nama table join tidak boleh kosong.");
      return null;
    }

    // --- 
    
    String firstCond = condition[1]; // operation =, <>
    String secCond = condition[2]; // where op. 
  
    switch (column) {
      case "id":
        if(firstCond.equals("=")) { // equal operator
          for (Team team : teamData) {
            if(team.id == Integer.parseInt(secCond)) {
              res = team;
            }
          }
        }

        break;
    
      case "team name":
        if(firstCond.equals("=")) { // equal operator
          for (Team team : teamData) {
            if(team.name.equals(secCond) == true) {
              res = team;
            }
          }
        }

        break;
      }

      return res;
  }

  @Override
  public Team insert(String[] data, Connection<Team> conn) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'insert'");
  }
    //number of team members based on team ID
    public int getTeamMemberCount(int teamId, Connection<Team> conn) {
      ArrayList<Team> teamMembers = find("id", new String[] { String.valueOf(teamId) }, true, "team_members", conn);
      return teamMembers.size();
  }
}
