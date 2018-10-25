
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Responsible for setting up a level.
 */
public class GameLevelBuilder {
  String name;
  String mapFile;

  public GameLevelBuilder(String name, String mapFile) {
  }

  public static LevelState loadState(String filename) {
    return null;
  }

  public static void saveState(LevelState state, String saveFileName) {
    try {
      PrintWriter out = new PrintWriter(new FileWriter(new File(saveFileName)));
      out.println(state);
      out.close();
    } catch (IOException e) {
      System.out.println(e);
    }
  }

}
