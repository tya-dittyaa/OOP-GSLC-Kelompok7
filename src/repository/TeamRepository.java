package repository;

import java.util.ArrayList;

import connection.Connection;
import models.Team;

public class TeamRepository implements Repository<Team> {

  @Override
  public ArrayList<Team> find(String column, String[] condition, boolean joinTable, String joinTableName, Connection<Team> conn) {


    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'find'");
  }

  @Override
  public Team findOne(String column, String[] condition, boolean joinTable, String joinTableName,
      Connection<Team> conn) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findOne'");
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
