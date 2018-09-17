package src;

import javax.swing.JFrame;

public class GameDriver {
  static final int WIDTH = 900;
  static final int HEIGHT = 500;

  public static void main(String[] args) {
    JFrame playWindow = new JFrame("Advanced War: Clone War");
    playWindow.setSize(WIDTH + 8, HEIGHT + 34);
    playWindow.setLocation(100,100);
    playWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    OmniPanel contentPanel = new OmniPanel();
    playWindow.setContentPane(contentPanel);
    playWindow.setVisible(true);
    playWindow.setResizable(false);
    contentPanel.requestFocus();
  }
}
