package src.assets.units;

@SuppressWarnings("unchecked")
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

  public Unit(UnitBuilder<?> builder) {
    mId = ++globalUnitCounter;
    mName = builder.mName;
    mCost = builder.mCost;
    mMovementRange = builder.mMovementRange;
    mAttackRangeClose = builder.mAttackRangeClose;
    mAttackRangeFar = builder.mAttackRangeFar;
    mAttack = builder.mAttack;
    mDefense = builder.mDefense;
    mHealth = builder.mHealth;
    mUnitType = builder.mUnitType;
    mRow = builder.mRow;
    mCol = builder.mCol;
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

////////// Builder ///////////////

  public static class UnitBuilder<T extends UnitBuilder<T>> {
    private String mName;
    private int mCost;
    private int mMovementRange;
    private int mAttackRangeClose;
    private int mAttackRangeFar;
    private int mAttack;
    private int mDefense;
    private int mHealth;
    private UNIT_TYPE mUnitType;
    private int mRow;
    private int mCol;

    public UnitBuilder(String name, int row, int col) {
      mName = name;
      mRow = row;
      mCol = col;
    }

    public T setCost(int cost) {
      mCost = cost;
      return (T) this;
    }

    public T setMovementRange(int range) {
      mMovementRange = range;
      return (T) this;
    }

    public T setAttackRangeClose(int range) {
      mAttackRangeClose = range;
      return (T) this;
    }

    public T setAttackRangeFar(int range) {
      mAttackRangeFar = range;
      return (T) this;
    }

    public T setAttack(int atk) {
      mAttack = atk;
      return (T) this;
    }

    public T setDefense(int def) {
      mDefense = def;
      return (T) this;
    }

    public T setHealth(int health) {
      mHealth = health;
      return (T) this;
    }

    public T setUnitType(UNIT_TYPE type) {
      mUnitType = type;
      return (T) this;
    }

    public Unit build() {
      return new Unit(this);
    }
  }

}
