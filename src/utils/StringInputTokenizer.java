package src.utils;

import java.util.StringTokenizer;
import static java.lang.Integer.parseInt;

public class StringInputTokenizer {
  private int mCurrentTokenCount;
  private StringTokenizer mStringTokenizer;

  public StringInputTokenizer(String input) {
    mStringTokenizer = new StringTokenizer(input, ",");
    mCurrentTokenCount = 0;
  }

  public int readInt() throws Exception {
    try {
      return parseInt(nextToken());
    } catch (NumberFormatException e) {
      throw new Exception(
          "Error converting value to int on token " + mCurrentTokenCount +".");
    }
  }

  public String readString() throws Exception {
    return mStringTokenizer.nextToken();
  }

  public boolean verifyStartReading(String classname) throws Exception {
    if (nextToken().equals("[" + classname)) {
      return true;
    }
    throw new Exception("Trying to start reading class but there's more data.");
  }

  public boolean verifyEndReading() throws Exception {
    if (nextToken().equals("]")) {
      return true;
    }
    throw new Exception("Trying to end reading class but there's more data.");
  }

  private String nextToken() throws Exception {
    mCurrentTokenCount++;
    return mStringTokenizer.nextToken();
  }
}
