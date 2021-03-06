/**
 * This class contains all the listeners and hosts the current visible content.
 */
package screens;

import utils.GameUtil;
import utils.StyleUtil;

import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.util.Stack;

public class OmniPanel extends JPanel {
  // approx 30hz update
  private static final long UPDATE_TIME_THRESHOLD = 33000000;
  private StyleUtil mStyleUtil;

  private Stack<GamePanel> mPanelStack;

  private BufferedImage mImage;
  private Graphics mBuffer;
  private GamePanel mCurrentPanel;
  private MouseAdapter mMouseClickListener;
  private MouseMotionAdapter mMouseMotionListener;
  private Timer mTimer;
  private long mLastTime;
  private long mCheckTime;

  public OmniPanel() {
    mImage = new BufferedImage(
        GameUtil.WIDTH,
        GameUtil.HEIGHT,
        BufferedImage.TYPE_INT_RGB);
    mBuffer = mImage.getGraphics();
    mStyleUtil = new StyleUtil(mBuffer);

    mCurrentPanel = new HomeMenuPanel(this, mBuffer);
    mPanelStack = new Stack<GamePanel>();

    mTimer = new Timer(30, new RefreshListener());
    mMouseClickListener = new MouseClickListener();
    mMouseMotionListener = new MouseMotionListener();
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
    mPanelStack.push(mCurrentPanel);
    mCurrentPanel = panel;
  }

  public void navigateBackOneScreen() {
    if (mPanelStack.size() > 0) {
      mCurrentPanel = mPanelStack.pop();
    } else {
      System.out.println("ERROR: Tried to go back on empty stack.");
    }
  }

  public void paintComponent(Graphics g) {
    g.drawImage(mImage, 0, 0, GameUtil.WIDTH, GameUtil.HEIGHT, null);
  }

  public class RefreshListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      mCheckTime = System.nanoTime();
      if (mCheckTime - mLastTime > UPDATE_TIME_THRESHOLD) {
        mBuffer.setColor(mStyleUtil.getBackgroundColor());
        mBuffer.fillRect(0, 0, GameUtil.WIDTH, GameUtil.HEIGHT);

        // process updates
        mCurrentPanel.updateState(mCheckTime - mLastTime);
        mCurrentPanel.updateVisualState();

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

  public StyleUtil getStyleUtil() { return mStyleUtil; }
}
