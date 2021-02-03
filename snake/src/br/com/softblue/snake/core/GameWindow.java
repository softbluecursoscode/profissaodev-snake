package br.com.softblue.snake.core;

import java.awt.Graphics;

import javax.swing.JFrame;

import br.com.softblue.snake.graphics.Renderer;
import br.com.softblue.snake.util.Constants;

@SuppressWarnings("serial")
public class GameWindow extends JFrame {
	
	private Renderer renderer;

	public GameWindow() {
		renderer = new Renderer();
		
		setTitle(Constants.GAME_TITLE);
		setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
	
	@Override
	public void paint(Graphics g) {
		renderer.render(g);
	}
	
	public Renderer getRenderer() {
		return renderer;
	}
}
