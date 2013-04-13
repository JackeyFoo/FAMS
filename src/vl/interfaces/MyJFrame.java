package vl.interfaces;

import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import vl.component.Jmenubar;
import vl.view.terminalpage.TerminalPage;

public class MyJFrame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected JTable mytable;
	protected Jmenubar menubar;
	protected JSplitPane splitpane;	
	protected TerminalPage terminalpane;
	
	public void setTable(JTable table){
		this.mytable = table;
	}
	
	public JTable getTable(){
		return mytable;
	}
	
	public void setMainPane(Component comp){
		
		if(splitpane != null){
			
			splitpane.setLeftComponent(null);
			splitpane.setLeftComponent(comp);
		}
	}
	
	public void setTerminalPane(){
		
		if(splitpane != null && terminalpane != null){
					
			splitpane.setRightComponent(null);
			splitpane.setRightComponent(terminalpane);
		}
	}
	
	public void removeTerminalPane(){
		
		if(splitpane != null){
					
			splitpane.setRightComponent(null);

		}
	}

}
