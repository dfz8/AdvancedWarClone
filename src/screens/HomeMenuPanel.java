package screens;

import gui.TextButton;
import gui.layouts.LayoutManager;
import utils.GameUtil;
import utils.StyleUtil;

import java.awt.Graphics;

public class HomeMenuPanel extends GamePanel {
  private LayoutManager mLayoutManager;

  public HomeMenuPanel(final OmniPanel parent, final Graphics buffer) {
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

  public void updateVisualState() {
    drawClickablePanelViews();
  }
}
