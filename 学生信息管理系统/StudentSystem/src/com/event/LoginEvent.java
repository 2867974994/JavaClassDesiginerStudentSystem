package com.event;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import com.Thread.RunGetAccountStart;

import com.mysqld.Mysqld;
import com.window.ChangeAccountMessage;
import com.window.ChangeOwnPassword;
import com.window.LoginStart;
import com.window.Manage;
import com.window.StudentSystem;

public class LoginEvent implements ActionListener{
	
	JButton button;//����һ����ť
	public static String accountA;//��¼��¼���˻�
	JMenuItem item;
	static ChangeOwnPassword aa;
	public static Manage manage;
	static  String start;
	public static Thread cheack;
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		try {
			
			button= (JButton) e.getSource();//ǿ��ת������
			
			if(button.getName()=="ok") {
				//����˺ź���������ݿ��������һ���Ǿ͵�¼ ͬд��״̬����
				String account=LoginStart.accounttext.getText();
				String passworn=new String (LoginStart.passwordtext.getPassword());
				
				if(Mysqld.loginAccount( account, passworn)) {
					//��¼�¼�
					this.accountA=account; //ͬ��Ҳд���¼״̬   0  �ǲ�����  1����
					//��һ���Ȳ�ѯ��ǰ�˺ŵĵ�¼״̬
					start=Mysqld.findAccountStart(accountA);//����һ���ַ�����״̬
					
					if(start.equals("1")) {
						//JOptionPane.showMessageDialog(null, "��ǰ�˺��Ѿ���¼", "��¼��Ϣ",JOptionPane.WARNING_MESSAGE);
						int a=JOptionPane.showConfirmDialog(null,"��ǰ�˺��Ѿ���¼���Ƿ������¼","��¼��Ϣ",JOptionPane.YES_NO_OPTION);
						//0����ȷ��  1���� ��
						
						if(a==0) {
							//�����ݿ��״̬˲���Ϊ0
							Mysqld.setStart(accountA,"0");
							StudentSystem.loginstartA.close();
							manage=new Manage();//�򿪵�¼����
							while(Mysqld.findAccountStart(accountA).equals("1")) {
								checkStart();
								break;
							}
							
							
						}
					//sleep
						
					}else {
						Mysqld.setStart(accountA,"1");
						StudentSystem.loginstartA.close();
						manage=new Manage();//�򿪵�¼����
						checkStart();
						
					}
				
					
					
					
					
				}else {
					JOptionPane.showMessageDialog(null, "�������", "��¼��Ϣ",JOptionPane.WARNING_MESSAGE);
				}
			
			
		
				
			}
			
			if(button.getName()=="change") {
				//�����ݿ������Ϣ
		
				Mysqld.changeOtherAccountMessage();
				
			}
			if(button.getName()=="changeown") {
				//��һ��֪����ǰ�˻����ĸ��˻�Ȼ�� ��Ϣ����
				String password=new String (ChangeOwnPassword.passwordtext.getPassword());
				
				Mysqld. changePassword(accountA,password);
				JOptionPane.showMessageDialog(null, "�޸�����ɹ�", "�޸�������Ϣ",JOptionPane.WARNING_MESSAGE);
				
				//�ѹ����������ر� �򿪵�¼����
				manage.dispose();//���������ʧ   
				//�ѵ�¼״̬����Ϊ0 
				Mysqld.setStart(accountA,"0");
				aa.dispose();
				StudentSystem.show();
			
			}
			
			//____________________________________________
			
			if(button.getName()=="add") {
				//�����ݿ�д������
				Manage.model.setNumRows(0);
				String name=Manage.nametext.getText();
				boolean man=Manage.Men.isSelected();
				boolean woman=Manage.Women.isSelected();
				boolean allsex=Manage.allsex.isSelected();
				
				String sex;
				String age=Manage.agetext.getText();
				String grade=Manage.gradetext.getText();
				String number=Manage.numbertext.getText();
				
				
				
				if(name.equals("")) {
					JOptionPane.showMessageDialog(null, "��������Ϊ��", "�༭��Ϣ",JOptionPane.WARNING_MESSAGE);
				}else if((man==false&&woman==false)&&allsex==true) {
					Manage.Men.setSelected(true);
					JOptionPane.showMessageDialog(null, "��ȫ������������Ϣ���ܱ�ѡ��", "�༭��Ϣ",JOptionPane.WARNING_MESSAGE);
					
					
				}else if(man==false&&woman==false&&allsex==false) {
					JOptionPane.showMessageDialog(null, "��ѡ���Ա�", "�༭��Ϣ",JOptionPane.WARNING_MESSAGE);
				}else if( age.equals("")) {
					JOptionPane.showMessageDialog(null, "��Ͳ���Ϊ��", "�༭��Ϣ",JOptionPane.WARNING_MESSAGE);
				}else if ( grade.equals("")) {
					JOptionPane.showMessageDialog(null, "�༶����Ϊ��", "�༭��Ϣ",JOptionPane.WARNING_MESSAGE);
				}else if(number.equals("")) {
					JOptionPane.showMessageDialog(null, "ѧ�Ų���Ϊ��", "�༭��Ϣ",JOptionPane.WARNING_MESSAGE);
				}else {
					if(Manage.Men.isSelected()==true) {
						sex=Manage.Men.getText();
					}else {
						sex=Manage.Women.getText();
					}
						
					Mysqld.addStudent(name, sex, age , grade, number);
					//����ӵ�������ʾ���������
					//ManageForm.model.addRow(dm);
					
					String  data[]=new String [5];
						data[0]=name;
						data[1]=sex;
						data[2]=age;
						data[3]=grade;
						data[4]=number;
						Manage.model.addRow(data);
					
				}
				
				
			}
			
			
			if(button.getName()=="del") {
				//ɾ������
				
				 
				 String numberA=Manage.numbeconditiontext.getText();
				 if(numberA.equals("")) {
					 JOptionPane.showMessageDialog(null, "��������Ϊ��", "ɾ����Ϣ",JOptionPane.WARNING_MESSAGE);
				 }else {
					 Mysqld.delStudeng(numberA);
				 }
				 
				
			}
			
			
				
			if(button.getName()=="chan") {
				String name=Manage.nametext.getText();
				boolean man=Manage.Men.isSelected();
				boolean woman=Manage.Women.isSelected();
				boolean allsex=Manage.allsex.isSelected();
				
				String sex;
				String age=Manage.agetext.getText();
				String grade=Manage.gradetext.getText();
				String number=Manage.numbertext.getText();
				
				
				String numberA=Manage.numbeconditiontext.getText();
				if(numberA.equals("")) {
					 JOptionPane.showMessageDialog(null, "������ѧ�Ų���Ϊ��", "ɾ����Ϣ",JOptionPane.WARNING_MESSAGE);
				 }else	if(name.equals("")) {
					JOptionPane.showMessageDialog(null, "��������Ϊ��", "�༭��Ϣ",JOptionPane.WARNING_MESSAGE);
				}else if((man==false&&woman==false)&&allsex==true) {
					Manage.Men.setSelected(true);
					JOptionPane.showMessageDialog(null, "��ȫ������������Ϣ���ܱ�ѡ��", "�༭��Ϣ",JOptionPane.WARNING_MESSAGE);
					
					
				}else if(man==false&&woman==false&&allsex==false) {
					JOptionPane.showMessageDialog(null, "��ѡ���Ա�", "�༭��Ϣ",JOptionPane.WARNING_MESSAGE);
				}else if( age.equals("")) {
					JOptionPane.showMessageDialog(null, "��Ͳ���Ϊ��", "�༭��Ϣ",JOptionPane.WARNING_MESSAGE);
				}else if ( grade.equals("")) {
					JOptionPane.showMessageDialog(null, "�༶����Ϊ��", "�༭��Ϣ",JOptionPane.WARNING_MESSAGE);
				}else if(number.equals("")) {
					JOptionPane.showMessageDialog(null, "ѧ�Ų���Ϊ��", "�༭��Ϣ",JOptionPane.WARNING_MESSAGE);
				}else {
					if(Manage.Men.isSelected()==true) {
						sex=Manage.Men.getText();
					}else {
						sex=Manage.Women.getText();
						
					}
				
					 Mysqld.changeStudeng(name, sex, age , grade, number,numberA);
				}
				
				
			}		
			if(button.getName()=="show") {
				
				String numberA=Manage.numbeconditiontext.getText();//������Ϣ
				
				
				String sex = "";
				String name=Manage.nametext.getText();
				boolean man=Manage.Men.isSelected();
				boolean woman=Manage.Women.isSelected();
				boolean allsex=Manage.allsex.isSelected();
				
				if(!man&&!woman&&!allsex) {
					Manage.allsex.setSelected(true);//ѡ��
				}
				String age=Manage.agetext.getText();
				String grade=Manage.gradetext.getText();
				String number=Manage.numbertext.getText();
				if(Manage.Men.isSelected()==true) {
					sex=Manage.Men.getText();
				}else if(Manage.Women.isSelected()==true){
					sex=Manage.Women.getText();
					
				}
				
			
				
				if(numberA.equals("")) {
	
					 if(name.equals("")&&allsex&&age.equals("")&&grade.equals("")&&number.equals("")) {
						  Mysqld.findAllStudeng();
					
					 }else {
						 //����������Ϣ��
						 if(name.equals("")) {
							 name=".*?";
						 }
						 if(sex.equals("")) {
							 sex=".*?";
						 }
						 if(age.equals("")) {
							 age=".*?";
						 }
						 if(grade.equals("")) {
							 grade=".*?";
						 }
						 if(number.equals("")) {
							 number=".*?";
						 }
						 Mysqld.finConStudent(name,sex,age,grade,number) ;
						 
					 }
					 
						//ResultSet rs=Mysqld.getRs();//��ȡ���н����rs
				} else if(!numberA.equals("")) {
					 Mysqld.findOneStudent(numberA);
					 
					 
				}
					
			}
			if(button.getName()=="reset") {
				Manage.nametext.setText("");
				Manage.allsex.setSelected(true);
				Manage.agetext.setText("");
				Manage.gradetext.setText("");
				Manage.numbertext.setText("");
			
		
				
				
			}
			//_________________________________________________
			
			
			
			
		}catch (ClassCastException e1) {
			
			
			try {
				item=(JMenuItem) e.getSource();
				if(item.getName()=="item1") {
					if(accountA.equals("root")) {
						Mysqld.onlineAccount();
					}else {
						JOptionPane.showMessageDialog(null, "�㲻�ǹ���Ա�˻��޷��鿴", "��Ϣ",JOptionPane.WARNING_MESSAGE);
					}
					
				}
				if(item.getName()=="item2") {
					if(accountA.equals("root")) {
						Mysqld.AllAccount() ;
					}else {
						JOptionPane.showMessageDialog(null, "�㲻�ǹ���Ա�˻��޷��鿴", "��Ϣ",JOptionPane.WARNING_MESSAGE);
					}
					
				}
				if(item.getName()=="item3") {
					if(accountA.equals("root")) {
						ChangeAccountMessage c=new ChangeAccountMessage();
					}else {
						JOptionPane.showMessageDialog(null, "�㲻�ǹ���Ա�˻��޷��鿴", "��Ϣ",JOptionPane.WARNING_MESSAGE);
					}
					
				}
				if(item.getName()=="item4") {
				 aa=new ChangeOwnPassword();
				}
				if(item.getName()=="item1_1") {
					
					Mysqld.setStart(accountA,"0");
					manage.dispose();
				}
				if(item.getName()=="item1_2") {
					Mysqld.setStart(accountA,"0");
					manage.dispose();
					StudentSystem.show();
					//���ǵ�¼����
				}
		
		
					
				

			}catch(Exception e2) {
				
			}
			
		}
	}
	public static void setStart() {
		Mysqld.setStart(accountA,"0");
	}
	void checkStart() {
		RunGetAccountStart run =new RunGetAccountStart();
		
		cheack=new Thread(run);
		cheack.start();
	}
	
	public static void addAble(ResultSet rs) {
		String  data[]=new String [5];
		try {
			while(rs.next()) {
				data[0]=rs.getString(1) ;
				data[1]=rs.getString(2) ;
				data[2]=rs.getString(3) ;
				data[3]=rs.getString(4) ;
				data[4]=rs.getString(5) ;
				Manage.model.addRow(data);
				
			}
			
			
		}catch(SQLException e) {
			
		}
		
	
	}
	public static void addOneAble(ResultSet rs) {
		String  data[]=new String [5];
		try {
				rs.next();
				data[0]=rs.getString(1) ;
				data[1]=rs.getString(2) ;
				data[2]=rs.getString(3) ;
				data[3]=rs.getString(4) ;
				data[4]=rs.getString(5) ;
				
				Manage.nametext.setText(data[0]);
				if(data[1].equals("��")) {
					Manage.Men.setSelected(true);
				}else if(data[1].equals("Ů")) {
					Manage.Women.setSelected(true);
				}
				Manage.agetext.setText(data[2]);
				Manage.gradetext.setText(data[3]);
				Manage.numbertext.setText(data[4]);
			
				Manage.model.addRow(data);
				

			
			
		}catch(SQLException e) {
			
		}
		
		
	}


}
