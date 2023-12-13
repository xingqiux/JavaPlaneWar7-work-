package com.xq.obj;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import com.xq.GameWin;

public class BossBullet extends GameObj{
	public BossBullet() {
		super();
	}
	
	public BossBullet(int x,int y) {
		super(x,y);
	}
	
	public BossBullet(Image img, int width, int height, int x, int y, double speed, GameWin frame) {
		super(img, width, height, x, y, speed, frame);
	}
	
	public BossBullet(Image img, int x, int y, double speed) {
		super(img, x, y, speed );
	}
	
	@Override
	public void paintSelf(Graphics g) {
		super.paintSelf(g);
	}
	
	public Rectangle getRec() {
		return super.getRec();
	}
}
