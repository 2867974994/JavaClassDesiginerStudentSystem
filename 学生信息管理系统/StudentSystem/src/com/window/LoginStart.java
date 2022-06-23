package com.window;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

/*���ڣ�2021��1��2��
 * ������:Bվup�� �̵���
 * QQ:3058333641
 * ��ǰ�ฺ�𣬵��ÿ�ʼ��ͼ�ν���
 * */
import javax.swing.*;

import com.event.AccountEvent;
import com.event.LoginEvent;
import com.event.RegEvent;
import com.stytle.Fronts;

public class LoginStart extends JFrame {
	//FlowLayout flowlayout;
	FlowLayout flowlayout;//����һ������
	
	
	
	//��Ҫ5����ǩ  ��һ���ı��򣬺�һ�������  ��һ����¼��ť
	JLabel bgimg;//���屳��  ��ǩ
	JLabel register;//����ע��   ��ǩ
	JLabel account;//�����˺�    ��ǩ
	JLabel password;//�������� 	��ǩ
	JLabel title;//�������   ��ǩ
	public static JTextField  accounttext;//�����˺��ı�
	public static JPasswordField passwordtext;//�������� ��
	JButton ok;//��¼��ť
	//���ڱ���  
	final int WIDTH=500;//���ö����ܵĿ��
	final int HEIGHT=280;//���ö����ܵĸ߶�
	//����һ������ 
	javax.swing.JPanel jpanel_1;//��ͼƬ������������
	javax.swing.JPanel jpanel_2;//ֻ�ű���
	javax.swing.JPanel jpanel_3;//���˺�������� �ͱ༭��������
	//javax.swing.JPanel jpanel_4;//���˺�������� �ͱ༭��������
	//������Ķ���
	RegEvent regevent;//����ע���ǩ���������¼�
	
	ActionListener lintener_1;
	
	
	
	public LoginStart() {
		init();
		setVisible(true); //���õ�ǰ�����Ƿ����ʾ 
		setResizable(false);//���ڵĴ�С���ɱ�
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//����Ĭ�Ϲرշ�ʽ
		validate();//�������Ч
		
	}
	
	void init() {
		//����һ������
		flowlayout=new FlowLayout(FlowLayout.CENTER);
		//������1��������
		jpanel_1=new javax.swing.JPanel();
		jpanel_1.setBounds(0, 0, WIDTH, HEIGHT);
		jpanel_1.setLayout(null);//���ò���Ϊ��
		//������2��������  ���ж���
		jpanel_2=new javax.swing.JPanel();
		jpanel_2.setBounds(0, 50, WIDTH, 50);
		jpanel_2.setLayout(flowlayout);
		jpanel_2.setOpaque(false);//����ǰ���������ó�͸��
		//������3���г�ʼ��
		jpanel_3=new javax.swing.JPanel();
		jpanel_3.setBounds(100, 105, 300,130);
		jpanel_3.setLayout(flowlayout);
		jpanel_3.setOpaque(false);//����ǰ���������ó�͸��
		
		
		
		//��ʼ�������� 
		Fronts fronts=new Fronts();
		//��ӱ���
		this.setTitle("ѧ����Ϣ����ϵͳ");
		
		// ���õ�ǰ���ڵĴ�С
		Toolkit kit =Toolkit.getDefaultToolkit();//��ȡ�����С	//���ô���λ��
		Dimension screenSize=kit.getScreenSize();
		int width=screenSize.width;
		int height=screenSize.height;//��ȡ��Ļ�߶ȺͿ��
		int x=(width-WIDTH)/2;
		int y=(height-HEIGHT)/2;
		this.setBounds(x, y, WIDTH, HEIGHT);
		
		//���ñ���ͼƬ
		ImageIcon img=new ImageIcon("src/img/1.jpg");//��ͼƬ��ȡ�ŵ�img��������
		bgimg=new JLabel(img);
		bgimg.setBounds(0,0,img.getIconWidth(), img.getIconHeight());//���ñ���ͼƬ ���ñ���λ��
		
		
		//��ӱ��� 
		title=new JLabel("ѧ����Ϣ����ϵͳ");
		title.setFont(fronts.title);
		title.setForeground(Color.CYAN);
		//����˺ź����� ���б༭��� 
		account=new JLabel("�˺� ");
		account.setFont(fronts.account);
		account.setForeground(new  Color(255,228,181));
		//����˺��ı���
		accounttext=new JTextField(20);
		accounttext.setFont(fronts.accounttext);
		accounttext.setForeground(new  Color(224,57,151));
		//��������ǩ
		password=new JLabel("���� ");
		password.setFont(fronts.account);
		password.setForeground(new  Color(255,228,181));
		//�����
		passwordtext=new JPasswordField(20);
		passwordtext.setFont(fronts.accounttext);
		passwordtext.setForeground(new  Color(224,57,151));
		//��¼��ť
		ok=new JButton("��ȫ��¼");
		ok.setPreferredSize(new Dimension(254,35));
		ok.setFont(fronts.ok);
		ok.setBackground(new Color(8,189,252));
		ok.setForeground(new Color(	255,215,0));
		ok.setName("ok");
		//ע���ǩ
		register=new JLabel("ע���˺�");
		register.setBounds(10, 210, 100, 40);
		register.setFont(fronts.register);
		register.setForeground(new Color(166,166,166));
		
		//��ӵĲ���
		jpanel_1.add(register);
		jpanel_1.add(register);
		jpanel_3.add(account);
		
		jpanel_3.add(accounttext);
		jpanel_3.add(password);
		jpanel_3.add(passwordtext);
		jpanel_3.add(ok);
		
		jpanel_2.add(title);
		jpanel_1.add(jpanel_2);
		jpanel_1.add(jpanel_3);
		jpanel_1.add(bgimg);//��ͼƬ�ŵ���������
		this.add(jpanel_1);
		
		allEvent();
	}
	//���д����¼���������ط�ȥд
		void allEvent() {
			regevent=new RegEvent();
			lintener_1=new LoginEvent();
			register.addMouseListener(regevent);
			ok.addActionListener(lintener_1);
			
		}
		//����������õ�ǰ������ʧ
		public void close() {
			this.dispose();
		}
	

}
