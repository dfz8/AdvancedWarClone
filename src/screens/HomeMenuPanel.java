package src.screens;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JButton;

import src.gui.ClickablePanel;
import src.gui.layouts.LayoutManager;
import src.utils.GameUtil;
import src.utils.StyleUtil;

public class HomeMenuPanel extends GamePanel {
  private static final String GAME_DIR = "../game_files/";
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

    ClickablePanel playButton =
        new ClickablePanel(
            width, height,
            "Play",
            StyleUtil.FONTS.TITLE_FONT,
            ClickablePanel.ALIGNMENT.CENTER,
            parent.getStyleUtil()) {
                public void onClickCallback() {
                  loadGame("testGame.json");
            }
        };

    ClickablePanel optionButton =
        new ClickablePanel(
            width, height,
            "Options",
            StyleUtil.FONTS.TITLE_FONT,
            ClickablePanel.ALIGNMENT.CENTER,
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

  public void loadGame(String filename) {
    // GameLevelBuilder.buildFrom(filename);
    System.out.println("Loading game from file: " + filename);
  }

}
