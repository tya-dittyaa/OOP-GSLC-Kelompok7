package repository;

import database.Connection;

public interface repository {
    void find(String columnName, String[] filterCondition, Boolean joinTable, String joinTableName, Connection obj);
    Connection findOne(String columnName, String[] filterCondition, Boolean joinTable, String joinTableName, Connection obj);
}

