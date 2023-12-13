package repository;

import java.util.ArrayList;

import connection.Connection;
import models.Model;

/**
 * Repository
 */
public interface Repository<T extends Model> {

  ArrayList<T> find(String column, String[] condition, boolean joinTable, String joinTableName, Connection<T> conn);

  T findOne(String column, String[] condition, boolean joinTable, String joinTableName, Connection<T> conn);

  T insert(String[] data, Connection<T> conn);

}