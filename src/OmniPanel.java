/**
 * This class contains all the listeners and hosts the current visible content.
 */
package src;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JPanel;
import javax.swing.Timer;

import src.gui.ClickablePanel;

public class OmniPanel extends JPanel {
  // approx 30hz update
  private static final long UPDATE_TIME_THRESHOLD = 33000000;

  private BufferedImage mImage;
  private Graphics mBuffer;
  private Color mBackgroundColor = Color.YELLOW;
  private GamePanel mCurrentPanel;
  private MouseAdapter mMouseClickListener;
  private MouseMotionAdapter mMouseMotionListener;
  private Timer mTimer;
  private long mLastTime;
  private long mCheckTime;

  public OmniPanel() {
    mImage = new BufferedImage(
        GameDriver.WIDTH,
        GameDriver.HEIGHT,
        BufferedImage.TYPE_INT_RGB);
    mBuffer = mImage.getGraphics();

    mCurrentPanel = new MenuPanel(this, mBuffer);

    mTimer = new Timer(30, new RefreshListener());
    mMouseClickListener = new MouseClickListener();
    mMouseMotionListener = new MouseMotionListener();
    add(mCurrentPanel);
    addMouseListener(mMouseClickListener);
    addMouseMotionListener(mMouseMotionListener);
    setFocusable(true);
    mLastTime = System.nanoTime();
    mTimer.start();
  }

  public void navigateToScreen(GamePanel panel) {
    if (mCurrentPanel == panel) {
      System.out.println("Already on this panel.");
      return;
    }
    mCurrentPanel = panel;
    // does this refresh what to draw?
  }

  public void paintComponent(Graphics g){
     g.drawImage(mImage, 0, 0, GameDriver.WIDTH, GameDriver.HEIGHT, null);
  }

  public class RefreshListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      mCheckTime = System.nanoTime();
      if ( mCheckTime - mLastTime > UPDATE_TIME_THRESHOLD) {
        mBuffer.setColor(mBackgroundColor);
        mBuffer.fillRect(0, 0, GameDriver.WIDTH, GameDriver.HEIGHT);
        // update graphics
        mCurrentPanel.updateState(mCheckTime - mLastTime);

        mLastTime = mCheckTime;
        repaint();
      }
    }
  }

  public class MouseMotionListener extends MouseMotionAdapter {
     public void mouseMoved(MouseEvent e) {
       if (mCurrentPanel != null) {
         mCurrentPanel.processMouseMoveEvent(e);
       }
     }
  }

  public class MouseClickListener extends MouseAdapter {
    public void mouseClicked(MouseEvent e) {
      if (mCurrentPanel != null) {
        mCurrentPanel.processMouseClickEvent(e);
      }
    }
  }
}
