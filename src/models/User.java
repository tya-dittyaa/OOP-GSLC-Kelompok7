package models;

/**
 * User
 */
public class User extends Model {

  public String nim;
  public String name;

  public User(String nim, String name, int id) {
    super(id);
    this.nim = nim;
    this.name = name;
  }

}