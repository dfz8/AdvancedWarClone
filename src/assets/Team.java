package src.assets;

import java.lang.StringBuilder;
import java.util.LinkedList;

import src.assets.units.Unit;

public class Team {
  private LinkedList<Unit> mUnits;

  public Team() {
    mUnits = new LinkedList<Unit>();
  }

  public boolean addUnit(Unit u) {
    return mUnits.add(u);
  }

  public boolean removeUnit(Unit u) {
    return mUnits.remove(u);
  }

  public int getTeamSize() {
    return mUnits.size();
  }

  public boolean isDefeated() {
    return mUnits.size() == 0;
  }

  public Team clone() {
    Team teamClone = new Team();
    for (Unit u : mUnits) {
      teamClone.addUnit(u.clone());
    }
    return teamClone;
  }

  public String toString() {
    StringBuilder sb = new StringBuilder("[Team:" + mUnits.size() +",");
    for (Unit u : mUnits) {
      sb.append(u);
      sb.append(",");
    }
    sb.append("]");
    return sb.toString();
  }
}
