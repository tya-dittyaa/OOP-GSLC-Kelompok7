import connection.TeamConnection;
import connection.UserConnection;
import repository.TeamRepository;
import repository.UserRepository;

public class Hackathon {
  private UserConnection uc = UserConnection.getInstance(); // singleton
  private TeamConnection tc = TeamConnection.getInstance();
  private UserRepository ur;
  private TeamRepository tr;

  // TODO: find one 1 user
  public void findUser() {
  }

  // TODO: find one many user
  public void findUsers() {
  }

  // TODO: insert one user
  public void insertUser() {
  }

  // TODO: find one 1 team
  public void findTeam() {
  }

  // TODO: find one many team
  public void findTeams() {
  }

  // TODO: insert one 1 team
  public void insertTeam() {
  }
}
