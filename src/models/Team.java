package models;

import database.Connection;
import repository.TeamRepository;

public class Team extends Connection implements TeamRepository{
    private String teamName;
    Connection connectToTeamFile = new Connection();

    public Team(String teamName, int id) {
        this.teamName = teamName;
    }

    @Override
    public void find(String columnName, String[] filterCondition, Boolean joinTable, String joinTableName,
            Connection obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'find'");
    }

    @Override
    public Connection findOne(String columnName, String[] filterCondition, Boolean joinTable, String joinTableName,
            Connection obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findOne'");
    }

    @Override
    public void readTeamFile() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readTeamFile'");
    }

    @Override
    public void writeTeamFile(String teamName, int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'writeTeamFile'");
    }


    
}
