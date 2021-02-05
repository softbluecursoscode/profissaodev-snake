package br.com.softblue.snake.graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Text extends Drawable {
	private String text;
	private Point location;

	public Text(String text, Point location, Color color) {
		super(color);
		this.text = text;
		this.location = location;
	}

	@Override
	public void draw(Graphics g) {
		g.drawString(text, (int) location.getX(), (int) location.getY());
	}
}
