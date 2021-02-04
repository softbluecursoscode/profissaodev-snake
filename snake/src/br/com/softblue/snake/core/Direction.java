package br.com.softblue.snake.core;

public enum Direction {
	NONE(0, 0),
	UP(0, -1),
	DOWN(0, 1),
	LEFT(-1, 0),
	RIGHT(1, 0);
	
	int sgnX;
	int sgnY;
	
	Direction(int sgnX, int sgnY) {
		this.sgnX = sgnX;
		this.sgnY = sgnY;
	}
	
	public int getSgnX() {
		return sgnX;
	}
	
	public int getSgnY() {
		return sgnY;
	}
	
	public boolean canChangeTo(Direction other) {
		return !(sgnX + other.sgnX == 0 && sgnY + other.sgnY == 0);
	}
}
