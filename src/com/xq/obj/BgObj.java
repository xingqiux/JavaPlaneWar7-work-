package com.xq.obj;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import com.xq.GameWin;

public class BgObj extends GameObj{

	public BgObj() {
		
	}
	
	public BgObj(Image img, int width, int height, int x, int y, double speed, GameWin frame) {
		super(img, width, height, x, y, speed, frame);
	}
	
	public BgObj(Image img, int x, int y, double speed) {
		super(img, x, y, speed );
	}
	
	@Override
	public void paintSelf(Graphics g) {
		// TODO Auto-generated method stub
		super.paintSelf(g);
		y+=speed;
		if (y>= 0){
			y = -1800;
		}
	}
	
	public Rectangle getRec() {
		return super.getRec();
	}

}
