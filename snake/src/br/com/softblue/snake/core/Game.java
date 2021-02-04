package br.com.softblue.snake.core;

import br.com.softblue.snake.graphics.Renderer;
import br.com.softblue.snake.scene.Background;
import br.com.softblue.snake.scene.Snake;
import br.com.softblue.snake.util.GameUtils;

public class Game implements Runnable {
	private GameWindow gameWindow;
	private Snake snake;
	private Renderer renderer;
	
	public void start() {
		snake = new Snake();
		gameWindow = new GameWindow(snake);
		renderer = gameWindow.getRenderer();
		addElementsToScreen();
	
		new Thread(this).start();
	}

	private void addElementsToScreen() {
		renderer.add(new Background());
		renderer.add(snake);
	}
	
	@Override
	public void run() {
		while (!isGameOver()) {
			snake.move();
			gameWindow.repaint();
			GameUtils.sleep(30);
		}
		
		gameWindow.dispose();
	}
	
	private boolean isGameOver() {
		return snake.collidesWithItself();
	}
}
