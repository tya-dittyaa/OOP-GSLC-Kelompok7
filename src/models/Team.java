package models;

public class Team extends Model {
  private String teamName;

  public Team(int teamId, String teamName) {
    super(teamId);
    this.teamName = teamName;
  }

  public String getTeamName() {
    return teamName;
  }

  public void setTeamName(String teamName) {
    this.teamName = teamName;
  }

}
