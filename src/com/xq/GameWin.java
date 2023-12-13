package com.xq;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import com.xq.obj.BgObj;
import com.xq.obj.BossBullet;
import com.xq.obj.BossObj;
import com.xq.obj.DoubleShellObj;
import com.xq.obj.Enemy1Obj;
import com.xq.obj.Enemy2BulletObj;
import com.xq.obj.Enemy2Obj;
import com.xq.obj.ExplodeObj;
import com.xq.obj.GameObj;
import com.xq.obj.LittleBoss1;
import com.xq.obj.LittleBoss1Bullet;
import com.xq.obj.LittleBoss2;
import com.xq.obj.LittleBoss2Bullet;
import com.xq.obj.PlaneObj;
import com.xq.obj.ShellObj;
import com.xq.obj.TripleShellObj;
import com.xq.utils.GameUtils;

public class GameWin extends JFrame {
	//记录游戏状态的变量
	//0未开始 1游戏中，2暂停，3失败，4通关
	public static int state=0;
	//背景图对象
	BgObj bgObj=new BgObj(GameUtils.bdImg,0,-1800,2);
	//定义一个图片变量
	Image offScreenImage=null;
	//我方飞机的对象
	PlaneObj planeObj=new PlaneObj(GameUtils.planeImg,37,41,290,550,0,this);
	//获取我方子弹的对象
	//ShellObj shellObj=new ShellObj(GameUtils.shellImg,14,29,planeObj.getX(), planeObj.getY(), 5,this);
	//记录游戏绘制的次数
	int count = 1;
	//新建一个索引，用来获取当前的飞机位置
	public static int planeindex = 0;
	
	public static int score = 0;
	
	//添加小boss的实例
	LittleBoss1 littleBoss1 = new LittleBoss1(GameUtils.littleboss1Img,172,112,-200,350,3,this);
	LittleBoss2 littleBoss2 = new LittleBoss2(GameUtils.littleboss2Img,172,112,300,-150,2,this);
	
	//获取敌方boss对象
	BossObj bossObj = new BossObj(GameUtils.bossImg,240,174,180,-180,3,this);
	public void launch(){
		//窗口是否可见
		this.setVisible(true);
		//窗口的大小
		this.setSize(600,800);
		//窗口的位置
		this.setLocationRelativeTo(null);
		//窗口的标题
		this.setTitle("李牛王飞机大战");
		//关闭窗口会自动结束进程
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//将所有要绘制的游戏物体全部放入所有元素集合中进行绘制
		GameUtils.gameObjList.add(bgObj);
		GameUtils.gameObjList.add(planeObj);
		planeindex = GameUtils.gameObjList.indexOf(planeObj);//拿到了我方飞机的索引值，然后通过这个索引值可以让二号boss的子弹实现追踪跟随

		//鼠标的点击事件
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getButton()==1 && state==0) {//当我们游戏处于一个未开始的转台下点击才能有反应
					state=1;//游戏开始状态
				}
			}
		});
		//空格暂停事件
		this.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 32) {
					if (state == 1)
					{
						state = 2;
					}else if(state == 2)
					{
						state = 1;
					}
				}
			}
		});
		while(true){
			createObj();
			repaint();
			try {
				Thread.sleep(25);//25毫秒
			}catch (Exception e){
				e.printStackTrace();
			}
		}

	}

	@Override
	public void paint(Graphics g) {
		//初始化双缓存图片对象
		if(offScreenImage==null){
			offScreenImage=createImage(600,800);//大小要和游戏窗口大小相同
		}
		//获取双缓存图片对象的画笔
		Graphics gImage=offScreenImage.getGraphics();
		gImage.fillRect(0,0,600,800);

		if(state==0) {
			gImage.drawImage(GameUtils.bdImg, 0, 0, null);
			gImage.drawImage(GameUtils.expImg, 270, 350, null);
			gImage.drawImage(GameUtils.planeImg, 280, 470, null);
			gImage.drawImage(GameUtils.bossImg, 190, 70, null);
			//绘制游戏开始界面的文字
			gImage.setColor(Color.BLUE);
			gImage.setFont(new Font("仿宋", Font.BOLD, 30));
			gImage.drawString("鼠标左键开始游戏", 180, 300);

		}
		if(state==1){
//			bgObj.paintSelf(gImage);
//			planeObj.paintSelf(gImage);
//			shellObj.paintSelf(gImage);
			//将爆炸集合添加到元素组件中
			GameUtils.gameObjList.addAll(GameUtils.explodeObjList);
			
			//不再单独绘制某个游戏元素，因为所有游戏元素都放入了所有元素集合中，这里只需要将集合中所有元素遍历出来，然后绘制自身即可
			for (int i = 0; i < GameUtils.gameObjList.size(); i++) {
				GameUtils.gameObjList.get(i).paintSelf(gImage);
			}

			//将要移除的元素从所有集合中删除
			//删除的是removeList和GameobjLIst的交集
			GameUtils.gameObjList.removeAll(GameUtils.removeList);
			count++;
			
		}
		if (state == 2) {
			gImage.drawImage(GameUtils.bdImg, 0, 0, null);
			GameUtils.drawWord(gImage, "游戏暂停", Color.yellow, 30, 220, 300);
			count = count;
		}
		if (state == 3) {
			gImage.drawImage(GameUtils.bdImg, 0, 0, null);
			GameUtils.drawWord(gImage, "失败", Color.red, 30, 220, 300);
			count = 0;
		}
		if (state == 4) {
			gImage.drawImage(GameUtils.bdImg, 0, 0, null);
			GameUtils.drawWord(gImage, "任务完成", Color.blue, 30, 220, 300);
			
		}
		//绘制游戏积分
		GameUtils.drawWord(gImage, score+"分/2000分",Color.green, 40, 30, 100);
		
		//将双缓存图片绘制在游戏窗口
		g.drawImage(offScreenImage,0,0,null);
	}

	//整个方法是用来批量创建物体
	void createObj() {
				
		if (count % 6 == 0) {//这里控制子弹产生的速度
			if (planeObj.times == 0) {	//初始子弹
				GameUtils.shellObjList.add(new ShellObj(GameUtils.shellImg, 14, 29, planeObj.getX() + 12, planeObj.getY() - 20, 5, this));
				GameUtils.gameObjList.add(GameUtils.shellObjList.get(GameUtils.shellObjList.size() - 1));//添加到所有元素集合中的对象，是新new出来的子弹对象，并不是整个子弹集合
			}
			if (planeObj.times == 1) {	//二级子弹
				GameUtils.doubleShellList.add(new DoubleShellObj(GameUtils.doubleshellImg, 32, 64, planeObj.getX() + 10, planeObj.getY() - 20, 8, this));
				GameUtils.gameObjList.add(GameUtils.doubleShellList.get(GameUtils.doubleShellList.size() - 1));//添加到所有元素集合中的对象，是新new出来的子弹对象，并不是整个子弹集合
			}
			if (planeObj.times == 2) {	//三级子弹
				GameUtils.tripleShellList.add(new TripleShellObj(GameUtils.tripleShellImg, 18, 14, planeObj.getX() -5, planeObj.getY() - 20, 8, this));
				GameUtils.gameObjList.add(GameUtils.tripleShellList.get(GameUtils.tripleShellList.size() - 1));//添加到所有元素集合中的对象，是新new出来的子弹对象，并不是整个子弹集合
			}
		}
		if (count % 15 == 0) {//控制地方小飞机的产生(小	//15	
			//这里的x轴坐标是随机数生成(math.random*10)*60意思是x轴有600像素，把他均匀的分成10份产生飞机，就是这样写随机数
			GameUtils.enemy1ObjList.add(new Enemy1Obj(GameUtils.enemy1Img,32,24,(int)(Math.random()*10)*60,-24,5,this));			
			GameUtils.gameObjList.add(GameUtils.enemy1ObjList.get(GameUtils.enemy1ObjList.size()-1));
		}
		
		if (count % 20 == 0) {	//控制敌方大飞机的速率  20
			if (count % 100 == 0) {//控制敌方小飞机的产生(大	
				//这里的x轴坐标是随机数生成(math.random*10)*60意思是x轴有600像素，把他均匀的分成10份产生飞机，就是这样写随机数
				GameUtils.enemy2ObjList.add(new Enemy2Obj(GameUtils.enemy2Img,44,67,(int)(Math.random()*10)*60,-67,3,this));			
				GameUtils.gameObjList.add(GameUtils.enemy2ObjList.get(GameUtils.enemy2ObjList.size()-1));
			}
			if (GameUtils.enemy2ObjList.size()>0){	//如果大于零肯定是产生了大飞机的
				//获得最新的大飞机中的坐标,x和y 就是最新产生的地方大飞机对象的位置，用这个位置产生地方大飞机的子弹
				int x=(GameUtils.enemy2ObjList.get(GameUtils.enemy2ObjList.size()-1)).getX();
				int y=(GameUtils.enemy2ObjList.get(GameUtils.enemy2ObjList.size()-1)).getY();
				GameUtils.enemy2BulletObjList.add(new Enemy2BulletObj(GameUtils.enemy2BulletImg, 14,25, x+17, y+55, 5, this));
				GameUtils.gameObjList.add(GameUtils.enemy2BulletObjList.get(GameUtils.enemy2BulletObjList.size()-1));
			}
		}
		
		if (count == 600 &&(!GameUtils.gameObjList.contains(littleBoss1))) {
			
			//小boss1出现
			GameUtils.gameObjList.add(littleBoss1);
			
		}
		if (count == 1500 && (!GameUtils.gameObjList.contains(littleBoss2))) {
			//小boss2出现
			GameUtils.gameObjList.add(littleBoss2);
		}
		if (count % 30 == 0) {
			//添加小boss1的子弹
			GameUtils.littleBoss1BulletList.add(new LittleBoss1Bullet(GameUtils.littleboss1BulletImg,42,42,littleBoss1.getX()+76,littleBoss1.getY()+100,4,this));
			GameUtils.gameObjList.add(GameUtils.littleBoss1BulletList.get(GameUtils.littleBoss1BulletList.size()-1));
		}
		if (count % 50 == 0) {
			//添加小boss2的子弹
			if (GameUtils.gameObjList.contains(littleBoss2)){
				GameUtils.littleBoss2BulletList.add(new LittleBoss2Bullet(GameUtils.littleboss2BulletImg,21,59,littleBoss2.getX()+75,littleBoss2.getY()+100,8,this));
				GameUtils.gameObjList.add(GameUtils.littleBoss2BulletList.get(GameUtils.littleBoss2BulletList.size()-1));
			}
		}
		if (score > 2000) {
			state = 4;
		}
		
//		//boss大于1300且没有其他小boss对象的时候
//		if (count == 1300 &&(!GameUtils.gameObjList.contains(bossObj))&&(!GameUtils.gameObjList.contains(littleBoss1))&&(!GameUtils.gameObjList.contains(littleBoss2))){
//			GameUtils.gameObjList.add(bossObj);
//		}
		
//		//将boss子弹添加到boss集合当中
//		if (GameUtils.gameObjList.contains(bossObj)) {
//				//添加小boss1的子弹
//				GameUtils.littleBoss1BulletList.add(new LittleBoss1Bullet(GameUtils.littleboss1BulletImg,42,42,bossObj.getX()+76,bossObj.getY()+100,4,this));
//				GameUtils.gameObjList.add(GameUtils.littleBoss1BulletList.get(GameUtils.littleBoss1BulletList.size()-1));
//				if (count % 50 == 0) {
//					//添加小boss2的子弹
//					if (GameUtils.gameObjList.contains(littleBoss2)){
//						GameUtils.littleBoss2BulletList.add(new LittleBoss2Bullet(GameUtils.littleboss2BulletImg,21,59,bossObj.getX()+75,bossObj.getY()+100,8,this));
//						GameUtils.gameObjList.add(GameUtils.littleBoss2BulletList.get(GameUtils.littleBoss2BulletList.size()-1));
//					}
//				}
//				GameUtils.BossBulletList.add(new BossBullet(GameUtils.bossBulletImg,21,59,bossObj.getX()+99,bossObj.getY()+120,9,this));
//				GameUtils.gameObjList.add(GameUtils.BossBulletList.get(GameUtils.BossBulletList.size()-1));
//		}
	}

	public static void main(String[] args) {
		System.out.println("ok");
		GameWin gameWin=new GameWin();
		gameWin.launch();
	}
}
