package com.mysqld;

import java.sql.*;

import javax.swing.JOptionPane;

import com.event.LoginEvent;

import com.window.ChangeAccountMessage;
import com.window.Manage;



public class Mysqld {
	
	public static Connection con=null;
	public Mysqld(String account,String password) {
		//������һ�����ݵ��˺ź�����
		//��һ����������
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("���������ɹ�");
		}catch (Exception e) {
			System.out.println("������ʧ��");
		}
		//
		
		String uri="jdbc:mysql://localhost:3306/student?characterEncoding=utf-8&useSSL=false";
		try {
			con=DriverManager.getConnection(uri,account,password);
			System.out.println("�������ݿ�ɹ�");
		}catch(SQLException e) {
			System.out.println("�������ݿ����Ӵ���");
			System.out.println(e);

		}
	}
	//��ע����Ϣд��
	public static boolean loginAccount(String account, String password) {
		//��¼�˺�
		//�����ݿ�����ݽ��ж���ȡ
		Statement sql;
		ResultSet rs;
		String uri="select account,password from user";
		try {
			sql=con.createStatement();
			rs=sql.executeQuery(uri);
			while(rs.next()) {
				String acc=rs.getString(1);//���صĵ�һ��ֵ�����˺�
				String pass=rs.getString(2);//���صĵ�һ��ֵ�����˺�
				if(acc.equals(account)&&pass.equals(password)){
					return true;
				}
				
			}
		
		}catch(SQLException e) {
		
			return false;
		}
		return false;
		
	}
	public static void onlineAccount() {
		Statement sql;
		ResultSet rs;
		String uri="select * from user";
		try {
			sql=con.createStatement();
			rs=sql.executeQuery(uri);
			Manage.resultText.setText("");
			Manage.resultText.setText("����\t�˺�\t״̬\n");
			while(rs.next()) {
				String name=rs.getString(1);//���صĵ�һ��ֵ�����˺�
				String account=rs.getString(2);//���صĵ�һ��ֵ�����˺�
				String password=rs.getString(3);//���صĵ�һ��ֵ�����˺�
				String start=rs.getString(4);//���صĵ�һ��ֵ�����˺�
				if(start.equals("1")) {
					System.out.println("����");
					String uri1=Manage.resultText.getText()+name+"\t"+account+"\t����"+"\n";
					Manage.resultText.setText(uri1);
					
				}

				
				}
				
			
		
		}catch(SQLException e) {
		

		}

		
	}
	public static void AllAccount() {
		Statement sql;
		ResultSet rs;
		String uri="select * from user";
		try {
			sql=con.createStatement();
			rs=sql.executeQuery(uri);
			Manage.resultText.setText("");
			Manage.resultText.setText("����\t�˺�\t״̬\n");
			while(rs.next()) {
				String name=rs.getString(1);//���صĵ�һ��ֵ�����˺�
				String account=rs.getString(2);//���صĵ�һ��ֵ�����˺�
				String password=rs.getString(3);//���صĵ�һ��ֵ�����˺�
				String start=rs.getString(4);//���صĵ�һ��ֵ�����˺�
				if(start.equals("1")) {
				
					String uri1=Manage.resultText.getText()+name+"\t"+account+"\t����"+"\n";
					Manage.resultText.setText(uri1);
					
				}
				if(start.equals("0")) {
					
					String uri1=Manage.resultText.getText()+name+"\t"+account+"\t����"+"\n";
					Manage.resultText.setText(uri1);
					
				}

				
				}
				
			
		
		}catch(SQLException e) {
		

		}

		
	}
	public static void changeOtherAccountMessage() {
		ResultSet rs;
		PreparedStatement preSql;
		String sqlStr="update user set name=?,password=? where account=?";
		try {
			String account=ChangeAccountMessage.accounttext.getText();
			String name=ChangeAccountMessage.nametext.getText();
			String password=new String (ChangeAccountMessage.passwordtext.getPassword());
			preSql=con.prepareStatement(sqlStr);
			int ok = 100;
			if(account.equals("")) {
				JOptionPane.showMessageDialog(null, "�˺Ų���Ϊ��", "������Ϣ",JOptionPane.WARNING_MESSAGE);
			}else if (name.equals("")) {
				JOptionPane.showMessageDialog(null, "��������Ϊ��", "������Ϣ",JOptionPane.WARNING_MESSAGE);
			}else if (password.equals("")) {
				JOptionPane.showMessageDialog(null, "���벻��Ϊ��", "������Ϣ",JOptionPane.WARNING_MESSAGE);
			}else {
				preSql.setString(1, name);
				preSql.setString(2,password);
				preSql.setString(3, account);
				ok=preSql.executeUpdate();
				if(ok==0) {
					JOptionPane.showMessageDialog(null, "��������ȷ�˺�", "������Ϣ",JOptionPane.WARNING_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "���ĳɹ�", "������Ϣ",JOptionPane.WARNING_MESSAGE);
				}
			
			}
			
			
			
		}catch(SQLException e) {
			
		}
	}
	public static void setStart(String account,String start) {//���˻������ִ������
		PreparedStatement preSql;
		String sqlStr="update user set start=? where account=?";
		try {
			preSql=con.prepareStatement(sqlStr);
			preSql.setString(1,  start);
			preSql.setString(2, account);
			preSql.executeLargeUpdate();
		}catch(SQLException e) {
			
		}
		
		
	}
	public static void changePassword(String account,String password) {
		PreparedStatement preSql;
		String sqlStr="update user set password=? where account=?";
		try {
			preSql=con.prepareStatement(sqlStr);
			preSql.setString(1, password);
			preSql.setString(2, account);
			preSql.executeLargeUpdate();
			
		}catch(SQLException e) {
			
		}
		
	}
	public static String  findAccountStart(String account) {
		PreparedStatement preSql;
		String sqlStr="select start from user where account=?";
		String satart="a";
		
		
		try {
			preSql=con.prepareStatement(sqlStr);
			preSql.setString(1, account);
			ResultSet rs = preSql.executeQuery();
			while(rs.next()) {
				satart=rs.getString(1);
				
			}
	
			return satart;
		}catch(SQLException e) {
			
			return satart;
		}
		
	}
	public static  void addStudent(String name,String sex,String age,String grade,String number) {
		PreparedStatement preSql;
		String sqlStr="insert into  stu(name,sex,age,grade,number) values(?,?,?,?,?)";
	
		
		
		try {
			preSql=con.prepareStatement(sqlStr);
			preSql.setString(1, name);
			preSql.setString(2, sex);
			preSql.setString(3, age);
			preSql.setString(4, grade);
			preSql.setString(5, number);
			int ok = preSql.executeUpdate();
			JOptionPane.showMessageDialog(null, "��ӳɹ�", "�������",JOptionPane.WARNING_MESSAGE);
		
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "��ǰѧ���Ѿ�����", "�������",JOptionPane.WARNING_MESSAGE);
		
		}
		
		
	}
	public static  void delStudeng(String number) {
		PreparedStatement preSql;
		String sqlStr="delete from stu where number=?";

		try {
			preSql=con.prepareStatement(sqlStr);
			preSql.setString(1, number);
			int ok = preSql.executeUpdate();
			if(ok==0) {
				JOptionPane.showMessageDialog(null, "δ�ҵ����ѧ��", "��Ϣ",JOptionPane.WARNING_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(null, "ɾ���ɹ�", "��Ϣ",JOptionPane.WARNING_MESSAGE);
			}
		
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "��ǰѧ���Ѿ�����", "�������",JOptionPane.WARNING_MESSAGE);
		
		}
	}
	
	public static  void changeStudeng(String name,String sex,String age,String grade,String number,String numberT) {
		
		PreparedStatement preSql;
		String sqlStr="update stu  set name=?,sex=?,age=?,grade=?,number=? where number=?";
		try {
			preSql=con.prepareStatement(sqlStr);
			preSql.setString(1, name);
			preSql.setString(2, sex);
			preSql.setString(3, age);
			preSql.setString(4, grade);
			preSql.setString(5, number);
			preSql.setString(6, numberT);
			int ok = preSql.executeUpdate();
			if(ok==0) {
				JOptionPane.showMessageDialog(null, "ѧ���ظ���������ѧ�Ų�����", "��Ϣ",JOptionPane.WARNING_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(null, "���ĳɹ�", "��Ϣ",JOptionPane.WARNING_MESSAGE);
			}
		
		}catch(SQLException e) {
		
			System.out.println(e);
		}
		
		
	}
	public static  void   findAllStudeng() {
		PreparedStatement preSql;
		Manage.model.setNumRows(0);//���������Ϊ0
		String sqlStr="select * from stu";//�������е�
		try {
			preSql=con.prepareStatement(sqlStr);
			ResultSet rs = preSql.executeQuery();
			LoginEvent.addAble(rs);
		
		}catch(SQLException e) {
		
			System.out.println(e);
		}
		
	}
	public static  ResultSet getRs() {
		PreparedStatement preSql;
		ResultSet rs = null ;
		Manage.model.setNumRows(0);//���������Ϊ0
		String sqlStr="select * from stu";//�������е�
		try {
			preSql=con.prepareStatement(sqlStr);
			rs = preSql.executeQuery();
			
		
		}catch(SQLException e) {
		
			System.out.println(e);
		}
	
		return rs;
		
	
	}
	public static  void finConStudent(String name,String sex,String age,String grade,String number) {
		PreparedStatement preSql;
		ResultSet rs = null ;
		Manage.model.setNumRows(0);//���������Ϊ0
		String sqlStr="select * from stu where name REGEXP? and sex REGEXP? and age REGEXP? and grade REGEXP? and number REGEXP?";//�������е�
		try {
			preSql=con.prepareStatement(sqlStr);
			preSql.setString(1, name);
			preSql.setString(2, sex);
			preSql.setString(3, age);
			preSql.setString(4, grade);
			preSql.setString(5, number);
			rs= preSql.executeQuery();
			LoginEvent.addAble(rs);
		
		}catch(SQLException e) {
		
			System.out.println(e);
		}
		
	}
	public static  void findOneStudent(String number) {
		PreparedStatement preSql;
		ResultSet rs = null ;
		Manage.model.setNumRows(0);//���������Ϊ0
		String sqlStr="select * from stu where number=?";
		try {
			preSql=con.prepareStatement(sqlStr);
			preSql.setString(1, number);
			rs= preSql.executeQuery();
			LoginEvent.addOneAble(rs);
		
		}catch(SQLException e) {
		
			System.out.println(e);
		}
		
	}

}
