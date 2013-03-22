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
		if(e.getActionCommand().equals("添加资产")){
			
			new NewAssetPage();
		}
        if(e.getActionCommand().equals("出库管理")){
			
			new NewDeliverOut();
		}
        if(e.getActionCommand().equals("借出管理")){
			
			new NewRentOut();
		} 
        if(e.getActionCommand().equals("转移管理")){
			
        	new NewTransfer();
		} 
        if(e.getActionCommand().equals("维修管理")){
			
			new NewMaintain();
		} 
        if(e.getActionCommand().equals("报废管理")){
			
			new NewDiscard();
		} 
	}

}
