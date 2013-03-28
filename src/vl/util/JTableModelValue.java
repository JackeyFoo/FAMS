package vl.util;

import javax.swing.table.AbstractTableModel;

import dal.interfaces.ModelObject;

public class JTableModelValue extends AbstractTableModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ModelObject[] mo;
	String[] col;
	
	public JTableModelValue(ModelObject[] o, String[] c){
		mo = o;
		col = c;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return col.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return mo.length;
	}

	@Override
	public Object getValueAt(int i, int j) {
		// TODO Auto-generated method stub
		return mo[i].getValue(j);
	}

	 public String getColumnName(int i){  
         return col[i];  
}
}
