package src.screens;

import java.awt.Graphics;

import src.gui.ClickablePanel;
import src.utils.StyleUtil;

public class OptionsMenuPanel extends GamePanel {
  public OptionsMenuPanel(OmniPanel parent, Graphics buffer) {
    super(parent, buffer);

    ClickablePanel backButton = new ClickablePanel(
        0,
        0,
        100,
        50,
        "Back",
        StyleUtil.FONTS.SUBTITLE_FONT,
        ClickablePanel.ALIGNMENT.CENTER,
        parent.getStyleUtil()) {
            public void onClickCallback() {
              parent.navigateBackOneScreen();
            }
        };
    registerClickablePanel(backButton);
  }
}
