package bll.controll;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vl.view.NewAssetPage;
import vl.view.NewDeliverOut;
import vl.view.NewDiscard;
import vl.view.NewMaintain;
import vl.view.NewRentOut;
import vl.view.NewTransfer;

public class MenuItemActionListen implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("����ʲ�")){
			
			new NewAssetPage();
		}
        if(e.getActionCommand().equals("�������")){
			
			new NewDeliverOut();
		}
        if(e.getActionCommand().equals("�������")){
			
			new NewRentOut();
		} 
        if(e.getActionCommand().equals("ת�ƹ���")){
			
        	new NewTransfer();
		} 
        if(e.getActionCommand().equals("ά�޹���")){
			
			new NewMaintain();
		} 
        if(e.getActionCommand().equals("���Ϲ���")){
			
			new NewDiscard();
		} 
	}

}
