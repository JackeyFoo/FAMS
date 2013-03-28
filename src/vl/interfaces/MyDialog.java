package vl.interfaces;

import java.awt.Dimension;
import java.io.File;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import dal.model.Assets;

import vl.component.ImagePanel;

public abstract class MyDialog extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JPanel  rightpanel01;
	protected File[] files;
	protected JFrame jframe;
	protected Assets asset;
	
	public MyDialog(JFrame jframe, String str, boolean b){
		super(jframe, str, b);
	}
	
	public abstract void initDialog();
	
	public abstract void initControlPanel();
	
	public abstract void initContentPanel();
	
	public abstract void packData();
	
	public abstract boolean isFull();
	
	public abstract void setImagePath(String txt);
	
	public void addImageToPanel(File[] f){
		
		this.files = f;
		
		int h = files.length;
		
		int height = 0;
		
		rightpanel01.setPreferredSize(new Dimension(300, height));
		
		for(int i = 0; i < h; i++){
			
			ImagePanel imgpanel = new ImagePanel(files[i].getAbsolutePath());
			
			height += (int)imgpanel.getheight();
			
			rightpanel01.setPreferredSize(new Dimension(300, height));
			
			rightpanel01.add(imgpanel);
		}
		
		rightpanel01.updateUI();
	}
	
	public void removeImgae() {
		// TODO Auto-generated method stub
		rightpanel01.removeAll();
		
	}
	
}
