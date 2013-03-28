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
		if(e.getActionCommand().equals("添加资产")){
			
			new NewAssetPage(jframe);
		}
		
        if(e.getActionCommand().equals("库存管理")){
			
			new AllAssetsPage(jframe);
		} 
        
        if(e.getActionCommand().equals("出库管理")){
			
			new NewDeliverOut(jframe);
        	
		}
        if(e.getActionCommand().equals("借出管理")){
			
			new NewRentOut(jframe);
		} 
        if(e.getActionCommand().equals("转移管理")){
			
        	new NewTransfer(jframe);
		} 
        if(e.getActionCommand().equals("维修管理")){
			
			new NewMaintain(jframe);
		} 
        if(e.getActionCommand().equals("报废管理")){
			
			new NewDiscard(jframe);
		} 
	}

}
