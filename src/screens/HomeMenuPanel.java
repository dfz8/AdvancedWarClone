package src.screens;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JButton;

import src.gui.ClickablePanel;
import src.gui.TextButton;
import src.gui.layouts.LayoutManager;
import src.utils.GameUtil;
import src.utils.StyleUtil;

public class HomeMenuPanel extends GamePanel {
  private LayoutManager mLayoutManager;

  public HomeMenuPanel(OmniPanel parent, Graphics buffer) {
    super(parent, buffer);
    mLayoutManager = new LayoutManager(
      0,
      0,
      GameUtil.WIDTH,
      GameUtil.HEIGHT,
      LayoutManager.FLEX_DIRECTION.VERTICAL);

    int width = 200;
    int height = 100;

    TextButton playButton =
        new TextButton(
            width, height,
            "Play",
            StyleUtil.FONTS.TITLE_FONT,
            TextButton.TEXT_ALIGNMENT.CENTER,
            parent.getStyleUtil()) {
                public void onClickCallback() {
                  parent.navigateToScreen(new LevelMenuPanel(parent, buffer));
            }
        };

    TextButton optionButton =
        new TextButton(
            width, height,
            "Options",
            StyleUtil.FONTS.TITLE_FONT,
            TextButton.TEXT_ALIGNMENT.CENTER,
            parent.getStyleUtil()) {
                public void onClickCallback() {
                  parent.navigateToScreen(new OptionsMenuPanel(parent, buffer));
            }
        };

    registerClickablePanel(playButton);
    registerClickablePanel(optionButton);
    mLayoutManager.add(playButton);
    mLayoutManager.add(optionButton);
  }
  
  public void updateState(long timeElapsed) {}
  public void updateVisualState() {}
}
