package gui.layouts;

import java.util.LinkedList;

/**
 * This class gets passed references to content on the screen, and repositions
 * them to take out positioning calculations when making screens.
 */
public class LayoutManager implements Layoutable {
  public static enum FLEX_DIRECTION {
    VERTICAL,
    HORIZONTAL,
  };
  public static enum ALIGN_CONTENT {
    CENTER,
    SPACE_BETWEEN,
  };

  private static final int minPadding = 5;

  private LinkedList<Layoutable> mContents;
  private FLEX_DIRECTION mFlexDirection;
  private ALIGN_CONTENT mAlignContent;
  private int mX;
  private int mY;
  private final int mTotalWidth;
  private final int mTotalHeight;

  public LayoutManager(
      int x,
      int y,
      int width,
      int height,
      FLEX_DIRECTION direction) {
    mContents = new LinkedList<Layoutable>();

    mTotalWidth = width;
    mTotalHeight = height;
    mFlexDirection = direction;
    mAlignContent = ALIGN_CONTENT.CENTER;
  }

  public LayoutManager(
      int x,
      int y,
      int width,
      int height,
      FLEX_DIRECTION direction,
      ALIGN_CONTENT alignment) {
    this(x,y,width,height,direction);
    mAlignContent = alignment;
  }

  public boolean add(Layoutable cp) {
    return mContents.add(cp) && relayout();
  }

  public boolean setFlexDirection(FLEX_DIRECTION direction) {
    if (mFlexDirection != direction) {
      mFlexDirection = direction;
      return relayout();
    }
    return true;
  }

  /**
   * Does the best to reorganize the contents to fit in the space with the
   * FLEX_DIRECTION but if it can't fit then will let it overflow and return false.
   */
  boolean relayout() {
    if (mFlexDirection == FLEX_DIRECTION.VERTICAL) {
      return relayoutVertically();
    }
    return relayoutHorizontally();
  }

  private boolean relayoutVertically() {
    int contentHeightSum = 0;
    for (Layoutable l : mContents ) {
      contentHeightSum += l.getHeight();
      // recenter other axis
      l.setX(mX + (mTotalWidth - l.getWidth()) / 2);
    }
    int leftover =
        mTotalHeight
        - contentHeightSum
        - (1 + mContents.size()) * minPadding;
    if (leftover < 0) {
      System.out.println("no leftovers");
      return false;
    }

    int space_around;
    int space_between;
    switch(mAlignContent) {
      case CENTER:
      default:
        space_around = leftover / 2;
        space_between = minPadding;
        break;
      case SPACE_BETWEEN:
        space_around
            = space_between
            = (mTotalHeight - contentHeightSum) / (mContents.size() + 1);
        break;
    }

    int curY = mY + space_around;
    for (Layoutable l : mContents) {
      l.setY(curY);
      curY += space_between + l.getHeight();
    }

    return true;
  }

  private boolean relayoutHorizontally() {
    int contentWidthSum = 0;
    for (Layoutable l : mContents ) {
      contentWidthSum += l.getWidth();
      // recenter other axis
      l.setY(mY + (mTotalHeight - l.getHeight()) / 2);
    }
    int leftover =
        mTotalWidth
        - contentWidthSum
        - (1 + mContents.size()) * minPadding;
    if (leftover < 0) {
      System.out.println("no leftovers");
      return false;
    }

    int space_around;
    int space_between;
    switch(mAlignContent) {
      case CENTER:
      default:
        space_around = leftover / 2;
        space_between = minPadding;
        break;
      case SPACE_BETWEEN:
        space_around
            = space_between
            = (mTotalWidth - contentWidthSum) / (mContents.size() + 1);
        break;
    }

    int curX = mX + space_around;
    for (Layoutable l : mContents) {
      l.setX(curX);
      curX += space_between + l.getWidth();
    }

    return true;
  }

// Layoutable interface implementations

  public int getX() { return mX; }
  public int getY() { return mY; }
  public int getWidth() { return mTotalWidth; }
  public int getHeight() { return mTotalHeight; }

  public void setX(int x) {
    mX = x;
    relayout();
  }

  public void setY(int y) {
    mY = y;
    relayout();
  }
}
