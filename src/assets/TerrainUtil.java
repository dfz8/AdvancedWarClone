package src.assets;

import src.assets.units.Unit;

public class TerrainUtil {
  public static enum TERRAIN_TYPE {
    PLAINS,
    HILLS,
    FOREST,
    OCEAN,
    SHORE,
    MOUNTAINS
  }

  public static int getTraversalCost(Unit u, TERRAIN_TYPE t) {
    return 0;
  }

  private static int getTraversalCostForLandUnit(TERRAIN_TYPE t) {
    return 0;
  }

  private static int getTraversalCostForAirUnit(TERRAIN_TYPE t) {
    return 0;
  }

  private static int getTraversalCostForWaterUnit(TERRAIN_TYPE t) {
    return 0;
  }

  /**
   * Returns the modifier for the base attack a unit has on terrain t.
   */
  public static double getAttackMultiplier(TERRAIN_TYPE t) {
    switch(t) {
      case PLAINS:
        return 1.0;
      case HILLS:
        return 1.5;
      case FOREST:
        return 1.0;
      case OCEAN:
        return 1.0;
      case SHORE:
        return 1.0;
      case MOUNTAINS:
        return 1.5;
      default:
        return 1.0;
    }
  }

  /**
   * Returns the modifier for the base defense a unit has on terrain t.
   */
  public static double getDefenseMultiplier(TERRAIN_TYPE t) {
    switch(t) {
      case PLAINS:
        return 1.0;
      case HILLS:
        return 1.0;
      case FOREST:
        return 1.5;
      case OCEAN:
        return 1.0;
      case SHORE:
        return 1.0;
      case MOUNTAINS:
        return 1.5;
      default:
        return 1.0;
    }
  }
}
