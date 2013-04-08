package vl.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import vl.interfaces.MyTable;
import dal.dal.AssetsDAO;
import dal.interfaces.ModelObject;
import dal.model.Assets;

public class AllAssetsPage  extends MyTable{

	public AllAssetsPage(JFrame j) {
		
		col = new String[] { "资产ID", "资产类型", "资产名称", "资产品牌",
				"资产型号", "资产机号", "资产购入日期", "资产生产商", "资产经销商", "资产库存状态", "资产运行状态" };
		
		this.jframe = j;

		Container pane = jframe.getContentPane();

		pane.setLayout(new BorderLayout());

		mo = (ModelObject[]) AssetsDAO.getAll();

		initJTable(pane);

		jframe.validate();
	}

	public AllAssetsPage(JFrame j,int id) {
		
		col = new String[] { "资产ID", "资产类型", "资产名称", "资产品牌",
				"资产型号", "资产机号", "资产购入日期", "资产生产商", "资产经销商", "资产库存状态", "资产运行状态" };
		
		this.jframe = j;

		Container pane = jframe.getContentPane();

		pane.setLayout(new BorderLayout());

		mo = (ModelObject[]) new Assets []{AssetsDAO.getAsset( id)};

		initJTable(pane);

		jframe.validate();
	}


	public void initPopMenu(JPopupMenu popupmenu, final ModelObject o) {

		JMenuItem asset = new JMenuItem("资产 " + o.getFormatID() + " 编辑");
		
		final Assets assets = AssetsDAO.getAsset(o.getAssetid());

		popupmenu.add(asset);
		
		asset.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			 new NewAssetPage( jframe, assets ,true);
				
			}
			
		});

	}
}
