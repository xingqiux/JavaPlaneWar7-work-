package com.xq.utils;

import java.awt.*;		//导入包含Image的库
import java.util.ArrayList;
import java.util.List;

import com.xq.obj.GameObj;
import com.xq.obj.GiftObj;
import com.xq.obj.LittleBoss1Bullet;
import com.xq.obj.LittleBoss2Bullet;
import com.xq.obj.ShellObj;
import com.xq.obj.TripleShellObj;
import com.xq.obj.BossBullet;
import com.xq.obj.DoubleShellObj;
import com.xq.obj.Enemy1Obj;
import com.xq.obj.Enemy2BulletObj;
import com.xq.obj.Enemy2Obj;
import com.xq.obj.ExplodeObj;

//这个类是游戏元素的父类
public class GameUtils {
	//获取游戏背景图片的方法
	public static Image bdImg = Toolkit.getDefaultToolkit().getImage("imags/bg_0.jpg");
	//&&Toolkit.getDefaultToolkit()是获取默认的工具包，
	//&&即Java AWT（Abstract Window Toolkit）工具包；而getImage方法则是从该工具包中获取一个图像对象。
	
	//获取boss图片
	public static Image bossImg = Toolkit.getDefaultToolkit().getImage("imags/boss.png");
	//获取爆炸图片
	public static Image expImg = Toolkit.getDefaultToolkit().getImage("imags/explode/e7.gif");
	//获取我方飞机图片
	public static Image planeImg = Toolkit.getDefaultToolkit().getImage("imags/plane.png");
	//获取我方飞机子单图片
	public static Image shellImg = Toolkit.getDefaultToolkit().getImage("imags/Shell.png");
	
	//用于添加两种敌方小飞机 
	public static Image enemy1Img = Toolkit.getDefaultToolkit().getImage("imags/enemy1.png");
	public static Image enemy2Img = Toolkit.getDefaultToolkit().getImage("imags/enemy2.png");
	
	public static Image enemy2BulletImg = Toolkit.getDefaultToolkit().getImage("imags/enemy2bullet.png");
	
	
	//获取小boss图片
	public static Image littleboss1Img = Toolkit.getDefaultToolkit().getImage("imags/littleboss1.png");//获取boss图片
	public static Image littleboss2Img = Toolkit.getDefaultToolkit().getImage("imags/littleboss2.png");
	
	//获取小boss的子弹
	
	public static Image littleboss1BulletImg = Toolkit.getDefaultToolkit().getImage("imags/littleboss1bullet.png");//获取boss图片
	public static Image littleboss2BulletImg = Toolkit.getDefaultToolkit().getImage("imags/littleboss2bullet.png");
	
	//获取补给品图片
	public static Image gifImg = Toolkit.getDefaultToolkit().getImage("imags/gift.png");
	
	
	//获取两种升级后的子弹图片
	//二级
	public static Image doubleshellImg = Toolkit.getDefaultToolkit().getImage("imags/doubleshell.png");
	//三级
	public static Image tripleShellImg = Toolkit.getDefaultToolkit().getImage("imags/tripleshell.png");

	//boss子弹的图片
	public static Image bossBulletImg = Toolkit.getDefaultToolkit().getImage("imags/bossbullet.png");

	
	//创建一个我方飞机子弹的集合,用于批量创建物体
	public static List<ShellObj> shellObjList = new ArrayList<>();
	
	//创建敌方小飞机集合
	public static List<Enemy1Obj> enemy1ObjList = new ArrayList<>();
	public static List<Enemy2Obj> enemy2ObjList = new ArrayList<>();
	
	//创建地方-大飞机子弹集合
	public static List<Enemy2BulletObj> enemy2BulletObjList = new ArrayList<>();
	//创建一个所有游戏元素的集合
	public static List<GameObj> gameObjList = new ArrayList<>();
	
	//创建一个移除游戏元素的集合
	public static List<GameObj> removeList = new ArrayList<>();
	
	//创建一个爆炸集合
	public static List<ExplodeObj> explodeObjList=new ArrayList<>();
	
	//创建小boss的子弹集合
	public static List<LittleBoss1Bullet> littleBoss1BulletList =new ArrayList<>();
	public static List<LittleBoss2Bullet> littleBoss2BulletList =new ArrayList<>();

	//创建补给的集合
	public static List<GiftObj> giftObjList = new ArrayList<>();

	//创建两种子弹的集合
	public static List<DoubleShellObj> doubleShellList = new ArrayList<>();
	public static List<TripleShellObj> tripleShellList = new ArrayList<>();

	public static List<BossBullet> BossBulletList =new ArrayList<>();

	//用于绘制文字
	public static void drawWord(Graphics gImage,String str,Color color,int size,int x,int y) {
		gImage.setColor(color);
		gImage.setFont(new Font("仿宋",Font.BOLD,size));
		gImage.drawString(str, x, y);
	}
	
}
