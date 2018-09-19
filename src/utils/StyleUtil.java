package src.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.FontMetrics;

import src.gui.SimpleRect;

public class StyleUtil {
  public static enum FONTS {
    TITLE_FONT,
    SUBTITLE_FONT,
    TEXT_FONT,
  };

  private static final Color HIGHLIGHT_COLOR = Color.GREEN;
  private static final Color BACKGROUND_COLOR = Color.WHITE;
  private static final Color PANEL_BACKGROUND_COLOR = Color.YELLOW;
  private static final Color TEXT_COLOR = Color.BLACK;
  private static final Color OUTLINE_COLOR = Color.GRAY;

  private static final Font titleFont = new Font("Agency FB",Font.BOLD,25);
  private static final Font subtitleFont = new Font("Agency FB",Font.BOLD,18);
  private static final Font textFont = new Font("Agency FB",Font.PLAIN,15);
  private static FontMetrics titleFontMetrics;
  private static FontMetrics subtitleFontMetrics;
  private static FontMetrics textFontMetrics;

  private boolean isDarkTheme;

  public StyleUtil(Graphics g) {
    titleFontMetrics = g.getFontMetrics(titleFont);
    subtitleFontMetrics = g.getFontMetrics(subtitleFont);
    textFontMetrics = g.getFontMetrics(textFont);
    isDarkTheme = false;
  }

  public Font getFont(FONTS font) {
    switch(font) {
      case TITLE_FONT:
        return titleFont;
      case SUBTITLE_FONT:
        return subtitleFont;
      case TEXT_FONT:
        return textFont;
    }
    return null;
  }

  public Color getHighlightColor() { return HIGHLIGHT_COLOR; }

  public Color getBackgroundColor() { return BACKGROUND_COLOR; }

  public Color getPanelBackgroundColor() { return PANEL_BACKGROUND_COLOR; }

  public Color getTextColor() { return TEXT_COLOR; }

  public Color getOutlineColor() { return OUTLINE_COLOR; }

  public void measureString(FONTS font, String text, SimpleRect bounds) {
    switch(font) {
      case TITLE_FONT:
        bounds.setRight(titleFontMetrics.stringWidth(text));
        bounds.setBottom(titleFontMetrics.getHeight());
        break;
      case SUBTITLE_FONT:
        bounds.setRight(subtitleFontMetrics.stringWidth(text));
        bounds.setBottom(subtitleFontMetrics.getHeight());
        break;
      case TEXT_FONT:
        bounds.setRight(textFontMetrics.stringWidth(text));
        bounds.setBottom(textFontMetrics.getHeight());
        break;
    }
  }


}
