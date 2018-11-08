package screens;

import gui.Alignment;
import gui.ButtonFactory;
import gui.TextButton;
import gui.layouts.ButtonConfig;
import gui.layouts.LayoutManager;
import utils.GameUtil;
import utils.OnClickListener;
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

    setUpPlayButton(width, height);
    setUpOptionButton(width, height);
  }

  public void updateState(long timeElapsed) {
  }

  public void updateVisualState() {
    drawClickablePanelViews();
  }

  private void setUpPlayButton(int width, int height) {
    TextButton playButton =
        (TextButton) ButtonFactory.getTextButton(
            new ButtonConfig.Builder()
                .setWidth(width)
                .setHeight(height)
                .setText("Play")
                .setFont(StyleUtil.Fonts.TITLE_FONT)
                .setAlignment(Alignment.CENTER)
                .setStyleUtil(getParent().getStyleUtil())
                .setOnClickListener(
                    new OnClickListener() {
                      @Override
                      public void onClick() {
                        getParent().navigateToScreen(new LevelMenuPanel(
                            getParent(),
                            getBuffer()));
                      }
                    }
                ).build());
    registerClickablePanel(playButton);
    mLayoutManager.add(playButton);
  }

  private void setUpOptionButton(int width, int height) {
    TextButton optionButton =
        (TextButton) ButtonFactory.getTextButton(
            new ButtonConfig.Builder()
                .setWidth(width)
                .setHeight(height)
                .setText("Options")
                .setFont(StyleUtil.Fonts.TITLE_FONT)
                .setAlignment(Alignment.CENTER)
                .setStyleUtil(getParent().getStyleUtil())
                .setOnClickListener(
                    new OnClickListener() {
                      @Override
                      public void onClick() {
                        getParent().navigateToScreen(new OptionsMenuPanel(
                            getParent(),
                            getBuffer()));
                      }
                    }
                ).build());
    registerClickablePanel(optionButton);
    mLayoutManager.add(optionButton);
  }
}
