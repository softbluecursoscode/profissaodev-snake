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
package br.com.softblue.snake.scene;

import static br.com.softblue.snake.util.Constants.FOOD_COLOR;
import static br.com.softblue.snake.util.Constants.FOOD_SIZE;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

import br.com.softblue.snake.graphics.Rect;
import br.com.softblue.snake.util.GameUtils;

public class Food extends Rect {
	private int eatenTimes;

	public Food(Snake snake, Rectangle drawingArea) {
		setRandomLocation(snake, drawingArea);
		setDimension(new Dimension(FOOD_SIZE, FOOD_SIZE));
		setColor(FOOD_COLOR);
	}

	public void setRandomLocation(Snake snake, Rectangle drawingArea) {
		int offset = 3;
		
		do {
			int x = GameUtils.random((int) drawingArea.getMinX() + offset, (int) drawingArea.getMaxX() - FOOD_SIZE - offset);
			int y = GameUtils.random((int) drawingArea.getMinY() + offset, (int) drawingArea.getMaxY() - FOOD_SIZE - offset);
			
			setlocation(new Point(x, y));
		} while(snake.intersects(this));
	}
	
	public void checkIfEaten(Snake snake, Rectangle drawingArea) {
		if (snake.intersects(this)) {
			eatenTimes++;
			setRandomLocation(snake, drawingArea);
			snake.elongate();
		}
	}
	
	public int getEatenTimes() {
		return eatenTimes;
	}
}
