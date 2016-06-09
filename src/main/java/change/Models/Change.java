package change;

import java.util.*;

public class Change {

  private final int id;
  private final Map hash;
  private final List list;

  public Change(int id, Map hash, List list) {
    this.id = id;
    this.hash = hash;
    this.list = list;
  }

  public int getId() {
    return id;
  }

  public Map getHash() {
    return hash;
  }

  public List getList() {
    return list;
  }

}
