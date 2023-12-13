package com.xq.obj;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class ExplodeObj extends GameObj{
	//����һ��һ�����ľ�̬���������ͼƬ����
	static Image[] explodePic = new Image[16];
	//���������¼�ı�ըͼ����
	int explodeCount = 0;
	
	//����һ����̬���������̬ͼƬ�������鵱��
	static {
		for (int i = 0 ; i< explodePic.length;i++) {
			explodePic[i] = Toolkit.getDefaultToolkit().getImage("imags/explode/e"+(i+1)+".gif");
		}
	}
	//����������֮����paintSelf��һ��aҲû�й�ϵ����Ϊ����Ǹ�д�̳е�GameObj���е�PaintSelf�����������д�Ļ���Ҳ��û������ġ����Ա��������ᱨ��
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
