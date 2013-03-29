package bll.controll;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import vl.view.AllAssetsDeliverOutPage;
import vl.view.AllAssetsDiscardPage;
import vl.view.AllAssetsInStoragePage;
import vl.view.AllAssetsMaintainPage;
import vl.view.AllAssetsRentOutPage;
import vl.view.AllAssetsTransferPage;
import vl.view.NewAssetPage;

public class MenuItemActionListen implements ActionListener {
	
	private JFrame jframe;
	
	public MenuItemActionListen(JFrame j){
		jframe = j;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("添加资产")){
			
			new NewAssetPage(jframe);
		}
		
        if(e.getActionCommand().equals("库存管理")){
			
			new AllAssetsInStoragePage(jframe);
		} 
        
        if(e.getActionCommand().equals("出库管理")){
			
        	new AllAssetsDeliverOutPage(jframe);
        	
		}
        if(e.getActionCommand().equals("借出管理")){
			
        	new AllAssetsRentOutPage(jframe);
        	
		} 
        if(e.getActionCommand().equals("转移管理")){
			
        	new AllAssetsTransferPage(jframe);
        	
		} 
        if(e.getActionCommand().equals("维修管理")){
			
			new AllAssetsMaintainPage(jframe);
			
		} 
        if(e.getActionCommand().equals("报废管理")){
			
			new AllAssetsDiscardPage(jframe);
		} 
	}

}
