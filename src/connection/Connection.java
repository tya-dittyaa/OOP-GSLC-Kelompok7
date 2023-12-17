package connection;

import java.util.ArrayList;

import models.Model;

/**
 * Connection
 */
public abstract interface Connection<T extends Model> {

  public ArrayList<T> readFile();

  public boolean writeFile(T data);

}