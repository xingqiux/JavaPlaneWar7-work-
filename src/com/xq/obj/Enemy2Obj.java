package com.xq.obj;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import com.xq.GameWin;
import com.xq.utils.GameUtils;

public class Enemy2Obj extends GameObj{
	int health = 2;
	public Enemy2Obj() {
		
	}
	
	public Enemy2Obj(Image img, int width, int height, int x, int y, double speed, GameWin frame) {
		super(img, width, height, x, y, speed, frame);
	}
	
	public Enemy2Obj(Image img, int x, int y, double speed) {
		super(img, x, y, speed );
	}
	
	@Override
	public void paintSelf(Graphics g) {
		super.paintSelf(g);
		y += speed;
		//我方飞机子弹和敌方大飞机碰撞代码(一级子弹
		for (ShellObj shellObj : GameUtils.shellObjList) {
			if (this.getRec().intersects(shellObj.getRec()) && health>0) {
				shellObj.setX(-1000);
				shellObj.setY(-1000);
				GameUtils.removeList.add(shellObj);
				health--;
			}else if (this.getRec().intersects(shellObj.getRec()) && health<=0) {
				//碰撞之后产生爆炸效果
				ExplodeObj explodeObj = new ExplodeObj(x, y);
				GameUtils.explodeObjList.add(explodeObj);
				GameUtils.removeList.add(explodeObj);
				
				shellObj.setX(-1000);
				shellObj.setY(-1000);
				this.x = -1000;
				this.y = -1000;
				GameUtils.removeList.add(shellObj);
				GameUtils.removeList.add(this);
				GameWin.score+=10;
			}
		}
		//二级子弹
		for (DoubleShellObj doubleshellObj : GameUtils.doubleShellList) {
			
			if (this.getRec().intersects(doubleshellObj.getRec()) && health>0) {
				doubleshellObj.setX(-1000);
				doubleshellObj.setY(-1000);
				GameUtils.removeList.add(doubleshellObj);
				health-=2;
			}else if (this.getRec().intersects(doubleshellObj.getRec()) && health<=0) {
				//碰撞之后产生爆炸效果
				ExplodeObj explodeObj = new ExplodeObj(x, y);
				GameUtils.explodeObjList.add(explodeObj);
				GameUtils.removeList.add(explodeObj);
				
				doubleshellObj.setX(-1000);
				doubleshellObj.setY(-1000);
				this.x = -1000;
				this.y = -1000;
				GameUtils.removeList.add(doubleshellObj);
				GameUtils.removeList.add(this);
				GameWin.score+=10;
			}
		}
		//三级子弹
		for (TripleShellObj tripleShellObj : GameUtils.tripleShellList) {
			if (this.getRec().intersects(tripleShellObj.getRec()) && health>0) {
				tripleShellObj.setX(-1000);
				tripleShellObj.setY(-1000);
				GameUtils.removeList.add(tripleShellObj);
				health-=3;
			}else if (this.getRec().intersects(tripleShellObj.getRec()) && health<=0) {
				//碰撞之后产生爆炸效果
				ExplodeObj explodeObj = new ExplodeObj(x, y);
				GameUtils.explodeObjList.add(explodeObj);
				GameUtils.removeList.add(explodeObj);
				
				tripleShellObj.setX(-1000);
				tripleShellObj.setY(-1000);
				this.x = -1000;
				this.y = -1000;
				GameUtils.removeList.add(tripleShellObj);
				GameUtils.removeList.add(this);
				GameWin.score+=10;
			}
		}
	}
	
	public Rectangle getRec() {
		return super.getRec();
	}
}
