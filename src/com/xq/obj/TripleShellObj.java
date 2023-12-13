package com.xq.obj;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import com.xq.GameWin;
import com.xq.utils.GameUtils;

public class TripleShellObj extends GameObj{
	public TripleShellObj() {
		super();
	}
	
	public TripleShellObj(int x,int y) {
		super(x,y);
	}
	
	public TripleShellObj(Image img, int width, int height, int x, int y, double speed, GameWin frame) {
		super(img, width, height, x, y, speed, frame);
	}
	
	public TripleShellObj(Image img, int x, int y, double speed) {
		super(img, x, y, speed );
	}
	
	@Override
	public void paintSelf(Graphics g) {
		// TODO Auto-generated method stub
		super.paintSelf(g);
		y -= speed;

	}
	
	public Rectangle getRec() {
		return super.getRec();
	}
}
