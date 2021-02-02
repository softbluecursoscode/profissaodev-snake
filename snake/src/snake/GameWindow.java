package snake;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class GameWindow extends JFrame {
	
	private Rect background;
	private Rect rect;

	public GameWindow() {
		background = new Rect(0, 0, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT, Constants.BACKGROUND_COLOR);
		rect = new Rect(60, 70, 200, 80, Color.GREEN);
		
		setTitle(Constants.GAME_TITLE);
		setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
	
	@Override
	public void paint(Graphics g) {
		background.draw(g);
		rect.draw(g);
	}
}
