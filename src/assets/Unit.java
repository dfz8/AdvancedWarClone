package src.assets;

public class Unit {

  protected enum UNIT_TYPE {
    LAND,
    SEA,
    AIR,
    LAND_SEA
  }

  /* Counter to keep track of total units created */
  private static int globalUnitCounter = 0;

  /* Specific id corresponding to the created unit */
  private int mId;

  /* Name of the unit */
  private String mName;

  /* Cost to produce unit */
  private int mCost;

  /* Allowed movement steps */
  private int mMovementRange;

  /* Closest distance able to attack */
  private int mAttackRangeClose;

  /* Farthest distance able to attack */
  private int mAttackRangeFar;

  /* Attack power of unit */
  private int mAttack;

  /* Defense power of unit */
  private int mDefense;

  /* Total health of unit */
  private int mHealth;

  /* The type of unit, determines where it can go. */
  private UNIT_TYPE mUnitType;

  /* Current row on the map */
  private int mRow;

  /* Current column on the map */
  private int mCol;

  public Unit(
      String name,
      int cost,
      int movementRange,
      int attackRangeClose,
      int attackRangeFar,
      int attack,
      int defense,
      int health,
      UNIT_TYPE type,
      int row,
      int col) {
    mId = ++globalUnitCounter;
    mName = name;
    mCost = cost;
    mMovementRange = movementRange;
    mAttackRangeClose = attackRangeClose;
    mAttackRangeFar = attackRangeFar;
    mAttack = attack;
    mDefense = defense;
    mHealth = health;
    mUnitType = type;
    mRow = row;
    mCol = col;
  }

  /*
   * Precondition: changing current location by dr and dc will not put the unit
   * out of bounds.
   */
  public void move(int dr, int dc) {
    mRow += dr;
    mCol += dc;
  }

  public boolean isDead() {
    return mHealth > 0;
  }

////////////////////////////////////////////////////////////////////////////////

  public int getId() {
    return mId;
  }

  public String getName() {
    return mName;
  }

  public int getCost() {
    return mCost;
  }

  public int getMovementRange() {
    return mMovementRange;
  }

  public int getAttackRangeClose() {
    return mAttackRangeClose;
  }

  public int getAttackRangeFar() {
    return mAttackRangeFar;
  }

  public int getAttack() {
    return mAttack;
  }

  public int getDefense() {
    return mDefense;
  }

  public int getHealth() {
    return mHealth;
  }

  public UNIT_TYPE getType() {
    return mUnitType;
  }

  public int getRow() {
    return mRow;
  }

  public int getCol() {
    return mCol;
  }

  public String toString() {
    return "[UNIT: " + mId + ", " + mName + "]";
  }
////////////////////////////////////////////////////////////////////////////////

  public void setHealth(int health) {
    mHealth = health;
  }

  public void setRow(int row) {
    mRow = row;
  }

  public void setCol(int col) {
    mCol = col;
  }
}
