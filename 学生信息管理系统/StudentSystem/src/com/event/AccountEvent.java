package com.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.*;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


import com.mysqld.Mysqld;
import com.window.Register;
//ֻ�Ǵ󲿷ֵļ���
public class AccountEvent implements ActionListener{
	
	JTextField alluse;
	JButton allJbutton;
	Statement sql;
	ResultSet rs;
	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			
			alluse=(JTextField) e.getSource();//��֤�����ǰ�ť
			if(alluse!=null) {
				allUee();
			}
			
		}catch(Exception e1) {
			
			 allJbutton= (JButton) e.getSource();
			if( allJbutton.getName()=="reg") {
				Jbtton();
				
			}
			
		}			
	}
	void allUee() {
		if(alluse.getName()=="nametext") {
			Register.accounttext.requestFocus();
	
		}
		if(alluse.getName()=="accounttext") {
			Register.passwordtext.requestFocus();
		}
		if(alluse.getName()=="passwordtext") {
			Register.okpasswordtext.requestFocus();
		}
		if(alluse.getName()=="okpasswordtext"){
			
			Register.reg.requestFocus();
		}
	}
	void Jbtton()  {
		boolean nameT=Register.nametext.getText().equals("");
		boolean accountT=Register. accounttext.getText().equals("");
		//��ȡ����
		char[] str=Register.passwordtext.getPassword();
		String passwordtext =new String(str);
		boolean passwordT=passwordtext.equals("");
		
		
		str=Register.okpasswordtext.getPassword();
		String okpasswordtext =new String(str);
		boolean okpasswordT=okpasswordtext.equals("");
		
		
		
		if(nameT==true) {
			JOptionPane.showMessageDialog(null, "��������Ϊ��", "ע����Ϣ",JOptionPane.WARNING_MESSAGE);
		}else if(accountT==true){
			JOptionPane.showMessageDialog(null, "�˺Ų���Ϊ��", "ע����Ϣ",JOptionPane.WARNING_MESSAGE);
		}else if(passwordT==true) {
			JOptionPane.showMessageDialog(null, "���벻��Ϊ��", "ע����Ϣ",JOptionPane.WARNING_MESSAGE);
		}else if(okpasswordT==true) {
			JOptionPane.showMessageDialog(null, "ȷ�����벻��Ϊ��", "ע����Ϣ",JOptionPane.WARNING_MESSAGE);
		}else if(passwordtext.equals(okpasswordtext)==false){
			//���ȷ������������ǲ�һ����
			JOptionPane.showMessageDialog(null, "�������벻һ��", "ע����Ϣ",JOptionPane.WARNING_MESSAGE);
		}else {
			//�����ı�
			String name=Register.nametext.getText();
			//�˺��ı�
			String account=Register. accounttext.getText();
			//�����ı�
			String password= passwordtext;
			java.sql.Connection con=Mysqld.con;
			PreparedStatement preSql;
			String Uri="insert into user values(?,?,?,?)";
			try {
				preSql=con.prepareStatement(Uri);
				preSql.setString(1, name);
				preSql.setString(2, account);
				preSql.setString(3, password);
				preSql.setString(4, "0");
				int ok=preSql.executeUpdate();
				JOptionPane.showMessageDialog(null, "ע��ɹ�", "ע����Ϣ",JOptionPane.WARNING_MESSAGE);
				
			}catch(SQLException e) {
				JOptionPane.showMessageDialog(null, "��ǰ�˺��Ѿ�����", "ע����Ϣ",JOptionPane.WARNING_MESSAGE);
				
			}
			
		}
		
		
	}

}
