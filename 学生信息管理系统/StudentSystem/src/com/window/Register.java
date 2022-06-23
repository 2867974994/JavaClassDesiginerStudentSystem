package com.window;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.event.AccountEvent;
import com.stytle.Fronts;

public class Register  extends JFrame{
	//���岼��
	FlowLayout flowlayout;//����һ������
	//���崰�ڵĸ߶ȺͿ��
	final int WIDTH=410;//���ö����ܵĿ��
	final int HEIGHT=345;//���ö����ܵĸ߶�
	//��������
	javax.swing.JPanel jpanel_1;//��ͼƬ������������
	javax.swing.JPanel jpanel_2;//ֻ�Ƿű���
	javax.swing.JPanel jpanel_3;//ֻ�Ƿű���
	
	//�������
	ActionListener lintener_1;//�˺��ı��� �ļ���

	
	
	
	//���尴ť�ͱ�ǩ
	JLabel bgimg;//���屳��  ��ǩ
	JLabel title;//�������   ��ǩ
	JLabel name;//�������ֱ�ǩ
	public static JTextField nametext;//�������ı���
	
	
	JLabel account;//�����˺ű���
	public static JTextField accounttext;//�����˺������ı�
	
	
	JLabel password;//���������ǩ
	public static JPasswordField passwordtext;//���������ı���

	
	JLabel okpassword;//����ȷ��
	public static JPasswordField okpasswordtext;//����ȷ�������ı���
	
	
	public static JButton reg;//ע�ᰴť
	
	
	public Register() {
		init();
		setVisible(true); //���õ�ǰ�����Ƿ����ʾ 
		setResizable(false);//���ڵĴ�С���ɱ�
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//����Ĭ�Ϲرշ�ʽ
		validate();//�������Ч
		
	}
	
	void init() {
		//���岼��
		flowlayout=new FlowLayout(FlowLayout.CENTER);//���ж��� 
		
		//�����ô�����ʾ��λ��
		// ���õ�ǰ���ڵĴ�С
		Toolkit kit =Toolkit.getDefaultToolkit();//��ȡ�����С	//���ô���λ��
		Dimension screenSize=kit.getScreenSize();
		int width=screenSize.width;
		int height=screenSize.height;//��ȡ��Ļ�߶ȺͿ��
		int x=(width-WIDTH)/2;
		int y=(height-HEIGHT)/2;
		this.setBounds(x, y,WIDTH,HEIGHT);
		//�������Ӵ�С
		jpanel_1=new javax.swing.JPanel();
		jpanel_1.setPreferredSize(new Dimension (WIDTH,HEIGHT));
		jpanel_1.setLayout(null);//���ò���
		jpanel_1.setOpaque(false);//����ǰ���������ó�͸��
		//���ñ���ͼƬ
		ImageIcon img=new ImageIcon("src/img/2.jpg");//��ͼƬ��ȡ�ŵ�img��������
		bgimg=new JLabel(img);
		bgimg.setBounds(0,0,img.getIconWidth(), img.getIconHeight());//���ñ���ͼƬ ���ñ���λ��
		//����һ������
		Fronts fronts=new Fronts();
		
		title=new JLabel("ѧ����Ϣ����ϵͳ�˺�ע��");
		title.setFont(fronts.title);
		title.setForeground(Color.gray);
		//�����Ӷ������ݽ��г�ʼ��
		jpanel_2=new javax.swing.JPanel();
		jpanel_2.setBounds(0, 30, WIDTH-10, 70);
		jpanel_2.setOpaque(false);//����ǰ���������ó�͸��
		jpanel_2.setLayout(flowlayout);
		//��ʼ����������
		jpanel_3=new javax.swing.JPanel();
		jpanel_3.setBounds(25, 100,350,200);
		jpanel_3.setOpaque(false);//����ǰ���������ó�͸��
		jpanel_3.setLayout(flowlayout);//���ò���
		//��һ�����ݽ��г�ʼ��
		name =new JLabel("��        ��:");
		name.setFont(fronts.account);
		nametext=new JTextField(20);
		name.setForeground(new Color(102,102,102));
		nametext.setForeground(new Color(18,120,192));
		nametext.setPreferredSize(new Dimension(15,28));
		nametext.setFont(fronts.accounttext);
	

		
		
		//�ڶ���
		account =new JLabel("��        ��:");
		account.setFont(fronts.account);
		accounttext=new JTextField(20);
		account.setForeground(new Color(102,102,102));
		accounttext.setForeground(new Color(18,120,192));
		accounttext.setPreferredSize(new Dimension(15,28));
		accounttext.setFont(fronts.accounttext);
			
	
		
		//������
		password =new JLabel("��        ��:");
		password.setFont(fronts.account);
		passwordtext=new JPasswordField(20);
		password.setForeground(new Color(102,102,102));		
		passwordtext.setForeground(new Color(18,120,192));
		passwordtext.setPreferredSize(new Dimension(15,28));
		passwordtext.setFont(fronts.accounttext);
		
		

		
		
		//passwordsatisfy.setBounds(0,0,img.getIconWidth(), img.getIconHeight());//���ñ���ͼƬ ���ñ���λ��
		//������
		
		okpassword =new JLabel("ȷ������:");
		okpassword.setFont(fronts.account);
		okpasswordtext=new JPasswordField(20);
		okpassword.setForeground(new Color(102,102,102));		
		okpasswordtext.setForeground(new Color(18,120,192));
		okpasswordtext.setPreferredSize(new Dimension(15,28));
		okpasswordtext.setFont(fronts.accounttext);

		
	
		//������
		reg=new JButton("ע          ��");
		reg.setPreferredSize(new Dimension(290,30));
		reg.setFont(fronts.ok);
		reg.setForeground(new Color(244,170,128));
	
		//��һ��
		jpanel_3.add(name);
		jpanel_3.add(nametext);

		//�ڶ���
		jpanel_3.add(account);
		jpanel_3.add(accounttext);

		//������
		jpanel_3.add(password);
		jpanel_3.add(passwordtext);

		//������
		jpanel_3.add(okpassword);
		jpanel_3.add(okpasswordtext);
	
		//���һ��
		jpanel_3.add(reg);
		jpanel_2.add(title);
		
		jpanel_3.setBorder(BorderFactory.createTitledBorder("�˺�ע�����"));
		
		jpanel_1.add(jpanel_3);
		jpanel_1.add(jpanel_2);
		jpanel_1.add(bgimg);
		this.add(jpanel_1);//������1��ӵ���Ͳ�  
		setAllTag();
		allEvent();
	}
	
	void allEvent() {
	
		lintener_1=new AccountEvent();
		nametext.addActionListener(lintener_1);
		accounttext.addActionListener(lintener_1);
		passwordtext.addActionListener(lintener_1);
		okpasswordtext.addActionListener(lintener_1);
		reg.addActionListener(lintener_1);
		
	}
	void setAllTag() {

		nametext.setName("nametext");//����
		accounttext.setName("accounttext");//�˺�
		passwordtext.setName("passwordtext");//���������ı���
		okpasswordtext.setName("okpasswordtext");//����ȷ�������ı���
		reg.setName("reg");
		
		
	}
	
	
	
}
