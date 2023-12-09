package models;

import java.util.ArrayList;
import java.util.List;

public class Model {
  protected List<String[]> data;

  public Model() {
    this.data = new ArrayList<>();
  }

  public List<String[]> getData() {
    return data;
  }

  public void setData(List<String[]> data) {
    this.data = data;
  }

  public void addData(String[] newData) {
    this.data.add(newData);
  }
}
