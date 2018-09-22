package src.screens;

import java.awt.event.MouseEvent;
import java.awt.Graphics;
import java.util.LinkedList;
import javax.swing.JPanel;

import src.gui.ClickablePanel;

public abstract class GamePanel extends JPanel {
  private OmniPanel mParent;
  private Graphics mBuffer;
  private LinkedList<ClickablePanel> mClickablePanels;

  public GamePanel(OmniPanel parent, Graphics buffer) {
    mParent = parent;
    mBuffer = buffer;
    mClickablePanels = new LinkedList<ClickablePanel>();
  }

  public abstract void updateState(long timeElapsed);

  public abstract void updateVisualState();

  public void drawClickablePanelViews() {
    for (ClickablePanel cp : mClickablePanels) {
      cp.draw(mBuffer);
    }
  }

  public boolean registerClickablePanel(ClickablePanel cp) {
    return mClickablePanels.add(cp);
  }

  public boolean unregisterClickablePanel(ClickablePanel cp) {
    return mClickablePanels.remove(cp);
  }

  public void processMouseClickEvent(MouseEvent e) {
    int x = e.getX();
    int y = e.getY();
    for(ClickablePanel cp : mClickablePanels) {
      cp.onMouseClick(x, y);
    }
  }

  public void processMouseMoveEvent(MouseEvent e) {
    int x = e.getX();
    int y = e.getY();
    for(ClickablePanel cp : mClickablePanels) {
      cp.onMouseMove(x, y);
    }
  }

  public Graphics getBuffer() { return mBuffer; }
}
