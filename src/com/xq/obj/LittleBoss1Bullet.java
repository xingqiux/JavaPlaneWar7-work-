package com.xq.obj;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import com.xq.GameWin;

public class LittleBoss1Bullet extends GameObj{

	public LittleBoss1Bullet() {
		
	}

	public LittleBoss1Bullet(Image img, int width, int height, int x, int y, double speed, GameWin frame) {
		super(img, width, height, x, y, speed, frame);
	}
	
	public LittleBoss1Bullet(Image img, int x, int y, double speed) {
		super(img, x, y, speed );
	
	}
	
	
	public void paintSelf(Graphics g) {
		super.paintSelf(g);
		y+=speed; 
	}
	
	public Rectangle getRec() {
		return super.getRec();
	}
}
