
public class Terrain {
  public enum TERRAIN_TYPE {
    PLAINS,
    HILLS,
    FOREST,
    OCEAN,
    SHORE,
    MOUNTAINS
  }

  private TERRAIN_TYPE mType;

  public Terrain(int type) {
    switch(type) {
      case 0:
        mType = TERRAIN_TYPE.PLAINS;
      case 1:
        mType = TERRAIN_TYPE.HILLS;
      case 2:
        mType = TERRAIN_TYPE.FOREST;
      case 3:
        mType = TERRAIN_TYPE.OCEAN;
      case 4:
        mType = TERRAIN_TYPE.SHORE;
      case 5:
      default:
        mType = TERRAIN_TYPE.MOUNTAINS;
    }
  }

  public TERRAIN_TYPE getType() {
    return mType;
  }

  public double getAttackMultiplier(Terrain t) {
    switch(t.getType()) {
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

  public double getDefenseMultiplier(Terrain t) {
    switch(t.getType()) {
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
