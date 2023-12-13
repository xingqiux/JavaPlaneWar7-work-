package com.xq.obj;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class ExplodeObj extends GameObj{
	//定义一个一连串的静态数组来存放图片数据
	static Image[] explodePic = new Image[16];
	//定义变量记录的爆炸图次数
	int explodeCount = 0;
	
	//定义一个静态代码块来静态图片放入数组当中
	static {
		for (int i = 0 ; i< explodePic.length;i++) {
			explodePic[i] = Toolkit.getDefaultToolkit().getImage("imags/explode/e"+(i+1)+".gif");
		}
	}
	//！！！这里之所以paintSelf少一个a也没有关系是因为这个是覆写继承的GameObj类中的PaintSelf，但如果不覆写的话，也是没有问题的。所以编译器不会报错
//	public void pintSelf(Graphics g) {
//
//		if (explodeCount < 16) {
//			super.img = explodePic[explodeCount];
//			super.paintSelf(g);
//			explodeCount++;
//		}
//		
//	}
	
	public void paintSelf(Graphics g) {

		if (explodeCount < 16) {
			super.img = explodePic[explodeCount];
			super.paintSelf(g);
			explodeCount++;
		}
		
	}
	
	public ExplodeObj(int x,int y) {
		super(x,y);
	}
}
