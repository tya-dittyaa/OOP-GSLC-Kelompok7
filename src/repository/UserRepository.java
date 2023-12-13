package repository;

import java.util.ArrayList;

import connection.Connection;
import models.User;

public class UserRepository implements Repository<User> {

  @Override
  public ArrayList<User> find(String column, String[] condition, boolean joinTable, String joinTableName,
      Connection<User> conn) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'find'");
  }

  @Override
  public User findOne(String column, String[] condition, boolean joinTable, String joinTableName,
      Connection<User> conn) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findOne'");
  }

  @Override
  public User insert(String[] data, Connection<User> conn) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'insert'");
  }

}
