package com.xq.utils;

import java.awt.*;		//�������Image�Ŀ�
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

//���������ϷԪ�صĸ���
public class GameUtils {
	//��ȡ��Ϸ����ͼƬ�ķ���
	public static Image bdImg = Toolkit.getDefaultToolkit().getImage("imags/bg_0.jpg");
	//&&Toolkit.getDefaultToolkit()�ǻ�ȡĬ�ϵĹ��߰���
	//&&��Java AWT��Abstract Window Toolkit�����߰�����getImage�������ǴӸù��߰��л�ȡһ��ͼ�����
	
	//��ȡbossͼƬ
	public static Image bossImg = Toolkit.getDefaultToolkit().getImage("imags/boss.png");
	//��ȡ��ըͼƬ
	public static Image expImg = Toolkit.getDefaultToolkit().getImage("imags/explode/e7.gif");
	//��ȡ�ҷ��ɻ�ͼƬ
	public static Image planeImg = Toolkit.getDefaultToolkit().getImage("imags/plane.png");
	//��ȡ�ҷ��ɻ��ӵ�ͼƬ
	public static Image shellImg = Toolkit.getDefaultToolkit().getImage("imags/Shell.png");
	
	//����������ֵз�С�ɻ� 
	public static Image enemy1Img = Toolkit.getDefaultToolkit().getImage("imags/enemy1.png");
	public static Image enemy2Img = Toolkit.getDefaultToolkit().getImage("imags/enemy2.png");
	
	public static Image enemy2BulletImg = Toolkit.getDefaultToolkit().getImage("imags/enemy2bullet.png");
	
	
	//��ȡСbossͼƬ
	public static Image littleboss1Img = Toolkit.getDefaultToolkit().getImage("imags/littleboss1.png");//��ȡbossͼƬ
	public static Image littleboss2Img = Toolkit.getDefaultToolkit().getImage("imags/littleboss2.png");
	
	//��ȡСboss���ӵ�
	
	public static Image littleboss1BulletImg = Toolkit.getDefaultToolkit().getImage("imags/littleboss1bullet.png");//��ȡbossͼƬ
	public static Image littleboss2BulletImg = Toolkit.getDefaultToolkit().getImage("imags/littleboss2bullet.png");
	
	//��ȡ����ƷͼƬ
	public static Image gifImg = Toolkit.getDefaultToolkit().getImage("imags/gift.png");
	
	
	//��ȡ������������ӵ�ͼƬ
	//����
	public static Image doubleshellImg = Toolkit.getDefaultToolkit().getImage("imags/doubleshell.png");
	//����
	public static Image tripleShellImg = Toolkit.getDefaultToolkit().getImage("imags/tripleshell.png");

	//boss�ӵ���ͼƬ
	public static Image bossBulletImg = Toolkit.getDefaultToolkit().getImage("imags/bossbullet.png");

	
	//����һ���ҷ��ɻ��ӵ��ļ���,����������������
	public static List<ShellObj> shellObjList = new ArrayList<>();
	
	//�����з�С�ɻ�����
	public static List<Enemy1Obj> enemy1ObjList = new ArrayList<>();
	public static List<Enemy2Obj> enemy2ObjList = new ArrayList<>();
	
	//�����ط�-��ɻ��ӵ�����
	public static List<Enemy2BulletObj> enemy2BulletObjList = new ArrayList<>();
	//����һ��������ϷԪ�صļ���
	public static List<GameObj> gameObjList = new ArrayList<>();
	
	//����һ���Ƴ���ϷԪ�صļ���
	public static List<GameObj> removeList = new ArrayList<>();
	
	//����һ����ը����
	public static List<ExplodeObj> explodeObjList=new ArrayList<>();
	
	//����Сboss���ӵ�����
	public static List<LittleBoss1Bullet> littleBoss1BulletList =new ArrayList<>();
	public static List<LittleBoss2Bullet> littleBoss2BulletList =new ArrayList<>();

	//���������ļ���
	public static List<GiftObj> giftObjList = new ArrayList<>();

	//���������ӵ��ļ���
	public static List<DoubleShellObj> doubleShellList = new ArrayList<>();
	public static List<TripleShellObj> tripleShellList = new ArrayList<>();

	public static List<BossBullet> BossBulletList =new ArrayList<>();

	//���ڻ�������
	public static void drawWord(Graphics gImage,String str,Color color,int size,int x,int y) {
		gImage.setColor(color);
		gImage.setFont(new Font("����",Font.BOLD,size));
		gImage.drawString(str, x, y);
	}
	
}
