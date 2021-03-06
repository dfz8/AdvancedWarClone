package gui;

import utils.StyleUtil;

import java.awt.Font;
import java.awt.Graphics;

public class TextButton extends ClickablePanel {
  private static int padding = 10;
  private String mText;
  private int mTextXOffset;
  private int mTextYOffset;
  private Font mFont;

  public TextButton(
      int width,
      int height,
      String text,
      StyleUtil.Fonts font,
      Alignment alignment,
      StyleUtil styleUtil) {
    this(0, 0, width, height, text, font, alignment, styleUtil);
  }

  public TextButton(
      int x,
      int y,
      int width,
      int height,
      String text,
      StyleUtil.Fonts font,
      Alignment alignment,
      StyleUtil styleUtil) {
    super(x, y, width, height, styleUtil);

    mText = text;
    mFont = getStyleUtil().getFont(font);
    computeAlignment(font, alignment);
  }

  // Computes the (x, y) for the baseline of the first line of text
  private void computeAlignment(StyleUtil.Fonts font, Alignment alignment) {
    SimpleRect rect = new SimpleRect();
    getStyleUtil().measureString(font, mText, rect);
    switch (alignment) {
      case CENTER:
        mTextXOffset = (getRight() - rect.getWidth()) / 2;
        mTextYOffset = (getBottom() + rect.getHeight()) / 2;
        break;
      case LEFT:
        mTextXOffset = padding;
        mTextYOffset = padding + rect.getHeight();
        break;
    }
  }

  public void draw(Graphics buffer) {
    super.draw(buffer);
    buffer.setFont(mFont);
    buffer.setColor(getStyleUtil().getTextColor());
    buffer.drawString(mText, getLeft() + mTextXOffset, getTop() + mTextYOffset);
  }

}
