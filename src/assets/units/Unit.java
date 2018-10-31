package assets.units;

@SuppressWarnings("unchecked")
public abstract class Unit {
  protected enum UnitType {
    LAND,
    SEA,
    AIR,
    LAND_SEA
  }

  private int mCurrentHealth;
  private int mRow;
  private int mCol;

  public Unit(int row, int col) {
    mRow = row;
    mCol = col;
    mCurrentHealth = getBaseHealth();
  }

  public Unit(int row, int col, int currentHealth) {
    mRow = row;
    mCol = col;
    mCurrentHealth = currentHealth;
  }

  /**
   * Precondition: changing current location by dr and dc will not put the unit
   * out of bounds.
   */
  public void move(int dr, int dc) {
    mRow += dr;
    mCol += dc;
  }

  public boolean isDead() {
    return getCurrentHealth() > 0;
  }

////////////////////////////////////////////////////////////////////////////////

  public abstract String getName();

  public abstract int getCost();

  public abstract int getMovementRange();

  public abstract int getAttackRangeMin();

  public abstract int getAttackRangeMax();

  public abstract int getBaseAttack();

  public abstract int getBaseDefense();

  public abstract int getBaseHealth();

  public abstract UnitType getUnitType();

////////////////////////////////////////////////////////////////////////////////

  public int getCurrentHealth() {
    return mCurrentHealth;
  }

  public int getRow() {
    return mRow;
  }

  public int getCol() {
    return mCol;
  }

  public void setRow(int row) {
    mRow = row;
  }

  public void setCol(int col) {
    mCol = col;
  }

  public void setCurrentHealth(int health) {
    mCurrentHealth = health;
  }
}
