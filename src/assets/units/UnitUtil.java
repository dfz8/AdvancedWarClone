package assets.units;

import com.sun.istack.internal.Nullable;
import utils.StringInputTokenizer;

public class UnitUtil {

  public static String serialize(Unit unit) {
    return new StringBuilder("[Unit,")
        .append(unit.getName() + ",")
        .append(unit.getRow() + ",")
        .append(unit.getCol() + ",")
        .append(unit.getCurrentHealth() + ",")
        .append("]")
        .toString();
  }

  public static @Nullable
  Unit deserialize(StringInputTokenizer tokenizer)
      throws Exception {
    tokenizer.verifyStartReading("Unit");
    Unit unit = null;
    String name = tokenizer.readString();
    if (name.equals(FootSoldier.TAG)) {
      unit = new FootSoldier(
          tokenizer.readInt(),
          tokenizer.readInt(),
          tokenizer.readInt());
    }
    tokenizer.verifyEndReading();
    return unit;
  }
}
