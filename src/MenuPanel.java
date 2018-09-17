package src;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JButton;

import src.gui.ClickablePanel;

public class MenuPanel extends GamePanel {
  private static final String GAME_DIR = "../game_files/";

  public MenuPanel(OmniPanel parent, Graphics buffer) {
    super(parent, buffer);

    ClickablePanel playButton =
        new ClickablePanel(100, 100, 400, 400, "play button") {
            public void onMouseClick(int eX, int eY) {
              if(isClickInBounds(eX, eY)) {
                loadGame("testGame.json");
              }
            }
        };

    System.out.println(registerClickablePanel(playButton));
  }

  public void loadGame(String filename) {
    // GameLevelBuilder.buildFrom(filename);
    System.out.println("Loading game from file: " + filename);
  }

}
