package br.com.softblue.snake.util;

import java.util.List;

import br.com.softblue.snake.graphics.Rect;

public class GameUtils {

	public static void moveRect(List<Rect> rects) {
		for (int i = rects.size() - 1; i >= 1; i--) {
			rects.set(i, rects.get(i - 1));
		}
	}
	
	public static void sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
		}
	}
}
