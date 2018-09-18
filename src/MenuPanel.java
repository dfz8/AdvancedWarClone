package src;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JButton;

import src.gui.ClickablePanel;
import src.styles.StyleUtil;

public class MenuPanel extends GamePanel {
  private static final String GAME_DIR = "../game_files/";

  public MenuPanel(OmniPanel parent, Graphics buffer) {
    super(parent, buffer);

    int width = 200;
    int height = 100;

    ClickablePanel playButton =
        new ClickablePanel(
            (GameDriver.WIDTH - width)/2, 100,
            width, height,
            "Play",
            StyleUtil.FONTS.TITLE_FONT,
            ClickablePanel.ALIGNMENT.CENTER,
            parent.getStyleUtil()) {
            public void onMouseClick(int eX, int eY) {
              if(isClickInBounds(eX, eY)) {
                loadGame("testGame.json");
              }
            }
        };

    ClickablePanel optionButton =
        new ClickablePanel(
            (GameDriver.WIDTH - width)/2, 100 + height + 25,
            width, height,
            "Options",
            StyleUtil.FONTS.TITLE_FONT,
            ClickablePanel.ALIGNMENT.CENTER,
            parent.getStyleUtil()) {
            public void onMouseClick(int eX, int eY) {
              if(isClickInBounds(eX, eY)) {
                System.out.println("going to options menu");
              }
            }
        };

    registerClickablePanel(playButton);
    registerClickablePanel(optionButton);
  }

  public void loadGame(String filename) {
    // GameLevelBuilder.buildFrom(filename);
    System.out.println("Loading game from file: " + filename);
  }

}
