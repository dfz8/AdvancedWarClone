package assets.units;

public class FootSoldier extends Unit {
  public static final String TAG = "FootSoldier";

  public FootSoldier(int row, int col) {
    super(row, col);
  }

  public FootSoldier(int row, int col, int currentHealth) {
    super(row, col, currentHealth);
  }

  public String getName() {
    return TAG;
  }

  public int getCost() {
    return 20;
  }

  public int getMovementRange() {
    return 3;
  }

  public int getAttackRangeMin() {
    return 1;
  }

  public int getAttackRangeMax() {
    return 1;
  }

  public int getBaseAttack() {
    return 40;
  }

  public int getBaseDefense() {
    return 40;
  }

  public int getBaseHealth() {
    return 100;
  }

  public UnitType getUnitType() {
    return UnitType.LAND;
  }

  @Override
  public FootSoldier clone() {
    return new FootSoldier(getRow(), getCol(), getCurrentHealth());
  }
}
