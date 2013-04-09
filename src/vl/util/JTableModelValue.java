package vl.util;

import javax.swing.table.AbstractTableModel;
import dal.interfaces.ModelObject;

public class JTableModelValue extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ModelObject[] mo;
	String[] col;

	public JTableModelValue(ModelObject[] o, String[] c) {
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
		if (mo != null) {
			return mo.length;
		} else {
			return 0;
		}
	}

	@Override
	public Object getValueAt(int i, int j) {
		// TODO Auto-generated method stub
		if (mo[i] != null) {
			return mo[i].getValue(j);
		} else {
			return null;
		}
	}

	public String getColumnName(int i) {
		return col[i];
	}
}
