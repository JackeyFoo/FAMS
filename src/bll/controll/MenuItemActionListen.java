package bll.controll;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

import dal.dal.DeliverOutDAO;
import dal.dal.MaintainDAO;
import dal.dal.RentOutDAO;
import dal.dal.TransferDAO;
import vl.view.listpage.AllAssetsDeliverOutPage;
import vl.view.listpage.AllAssetsDiscardPage;
import vl.view.listpage.AllAssetsInStoragePage;
import vl.view.listpage.AllAssetsMaintainPage;
import vl.view.listpage.AllAssetsPage;
import vl.view.listpage.AllAssetsRentOutPage;
import vl.view.listpage.AllAssetsTransferPage;
import vl.view.newpage.NewAssetPage;
import vl.view.searchpage.IDSearchPage;


public class MenuItemActionListen implements ActionListener {
	
	private JFrame jframe;
	
	public MenuItemActionListen(JFrame j){
		jframe = j;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("添加资产")){
			
			new NewAssetPage(jframe, null, true);
		}
		
        if(e.getActionCommand().equals("库存管理")){
			
			new AllAssetsInStoragePage(jframe);
		} 
        
        if(e.getActionCommand().equals("出库管理")){
			
        	new AllAssetsDeliverOutPage(jframe, DeliverOutDAO.getAllDeliverOut());
        	
		}
        if(e.getActionCommand().equals("借出管理")){
			
        	new AllAssetsRentOutPage(jframe, RentOutDAO.getAllRentOut());
        	
		} 
        if(e.getActionCommand().equals("转移管理")){
			
        	new AllAssetsTransferPage(jframe, TransferDAO.getAllTransfer());
        	
		} 
        if(e.getActionCommand().equals("维修管理")){
			
			new AllAssetsMaintainPage(jframe,  MaintainDAO.getAllMaintain());
			
		} 
        if(e.getActionCommand().equals("报废管理")){
			
			new AllAssetsDiscardPage(jframe);
		} 
        if(e.getActionCommand().equals("全部资产管理")){
			
			new AllAssetsPage(jframe);

		} 
        
		if(e.getActionCommand().equals("资产ID搜索")){
			
			new IDSearchPage(jframe);
		}

	}

}
