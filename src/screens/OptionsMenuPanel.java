package screens;

import gui.TextButton;
import utils.StyleUtil;

import java.awt.Graphics;

public class OptionsMenuPanel extends GamePanel {
  public OptionsMenuPanel(OmniPanel parent, Graphics buffer) {
    super(parent, buffer);

    TextButton backButton = new TextButton(
        0,
        0,
        100,
        50,
        "Back",
        StyleUtil.FONTS.SUBTITLE_FONT,
        TextButton.TEXT_ALIGNMENT.CENTER,
        parent.getStyleUtil()) {
            public void onClickCallback() {
              parent.navigateBackOneScreen();
            }
        };
    registerClickablePanel(backButton);
  }

  public void updateState(long timeElapsed) {}
    
  public void updateVisualState() {
    drawClickablePanelViews();
  }
}
