import java.util.ArrayList;

import connection.Connection;
import connection.TeamConnection;
import connection.UserConnection;
import models.Team;
import models.User;
import repository.TeamRepository;
import repository.UserRepository;

public class Hackathon {
  private UserConnection uc = UserConnection.getInstance(); // singleton
  private TeamConnection tc = TeamConnection.getInstance();
  private UserRepository ur = new UserRepository();
  private TeamRepository tr = new TeamRepository();

  // TODO: find one 1 user
  public User findUser(String column, String[] condition, Boolean joinTable, String joinTableName,
      Connection<User> conn) {
    return ur.findOne(column, condition, joinTable, joinTableName, conn);
  }

  // TODO: find one many user
  public ArrayList<User> findUsers(String column, String[] condition, Boolean joinTable, String joinTableName,
      Connection<User> conn) {
    return ur.find(column, condition, joinTable, joinTableName, conn);
  }

  // TODO: insert one user
  public User insertUser(String nim, String name, String teamName) {
    int teamId = 0;
    String[] conditionForCheck = { "=", teamName };
    Team getTeamFirst = tr.findOne("name", conditionForCheck, null, null, tc);

    if (getTeamFirst != null) {
      String[] conditionForCheckTeamId = { "=", Integer.toString(getTeamFirst.id) };
      ArrayList<User> tempList = findUsers("teamId", conditionForCheckTeamId, null, null, uc);

      if (tempList.size() == 3) {
        return null;
      }

      teamId = getTeamFirst.id;
    } else {
      String[] conditionForInsertTeamName = { teamName };
      Team newTeam = tr.insert(conditionForInsertTeamName, tc);

      teamId = newTeam.id;
    }

    String[] conditionForInsertNewUser = { nim, name, Integer.toString(teamId) };
    return ur.insert(conditionForInsertNewUser, uc);
  }

  // TODO: find one 1 team
  public Team findTeam(String column, String[] condition, Boolean joinTable, String joinTableName,
      Connection<Team> conn) {
    return tr.findOne(column, condition, joinTable, joinTableName, conn);
  }

  // TODO: find one many team
  public ArrayList<Team> findTeams(String column, String[] condition, Boolean joinTable, String joinTableName,
      Connection<Team> conn) {
    return tr.find(column, condition, joinTable, joinTableName, conn);
  }

  // TODO: insert one 1 team
  public Team insertTeam(String name) {
    String[] conditionForCheck = { "=", name };
    String[] conditionForInsert = { name };
    Team checkTeam = findTeam("name", conditionForCheck, null, null, tc);

    if (checkTeam != null) {
      return null;
    } else {
      return tr.insert(conditionForInsert, tc);
    }
  }
}
