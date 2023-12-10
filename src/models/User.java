package models;

public class User extends Model {
  private String nim;
  private String name;

  public User(String nim, String name, int teamId) {
    super(teamId);
    this.nim = nim;
    this.name = name;
  }

  public String getNim() {
    return nim;
  }

  public void setNim(String nim) {
    this.nim = nim;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
