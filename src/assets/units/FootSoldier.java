package assets.units;

public class FootSoldier extends Unit {

    public FootSoldier(Builder builder) {
        super(builder);
    }

    public static class Builder extends Unit.Builder<Builder> {

        public Builder(int row, int col) {
            super("Foot Soldier", row, col)
                    .setCost(20)
                    .setMovementRange(3)
                    .setAttackRangeClose(1)
                    .setAttackRangeFar(1)
                    .setAttack(40)
                    .setDefense(20)
                    .setHealth(100)
                    .setUnitType(UNIT_TYPE.LAND);
        }

        public FootSoldier build() {
            return new FootSoldier(this);
        }
    }
}
