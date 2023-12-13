package connection;

import java.util.ArrayList;

/**
 * Connection
 */
public interface Connection<T> {

  public ArrayList<T> readFile();

  public void writeFile(ArrayList<T> data);
}