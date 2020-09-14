/*******************************************************************************
 * MIT License
 *
 * Copyright (c) 2020 softbluecursoscode
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *******************************************************************************/
package br.com.softblue.snake.core;

import static br.com.softblue.snake.util.Constants.SNAKE_PIECE_SIZE;

import java.awt.Rectangle;

import br.com.softblue.snake.graphics.Rect;
import br.com.softblue.snake.graphics.Renderer;
import br.com.softblue.snake.scene.Background;
import br.com.softblue.snake.scene.Food;
import br.com.softblue.snake.scene.GameOverText;
import br.com.softblue.snake.scene.Snake;
import br.com.softblue.snake.util.Constants;
import br.com.softblue.snake.util.GameUtils;

public class Game implements Runnable {
	private GameWindow gameWindow;
	private Renderer renderer;
	private Snake snake;
	private Food food;

	public void start() {
		snake = new Snake();
		gameWindow = new GameWindow(snake);
		food = new Food(snake, gameWindow.getDrawingArea());
		renderer = gameWindow.getRenderer();
		
		addElementsToScreen();
		
		new Thread(this).start();
	}
	
	private void addElementsToScreen() {
		renderer.add(new Background());
		renderer.add(snake);
		renderer.add(food);
	}
	
	@Override
	public void run() {
		do {
			gameWindow.repaint();
			snake.move();
			food.checkIfEaten(snake, gameWindow.getDrawingArea());
			GameUtils.sleep(Constants.SLEEP_TIME);
		
		} while (!isGameOver());
		
		processGameOver();
	}
	
	private void processGameOver() {
		renderer.remove(snake);
		renderer.remove(food);
		renderer.add(new GameOverText(food.getEatenTimes()));
		gameWindow.repaint();
	}
	
	private boolean isGameOver() {
		return isSnakeHitBounds() || snake.collidedWithItself();
	}
	
	private boolean isSnakeHitBounds() {
		Rect head = snake.getFirstRect();
		Rectangle drawingArea = gameWindow.getDrawingArea();
		
		int headX = (int) head.getLocation().getX();
		int headY = (int) head.getLocation().getY();
		
		int areaX1 = (int) drawingArea.getMinX();
		int areaY1 = (int) drawingArea.getMinY() - SNAKE_PIECE_SIZE * 2;
		
		int areaX2 = (int) drawingArea.getMaxX();
		int areaY2 = (int) drawingArea.getMaxY();
		
		if (headX <= areaX1 || headX + SNAKE_PIECE_SIZE >= areaX2) {
			return true;
		}
		
		if (headY <= areaY1 || headY + SNAKE_PIECE_SIZE >= areaY2) {
			return true;
		}

		return false;
	}
}
