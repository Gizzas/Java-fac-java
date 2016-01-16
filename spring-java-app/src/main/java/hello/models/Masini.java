package hello;

import java.util.List;
import java.util.ArrayList;

public class Masini {
  private String marca;
  private int id;
  private int an;

  public Masini() {}

  public Masini(int id, String marca,int an) {
      this.marca = marca;
      this.id = id;
      this.an=an;

  }

  public String getName() {
      return this.marca;
  }

  public int getId() {
    return this.id;
  }
  public int getAn() {
    return this.an;
  }
}