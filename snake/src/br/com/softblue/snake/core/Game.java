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
	
//	private boolean isSnakeHitBounds() {
//		Rect head = snake.getFirstRect();
//		Rectangle drawingArea = gameWindow.getDrawingArea();
//		
//		int headX = (int) head.getLocation().getX();
//		int headY = (int) head.getLocation().getY();
//		
//		int areaX1 = (int) drawingArea.getMinX();
//		int areaY1 = (int) drawingArea.getMinY() - Constants.SNAKE_PIECE_SIZE * 2;
//		
//		int areaX2 = (int) drawingArea.getMaxX();
//		int areaY2 = (int) drawingArea.getMaxY();
//		
//		if (headX <= areaX1 || headX + Constants.SNAKE_PIECE_SIZE >= areaX2) {
//			return true;
//		}
//		
//		if (headY <= areaY1 || headY + Constants.SNAKE_PIECE_SIZE >= areaY2) {
//			return true;
//		}
//
//		return false;
//	}
}
