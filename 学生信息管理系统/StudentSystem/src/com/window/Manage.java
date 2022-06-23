package com.window;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import com.Thread.RunGetAccountStart;
import com.event.LoginEvent;
import com.event.WindowsEven;

import static javax.swing.JFrame.*;

public class Manage extends JFrame {
	//���岼��
	FlowLayout flowlayout;//����һ������

	
	//���崰�ڵĸ߶ȺͿ��
	//���ڱ���  
	final int WIDTH=800;//���ö����ܵĿ��
	final int HEIGHT=725;//���ö����ܵĸ߶�
	//�����ǩ
	JLabel bgimg;//�����ͼƬ
	//����˵���
	JMenuBar menubar;//��һ���˵���
	JMenu menu,menu1;//����һ���˵�
	JMenuItem item1,item2,item3,item4;
	JMenuItem item1_1,item1_2;
	//����һ������
	javax.swing.JPanel jpanel_1;//��ͼƬ������������
	javax.swing.JPanel jpanel_2;//�����ű��
	//�����ǩ
	JLabel name;
	public static JTextField nametext;
	ButtonGroup group=null;
	public static JRadioButton Men,Women,allsex;
	JLabel age;
	public static JTextField agetext;
	
	JLabel grade;
	public static JTextField gradetext;
	
	JLabel number;
	public static JTextField numbertext;
	
	JButton add,del,change,show,reset;
	
	JLabel numbecondition;//ѧ������
	public static JTextField numbeconditiontext;//ѧ�������ı�
	
	public static JTextArea resultText;//��ʾ���
	
	//��������
	Object columns[] ={"����","�Ա�","����","�༶","ѧ��"};//������Ϣ
	JTable tableL=null;
	JScrollPane jscrollpane;	
	static Vector rwo;
	static Object a[][];
	static int row ;
	public static DefaultTableModel  model;
	static TableColumnModel columnModel;
	
	//����һ������
	ActionListener lintener_1;
	//����һ�����ڼ���
	WindowsEven lintener_2;
	
	public  Manage() {
		init();
		setVisible(true); //���õ�ǰ�����Ƿ����ʾ 
		setResizable(false);//���ڵĴ�С���ɱ�
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//����Ĭ�Ϲرշ�ʽ
		validate();//�������Ч
		
	}
	void init() {
	
		//���岼��
		flowlayout=new FlowLayout(FlowLayout.CENTER);//���ж��� 
		//��һ��������ײ�Ĳ���
		this.setLayout(null);
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
		ImageIcon img=new ImageIcon("src/img/3.jpg");//��ͼƬ��ȡ�ŵ�img��������
		bgimg=new JLabel(img);
		bgimg.setBounds(0,0,img.getIconWidth(),100);//���ñ���ͼƬ ���ñ���λ��
		//��Ӳ˵���
		menubar=new JMenuBar();//����˵���
		menu=new JMenu("����");
		menu1=new JMenu("�˺�");
		item1=new JMenuItem("�鿴���ߵ��˺�",new  ImageIcon("src/img/I1.gif"));
		item2=new JMenuItem("�鿴�����˺�",new  ImageIcon("src/img/I2.gif"));
		item3=new JMenuItem("����Ա���˺���Ϣ",new  ImageIcon("src/img/I3.gif"));
		item4=new JMenuItem("���ĵ�ǰ�˻�����",new  ImageIcon("src/img/I4.gif"));
		item1_1=new JMenuItem("�˳�",new  ImageIcon("src/img/I1_1.jpg"));
		item1_2=new JMenuItem("ע��",new  ImageIcon("src/img/I1_2.jpg"));
		 //
		
		
		
		menu.add(item1);
		menu.add(item2);
		menu.add(item3);
		menu.add(item4);
		
		menu1.add(item1_1);
		menu1.add(item1_2);
		
		
		menubar.add(menu);
		menubar.add(menu1);
		//��ʼ����һ������
		jpanel_1  =new javax.swing.JPanel();
		jpanel_1.setLayout(flowlayout);//���ж���
		jpanel_1.setBorder(BorderFactory.createTitledBorder("������Ϣ����"));
		jpanel_1.setBounds(0, 100, WIDTH-14, 100);
		//��Ӱ�ť
		name=new JLabel("����");
		
		
		//����ı�
		
		nametext=new JTextField(12);
		//����Ա�

		group=new ButtonGroup();
		Men=new JRadioButton("��");
		Women=new JRadioButton("Ů");
		allsex=new JRadioButton("ȫ��");
		group.add(Men);
		group.add(Women);
		group.add(allsex);
		//�������
		age=new JLabel("����");
		
		//��������ı�
		agetext=new JTextField(12);
		
		//��Ӱ༶
		grade=new JLabel("�༶");
		
		//��Ӱ༶�ı�
		gradetext=new JTextField(12);
		
		//���ѧ��
		number=new JLabel("ѧ��");
		
		//���ѧ���ı�
		numbertext=new JTextField(12);

		//���5����ť
	
		add=new JButton("��������");
		del=new JButton("ɾ������");
		change=new JButton("�޸�����");
		show=new JButton("��������");
		reset=new JButton("��������");
		numbecondition=new JLabel("�����ı���������ȷ��:��ѧ�š�");//ѧ������
		numbeconditiontext=new JTextField(14);//ѧ�������ı�
		
		
		//���õڶ������ӵĲ���
		jpanel_2  =new javax.swing.JPanel();
		jpanel_2.setLayout(flowlayout);
		jpanel_2.setBounds(0, 200, WIDTH-14, 300);
		jpanel_2.setBorder(BorderFactory.createTitledBorder("ѧ��������Ϣ��ʾ"));
		
		
		table();
		//�����ʾ�����Ϣ�ı���
		resultText=new JTextArea();
		resultText.setBounds(10,510 , WIDTH-30, 150);
		resultText.setBorder(BorderFactory.createTitledBorder("�˺���Ϣ��ʾ"));
		resultText.setEditable(false); 
		
		jpanel_1.add(name);
		jpanel_1.add(nametext);
		jpanel_1.add(Men);
		jpanel_1.add(Women);
		jpanel_1.add(allsex);
		jpanel_1.add(age);
		jpanel_1.add(agetext);
		
		jpanel_1.add(grade);
		jpanel_1.add(gradetext);
		
		jpanel_1.add(number);
		jpanel_1.add(numbertext);
		
		jpanel_1.add(numbecondition);
		jpanel_1.add(numbeconditiontext);
		
		jpanel_1.add(add);
		jpanel_1.add(del);
		jpanel_1.add(change);
		jpanel_1.add(show);
		jpanel_1.add(reset);
		

		
		jpanel_2.add(jscrollpane);
		this.add(jpanel_2);
		this.add(jpanel_1);
		this.add(menubar);
		this.add(bgimg);
		this.setJMenuBar(menubar);
		this.add(resultText);
		setAllName();
		allEvent();
	}
	void table() {
		tableL=getTable();
		jscrollpane=new JScrollPane(tableL);//���һ���������
		jscrollpane.setPreferredSize(new Dimension(WIDTH-30,250));//���������ô�С
		tableL.setPreferredSize(new Dimension(WIDTH-30,10000));//��������ô�С
		jscrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);//�����������ʾ�ڴ�����
	
	}
	JTable getTable() {
		if(tableL==null) {
			tableL=new JTable();//���� 
			int[] columnWidth={150,150,150,150,150};//�����п�
			model=new DefaultTableModel(){
				public boolean isCellEditable(int row, int column)
				{
				return false;
				}
				};//�п� ������  �����ñ�񲻿ɱ༭
			model.setColumnIdentifiers(columns);
			tableL.setModel(model);//����Ϊ����ģʽ
			columnModel=tableL.getColumnModel();//��ȡ�����Ŀ���
			tableL.getTableHeader().setReorderingAllowed(false);//�ñ�񲻿��϶�
			tableL.getTableHeader().setResizingAllowed(false);//�ñ�񲻿��϶�
			int count=columnModel.getColumnCount();//��������������
			for(int i=0;i<count;i++){
				javax.swing.table.TableColumn column=columnModel.getColumn(i);//�����б��еĶ���
				column.setPreferredWidth(columnWidth[i]);
			}
			 rwo = new Vector(5);
		}
		return tableL;
	}
	void allEvent() {
		lintener_1=new LoginEvent();
		lintener_2=new WindowsEven();
		item1.addActionListener(lintener_1);
		
		item2.addActionListener(lintener_1);
		item3.addActionListener(lintener_1);
		item4.addActionListener(lintener_1);
		item1_1.addActionListener(lintener_1);
		item1_2.addActionListener(lintener_1);
		add.addActionListener(lintener_1);
		del.addActionListener(lintener_1);
		change.addActionListener(lintener_1);
		show.addActionListener(lintener_1);
		reset.addActionListener(lintener_1);
		this.addWindowListener(lintener_2);
		
	}
	void setAllName() {
		item1.setName("item1");
		item2.setName("item2");
		item3.setName("item3");
		item4.setName("item4");
		item1_1.setName("item1_1");
		item1_2.setName("item1_2");

		add.setName("add");
		del.setName("del");
		change.setName("chan");
		show.setName("show");
		reset.setName("reset");
		show.setName("show");
		reset.setName("reset");
	
		
		
	}

}
