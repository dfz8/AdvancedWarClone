package src;

import src.assets.TeamsStateController;

/**
 * Create a pure-ish state representation for the current state of a level
 */
public class LevelState {
  // constants for each level:
  private String mLevelId;
  private int mTotalPlayers;

  // values that change per state:
  private int mWhoseTurn; // int allows multiple AI, 0 == user
  private TeamsStateController mTeamsStateController;

  public LevelState(String levelConfigFileName) {
  }

  public LevelState(Builder builder) {
    mLevelId = builder.mLevelId;
    mTotalPlayers = builder.mTotalPlayers;
    mWhoseTurn = builder.mWhoseTurn;
    mTeamsStateController = builder.mTeamsStateController;
  }

  public LevelState endTurn() {
    return new Builder()
        .from(this)
        .setWhoseTurn((mWhoseTurn + 1) % mTotalPlayers)
        .build();
  }

  // Should be called whenever changes happens to a unit or to a team.
  public LevelState updateTeams() {
    return new Builder()
        .from(this)
        .setTeamsStateController(mTeamsStateController.clone())
        .build();
  }

  public static void saveState(LevelState state) {
  }

  public static void loadState(String saveFileName) {
  }

  public static class Builder {
    private String mLevelId;
    private int mTotalPlayers;
    private int mWhoseTurn;
    private TeamsStateController mTeamsStateController;

    private Builder() {}

    public Builder(String levelId, int totalPlayers) {
      mLevelId = levelId;
      mTotalPlayers = totalPlayers;
    }

    /**
     * Copy over current values, any updates should be done through
     * the set functions below.
     **/
    public Builder from(LevelState state) {
      mTotalPlayers = state.mTotalPlayers;
      mWhoseTurn = state.mWhoseTurn;
      mTeamsStateController = state.mTeamsStateController;
      return this;
    }

    public Builder setWhoseTurn(int player) {
      mWhoseTurn = player;
      return this;
    }

    public Builder setTeamsStateController(TeamsStateController controller) {
      mTeamsStateController = controller;
      return this;
    }

    public LevelState build() {
      return new LevelState(this);
    }
  }
}
