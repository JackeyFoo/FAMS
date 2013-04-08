package bll.controll;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

import dal.dal.DeliverOutDAO;
import dal.dal.MaintainDAO;
import dal.dal.RentOutDAO;
import dal.dal.TransferDAO;
import vl.view.AllAssetsDeliverOutPage;
import vl.view.AllAssetsDiscardPage;
import vl.view.AllAssetsInStoragePage;
import vl.view.AllAssetsMaintainPage;
import vl.view.AllAssetsPage;
import vl.view.AllAssetsRentOutPage;
import vl.view.AllAssetsTransferPage;
import vl.view.NewAssetPage;
import vl.view.IDSearchPage;


public class MenuItemActionListen implements ActionListener {
	
	private JFrame jframe;
	
	public MenuItemActionListen(JFrame j){
		jframe = j;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("����ʲ�")){
			
			new NewAssetPage(jframe, null, true);
		}
		
        if(e.getActionCommand().equals("������")){
			
			new AllAssetsInStoragePage(jframe);
		} 
        
        if(e.getActionCommand().equals("�������")){
			
        	new AllAssetsDeliverOutPage(jframe, DeliverOutDAO.getAllDeliverOut());
        	
		}
        if(e.getActionCommand().equals("�������")){
			
        	new AllAssetsRentOutPage(jframe, RentOutDAO.getAllRentOut());
        	
		} 
        if(e.getActionCommand().equals("ת�ƹ���")){
			
        	new AllAssetsTransferPage(jframe, TransferDAO.getAllTransfer());
        	
		} 
        if(e.getActionCommand().equals("ά�޹���")){
			
			new AllAssetsMaintainPage(jframe,  MaintainDAO.getAllMaintain());
			
		} 
        if(e.getActionCommand().equals("���Ϲ���")){
			
			new AllAssetsDiscardPage(jframe);
		} 
        if(e.getActionCommand().equals("ȫ���ʲ�����")){
			
			new AllAssetsPage(jframe);

		} 
        
		if(e.getActionCommand().equals("�ʲ�ID����")){
			
			new IDSearchPage(jframe);
		}

	}

}
