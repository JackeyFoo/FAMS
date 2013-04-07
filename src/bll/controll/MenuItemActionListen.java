package bll.controll;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import vl.view.AllAssetsDeliverOutPage;
import vl.view.AllAssetsDiscardPage;
import vl.view.AllAssetsInStoragePage;
import vl.view.AllAssetsMaintainPage;
import vl.view.AllAssetsPage;
import vl.view.AllAssetsRentOutPage;
import vl.view.AllAssetsTransferPage;
import vl.view.NewAssetPage;
import vl.view.NewSearchPage;


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
			
			new AllAssetsInStoragePage(jframe);
		} 
        
        if(e.getActionCommand().equals("�������")){
			
        	new AllAssetsDeliverOutPage(jframe);
        	
		}
        if(e.getActionCommand().equals("�������")){
			
        	new AllAssetsRentOutPage(jframe);
        	
		} 
        if(e.getActionCommand().equals("ת�ƹ���")){
			
        	new AllAssetsTransferPage(jframe);
        	
		} 
        if(e.getActionCommand().equals("ά�޹���")){
			
			new AllAssetsMaintainPage(jframe);
			
		} 
        if(e.getActionCommand().equals("���Ϲ���")){
			
			new AllAssetsDiscardPage(jframe);
		} 
        if(e.getActionCommand().equals("ȫ���ʲ�����")){
			
			new AllAssetsPage(jframe);

		} 
        
		if(e.getActionCommand().equals("�ʲ�ID����")){
			
			new NewSearchPage(jframe);
		}

	}

}
