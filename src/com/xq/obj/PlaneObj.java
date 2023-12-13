package com.xq.obj;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.management.monitor.GaugeMonitor;

import com.xq.GameWin;
import com.xq.utils.GameUtils;

//我方飞机的类
public class PlaneObj extends GameObj{
	LittleBoss1 littleBoss1 =  new LittleBoss1();
	LittleBoss2 littleBoss2 = new LittleBoss2();
	
	//碰撞补给的次数
	public static int times = 0;
	
	public PlaneObj() {
		super();
	}
	
	public PlaneObj(Image img, int width, int height, int x, int y, double speed, GameWin frame) {
		super(img, width, height, x, y, speed, frame);
		
		//添加鼠标的移动事件
		this.frame.addMouseMotionListener(new MouseAdapter() {
			public void mouseMoved(MouseEvent e) {
				PlaneObj.super.x = e.getX() - 19;
				PlaneObj.super.y = e.getY() - 20 ;
			}
		});
	}
	
	public PlaneObj(Image img, int x, int y, double speed) {
		super(img, x, y, speed );
	}
	
	@Override
	public void paintSelf(Graphics g) {
		// TODO Auto-generated method stub
		super.paintSelf(g);
		//这里进行碰撞检测
		//我放飞机和敌方小飞机碰撞之后，都消失
		for (Enemy1Obj enemy1Obj : GameUtils.enemy1ObjList) {
			//如果发生碰撞了,这个intersects是用来检测两个矩形是否相交
			if(this.getRec().intersects(enemy1Obj.getRec())) {
				//碰撞之后产生爆炸效果
				ExplodeObj explodeObj = new ExplodeObj(x, y);
				GameUtils.explodeObjList.add(explodeObj);
				GameUtils.removeList.add(explodeObj);
				
				//敌方小飞机消失
				enemy1Obj.setX(-1000);
				enemy1Obj.setY(-1000);
				//我方小飞机消失
				this.x = -1000;
				this.y = -1000;
				GameUtils.removeList.add(enemy1Obj);
				GameUtils.removeList.add(this);
				GameWin.state = 3;
			}
		}
		
		
		//我方飞机和地方大飞机碰撞后两者都消失
		for (Enemy2Obj enemy2Obj : GameUtils.enemy2ObjList) {
			//如果发生碰撞了,这个intersects是用来检测两个矩形是否相交
			if(this.getRec().intersects(enemy2Obj.getRec())) {
				
				//碰撞之后产生爆炸效果
				ExplodeObj explodeObj = new ExplodeObj(x, y);
				GameUtils.explodeObjList.add(explodeObj);
				GameUtils.removeList.add(explodeObj);
				
				//敌方小飞机消失
				enemy2Obj.setX(-1000);
				enemy2Obj.setY(-1000);
				//我方小飞机消失
				this.x = -1000;
				this.y = -1000;
				GameUtils.removeList.add(enemy2Obj);
				GameUtils.removeList.add(this);
			
				GameWin.state = 3;}
		}
		
		//我放飞机和敌方大飞机子弹碰着后两者都消失
		
		for (Enemy2BulletObj enemy2BulletObj : GameUtils.enemy2BulletObjList) {
			//如果发生碰撞了,这个intersects是用来检测两个矩形是否相交
			if(this.getRec().intersects(enemy2BulletObj.getRec())) {
				
				//碰撞之后产生爆炸效果
				ExplodeObj explodeObj = new ExplodeObj(x, y);
				GameUtils.explodeObjList.add(explodeObj);
				GameUtils.removeList.add(explodeObj);
				
				
				//敌方小飞机消失
				enemy2BulletObj.setX(-1000);
				enemy2BulletObj.setY(-1000);
				//我方小飞机消失
				this.x = -1000;
				this.y = -1000;
				GameUtils.removeList.add(enemy2BulletObj);
				GameUtils.removeList.add(this);
				GameWin.state = 3;
			}
		}
		
		//我方飞机和敌方boss1碰撞后我方飞机消失敌方飞机不消失
		if (this.getRec().intersects(littleBoss1.getRec())) {
			//绘制爆炸
			System.out.println("get");
			ExplodeObj explodeObj = new ExplodeObj(x, y);
			GameUtils.explodeObjList.add(explodeObj);
			GameUtils.removeList.add(explodeObj);			
			this.x= -200;
			this.y = -200;
			GameUtils.removeList.add(this);
			GameWin.state = 3;
		}
		//我方飞机和敌方boss2碰撞后我方飞机消失敌方飞机不消失
		
		if (this.getRec().intersects(littleBoss2.getRec())) {
			//绘制爆炸
			ExplodeObj explodeObj = new ExplodeObj(x, y);
			GameUtils.explodeObjList.add(explodeObj);
			GameUtils.removeList.add(explodeObj);
			this.x= -200;
			this.y = -200;
			GameUtils.removeList.add(this);
			GameWin.state = 3;
		}
		
		//我方飞机和敌方boss1的子弹碰撞后都消失
		for (LittleBoss1Bullet littleBoss1Bullet : GameUtils.littleBoss1BulletList) {
			if (this.getRec().intersects(littleBoss1Bullet.getRec())) {
				//绘制爆炸
				System.out.println("get1");
				ExplodeObj explodeObj = new ExplodeObj(x, y);
				GameUtils.explodeObjList.add(explodeObj);
				GameUtils.removeList.add(explodeObj);
				littleBoss1Bullet.setX(-100);
				littleBoss1Bullet.setY(-100);
				GameUtils.removeList.add(littleBoss1Bullet);
				this.x = -200;
				this.y = -200;
				GameUtils.removeList.add(this);
				GameWin.state = 3;
			}
		}
		
		//我方飞机和敌方boss2的子弹碰撞后都消失
		for (LittleBoss2Bullet littleBoss2Bullet : GameUtils.littleBoss2BulletList) {
			if (this.getRec().intersects(littleBoss2Bullet.getRec())) {
				//绘制爆炸
				ExplodeObj explodeObj = new ExplodeObj(x, y);
				GameUtils.explodeObjList.add(explodeObj);
				GameUtils.removeList.add(explodeObj);
				littleBoss2Bullet.setX(-100);
				littleBoss2Bullet.setY(-100);
				GameUtils.removeList.add(littleBoss2Bullet);
				this.x = -200;
				this.y = -200;
				GameUtils.removeList.add(this);
				GameWin.state = 3;
			}
		}
		
		//飞机和补给碰撞后的代码
		for  (GiftObj giftObj : GameUtils.giftObjList) {
			if (this.getRec().intersects(giftObj.getRec())) {
				giftObj.setX(-100);
				giftObj.setY(-100);
				GameUtils.removeList.add(giftObj);
				times++;
			}
		}
	}
	
	public Rectangle getRec() {
		return super.getRec(x,y,1,1);
	}
}
