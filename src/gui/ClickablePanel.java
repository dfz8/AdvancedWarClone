package gui;

import gui.layouts.Layoutable;
import utils.OnClickListener;
import utils.StyleUtil;

import java.awt.Graphics;

public class ClickablePanel implements Layoutable {
  private int mLeft;
  private int mTop;
  private int mRight;
  private int mBottom;
  private int mWidth;
  private int mHeight;
  private boolean isHoveredOver;
  private boolean isEnabled;
  private StyleUtil mStyleUtil;
  private OnClickListener mOnClickListener;

  public ClickablePanel(
      int width,
      int height,
      StyleUtil styleUtil) {
    this(0, 0, width, height, styleUtil);
  }

  public ClickablePanel(
      int left,
      int top,
      int width,
      int height,
      StyleUtil styleUtil) {
    mLeft = left;
    mTop = top;
    mRight = left + width;
    mBottom = top + height;
    mWidth = width;
    mHeight = height;
    mStyleUtil = styleUtil;
    isHoveredOver = false;
    isEnabled = true;
  }

  public void draw(Graphics mBuffer) {
    // Draw highlight if mouse is over
    if (isEnabled && isHoveredOver) {
      mBuffer.setColor(mStyleUtil.getHighlightColor());
      mBuffer.fillRect(mLeft - 5, mTop - 5, mWidth + 10, mHeight + 10);
    }

    // Fill space
    mBuffer.setColor(mStyleUtil.getPanelBackgroundColor());
    mBuffer.fillRect(mLeft, mTop, mWidth, mHeight);

    // Draw outline
    mBuffer.setColor(mStyleUtil.getOutlineColor());
    mBuffer.drawRect(mLeft, mTop, mWidth, mHeight);
  }

  public boolean isClickInBounds(int eX, int eY) {
    return eX >= mLeft && eX <= mRight && eY >= mTop && eY <= mBottom;
  }

  public boolean onMouseClick(int eX, int eY) {
    if (isEnabled && isClickInBounds(eX, eY)) {
      mOnClickListener.onClick();
      return true;
    }
    return false;
  }

  public void setOnClickListener(OnClickListener onClickListener) {
    mOnClickListener = onClickListener;
  }

  public void onMouseMove(int eX, int eY) {
    isHoveredOver = isClickInBounds(eX, eY);
  }

  // Layoutable Interface implementations
  public int getX() {
    return mLeft;
  }

  public int getY() {
    return mTop;
  }

  public int getWidth() {
    return mWidth;
  }

  public int getHeight() {
    return mHeight;
  }

  public void setX(int x) {
    setLeft(x);
  }

  public void setY(int y) {
    setTop(y);
  }

  // getter & setters:
  public int getLeft() {
    return mLeft;
  }

  public int getTop() {
    return mTop;
  }

  public int getRight() {
    return mRight;
  }

  public int getBottom() {
    return mBottom;
  }

  public boolean getIsEnabled() {
    return isEnabled;
  }

  public StyleUtil getStyleUtil() {
    return mStyleUtil;
  }

  public void setLeft(int left) {
    mLeft = left;
    mRight = mLeft + mWidth;
  }

  public void setTop(int top) {
    mTop = top;
    mBottom = mTop + mHeight;
  }

  public void setWidth(int width) {
    mWidth = width;
    mRight = mLeft + mWidth;
  }

  public void setHeight(int height) {
    mHeight = height;
    mBottom = mTop + mHeight;
  }

  public void setIsEnabled(boolean isEnabled) {
    this.isEnabled = isEnabled;
  }
}
