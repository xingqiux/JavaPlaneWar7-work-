package com.xq.obj;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import com.xq.GameWin;
import com.xq.utils.GameUtils;

public class Enemy1Obj extends GameObj{
	public Enemy1Obj() {
		
	}
	
	public Enemy1Obj(Image img, int width, int height, int x, int y, double speed, GameWin frame) {
		super(img, width, height, x, y, speed, frame);
	}
	
	public Enemy1Obj(Image img, int x, int y, double speed) {
		super(img, x, y, speed );
	}
	
	@Override
	public void paintSelf(Graphics g) {
		super.paintSelf(g);
		y += speed;
		//一级子弹碰撞
		for (ShellObj shellObj : GameUtils.shellObjList) {
			if (this.getRec().intersects(shellObj.getRec())) {
				//碰撞之后产生爆炸效果
				ExplodeObj explodeObj = new ExplodeObj(x, y);
				GameUtils.explodeObjList.add(explodeObj);
				GameUtils.removeList.add(explodeObj);
				//
				shellObj.setX(-1000);
				shellObj.setY(-1000);
				this.setX(-1000);
				this.setY(-1000);
				GameUtils.removeList.add(shellObj);
				GameUtils.removeList.add(this);
				GameWin.score+=5;
			}
		}
		//二级子弹碰撞
		for (DoubleShellObj doubleshellObj : GameUtils.doubleShellList) {
			if (this.getRec().intersects(doubleshellObj.getRec())) {
				//碰撞之后产生爆炸效果
				ExplodeObj explodeObj = new ExplodeObj(x, y);
				GameUtils.explodeObjList.add(explodeObj);
				GameUtils.removeList.add(explodeObj);
				//
				doubleshellObj.setX(-1000);
				doubleshellObj.setY(-1000);
				this.setX(-1000);
				this.setY(-1000);
				GameUtils.removeList.add(doubleshellObj);
				GameUtils.removeList.add(this);
				GameWin.score+=5;
			}
		}
		//三级子弹碰撞
		for (TripleShellObj tripleShellObj : GameUtils.tripleShellList) {
			if (this.getRec().intersects(tripleShellObj.getRec())) {
				//碰撞之后产生爆炸效果
				ExplodeObj explodeObj = new ExplodeObj(x, y);
				GameUtils.explodeObjList.add(explodeObj);
				GameUtils.removeList.add(explodeObj);
				//
				tripleShellObj.setX(-1000);
				tripleShellObj.setY(-1000);
				this.setX(-1000);
				this.setY(-1000);
				GameUtils.removeList.add(tripleShellObj);
				GameUtils.removeList.add(this);
				GameWin.score+=5;
			}
		}
	}
	
	public Rectangle getRec() {
		return super.getRec();
	}

}
