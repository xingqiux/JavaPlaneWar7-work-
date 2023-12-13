package com.xq.obj;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.net.NoRouteToHostException;

import com.xq.GameWin;
import com.xq.utils.GameUtils;

public class LittleBoss1 extends GameObj{
	//一号boss的血量
	int health = 10;

	public LittleBoss1() {
		
	}
	
	public LittleBoss1(Image img, int width, int height, int x, int y, double speed, GameWin frame) {
		super(img, width, height, x, y, speed, frame);
	}
	
	public LittleBoss1(Image img, int x, int y, double speed) {
		super(img, x, y, speed );
	}
	
	
	public LittleBoss1(int x, int y) {
		super();
		this.x = x;
		this.y = y;

	}
	
	
		public Image getImg() {
		return img;
	}
	
	public void paintSelf(Graphics g) {
		super.paintSelf(g);
		//小boss1的运动轨迹
		x+=speed;
		if (x>400) {
			speed = -1;
		}
		
		//当敌方1号boss和我放子弹碰撞之后，我方子弹消失,当1号boss血量为0消失(一级子弹
		for (ShellObj shellObj : GameUtils.shellObjList) {
			if (this.getRec().intersects(shellObj.getRec())&& health > 0) {
				shellObj.setX(-100);
				shellObj.setY(-100);
				GameUtils.removeList.add(shellObj);
				health--;
			}else if (this.getRec().intersects(shellObj.getRec())&& health <= 0) {
				ExplodeObj explodeObj = new ExplodeObj(x, y);
				GameUtils.explodeObjList.add(explodeObj);
				GameUtils.removeList.add(explodeObj);
				//当血量小于等于0时出现补给品
				GiftObj giftObj = new GiftObj(this.x,this.y);
				GameUtils.giftObjList.add(giftObj);
				GameUtils.gameObjList.addAll(GameUtils.giftObjList);
				
				shellObj.setX(-100);
				shellObj.setY(-100);
				GameUtils.removeList.add(shellObj);
				this.x = -200;
				this.y = -200;
				GameUtils.removeList.add(this);
			}
		}
		//当敌方1号boss和我放子弹碰撞之后，我方子弹消失,当1号boss血量为0消失(二级子弹
		for (DoubleShellObj doubleShellObj : GameUtils.doubleShellList) {
			if (this.getRec().intersects(doubleShellObj.getRec())&& health > 0) {
				doubleShellObj.setX(-100);
				doubleShellObj.setY(-100);
				GameUtils.removeList.add(doubleShellObj);
				health-=2;
			}else if (this.getRec().intersects(doubleShellObj.getRec())&& health <= 0) {
				ExplodeObj explodeObj = new ExplodeObj(x, y);
				GameUtils.explodeObjList.add(explodeObj);
				GameUtils.removeList.add(explodeObj);
				//当血量小于等于0时出现补给品
				GiftObj giftObj = new GiftObj(this.x,this.y);
				GameUtils.giftObjList.add(giftObj);
				GameUtils.gameObjList.addAll(GameUtils.giftObjList);
				
				doubleShellObj.setX(-100);
				doubleShellObj.setY(-100);
				GameUtils.removeList.add(doubleShellObj);
				this.x = -200;
				this.y = -200;
				GameUtils.removeList.add(this);
				GameWin.score+=200;
			}
		}
		
	}
	
	public Rectangle getRec() {
		return super.getRec();
	}
}
