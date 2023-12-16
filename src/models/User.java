package models;

import database.Connection;
import repository.UserRepository;

public class User extends Connection implements UserRepository{
    private String name, nim;
    private int id;

    Connection connectToUserFile = new Connection();

    public User(String name, String nim, int id) {
        this.name = name;
        this.nim = nim;
        this.id = id;
    }

    @Override
    public void find(String columnName, String[] filterCondition, Boolean joinTable, String joinTableName, Connection obj) {
        
    }

    @Override
    public Connection findOne(String columnName, String[] filterCondition, Boolean joinTable, String joinTableName, Connection obj) {
        // ignore this
        throw new UnsupportedOperationException("Unimplemented method 'findOne'");
    }

    @Override
    public void readUserFile() {
        connectToUserFile.readUser();
    }

    @Override
    public void writeUserFile(String name, String nim, int id) {
        connectToUserFile.writeUser(name, nim, id);
    }
}
