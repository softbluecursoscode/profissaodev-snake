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

import static br.com.softblue.snake.core.Direction.DOWN;
import static br.com.softblue.snake.core.Direction.LEFT;
import static br.com.softblue.snake.core.Direction.NONE;
import static br.com.softblue.snake.core.Direction.RIGHT;
import static br.com.softblue.snake.core.Direction.UP;
import static br.com.softblue.snake.util.Constants.SNAKE_COLOR;
import static br.com.softblue.snake.util.Constants.SNAKE_ELONGATE_PIECES;
import static br.com.softblue.snake.util.Constants.SNAKE_INITIAL_SIZE;
import static br.com.softblue.snake.util.Constants.SNAKE_PIECE_SIZE;
import static br.com.softblue.snake.util.Constants.SNAKE_START_X;
import static br.com.softblue.snake.util.Constants.SNAKE_START_Y;

import java.awt.Dimension;
import java.awt.Point;

import br.com.softblue.snake.core.Direction;
import br.com.softblue.snake.graphics.Rect;
import br.com.softblue.snake.graphics.Shape;
import br.com.softblue.snake.util.GameUtils;

public class Snake extends Shape {
	
	private Direction direction;
	private int piecesToElongate;

	public Snake() {
		super(SNAKE_COLOR);
		direction = NONE;

		Point p = new Point(SNAKE_START_X, SNAKE_START_Y);
		Dimension d = new Dimension(SNAKE_PIECE_SIZE, SNAKE_PIECE_SIZE);
		
		Rect rect = new Rect(p, d);
		addRect(rect);
		
		for (int i = 1; i < SNAKE_INITIAL_SIZE; i++) {
			rect = duplicateRect(rect, LEFT);
			addRect(rect);
		}
	}
	
	public void move() {
		if (direction != NONE) {
			Rect head = getFirstRect();
			Rect tail = getLastRect();
			GameUtils.moveRects(getRects());
			
			Rect newHead = duplicateRect(head, direction);
			getRects().set(0, newHead);
			
			if (piecesToElongate > 0) {
				getRects().add(tail);
				piecesToElongate--;
			}
		}
	}
	
	public void right() {
		if (direction.canChangeTo(RIGHT)) {
			direction = RIGHT;
		}
	}
	
	public void left() {
		if (direction.canChangeTo(LEFT) && direction != NONE) {
			direction = LEFT;
		}
	}
	
	public void up() {
		if (direction.canChangeTo(UP)) {
			direction = UP;
		}
	}
	
	public void down() {
		if (direction.canChangeTo(DOWN)) {
			direction = DOWN;
		}
	}
	
	public void elongate() {
		piecesToElongate = SNAKE_ELONGATE_PIECES;
	}
	
	public boolean collidedWithItself() {
		Rect head = getFirstRect();
		
		for (int i = 1; i < size(); i++) {
			Rect rect = getRect(i);
			if (head.intersects(rect)) {
				return true;
			}
		}
		
		return false;
	}
}
