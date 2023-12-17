package repository;

import java.util.ArrayList;

import connection.Connection;
import connection.TeamConnection;
import connection.UserConnection;
import models.Team;
import models.User;

public class UserRepository implements Repository<User> {
  UserConnection uc = new UserConnection();
  TeamConnection ut = new TeamConnection();

  ArrayList<User> userData = uc.readFile();
  ArrayList<Team> teamData = ut.readFile();
  ArrayList<User> res = new ArrayList<>();

  @Override
  public ArrayList<User> find(String column, String[] condition, boolean joinTable, String joinTableName, Connection<User> conn) {

    // validasi param
    // select *
    if(column == null && condition == null && joinTable == false && joinTableName == null){    
      return userData;
    }

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
          for (User user : userData) {
            if(user.id == Integer.parseInt(secCond)) {
              res.add(user);

              // join table
              // for (Team team : teamData) {
              //   if(user.id == team.id) {
              //     System.out.println("team name: " + team.name);
              //     break;
              //   }
              // }

            }
          }
        }

        break;
    
      case "nim":
        if(firstCond.equals("=")) { // equal operator
          for (User user : userData) {
            if(user.nim.equals(secCond) == true) {
              res.add(user);

              // join table
              // for (Team team : teamData) {
              //   if(user.id == team.id) {
              //     System.out.println("team name: " + team.name);
              //     break;
              //   }
              // }

            }
          }
        }

        break;

      case "name":
        int theID = 0; 

        if(firstCond.equals("=")) { // equal operator
          for (User user : userData) {
            if(user.name.toLowerCase().contains(secCond) == true) {
              res.add(user);

              // join table
              // for (Team team : teamData) {
              //   if(user.id == team.id) {
              //     System.out.println("team name: " + team.name);
              //   }
              // }

            }
          }
        }

        break;
      }

      return res;
  }

  @Override
  public User findOne(String column, String[] condition, boolean joinTable, String joinTableName, Connection<User> conn) {
    User res = null;

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
          for (User user : userData) {
            if(user.id == Integer.parseInt(secCond)) {
              res = user;

              // join table
              // for (Team team : teamData) {
              //   if(user.id == team.id) {
              //     System.out.println("team name: " + team.name);
              //     break;
              //   }
              // }

            }
          }
        }

        break;
    
      case "nim":
        if(firstCond.equals("=")) { // equal operator
          for (User user : userData) {
            if(user.nim.equals(secCond) == true) {
              res = user;

              // join table
              // for (Team team : teamData) {
              //   if(user.id == team.id) {
              //     System.out.println("team name: " + team.name);
              //     break;
              //   }
              // }

            }
          }
        }

        break;

      case "name":
        int theID = 0; 

        if(firstCond.equals("=")) { // equal operator
          for (User user : userData) {
            if(user.name.toLowerCase().contains(secCond) == true) {
              res = user;

              // join table
              // for (Team team : teamData) {
              //   if(user.id == team.id) {
              //     System.out.println("team name: " + team.name);
              //   }
              // }

            }
          }
        }

        break;
      }

      return res;
  }

  @Override
  public User insert(String[] data, Connection<User> conn) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'insert'");
  }

}
