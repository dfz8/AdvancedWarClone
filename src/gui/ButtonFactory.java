package gui;

import gui.layouts.ButtonConfig;
import screens.GamePanel;
import screens.LevelMenuPanel;
import screens.OptionsMenuPanel;
import utils.OnClickListener;
import utils.StyleUtil;

public class ButtonFactory {
  public enum ButtonType {
    DEFAULT_BACK,
    PLAY,
    OPTIONS,
  }

  public static ClickablePanel getButton(
      final GamePanel panel,
      ButtonType type) {
    switch (type) {
      case DEFAULT_BACK:
        return getTextButton(
            new ButtonConfig.Builder()
                .setX(0)
                .setY(0)
                .setWidth(100)
                .setHeight(50)
                .setText("Back")
                .setFont(StyleUtil.Fonts.SUBTITLE_FONT)
                .setAlignment(Alignment.CENTER)
                .setStyleUtil(panel.getParent().getStyleUtil())
                .setOnClickListener(
                    new OnClickListener() {
                      @Override
                      public void onClick() {
                        panel.getParent().navigateBackOneScreen();
                      }
                    })
                .build());
      case PLAY:
        return getTextButton(
            new ButtonConfig.Builder()
                .setWidth(200)
                .setHeight(100)
                .setText("Play")
                .setFont(StyleUtil.Fonts.TITLE_FONT)
                .setAlignment(Alignment.CENTER)
                .setStyleUtil(panel.getParent().getStyleUtil())
                .setOnClickListener(
                    new OnClickListener() {
                      @Override
                      public void onClick() {
                        panel.getParent()
                             .navigateToScreen(new LevelMenuPanel(
                                 panel.getParent(),
                                 panel.getBuffer()));
                      }
                    }).build());
      case OPTIONS:
        return getTextButton(
            new ButtonConfig.Builder()
                .setWidth(200)
                .setHeight(100)
                .setText("Options")
                .setFont(StyleUtil.Fonts.TITLE_FONT)
                .setAlignment(Alignment.CENTER)
                .setStyleUtil(panel.getParent().getStyleUtil())
                .setOnClickListener(
                    new OnClickListener() {
                      @Override
                      public void onClick() {
                        panel.getParent().navigateToScreen(new OptionsMenuPanel(
                            panel.getParent(),
                            panel.getBuffer()));
                      }
                    }
                ).build());
      default:
        throw new IllegalArgumentException("Button type " + type.toString() +
                                           " does not have a default configuration");
    }
  }

  public static ClickablePanel getTextButton(ButtonConfig config) {
    ClickablePanel textButton = new TextButton(
        config.getWidth(),
        config.getHeight(),
        config.getText(),
        config.getFont(),
        config.getAlignment(),
        config.getStyleUtil());
    textButton.setOnClickListener(config.getOnClickListener());
    return textButton;
  }
}
