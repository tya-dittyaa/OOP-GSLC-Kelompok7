package models;

import database.Connection;
import repository.TeamRepository;

public class Team extends Connection implements TeamRepository{
    private String teamName;
    private int id;

    Connection connectToTeamFile = new Connection();

    public Team(String teamName, int id) {
        this.teamName = teamName;
        this.id = id;
    }

    @Override
    public void find(String columnName, String[] filterCondition, Boolean joinTable, String joinTableName, Connection obj) {
        // ignore this
        throw new UnsupportedOperationException("Unimplemented method 'find'");
    }

    @Override
    public Connection findOne(String columnName, String[] filterCondition, Boolean joinTable, String joinTableName, Connection obj) {
        // ignore this
        throw new UnsupportedOperationException("Unimplemented method 'findOne'");
    }

    @Override
    public void readTeamFile() {
        connectToTeamFile.readTeam();
    }

    @Override
    public void writeTeamFile(String teamName, int id) {
        connectToTeamFile.writeTeam(teamName, id);
    }


}
