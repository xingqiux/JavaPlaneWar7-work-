package com.xq.obj;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import com.xq.GameWin;
import com.xq.utils.GameUtils;

public class BossObj extends GameObj{
	public BossObj() {
		super();
	}
	
	public BossObj(int x,int y) {
		super(x,y);
	}
	
	public BossObj(Image img, int width, int height, int x, int y, double speed, GameWin frame) {
		super(img, width, height, x, y, speed, frame);
	}
	
	public BossObj(Image img, int x, int y, double speed) {
		super(img, x, y, speed );
	}
	
	@Override
	public void paintSelf(Graphics g) {
		super.paintSelf(g);
		if (y<40) {
			y += speed;
		}else {
			x+= speed;
			if (x<0 || x>360) {
				speed=-speed;
			}
		}
	}
	
	public Rectangle getRec() {
		return super.getRec();
	}
}
