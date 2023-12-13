package com.xq.obj;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import com.xq.GameWin;
import com.xq.utils.GameUtils;

public class LittleBoss2Bullet extends GameObj{

	int health = 1;
	public LittleBoss2Bullet() {
		super();
	}

	public LittleBoss2Bullet(Image img, int width, int height, int x, int y, double speed, GameWin frame) {
		super(img, width, height, x, y, speed, frame);
	}
	
	public LittleBoss2Bullet(Image img, int x, int y, double speed) {
		super(img, x, y, speed );
	
	}
	
	
	public void paintSelf(Graphics g) {
		super.paintSelf(g);
		this.y+=speed;
		//编写追踪的逻辑,也就是改变x的坐标
		this.x -=(this.x-GameUtils.gameObjList.get(GameWin.planeindex).getX())/30;
		//当敌方2号boss子弹和我放子弹碰撞之后，我方子弹消失,当1号boss血量为0消失
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
				health=0;
			}else if (this.getRec().intersects(doubleShellObj.getRec())&& health <= 0) {
				ExplodeObj explodeObj = new ExplodeObj(x, y);
				GameUtils.explodeObjList.add(explodeObj);
				GameUtils.removeList.add(explodeObj);

				doubleShellObj.setX(-100);
				doubleShellObj.setY(-100);
				GameUtils.removeList.add(doubleShellObj);
				this.x = -200;
				this.y = -200;
				GameUtils.removeList.add(this);
			}
		}
	}
	
	public Rectangle getRec() {
		return super.getRec();
	}

}
