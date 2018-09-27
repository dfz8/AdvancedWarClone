package src.screens;

import java.awt.event.MouseEvent;
import java.awt.Graphics;
import java.util.LinkedList;

import src.gui.ClickablePanel;
import src.gui.TextButton;
import src.gui.layouts.LayoutManager;
import src.utils.GameUtil;
import src.utils.StyleUtil;

public class LevelMenuPanel extends GamePanel {
  private LayoutManager mLevelLayoutManager;
  private LinkedList<LevelRowPanel> mLevels;

  public LevelMenuPanel(OmniPanel parent, Graphics buffer) {
    super(parent, buffer);
    mLevelLayoutManager = new LayoutManager(
        0,
        0,
        GameUtil.WIDTH,
        GameUtil.HEIGHT,
        LayoutManager.FLEX_DIRECTION.VERTICAL,
        LayoutManager.ALIGN_CONTENT.SPACE_BETWEEN);

    // TODO: load level state from save. then populate contents of levels

    // proof of concept:
    mLevels = new LinkedList<LevelRowPanel>();
    LevelRowPanel tutorialLevels = new LevelRowPanel(parent, buffer, "Tutorial", 500, 100);
    LevelRowPanel campaign1 = new LevelRowPanel(parent, buffer, "Red Campaign", 500, 100);
    mLevelLayoutManager.add(tutorialLevels.getLayoutManager());
    mLevelLayoutManager.add(campaign1.getLayoutManager());
    mLevels.add(tutorialLevels);
    mLevels.add(campaign1);
  }

  public void updateState(long timeElapsed) {}

  public void updateVisualState() {
    for (LevelRowPanel row : mLevels) {
      row.updateVisualState();
    }
  }

  public void processMouseClickEvent(MouseEvent e) {
    for (LevelRowPanel panel : mLevels) {
      panel.processMouseClickEvent(e);
    }
  }

  public void processMouseMoveEvent(MouseEvent e) {
    for(LevelRowPanel panel : mLevels) {
      panel.processMouseMoveEvent(e);
    }
  }

  class LevelRowPanel extends GamePanel {
    private LayoutManager mLayoutManager;
    private String mTitle;
    private LinkedList<ClickablePanel> mContent;

    public LevelRowPanel(
        OmniPanel parent,
        Graphics buffer,
        String title,
        int width,
        int height) {
      super(parent, buffer);
      mTitle = title;
      mLayoutManager = new LayoutManager(
          0,
          0,
          width,
          height,
          LayoutManager.FLEX_DIRECTION.HORIZONTAL,
          LayoutManager.ALIGN_CONTENT.SPACE_BETWEEN);
      // register bunch of buttons to the layout
      mContent = new LinkedList<ClickablePanel>();
      StyleUtil styleUtil = parent.getStyleUtil();
      TextButton titleCard =
          new TextButton(
              150,
              50,
              mTitle,
              StyleUtil.FONTS.SUBTITLE_FONT,
              TextButton.TEXT_ALIGNMENT.CENTER,
              styleUtil);
      titleCard.setIsEnabled(false);

      registerClickablePanel(titleCard);
      mLayoutManager.add(titleCard);

      // add dummy clickables
      for (int i = 0; i < 4; i++) {
        ClickablePanel cp = new ClickablePanel(75, 75, styleUtil);
        registerClickablePanel(cp);
        mLayoutManager.add(cp);
      }
    }

    public void updateState(long timeElapsed) {}

    public void updateVisualState() {
      getBuffer().setColor(getParent().getStyleUtil().getLevelBackgroundColor());
      getBuffer().fillRoundRect(
          mLayoutManager.getX(),
          mLayoutManager.getY(),
          mLayoutManager.getWidth(),
          mLayoutManager.getHeight(),
          20,
          20);

      drawClickablePanelViews();
    }

    public LayoutManager getLayoutManager() {
      return mLayoutManager;
    }
  }
}
