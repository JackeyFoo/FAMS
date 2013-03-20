package dal.dal;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import dal.model.RentOut;


public class RentOutDAO {

	public boolean insert(RentOut rentout) {
		
		try {
			updateNewRecord(rentout.getAssetid());
			
			String sql = "insert into RentOut(AssetID, RentDepartment, RentStaff, RentDate,"
				+ "ForeCastReturnDate, RentHandler, RentRemark, RentRecordIsNew, ReturnDate, "
				+ "ReturnStaff) value(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement statement = SQLDBConnect.getSQLDBConection()
					.prepareStatement(sql);
			
			statement.setInt(1, rentout.getAssetid());
			statement.setString(2, rentout.getRentdepartment());
			statement.setString(3, rentout.getRentstaff());
			statement.setString(4, rentout.getRentdate());
			statement.setString(5, rentout.getForecastreturndate());
			statement.setString(6, rentout.getRenthandler());
			statement.setString(7, rentout.getRentremark());
			statement.setString(8, rentout.getRentrecordisnew());
			statement.setString(9, rentout.getReturndate());
			statement.setString(10, rentout.getReturndate());
			
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

			String sql = "update RentOut set RentRecordIsNew='no' " +
					"where RentRecordIsNew='newest'";
			
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
