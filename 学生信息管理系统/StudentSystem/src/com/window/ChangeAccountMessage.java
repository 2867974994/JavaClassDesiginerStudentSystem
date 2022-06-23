package com.window;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import com.event.LoginEvent;

import javax.swing.*;

public class ChangeAccountMessage extends  JFrame {
	FlowLayout flowlayout;//����һ������
	final int WIDTH=230;//���ö����ܵĿ��
	final int HEIGHT=160;//���ö����ܵĸ߶�
	
	//����    ����   2����ǩ  1���༭��  һ�������  ��һ����ť
	JLabel account;
	public static JTextField accounttext;
	JLabel name;
	JLabel password;
	public static JTextField nametext;
	public static JPasswordField passwordtext;
	JButton change;
	
	//����һ������
	ActionListener lintener_1;
	public ChangeAccountMessage() {
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
		name=new JLabel("����");
		password=new JLabel("����");
		account=new JLabel("�˻�");
		nametext=new JTextField(15);
		passwordtext=new JPasswordField(15);
		accounttext=new JTextField(15);
		change=new JButton("����Ա����Ϣ");
		
		change.setName("change");
		
	
		
		
		this.setTitle("����Ϣ");
		
		
		this.add(account);
		this.add(accounttext);
		
		this.add(name);
		this.add(nametext);
		this.add(password);
		this.add(passwordtext);
		this.add(change);
		lintener_1=new LoginEvent();
		change.addActionListener(lintener_1);
		
	}
	

}
