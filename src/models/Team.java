package models;

/**
 * Team
 */
public class Team extends Model {

  public String name;

  public Team(int id, String name) {
    super(id);
    this.name = name;
  }

}