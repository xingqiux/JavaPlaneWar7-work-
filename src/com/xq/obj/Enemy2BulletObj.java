package com.xq.obj;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import com.xq.GameWin;

public class Enemy2BulletObj extends GameObj{
	
	
	public Enemy2BulletObj() {
		
	}
	
	public Enemy2BulletObj(Image img, int width, int height, int x, int y, double speed, GameWin frame) {
		super(img, width, height, x, y, speed, frame);
	}
	
	public Enemy2BulletObj(Image img, int x, int y, double speed) {
		super(img, x, y, speed );
	}
	
	@Override
	public void paintSelf(Graphics g) {
		super.paintSelf(g);
		y += speed;
	}
	
	public Rectangle getRec() {
		return super.getRec();
	}
}
