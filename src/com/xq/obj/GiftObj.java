package com.xq.obj;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import com.xq.GameWin;
import com.xq.utils.GameUtils;

public class GiftObj extends GameObj{
	
	public GiftObj() {
		super();
	}
	
	public GiftObj(int x,int y) {
		super(x,y);
	}
	
	public GiftObj(Image img, int width, int height, int x, int y, double speed, GameWin frame) {
		super(img, width, height, x, y, speed, frame);
	}
	
	public GiftObj(Image img, int x, int y, double speed) {
		super(img, x, y, speed );
	}
	
	@Override
	public void paintSelf(Graphics g) {
		// TODO Auto-generated method stub
		this.img = GameUtils.gifImg;
		super.width = 64;
		super.height = 62;
		super.paintSelf(g);

	}
	
	public Rectangle getRec() {
		return super.getRec();
	}
}
