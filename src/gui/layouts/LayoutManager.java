package src.gui.layouts;

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

  private static final minPadding = 5;

  private LinkedList<Layoutable> mContents;
  private FLEX_DIRECTION mFlexDirection;
  private ALIGN_CONTENT mAlignContent;
  private int mX;
  private int mY;
  private int mTotalWidth;
  private int mTotalHeight;

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

  public boolean addPanel(Layoutable cp) {
      return mContents.add(cp) && relayout(false);
  }

  public boolean setFlexDirection(FLEX_DIRECTION direction) {
    if (mDirection != direction) {
      mDirection = direction;
      return relayout(true);
    }
    return true;
  }

  /**
   * Does the best to reorganize the contents to fit in the space with the
   * FLEX_DIRECTION but if it can't fit then will let it overflow and return false.
   */
  boolean relayout(boolean didReallign) {
    if (didReallign) {
    } else {
    }

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
      l.setX(l.getX() - l.getWidth()/2 + mX);
    }
    int leftover =
        mTotalHeight
        - totalLength
        - (1 + mContents.size()) * minPadding;
    if (leftover < 0) {

      return false;
    }

    int space_around;
    int space_between;
    switch(mAlignContent) {
      case CENTER:
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
      curY += space_between;
    }

    return true;
  }

  private boolean relayoutHorizontally() {
    return true;
  }

// Layoutable interface implementations

  int getX() { return mX; }
  int gety() { return mY; }
  int getWidth() { return mTotalWidth; }
  int getHeight() { return mTotalHeight; }

  void setX(int x) {
    mX = x;
    relayout(false);
  }

  void setY(int y) {
    mY = y;
    relayout(false);
  }
}
