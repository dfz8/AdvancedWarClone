package src.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class ClickablePanel {
  private int mLeft;
  private int mTop;
  private int mRight;
  private int mBottom;
  private int mWidth;
  private int mHeight;

  private String mText;
  private int mTextX;
  private int mTextY;

  private boolean isHoveredOver;

  public ClickablePanel(int left, int top, int right, int bottom, String text){
    mLeft = left;
    mTop = top;
    mRight = right;
    mBottom = bottom;
    mText = text;
    mWidth = mRight - mLeft;
    mHeight = mBottom - mTop;

    // temp values for now
    mTextX = mLeft;
    mTextY = mBottom;

    isHoveredOver = false;
  }

  public void draw(Graphics mBuffer) {
    if(isHoveredOver) {
      mBuffer.setColor(Color.GREEN);
      mBuffer.fillRect(mLeft - 5, mTop - 5, mWidth + 10, mHeight + 10);
    }
    mBuffer.setColor(Color.WHITE);
    mBuffer.fillRect(mLeft, mTop, mWidth, mHeight);
    mBuffer.setColor(Color.BLACK);
    mBuffer.drawRect(mLeft, mTop, mWidth, mHeight);
    mBuffer.drawString(mText, mTextX, mTextY);
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
}
