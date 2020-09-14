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
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import br.com.softblue.snake.core.Direction;

public abstract class Shape extends Drawable {
	private List<Rect> rects;

	public Shape(Color color) {
		super(color);
		rects = new ArrayList<>();
	}

	public List<Rect> getRects() {
		return rects;
	}
	
	public Rect getRect(int index) {
		return rects.get(index);
	}
	
	public Rect getFirstRect() {
		return rects.get(0);
	}
	
	public Rect getLastRect() {
		return rects.get(rects.size() - 1);
	}
	
	public void addRect(Rect rect) {
		rect.setColor(getColor());
		rects.add(rect);
	}
	
	public int size() {
		return rects.size();
	}
	
	public Rect duplicateRect(Rect baseRect, Direction direction) {
		int baseX = (int) baseRect.getLocation().getX();
		int baseY = (int) baseRect.getLocation().getY();
		int baseWidth = (int) baseRect.getDimension().getWidth();
		int baseHeight = (int) baseRect.getDimension().getHeight();
		
		Point p = new Point(baseX + direction.getSgnX() * baseWidth, baseY + direction.getSgnY() * baseHeight);
		return new Rect(p, baseRect.getDimension());
	}
	
	public boolean intersects(Rect other) {
		for (Rect rect : rects) {
			if (rect.intersects(other)) {
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public void draw(Graphics g) {
		for (Rect rect : rects) {
			rect.draw(g);
		}
	}
}
