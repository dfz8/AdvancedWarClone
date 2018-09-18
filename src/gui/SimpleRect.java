package src.gui;

public class SimpleRect {
  private int mLeft;
  private int mTop;
  private int mRight;
  private int mBottom;

  public SimpleRect() {
  }

  public SimpleRect(int left, int top, int right, int bottom) {
    set(left,top,right,bottom);
  }

  public int getLeft() { return mLeft; }

  public int getTop() { return mTop; }

  public int getRight() { return mRight; }

  public int getBottom() { return mBottom; }

  public int getWidth() { return mRight - mLeft; }

  public int getHeight() { return mBottom - mTop; }

  public void set(int left, int top, int right, int bottom) {
    mLeft = left;
    mTop = top;
    mRight = right;
    mBottom = bottom;
  }

  public void setLeft(int left) { mLeft = left; }

  public void setTop(int top) { mTop = top; }

  public void setRight(int right) { mRight = right; }

  public void setBottom(int bottom) { mBottom = bottom; }
}
