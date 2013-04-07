package vl.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.StringTokenizer;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import vl.interfaces.MyDialog;
import dal.model.Assets;

public class NewAssetDetailPage extends MyDialog {
	
	private JLabel assetid;
	private JTextField assettype;
	private JTextField assetname;
	private JTextField assetbrand;
	private JTextField assetmodel;
	private JTextField assetno;
	private JTextField assetpurchasedate;
	private JTextField assetmanufacturer;
	private JTextField assetdealer;
	private JLabel assetindeliverstatus;
	private JLabel assetrunningstatus;
    private Assets asset;
	private static File filesshow[];
	
	
	private static final long serialVersionUID = 1L;

	private JPanel contentpanel;
	private JPanel controlpanel;
	
	 public NewAssetDetailPage(JFrame jf, Assets a){
			super(jf, "资产详细", false);
			asset = a ;
			this.jframe = jf;
			setResizable(false);
			setSize(800, 500);
			setLocation(200, 150);
			setVisible(true);
			setLayout(new BorderLayout());
			initDialog();

			setVisible(true);
			
	 }
       
	 public void initDialog(){
			contentpanel = new JPanel(); 
			contentpanel.setBorder(BorderFactory.createTitledBorder("资产信息"));
			
			add(contentpanel, BorderLayout.CENTER);
			
			controlpanel = new JPanel();
			
			add(controlpanel, BorderLayout.PAGE_END);

			initContentPanel();
			initControlPanel();
	 }
		
		
		public  void initControlPanel(){
			 JButton sure = new JButton ("确定");
			 controlpanel.add(sure);
				sure.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						NewAssetDetailPage.this.dispose();
					}
					
				});
		}
		
		
		public  void initContentPanel(){
			contentpanel.setLayout(new BoxLayout(contentpanel, BoxLayout.X_AXIS));

			JPanel leftpanel = new JPanel();
			leftpanel.setLayout(new BoxLayout(leftpanel, BoxLayout.Y_AXIS));

			JPanel rightpanel = new JPanel();
			rightpanel.setBorder(BorderFactory.createTitledBorder("合同"));
			rightpanel.setLayout(new BorderLayout());

			contentpanel.add(leftpanel);
			contentpanel.add(rightpanel);

			/**************** 资产ID: *************/
			JPanel leftpanel01 = new JPanel();
			leftpanel.setAlignmentX(Component.LEFT_ALIGNMENT);
			leftpanel.add(leftpanel01);

			JLabel idlabel = new JLabel("资产ID  ");
			assetid = new JLabel(String.valueOf(asset.getAssetid()));
            //System.out.println(asset.getAssetid());
            
            //get.id 返回值为int Integer.toString(asset.getAssetid())
            
            
			leftpanel01.add(idlabel);
			leftpanel01.add(assetid);

			/*************** 资产类型 **************/
			JPanel leftpanel02 = new JPanel();
			leftpanel.add(leftpanel02);

			JLabel typelabel = new JLabel("资产类型(必填):  ");
			assettype = new JTextField();
			assettype.setColumns(30);
            assettype.setText(asset.getAssettype());
			assettype.setEditable(false);
			
			leftpanel02.add(typelabel);
			leftpanel02.add(assettype);

			/************** 资产名称 ***************/
			JPanel leftpanel03 = new JPanel();
			leftpanel.add(leftpanel03);

			JLabel namelabel = new JLabel("资产名称(必填):  ");
			assetname = new JTextField();
			assetname.setColumns(30);
            assetname.setText(asset.getAssetname());
            assetname.setEditable(false);
            
			leftpanel03.add(namelabel);
			leftpanel03.add(assetname);

			/**************** 资产品牌 *************/
			JPanel leftpanel04 = new JPanel();
			leftpanel.add(leftpanel04);

			JLabel brandlabel = new JLabel("资产品牌(必填):  ");
			assetbrand = new JTextField();
			assetbrand.setColumns(30);
            assetbrand.setText(asset.getAssetbrand());
            assetbrand.setEditable(false);
            
			leftpanel04.add(brandlabel);
			leftpanel04.add(assetbrand);

			/**************** 资产型号 *************/
			JPanel leftpanel05 = new JPanel();
			leftpanel.add(leftpanel05);

			JLabel modellabel = new JLabel("资产型号(必填):  ");
			assetmodel = new JTextField();
			assetmodel.setColumns(30);
            assetmodel.setText(asset.getAssetmodel());
            assetmodel.setEditable(false);
            
			leftpanel05.add(modellabel);
			leftpanel05.add(assetmodel);

			/************** 资产机号 ***************/
			JPanel leftpanel06 = new JPanel();
			leftpanel.add(leftpanel06);

			JLabel nolabel = new JLabel("资产机号(必填):  ");
			assetno = new JTextField();
			assetno.setColumns(30);
            assetno.setText(Integer.toString(asset.getAssetno()));
            assetno.setEditable(false);
            
			leftpanel06.add(nolabel);
			leftpanel06.add(assetno);

			/************** 购入日期 ***************/
			JPanel leftpanel07 = new JPanel();
			leftpanel.add(leftpanel07);

			JLabel datelabel = new JLabel("购入日期(必填):  ");
			assetpurchasedate = new JTextField();
			assetpurchasedate.setColumns(30);
			assetpurchasedate.setText(asset.getAssetpurchasedate());
			assetpurchasedate.setEditable(false);
			
			leftpanel07.add(datelabel);
			leftpanel07.add(assetpurchasedate);

			/************** 资产生产商 ***************/
			JPanel leftpanel08 = new JPanel();
			leftpanel.add(leftpanel08);

			JLabel manufacturerlabel = new JLabel("资产生产商(必填):  ");
			assetmanufacturer = new JTextField();
			assetmanufacturer.setColumns(30);
			assetmanufacturer.setText(asset.getAssetManufacturer());
			assetmanufacturer.setEditable(false);
			
			leftpanel08.add(manufacturerlabel);
			leftpanel08.add(assetmanufacturer);

			/************** 资产经销商 ***************/
			JPanel leftpanel09 = new JPanel();
			leftpanel.add(leftpanel09);

			JLabel dealerlabel = new JLabel("资产经销商(必填):  ");
			assetdealer = new JTextField();
			assetdealer.setColumns(30);
			assetdealer.setText(asset.getAssetdealer());
			assetdealer.setEditable(false);
			
			leftpanel09.add(dealerlabel);
			leftpanel09.add(assetdealer);

			/************** 资产位置状态 ***************/
			JPanel leftpanel11 = new JPanel();
			leftpanel.add(leftpanel11);

			JLabel instatuslabel = new JLabel("资产位置状态:  ");
			assetindeliverstatus = new JLabel(asset.getAssetindeliverstatus());
			
			
			leftpanel11.add(instatuslabel);
			leftpanel11.add(assetindeliverstatus);

			/************** 资产运行状况 ***************/
			JPanel leftpanel12 = new JPanel();
			leftpanel.add(leftpanel12);

			JLabel runningstatuslabel = new JLabel("资产运行状况:  ");
			assetrunningstatus = new JLabel(asset.getAssetrunningstatus());
			
			
			leftpanel12.add(runningstatuslabel);
			leftpanel12.add(assetrunningstatus);

			
			//凭证图片
			
			rightpanel01 = new JPanel();
			filesAnalytical(asset.getAssetcontract(),";");
			addImageToPanel(filesAnalytical(asset.getAssetcontract(),"<"));
			
			
			JScrollPane rightscroll = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
					JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			
			rightpanel01.setLayout(new BoxLayout(rightpanel01, BoxLayout.PAGE_AXIS));
			rightpanel.add(rightscroll, BorderLayout.CENTER);

			rightscroll.setViewportView(rightpanel01);
			
			
		}
		
		
		public static File [] filesAnalytical(String string, String divisionChar){
			 
	        int i = 0;  
	      
	        StringTokenizer tokenizer = new StringTokenizer(string, divisionChar); 
	        String[] str = new String[tokenizer.countTokens()];  
	          filesshow = new File [tokenizer.countTokens()];
	        while (tokenizer.hasMoreTokens())  
	        {  
	           str[i] = new String();  
	            str[i] = tokenizer.nextToken();  
	            filesshow [i]= new File (str[i]);
	            i++;  
	        }  
			return filesshow;
		}
		
		
		

		public  void packData(){}
		
		public boolean isFull(){return  false;}
		
		public void setImagePath(String txt){}

		@Override
		public void isEditable(boolean editable) {
			// TODO Auto-generated method stub
			
		}
	 
}
