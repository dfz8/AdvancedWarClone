package screens;

import gui.ButtonFactory;

import java.awt.Graphics;

public class OptionsMenuPanel extends GamePanel {
  public OptionsMenuPanel(final OmniPanel parent, final Graphics buffer) {
    super(parent, buffer);

    registerClickablePanel(
        ButtonFactory.getButton(this, ButtonFactory.ButtonType.DEFAULT_BACK));
  }

  public void updateState(long timeElapsed) {
  }

  public void updateVisualState() {
    drawClickablePanelViews();
  }
}
