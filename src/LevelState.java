package src;

import src.assets.TeamsStateController;

/**
 * Create a pure-ish state representation for the current state of a level
 */
public class LevelState {
  // constants for each level:
  private int mTotalPlayers;

  // values that change per state:
  private int mWhoseTurn; // int allows multiple AI, 0 == user
  private TeamsStateController mTeamsStateController;

  public LevelState(String levelConfigFileName) {
  }

  public LevelState(LevelStateBuilder builder) {
    mTotalPlayers = builder.mTotalPlayers;
    mWhoseTurn = builder.mWhoseTurn;
    mTeamsStateController = builder.mTeamsStateController;
  }

  public LevelState endTurn() {
    return new LevelStateBuilder()
        .from(this)
        .setWhoseTurn((mWhoseTurn + 1) % mTotalPlayers)
        .build();
  }

  // Should be called whenever changes happens to a unit or to a team.
  public LevelState updateTeams() {
    return new LevelStateBuilder()
        .from(this)
        .setTeamsStateController(mTeamsStateController.clone())
        .build();
  }

  public static void saveState(LevelState state) {
  }

  public static void loadState(String saveFileName) {
  }

  public static class LevelStateBuilder {
    private int mTotalPlayers;
    private int mWhoseTurn;
    private TeamsStateController mTeamsStateController;

    private LevelStateBuilder() {}

    public LevelStateBuilder(int totalPlayers) {
      mTotalPlayers = totalPlayers;
    }

    /**
     * Copy over current values, any updates should be done through
     * the set functions below.
     **/
    public LevelStateBuilder from(LevelState state) {
      mTotalPlayers = state.mTotalPlayers;
      mWhoseTurn = state.mWhoseTurn;
      mTeamsStateController = state.mTeamsStateController;
      return this;
    }

    public LevelStateBuilder setWhoseTurn(int player) {
      mWhoseTurn = player;
      return this;
    }

    public LevelStateBuilder setTeamsStateController(TeamsStateController controller) {
      mTeamsStateController = controller;
      return this;
    }

    public LevelState build() {
      return new LevelState(this);
    }
  }
}
