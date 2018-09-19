package src.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

import src.gui.layouts.Layoutable;
import src.utils.StyleUtil;

public class ClickablePanel implements Layoutable {
  public static enum ALIGNMENT {
    CENTER,
    LEFT,
  };

  private static int padding = 10;

  private int mLeft;
  private int mTop;
  private int mRight;
  private int mBottom;
  private int mWidth;
  private int mHeight;

  private String mText;
  private int mTextXOffset;
  private int mTextYOffset;

  private boolean isHoveredOver;

  private StyleUtil mStyleUtil;
  private Font mFont;


  public ClickablePanel(
      int width,
      int height,
      String text,
      StyleUtil.FONTS font,
      ALIGNMENT alignment,
      StyleUtil styleUtil) {
    this(0, 0, width, height, text, font, alignment, styleUtil);
  }

  public ClickablePanel(
      int left,
      int top,
      int width,
      int height,
      String text,
      StyleUtil.FONTS font,
      ALIGNMENT alignment,
      StyleUtil styleUtil){
    mLeft = left;
    mTop = top;
    mRight = left + width;
    mBottom = top + height;
    mText = text;
    mWidth = width;
    mHeight = height;

    mStyleUtil = styleUtil;
    mFont = mStyleUtil.getFont(font);
    computeALignment(font, alignment);

    isHoveredOver = false;
  }

  // Computes the (x, y) for the baseline of the first line of text
  private void computeALignment(StyleUtil.FONTS font, ALIGNMENT alignment) {
    SimpleRect rect = new SimpleRect();
    mStyleUtil.measureString(font, mText, rect);
    switch(alignment) {
      case CENTER:
        mTextXOffset = (mRight - rect.getWidth()) / 2;
        mTextYOffset = (mBottom + rect.getHeight()) / 2;
        break;
      case LEFT:
        mTextXOffset = padding;
        mTextYOffset = padding + rect.getHeight();
        break;
    }
  }

  public void draw(Graphics mBuffer) {
    if(isHoveredOver) {
      mBuffer.setColor(mStyleUtil.getHighlightColor());
      mBuffer.fillRect(mLeft - 5, mTop - 5, mWidth + 10, mHeight + 10);
    }

    mBuffer.setColor(mStyleUtil.getPanelBackgroundColor());
    mBuffer.fillRect(mLeft, mTop, mWidth, mHeight);

    mBuffer.setColor(mStyleUtil.getOutlineColor());
    mBuffer.drawRect(mLeft, mTop, mWidth, mHeight);

    mBuffer.setFont(mFont);
    mBuffer.setColor(mStyleUtil.getTextColor());
    mBuffer.drawString(mText, mLeft + mTextXOffset, mTop + mTextYOffset);
  }

  public boolean isClickInBounds(int eX, int eY) {
    return eX >= mLeft && eX <= mRight && eY >= mTop && eY <= mBottom;
  }

  // Needs to be overriden
  public void onMouseClick(int eX, int eY) {
    System.out.println("Default on mouse click...needed to override");
  }

  public void onMouseMove(int eX, int eY) {
    isHoveredOver = isClickInBounds(eX, eY);
  }

  // Layoutable Interface implementations

  public int getX() { return mLeft; }
  public int gety() { return mTop; }
  public int getWidth() { return mWidth; }
  public int getHeight() { return mHeight; }
  public void setX(int x) {
    mLeft = x;
    mRight = mLeft + mWidth;
  }
  public void setY(int y) {
    mTop = y;
    mBottom = mTop + mHeight;
  }
}
