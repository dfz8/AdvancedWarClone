package screens;

import gui.ClickablePanel;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

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

  public boolean processMouseClickEvent(MouseEvent e) {
    int x = e.getX();
    int y = e.getY();
    boolean consumed = false;
    for (ClickablePanel cp : mClickablePanels) {
      // Only the first ClickablePanel will get to process the click
      consumed = consumed || cp.onMouseClick(x, y);
    }
    return consumed;
  }

  public void processMouseMoveEvent(MouseEvent e) {
    int x = e.getX();
    int y = e.getY();
    for (ClickablePanel cp : mClickablePanels) {
      cp.onMouseMove(x, y);
    }
  }

  public OmniPanel getParent() {
    return mParent;
  }

  public Graphics getBuffer() {
    return mBuffer;
  }
}
