package screens;

import gui.ButtonFactory;
import gui.TextButton;
import gui.layouts.LayoutManager;
import utils.GameUtil;

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

    setUpNavigationButtons();
  }

  public void updateState(long timeElapsed) {
  }

  public void updateVisualState() {
    drawClickablePanelViews();
  }

  private void setUpNavigationButtons() {
    TextButton playButton =
        (TextButton) ButtonFactory.getButton(
            this,
            ButtonFactory.ButtonType.PLAY);
    registerClickablePanel(playButton);
    mLayoutManager.add(playButton);

    TextButton optionButton =
        (TextButton) ButtonFactory.getButton(
            this,
            ButtonFactory.ButtonType.OPTIONS);
    registerClickablePanel(optionButton);
    mLayoutManager.add(optionButton);
  }
}
