package com.window;
import com.mysqld.Mysqld;

public class StudentSystem {
	public static LoginStart loginstartA;

	public static void main(String[] args) {
		
		show();
		
	}
	static public  void show() {
		LoginStart loginstart=new LoginStart();//��ʼ�����췽��
		loginstartA=loginstart;
		Mysqld a=new Mysqld("root","root");//���ݿ��˺� ������
		//Manage aa=new Manage();
	}

}
