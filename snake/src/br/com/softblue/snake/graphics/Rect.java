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
package br.com.softblue.snake.graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class Rect extends Drawable {
	private Rectangle rect;
	
	public Rect() {
		super(Color.BLACK);
		rect = new Rectangle(0, 0, 0, 0);
	}
	
	public Rect(int x, int y, int width, int height) {
		super(Color.BLACK);
		rect = new Rectangle(x, y, width, height);
	}
	
	public Rect(Point location, Dimension dimension) {
		super(Color.BLACK);
		rect = new Rectangle(location, dimension);
	}

	public Point getLocation() {
		return rect.getLocation();
	}
	
	public void setlocation(Point location) {
		rect.setLocation(location);
	}
	
	public Dimension getDimension() {
		return rect.getSize();
	}
	
	public void setDimension(Dimension dimension) {
		rect.setSize(dimension);
	}
	
	public boolean intersects(Rect other) {
		return rect.intersects(other.rect);
	}

	@Override
	public void draw(Graphics g) {
		g.fillRect((int) rect.getX(), (int) rect.getY(), (int) rect.getWidth(), (int) rect.getHeight());
	}
}
