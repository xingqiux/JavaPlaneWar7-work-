package com.xq.obj;

import java.awt.*;

import com.xq.GameWin;

//所有游戏元素的父类

public class GameObj {
	// 元素的图片
	Image img;
	// 游戏元素的大小
	int width; // 元素的宽

	int height; // 元素的高

	int x; // 元素x轴

	int y; // 元素y轴

	double speed; // 元素们的速度

	GameWin frame; // 窗口类
	
	
	//set 和 get 方法
	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public GameWin getFrame() {
		return frame;
	}

	public void setFrame(GameWin frame) {
		this.frame = frame;
	}
	
	
	//构造方法
	public GameObj() {	//无参构造方法
		
	}
	//有参构造方法
	public GameObj(Image img, int width, int height, int x, int y, double speed, GameWin frame) {
		this.img = img;
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.frame = frame;
	}
	

	public GameObj(Image img, int x, int y, double speed) {
		super();
		this.img = img;
		this.x = x;
		this.y = y;
		this.speed = speed;
	}
	
	public GameObj(int x, int y) {
		super();
		this.x = x;
		this.y = y;

	}

	//绘制元素自身的方法
	public void paintSelf(Graphics g) {
		g.drawImage(img, x, y,null);
	}
	
	//获得自身矩形的方法，用于碰撞检测
	public Rectangle getRec() {
		return new Rectangle(x,y,width,height);
	}
	public Rectangle getRec(int x2, int y2, int i, int j) {
		return new Rectangle(x,y,width,height);
	}
	

}
