package bll.controll;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

import vl.view.AllAssetsPage;
import vl.view.NewAssetPage;
import vl.view.NewDeliverOut;
import vl.view.NewDiscard;
import vl.view.NewMaintain;
import vl.view.NewRentOut;
import vl.view.NewTransfer;

public class MenuItemActionListen implements ActionListener {
	
	private JFrame jframe;
	
	public MenuItemActionListen(JFrame j){
		jframe = j;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("����ʲ�")){
			
			new NewAssetPage(jframe);
		}
		
        if(e.getActionCommand().equals("������")){
			
			new AllAssetsPage(jframe);
		} 
        
        if(e.getActionCommand().equals("�������")){
			
			new NewDeliverOut(jframe);
        	
		}
        if(e.getActionCommand().equals("�������")){
			
			new NewRentOut(jframe);
		} 
        if(e.getActionCommand().equals("ת�ƹ���")){
			
        	new NewTransfer(jframe);
		} 
        if(e.getActionCommand().equals("ά�޹���")){
			
			new NewMaintain(jframe);
		} 
        if(e.getActionCommand().equals("���Ϲ���")){
			
			new NewDiscard(jframe);
		} 
	}

}
