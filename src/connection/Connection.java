package connection;

import java.util.ArrayList;

import models.Model;

/**
 * Connection
 */
public interface Connection<T extends Model> {

  public ArrayList<T> readFile();

  public boolean writeFile(T data);
}