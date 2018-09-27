package src.assets;

/**
 * This class handles the logic for handling teams.
 **/
public class TeamsStateController {
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
