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
package br.com.softblue.snake.util;

import java.awt.Color;
import java.awt.Point;

public class Constants {
	public static final String WINDOW_TITLE = "Snake!";
	public static final int WINDOW_WIDTH = 400;
	public static final int WINDOW_HEIGHT = 400;
	
	public static final Color BACKGROUND_COLOR = Color.BLACK;

	public static final int SNAKE_PIECE_SIZE = 5;
	public static final int SNAKE_INITIAL_SIZE = 20;
	public static final int SNAKE_START_X = 150;
	public static final int SNAKE_START_Y = 150;
	public static final int SNAKE_ELONGATE_PIECES = 5;
	public static final Color SNAKE_COLOR = Color.WHITE;
	
	public static final int FOOD_SIZE = 6;
	public static final Color FOOD_COLOR = Color.GREEN;

	public static final String GAME_OVER_TEXT = "GAME OVER! %d PONTO(S)";
	public static final Color GAME_OVER_COLOR = Color.RED;
	public static final Point GAME_OVER_location = new Point(WINDOW_WIDTH / 2 - 80, WINDOW_HEIGHT / 2);
	public static final int GAME_MIN_TIME_BETWEEN_KEYBOARD_EVENTS = 40;
	
	public static final int SLEEP_TIME = 30;
	
}
