package assets;

import assets.units.Unit;
import assets.units.UnitUtil;
import utils.Stateful;
import utils.StringInputTokenizer;

import java.util.LinkedList;

public class Team implements Stateful<Team> {
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

  @Override
  public String serialize() {
    StringBuilder sb = new StringBuilder("[Team,");
    sb.append(mUnits.size() +",");
    for (Unit u : mUnits) {
      sb.append(u);
      sb.append(",");
    }
    sb.append("]");
    return sb.toString();
  }

  @Override
  public Team deserialize(StringInputTokenizer tokenizer) throws Exception {
    tokenizer.verifyStartReading("Team");
    Team team = new Team();
    int size = tokenizer.readInt();
    for (int i = 0; i < size; i++) {
      team.addUnit(UnitUtil.deserialize(tokenizer));
    }
    tokenizer.verifyEndReading();
    return team;
  }
}
