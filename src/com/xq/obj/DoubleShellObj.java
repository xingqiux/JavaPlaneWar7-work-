package com.xq.obj;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import com.xq.GameWin;
import com.xq.utils.GameUtils;

public class DoubleShellObj extends GameObj{


	public DoubleShellObj() {
		super();
	}
	
	public DoubleShellObj(int x,int y) {
		super(x,y);
	}
	
	public DoubleShellObj(Image img, int width, int height, int x, int y, double speed, GameWin frame) {
		super(img, width, height, x, y, speed, frame);
	}
	
	public DoubleShellObj(Image img, int x, int y, double speed) {
		super(img, x, y, speed );
	}
	
	@Override
	public void paintSelf(Graphics g) {
		super.paintSelf(g);
		y-=speed;

	}
	
	public Rectangle getRec() {
		return super.getRec();
	}
}
