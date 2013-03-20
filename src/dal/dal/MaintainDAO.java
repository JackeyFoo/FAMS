package dal.dal;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import dal.model.Maintain;

public class MaintainDAO {
	public boolean insert(Maintain maintain) {

		try {
			updateNewRecord(maintain.getAssetid());
			
			String sql = "insert into Transfer(AssetID, MaintainDepartment, DownDate, MaintainHandler,"
					+ "DownRemark, DownPhenomenon, MaintainProcess, DeviceStatus, MaintainCost, MaintainRecordIsNew) "
					+ "value(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement statement = SQLDBConnect.getSQLDBConection()
					.prepareStatement(sql);

			statement.setInt(1, maintain.getAssetid());
			statement.setString(2, maintain.getMaintaindepartment());
			statement.setString(3, maintain.getDowndate());
			statement.setString(4, maintain.getMaintanhandler());
			statement.setString(5, maintain.getDownremark());
			statement.setString(6, maintain.getDownphenomenon());
			statement.setString(7, maintain.getMaintainprocess());
			statement.setString(8, maintain.getDevicestatus());
			statement.setInt(9, maintain.getMaintaincost());
			statement.setString(10, maintain.getMaintainrecordisnew());

			return statement.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	private boolean updateNewRecord(int assetid) {
		
		PreparedStatement statement;
		try {

			String sql = "update Maintain set MaintainRecordIsNew='no' " +
					"where MaintainRecordIsNew='newest'";
			
			statement = SQLDBConnect.getSQLDBConection()
					.prepareStatement(sql);
			
			return statement.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return false;
		}
	}
}
