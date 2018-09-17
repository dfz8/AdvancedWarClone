package src.assets;

public class TerrainMap {
  private TerrainUtil.TERRAIN_TYPE[][] mMap;
  private Unit[][] location;

  public TerrainMap(String filename) {
    mMap = readFromFile(filename);
    location = new Unit[mMap.length][mMap[0].length];
  }

  private static TerrainUtil.TERRAIN_TYPE[][] readFromFile(String filename) {
    return null;
  }

  public double getAttackMultiplier(int r, int c) {
    return TerrainUtil.getAttackMultiplier(mMap[r][c]);
  }

  public double getDefenseMultiplier(int r, int c) {
    return TerrainUtil.getDefenseMultiplier(mMap[r][c]);
  }

  public boolean moveUnit(Unit u, int destR, int destC) {
    if (location[destR][destC] != null) {
      System.out.println(
        "ERROR: movement destination is occupied by "
        + location[destR][destC]
      );
      return false;
    }
    if (location[u.getRow()][u.getCol()] != u) {
      System.out.println(
        "ERROR: unit location and unit stored in TerrainMap do not match:"
        + location[u.getRow()][u.getCol()]
        + " is not "
        + u
      );
      return false;
    }
    location[u.getRow()][u.getCol()] = null;
    location[u.getRow()][u.getCol()] = u;
    return true;
  }

  public boolean isOccupied(int r, int c) {
    return location[r][c] == null;
  }
}
