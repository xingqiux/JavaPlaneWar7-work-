package com.xq.obj;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.management.monitor.GaugeMonitor;

import com.xq.GameWin;
import com.xq.utils.GameUtils;

//�ҷ��ɻ�����
public class PlaneObj extends GameObj{
	LittleBoss1 littleBoss1 =  new LittleBoss1();
	LittleBoss2 littleBoss2 = new LittleBoss2();
	
	//��ײ�����Ĵ���
	public static int times = 0;
	
	public PlaneObj() {
		super();
	}
	
	public PlaneObj(Image img, int width, int height, int x, int y, double speed, GameWin frame) {
		super(img, width, height, x, y, speed, frame);
		
		//��������ƶ��¼�
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
		//���������ײ���
		//�ҷŷɻ��͵з�С�ɻ���ײ֮�󣬶���ʧ
		for (Enemy1Obj enemy1Obj : GameUtils.enemy1ObjList) {
			//���������ײ��,���intersects������������������Ƿ��ཻ
			if(this.getRec().intersects(enemy1Obj.getRec())) {
				//��ײ֮�������ըЧ��
				ExplodeObj explodeObj = new ExplodeObj(x, y);
				GameUtils.explodeObjList.add(explodeObj);
				GameUtils.removeList.add(explodeObj);
				
				//�з�С�ɻ���ʧ
				enemy1Obj.setX(-1000);
				enemy1Obj.setY(-1000);
				//�ҷ�С�ɻ���ʧ
				this.x = -1000;
				this.y = -1000;
				GameUtils.removeList.add(enemy1Obj);
				GameUtils.removeList.add(this);
				GameWin.state = 3;
			}
		}
		
		
		//�ҷ��ɻ��͵ط���ɻ���ײ�����߶���ʧ
		for (Enemy2Obj enemy2Obj : GameUtils.enemy2ObjList) {
			//���������ײ��,���intersects������������������Ƿ��ཻ
			if(this.getRec().intersects(enemy2Obj.getRec())) {
				
				//��ײ֮�������ըЧ��
				ExplodeObj explodeObj = new ExplodeObj(x, y);
				GameUtils.explodeObjList.add(explodeObj);
				GameUtils.removeList.add(explodeObj);
				
				//�з�С�ɻ���ʧ
				enemy2Obj.setX(-1000);
				enemy2Obj.setY(-1000);
				//�ҷ�С�ɻ���ʧ
				this.x = -1000;
				this.y = -1000;
				GameUtils.removeList.add(enemy2Obj);
				GameUtils.removeList.add(this);
			
				GameWin.state = 3;}
		}
		
		//�ҷŷɻ��͵з���ɻ��ӵ����ź����߶���ʧ
		
		for (Enemy2BulletObj enemy2BulletObj : GameUtils.enemy2BulletObjList) {
			//���������ײ��,���intersects������������������Ƿ��ཻ
			if(this.getRec().intersects(enemy2BulletObj.getRec())) {
				
				//��ײ֮�������ըЧ��
				ExplodeObj explodeObj = new ExplodeObj(x, y);
				GameUtils.explodeObjList.add(explodeObj);
				GameUtils.removeList.add(explodeObj);
				
				
				//�з�С�ɻ���ʧ
				enemy2BulletObj.setX(-1000);
				enemy2BulletObj.setY(-1000);
				//�ҷ�С�ɻ���ʧ
				this.x = -1000;
				this.y = -1000;
				GameUtils.removeList.add(enemy2BulletObj);
				GameUtils.removeList.add(this);
				GameWin.state = 3;
			}
		}
		
		//�ҷ��ɻ��͵з�boss1��ײ���ҷ��ɻ���ʧ�з��ɻ�����ʧ
		if (this.getRec().intersects(littleBoss1.getRec())) {
			//���Ʊ�ը
			System.out.println("get");
			ExplodeObj explodeObj = new ExplodeObj(x, y);
			GameUtils.explodeObjList.add(explodeObj);
			GameUtils.removeList.add(explodeObj);			
			this.x= -200;
			this.y = -200;
			GameUtils.removeList.add(this);
			GameWin.state = 3;
		}
		//�ҷ��ɻ��͵з�boss2��ײ���ҷ��ɻ���ʧ�з��ɻ�����ʧ
		
		if (this.getRec().intersects(littleBoss2.getRec())) {
			//���Ʊ�ը
			ExplodeObj explodeObj = new ExplodeObj(x, y);
			GameUtils.explodeObjList.add(explodeObj);
			GameUtils.removeList.add(explodeObj);
			this.x= -200;
			this.y = -200;
			GameUtils.removeList.add(this);
			GameWin.state = 3;
		}
		
		//�ҷ��ɻ��͵з�boss1���ӵ���ײ����ʧ
		for (LittleBoss1Bullet littleBoss1Bullet : GameUtils.littleBoss1BulletList) {
			if (this.getRec().intersects(littleBoss1Bullet.getRec())) {
				//���Ʊ�ը
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
		
		//�ҷ��ɻ��͵з�boss2���ӵ���ײ����ʧ
		for (LittleBoss2Bullet littleBoss2Bullet : GameUtils.littleBoss2BulletList) {
			if (this.getRec().intersects(littleBoss2Bullet.getRec())) {
				//���Ʊ�ը
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
		
		//�ɻ��Ͳ�����ײ��Ĵ���
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
