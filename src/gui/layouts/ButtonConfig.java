package gui.layouts;

import gui.Alignment;
import utils.OnClickListener;
import utils.StyleUtil;
import utils.StyleUtil.Fonts;

public class ButtonConfig {
  private int mX;
  private int mY;
  private int mWidth;
  private int mHeight;
  private StyleUtil mStyleUtil;
  private Fonts mFont;
  private String mText;
  private Alignment mAlignment;
  private OnClickListener mOnClickListener;

  private ButtonConfig(Builder builder) {
    mX = builder.mX;
    mY = builder.mY;
    mWidth = builder.mWidth;
    mHeight = builder.mHeight;
    mStyleUtil = builder.mStyleUtil;
    mOnClickListener = builder.mOnClickListener;
    mFont = builder.mFont;
    mText = builder.mText;
    mAlignment = builder.mAlignment;
  }

  public int getX() {
    return mX;
  }

  public int getY() {
    return mY;
  }

  public int getWidth() {
    return mWidth;
  }

  public int getHeight() {
    return mHeight;
  }

  public StyleUtil getStyleUtil() {
    return mStyleUtil;
  }

  public Fonts getFont() {
    return mFont;
  }

  public String getText() {
    return mText;
  }

  public Alignment getAlignment() {
    return mAlignment;
  }

  public OnClickListener getOnClickListener() {
    return mOnClickListener;
  }

  public static class Builder {
    private int mX;
    private int mY;
    private int mWidth;
    private int mHeight;
    private StyleUtil mStyleUtil;
    private OnClickListener mOnClickListener;
    // Text Button Values
    private Fonts mFont;
    private Alignment mAlignment;
    private String mText;

    public ButtonConfig build() {
      return new ButtonConfig(this);
    }

    public Builder setX(int x) {
      mX = x;
      return this;
    }

    public Builder setY(int y) {
      mY = y;
      return this;
    }

    public Builder setWidth(int width) {
      mWidth = width;
      return this;
    }

    public Builder setHeight(int height) {
      mHeight = height;
      return this;
    }

    public Builder setStyleUtil(StyleUtil styleUtil) {
      mStyleUtil = styleUtil;
      return this;
    }

    public Builder setOnClickListener(OnClickListener onClickListener) {
      mOnClickListener = onClickListener;
      return this;
    }

    public Builder setFont(Fonts font) {
      mFont = font;
      return this;
    }

    public Builder setAlignment(Alignment alignment) {
      mAlignment = alignment;
      return this;
    }

    public Builder setText(String text) {
      mText = text;
      return this;
    }
  }
}
