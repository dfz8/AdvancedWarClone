package assets;

import utils.Stateful;
import utils.StringInputTokenizer;

/**
 * This class handles the logic for handling teams.
 **/
public class TeamsStateController implements Stateful<TeamsStateController> {
  private Team[] mTeams;

  private TeamsStateController() {}

  public TeamsStateController(int numPlayers) {
    mTeams = new Team[numPlayers];
  }

  public void setTeam(int player, Team team) {
    mTeams[player] = team;
  }

  public Team getTeam(int player) {
    return mTeams[player];
  }

  public int getNumberOfTeams() {
    return mTeams.length;
  }

  @Override
  public String serialize() {
    StringBuilder sb = new StringBuilder("[TeamsStateController,");
    sb.append(mTeams.length + ",");
    for (Team t : mTeams) {
      sb.append(t);
      sb.append(",");
    }
    sb.append("]");
    return sb.toString();
  }

  @Override
  public TeamsStateController deserialize(StringInputTokenizer tokenizer) throws Exception {
    tokenizer.verifyStartReading("TeamsStateController");
    TeamsStateController controller = new TeamsStateController();
    int numTeams = tokenizer.readInt();
    for (int i = 0; i < numTeams; i++) {
      controller.setTeam(i, mTeams[i].deserialize(tokenizer));
    }
    tokenizer.verifyEndReading();
    return controller;
  }

  @Override
  public TeamsStateController clone() {
    TeamsStateController teamsStateControllerClone = new TeamsStateController();
    Team[] teamsClone = new Team[mTeams.length];
    for (int i = 0; i < mTeams.length; i++) {
      teamsClone[i] = mTeams[i].clone();
    }
    teamsStateControllerClone.mTeams = teamsClone;
    return teamsStateControllerClone;
  }
}
