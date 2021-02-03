package br.com.softblue.snake.graphics;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Drawable {
	private Color color;
	
	public Drawable() {
		color = Color.BLACK;
	}
	
	public Drawable(Color color) {
		this.color = color;
	}
	
	public Color getColor() {
		return color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public abstract void draw(Graphics g);
}
