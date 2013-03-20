package bll.controll;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vl.view.NewAssetPage;
import vl.view.NewDeliverOut;

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
	}

}
