package dal.interfaces;

import java.io.Serializable;

public interface ModelObject extends Serializable{
	
	public String getFormatID();
	
	public String getValue(int i);
	
	public String getFormatAssetid();
	
	public int getAssetid();

}
