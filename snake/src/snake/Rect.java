package snake;

import java.awt.Color;
import java.awt.Graphics;

public class Rect {
	private int x;
	private int y;
	private int width;
	private int height;
	private Color color;
	
	public Rect(int x, int y, int width, int height, Color color) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
	}
	
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, width, height);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	public Color getColor() {
		return color;
	}
}
