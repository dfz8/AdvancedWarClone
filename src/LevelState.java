package src;

public class LevelState {
  private int mTotalPlayers;
  private int mWhoseTurn; // int allows multiple AI, 0 == user

  public LevelState(String levelConfigFileName) {
  }

  public LevelState(LevelStateBuilder builder) {
    mTotalPlayers = builder.mTotalPlayers;
    mWhoseTurn = builder.mWhoseTurn;
  }

  public LevelState endTurn() {
    return new LevelStateBuilder()
        .from(this)
        .setWhoseTurn((whoseTurn + 1) % totalPlayers)
        .build();
  }

  public static void saveState(LevelState state) {
  }

  public static void loadState(String saveFileName) {
  }

  public static class LevelStateBuilder {
    private int mTotalPlayers;
    private int mWhoseTurn;

    public LevelStateBuilder() {}
    public LevelStateBuilder(int totalPlayers) {
      mTotalPlayers = totalPlayers;
    }

    public LevelStateBuilder from(LevelState state) {
      mTotalPlayers = state.mTotalPlayers;
      mWhoseTurn = state.mWhoseTurn;
      return this;
    }

    public LevelStateBuilder setWhoseTurn(int player) {
      mWhoseTurn = player;
      return this;
    }

    public LevelState build() {
      return LevelState(this);
    }
  }
}
