
import javax.swing.JFrame;

import utils.GameUtil;
import screens.OmniPanel;

public class GameDriver {

  public static void main(String[] args) {
    JFrame playWindow = new JFrame("Advanced War: Clone War");
    playWindow.setSize(GameUtil.WIDTH, GameUtil.HEIGHT);
    playWindow.setLocation(100,100);
    playWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    OmniPanel contentPanel = new OmniPanel();
    playWindow.setContentPane(contentPanel);
    playWindow.setVisible(true);
    playWindow.setResizable(false);
    contentPanel.requestFocus();
  }
}
