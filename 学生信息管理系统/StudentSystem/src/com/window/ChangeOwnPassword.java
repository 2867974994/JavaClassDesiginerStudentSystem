package com.window;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import com.event.LoginEvent;

import javax.swing.*;

public class ChangeOwnPassword extends  JFrame {
	FlowLayout flowlayout;//����һ������
	final int WIDTH=300;//���ö����ܵĿ��
	final int HEIGHT=80;//���ö����ܵĸ߶�
	//һ����ǩ  һ�������һ��  ��һ����ť  
	JLabel password;//�����ǩ
	public static JPasswordField passwordtext;//����һ�������
	JButton changeown;

	ActionListener lintener_1;
	public ChangeOwnPassword() {
		init();
		setVisible(true); //���õ�ǰ�����Ƿ����ʾ 
		setResizable(false);//���ڵĴ�С���ɱ�
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//����Ĭ�Ϲرշ�ʽ
		validate();//�������Ч
		
	}
	void init() {
		// ���õ�ǰ���ڵĴ�С
		Toolkit kit =Toolkit.getDefaultToolkit();//��ȡ�����С	//���ô���λ��
		Dimension screenSize=kit.getScreenSize();
		int width=screenSize.width;
		int height=screenSize.height;//��ȡ��Ļ�߶ȺͿ��
		int x=(width-WIDTH)/2;
		int y=(height-HEIGHT)/2;
		this.setBounds(x, y, WIDTH, HEIGHT);
		flowlayout=new FlowLayout(FlowLayout.CENTER);
		this.setLayout(flowlayout);//���ò���
		
		
		 password=new JLabel("����");
		 passwordtext=new JPasswordField(15);
		 changeown=new JButton("�޸�����");
		 
		 lintener_1=new LoginEvent();
		 changeown.addActionListener(lintener_1);
		
		 changeown.setName("changeown");
		this.setTitle("��������");
		
		this.add(password);
		this.add(passwordtext);
		this.add(changeown);
	}
	

}
