package com.event;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.window.Register;

public class RegEvent implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		//�����������µ�ʱ��Żᴥ���¼�
		if(e.getButton()==MouseEvent.BUTTON1) {
			Register register =new Register();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	



}
