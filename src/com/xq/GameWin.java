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
	//��¼��Ϸ״̬�ı���
	//0δ��ʼ 1��Ϸ�У�2��ͣ��3ʧ�ܣ�4ͨ��
	public static int state=0;
	//����ͼ����
	BgObj bgObj=new BgObj(GameUtils.bdImg,0,-1800,2);
	//����һ��ͼƬ����
	Image offScreenImage=null;
	//�ҷ��ɻ��Ķ���
	PlaneObj planeObj=new PlaneObj(GameUtils.planeImg,37,41,290,550,0,this);
	//��ȡ�ҷ��ӵ��Ķ���
	//ShellObj shellObj=new ShellObj(GameUtils.shellImg,14,29,planeObj.getX(), planeObj.getY(), 5,this);
	//��¼��Ϸ���ƵĴ���
	int count = 1;
	//�½�һ��������������ȡ��ǰ�ķɻ�λ��
	public static int planeindex = 0;
	
	public static int score = 0;
	
	//���Сboss��ʵ��
	LittleBoss1 littleBoss1 = new LittleBoss1(GameUtils.littleboss1Img,172,112,-200,350,3,this);
	LittleBoss2 littleBoss2 = new LittleBoss2(GameUtils.littleboss2Img,172,112,300,-150,2,this);
	
	//��ȡ�з�boss����
	BossObj bossObj = new BossObj(GameUtils.bossImg,240,174,180,-180,3,this);
	public void launch(){
		//�����Ƿ�ɼ�
		this.setVisible(true);
		//���ڵĴ�С
		this.setSize(600,800);
		//���ڵ�λ��
		this.setLocationRelativeTo(null);
		//���ڵı���
		this.setTitle("��ţ���ɻ���ս");
		//�رմ��ڻ��Զ���������
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//������Ҫ���Ƶ���Ϸ����ȫ����������Ԫ�ؼ����н��л���
		GameUtils.gameObjList.add(bgObj);
		GameUtils.gameObjList.add(planeObj);
		planeindex = GameUtils.gameObjList.indexOf(planeObj);//�õ����ҷ��ɻ�������ֵ��Ȼ��ͨ���������ֵ�����ö���boss���ӵ�ʵ��׷�ٸ���

		//���ĵ���¼�
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getButton()==1 && state==0) {//��������Ϸ����һ��δ��ʼ��ת̨�µ�������з�Ӧ
					state=1;//��Ϸ��ʼ״̬
				}
			}
		});
		//�ո���ͣ�¼�
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
				Thread.sleep(25);//25����
			}catch (Exception e){
				e.printStackTrace();
			}
		}

	}

	@Override
	public void paint(Graphics g) {
		//��ʼ��˫����ͼƬ����
		if(offScreenImage==null){
			offScreenImage=createImage(600,800);//��СҪ����Ϸ���ڴ�С��ͬ
		}
		//��ȡ˫����ͼƬ����Ļ���
		Graphics gImage=offScreenImage.getGraphics();
		gImage.fillRect(0,0,600,800);

		if(state==0) {
			gImage.drawImage(GameUtils.bdImg, 0, 0, null);
			gImage.drawImage(GameUtils.expImg, 270, 350, null);
			gImage.drawImage(GameUtils.planeImg, 280, 470, null);
			gImage.drawImage(GameUtils.bossImg, 190, 70, null);
			//������Ϸ��ʼ���������
			gImage.setColor(Color.BLUE);
			gImage.setFont(new Font("����", Font.BOLD, 30));
			gImage.drawString("��������ʼ��Ϸ", 180, 300);

		}
		if(state==1){
//			bgObj.paintSelf(gImage);
//			planeObj.paintSelf(gImage);
//			shellObj.paintSelf(gImage);
			//����ը������ӵ�Ԫ�������
			GameUtils.gameObjList.addAll(GameUtils.explodeObjList);
			
			//���ٵ�������ĳ����ϷԪ�أ���Ϊ������ϷԪ�ض�����������Ԫ�ؼ����У�����ֻ��Ҫ������������Ԫ�ر���������Ȼ�����������
			for (int i = 0; i < GameUtils.gameObjList.size(); i++) {
				GameUtils.gameObjList.get(i).paintSelf(gImage);
			}

			//��Ҫ�Ƴ���Ԫ�ش����м�����ɾ��
			//ɾ������removeList��GameobjLIst�Ľ���
			GameUtils.gameObjList.removeAll(GameUtils.removeList);
			count++;
			
		}
		if (state == 2) {
			gImage.drawImage(GameUtils.bdImg, 0, 0, null);
			GameUtils.drawWord(gImage, "��Ϸ��ͣ", Color.yellow, 30, 220, 300);
			count = count;
		}
		if (state == 3) {
			gImage.drawImage(GameUtils.bdImg, 0, 0, null);
			GameUtils.drawWord(gImage, "ʧ��", Color.red, 30, 220, 300);
			count = 0;
		}
		if (state == 4) {
			gImage.drawImage(GameUtils.bdImg, 0, 0, null);
			GameUtils.drawWord(gImage, "�������", Color.blue, 30, 220, 300);
			
		}
		//������Ϸ����
		GameUtils.drawWord(gImage, score+"��/2000��",Color.green, 40, 30, 100);
		
		//��˫����ͼƬ��������Ϸ����
		g.drawImage(offScreenImage,0,0,null);
	}

	//��������������������������
	void createObj() {
				
		if (count % 6 == 0) {//��������ӵ��������ٶ�
			if (planeObj.times == 0) {	//��ʼ�ӵ�
				GameUtils.shellObjList.add(new ShellObj(GameUtils.shellImg, 14, 29, planeObj.getX() + 12, planeObj.getY() - 20, 5, this));
				GameUtils.gameObjList.add(GameUtils.shellObjList.get(GameUtils.shellObjList.size() - 1));//��ӵ�����Ԫ�ؼ����еĶ�������new�������ӵ����󣬲����������ӵ�����
			}
			if (planeObj.times == 1) {	//�����ӵ�
				GameUtils.doubleShellList.add(new DoubleShellObj(GameUtils.doubleshellImg, 32, 64, planeObj.getX() + 10, planeObj.getY() - 20, 8, this));
				GameUtils.gameObjList.add(GameUtils.doubleShellList.get(GameUtils.doubleShellList.size() - 1));//��ӵ�����Ԫ�ؼ����еĶ�������new�������ӵ����󣬲����������ӵ�����
			}
			if (planeObj.times == 2) {	//�����ӵ�
				GameUtils.tripleShellList.add(new TripleShellObj(GameUtils.tripleShellImg, 18, 14, planeObj.getX() -5, planeObj.getY() - 20, 8, this));
				GameUtils.gameObjList.add(GameUtils.tripleShellList.get(GameUtils.tripleShellList.size() - 1));//��ӵ�����Ԫ�ؼ����еĶ�������new�������ӵ����󣬲����������ӵ�����
			}
		}
		if (count % 15 == 0) {//���Ƶط�С�ɻ��Ĳ���(С	//15	
			//�����x�����������������(math.random*10)*60��˼��x����600���أ��������ȵķֳ�10�ݲ����ɻ�����������д�����
			GameUtils.enemy1ObjList.add(new Enemy1Obj(GameUtils.enemy1Img,32,24,(int)(Math.random()*10)*60,-24,5,this));			
			GameUtils.gameObjList.add(GameUtils.enemy1ObjList.get(GameUtils.enemy1ObjList.size()-1));
		}
		
		if (count % 20 == 0) {	//���Ƶз���ɻ�������  20
			if (count % 100 == 0) {//���Ƶз�С�ɻ��Ĳ���(��	
				//�����x�����������������(math.random*10)*60��˼��x����600���أ��������ȵķֳ�10�ݲ����ɻ�����������д�����
				GameUtils.enemy2ObjList.add(new Enemy2Obj(GameUtils.enemy2Img,44,67,(int)(Math.random()*10)*60,-67,3,this));			
				GameUtils.gameObjList.add(GameUtils.enemy2ObjList.get(GameUtils.enemy2ObjList.size()-1));
			}
			if (GameUtils.enemy2ObjList.size()>0){	//���������϶��ǲ����˴�ɻ���
				//������µĴ�ɻ��е�����,x��y �������²����ĵط���ɻ������λ�ã������λ�ò����ط���ɻ����ӵ�
				int x=(GameUtils.enemy2ObjList.get(GameUtils.enemy2ObjList.size()-1)).getX();
				int y=(GameUtils.enemy2ObjList.get(GameUtils.enemy2ObjList.size()-1)).getY();
				GameUtils.enemy2BulletObjList.add(new Enemy2BulletObj(GameUtils.enemy2BulletImg, 14,25, x+17, y+55, 5, this));
				GameUtils.gameObjList.add(GameUtils.enemy2BulletObjList.get(GameUtils.enemy2BulletObjList.size()-1));
			}
		}
		
		if (count == 600 &&(!GameUtils.gameObjList.contains(littleBoss1))) {
			
			//Сboss1����
			GameUtils.gameObjList.add(littleBoss1);
			
		}
		if (count == 1500 && (!GameUtils.gameObjList.contains(littleBoss2))) {
			//Сboss2����
			GameUtils.gameObjList.add(littleBoss2);
		}
		if (count % 30 == 0) {
			//���Сboss1���ӵ�
			GameUtils.littleBoss1BulletList.add(new LittleBoss1Bullet(GameUtils.littleboss1BulletImg,42,42,littleBoss1.getX()+76,littleBoss1.getY()+100,4,this));
			GameUtils.gameObjList.add(GameUtils.littleBoss1BulletList.get(GameUtils.littleBoss1BulletList.size()-1));
		}
		if (count % 50 == 0) {
			//���Сboss2���ӵ�
			if (GameUtils.gameObjList.contains(littleBoss2)){
				GameUtils.littleBoss2BulletList.add(new LittleBoss2Bullet(GameUtils.littleboss2BulletImg,21,59,littleBoss2.getX()+75,littleBoss2.getY()+100,8,this));
				GameUtils.gameObjList.add(GameUtils.littleBoss2BulletList.get(GameUtils.littleBoss2BulletList.size()-1));
			}
		}
		if (score > 2000) {
			state = 4;
		}
		
//		//boss����1300��û������Сboss�����ʱ��
//		if (count == 1300 &&(!GameUtils.gameObjList.contains(bossObj))&&(!GameUtils.gameObjList.contains(littleBoss1))&&(!GameUtils.gameObjList.contains(littleBoss2))){
//			GameUtils.gameObjList.add(bossObj);
//		}
		
//		//��boss�ӵ���ӵ�boss���ϵ���
//		if (GameUtils.gameObjList.contains(bossObj)) {
//				//���Сboss1���ӵ�
//				GameUtils.littleBoss1BulletList.add(new LittleBoss1Bullet(GameUtils.littleboss1BulletImg,42,42,bossObj.getX()+76,bossObj.getY()+100,4,this));
//				GameUtils.gameObjList.add(GameUtils.littleBoss1BulletList.get(GameUtils.littleBoss1BulletList.size()-1));
//				if (count % 50 == 0) {
//					//���Сboss2���ӵ�
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
