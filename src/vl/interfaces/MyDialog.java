package vl.interfaces;

import java.io.File;

public interface MyDialog{
	
	public void initDialog();
	
	public void initControlPanel();
	
	public void initContentPanel();
	
	public void packData();
	
	public boolean isFull();
	
	public void setImagePath(String txt);
	
	public void addImageToPanel(File[] files);
	
	public void removeImgae();
	
}
