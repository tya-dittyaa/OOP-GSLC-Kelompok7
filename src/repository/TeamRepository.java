package repository;

import java.util.ArrayList;

import connection.Connection;
import models.Team;

public class TeamRepository implements Repository<Team> {

  @Override
  public ArrayList<Team> find(String column, String[] condition, Boolean joinTable, String joinTableName,
      Connection<Team> conn) {
    // * Validasi parameter
    if (column == null && condition != null) {
      System.err.println("Error: Kolom filter null, tapi ada kondisi filter.");
      return null;
    }

    if (column != null && condition == null) {
      System.err.println("Error: Kondisi filter tidak null, tapi kolom filter null.");
      return null;
    }

    if (joinTableName == null && joinTable != null && joinTable) {
      System.err.println("Error: Nama table join null, tapi boolean kondisi join true.");
      return null;
    }

    if (joinTableName != null && joinTable == null) {
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

    ArrayList<Team> result = conn.readFile();
    ArrayList<Team> newResult = new ArrayList<>();

    for (Team team : result) {
      if (column.equals("id")) {
        if (condition[1].equals(Integer.toString(team.id))) {
          newResult.add(team);
        }
      }

      if (column.equals("name")) {
        if (condition[1].equalsIgnoreCase(team.name)) {
          newResult.add(team);
        }
      }
    }

    if (condition == null) {
      return result;
    } else {
      return newResult;
    }
  }

  @Override
  public Team findOne(String column, String[] condition, Boolean joinTable, String joinTableName,
      Connection<Team> conn) {
    // * Validasi parameter
    if (column == null && condition != null) {
      System.err.println("Error: Kolom filter null, tapi ada kondisi filter.");
      return null;
    }

    if (column != null && condition == null) {
      System.err.println("Error: Kondisi filter tidak null, tapi kolom filter null.");
      return null;
    }

    if (joinTableName == null && joinTable != null && joinTable) {
      System.err.println("Error: Nama table join null, tapi boolean kondisi join true.");
      return null;
    }

    if (joinTableName != null && joinTable == null) {
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

    ArrayList<Team> result = conn.readFile();

    for (Team team : result) {
      if (column.equals("id")) {
        if (condition[1].equals(Integer.toString(team.id))) {
          return team;
        }
      }

      if (column.equals("name")) {
        if (condition[1].equalsIgnoreCase(team.name)) {
          return team;
        }
      }
    }

    return null;
  }

  @Override
  public Team insert(String[] data, Connection<Team> conn) {
    ArrayList<Team> result = conn.readFile();
    int id = result.size() + 1;
    String name = data[0];

    conn.writeFile(new Team(id, name));

    return new Team(id, name);
  }

}
