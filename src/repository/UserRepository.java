package repository;

import java.util.ArrayList;

import connection.Connection;
import models.User;

public class UserRepository implements Repository<User> {

  @Override
  public ArrayList<User> find(String column, String[] condition, Boolean joinTable, String joinTableName,
      Connection<User> conn) {
    if (column == null && condition != null) {
      System.err.println("Error: Kolom filter null, tapi ada kondisi filter.");
      return null;
    }

    if (column != null && condition == null) {
      System.err.println("Error: Kondisi filter tidak null, tapi kolom filter null.");
      return null;
    }

    if (column != null && condition != null && condition[0].equals("=") == false) {
      System.err.println("Error: Kondisi filter tidak null, kondisi filter tidak null, tapi kondisi pertama harus '='");
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

    try {
      ArrayList<User> result = conn.readFile();

      if (column == null && condition == null && joinTable == null && joinTableName == null) {
        return result;
      } else {
        ArrayList<User> newResult = new ArrayList<>();

        for (User user : result) {
          if (column.equals("nim")) {
            if (user.nim.equals(condition[1])) {
              newResult.add(user);
            }
          }

          if (column.equals("name")) {
            if (user.name.toLowerCase().contains(condition[1].toLowerCase())) {
              newResult.add(user);
            }
          }

          if (column.equals("teamId")) {
            if (Integer.toString(user.id).equals(condition[1])) {
              newResult.add(user);
            }
          }
        }

        return newResult;
      }
    } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public User findOne(String column, String[] condition, Boolean joinTable, String joinTableName,
      Connection<User> conn) {
    // * Validasi parameter
    if (column == null && condition != null) {
      System.err.println("Error: Kolom filter null, tapi ada kondisi filter.");
      return null;
    }

    if (column != null && condition == null) {
      System.err.println("Error: Kondisi filter tidak null, tapi kolom filter null.");
      return null;
    }

    if (column != null && condition != null && condition[0].equals("=") == false) {
      System.err.println("Error: Kondisi filter tidak null, kondisi filter tidak null, tapi kondisi pertama harus '='");
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

    try {
      ArrayList<User> result = conn.readFile();

      for (User user : result) {
        if (column.equals("nim")) {
          if (user.nim.equals(condition[1])) {
            return user;
          }
        }

        if (column.equals("name")) {
          if (user.name.toLowerCase().contains(condition[1].toLowerCase())) {
            return user;
          }
        }

        if (column.equals("teamId")) {
          if (Integer.toString(user.id).equals(condition[1])) {
            return user;
          }
        }
      }

      return null;
    } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public User insert(String[] data, Connection<User> conn) {
    String nim = data[0];
    String name = data[1];
    int teamId = Integer.parseInt(data[2]);

    conn.writeFile(new User(nim, name, teamId));

    return new User(nim, name, teamId);
  }

}
