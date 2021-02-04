package br.com.softblue.snake.scene;

import br.com.softblue.snake.core.Direction;
import br.com.softblue.snake.graphics.Rect;
import br.com.softblue.snake.graphics.Shape;
import br.com.softblue.snake.util.Constants;
import br.com.softblue.snake.util.GameUtils;

public class Snake extends Shape {
	private Direction direction;

	public Snake() {
		super(Constants.SNAKE_COLOR);

		direction = Direction.NONE;
		Rect rect = new Rect(Constants.SNAKE_INITIAL_X, Constants.SNAKE_INITIAL_Y, Constants.SNAKE_PIECE_SIZE,
				Constants.SNAKE_PIECE_SIZE);
		addRect(rect);

		for (int i = 1; i < Constants.SNAKE_SIZE; i++) {
			rect = duplicate(rect, Direction.LEFT);
			addRect(rect);
		}
	}
	
	public void move() {
		if (direction != Direction.NONE) {
			Rect head = getFirstRect();
			GameUtils.moveRect(getRects());
			Rect newHead = duplicate(head, direction);
			getRects().set(0, newHead);
		}
	}

	public void up() {
		if (direction.canChangeTo(Direction.UP)) {
			direction = Direction.UP;
		}
	}

	public void down() {
		if (direction.canChangeTo(Direction.DOWN)) {
			direction = Direction.DOWN;
		}
	}

	public void left() {
		if (direction.canChangeTo(Direction.LEFT)) {
			direction = Direction.LEFT;
		}
	}

	public void right() {
		if (direction.canChangeTo(Direction.RIGHT)) {
			direction = Direction.RIGHT;
		}
	}
	
	public boolean collidesWithItself() {
		Rect head = getFirstRect();
		
		for (int i = 1; i < getRects().size(); i++) {
			Rect rect = getRects().get(i);
			if (head.intersects(rect)) {
				return true;
			}
		}
		
		return false;
	}
}
