package dal.dal;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import dal.model.DeliverOut;


public class DeliverOutDAO {
	public boolean insert(DeliverOut deliverout) {

		try {
			
			updateNewRecord(deliverout.getAssetid());
			
			String sql = "insert into DeliverOut(AssetID, DeliverDepartment, DeliverStaff, DeliverDate,"
					+ "DeliverAddress, DeliverRemark, DeliverCertificate, DeliverRecordIsNew, ReturnDate, "
					+ "ReturnStaff) value(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement statement = SQLDBConnect.getSQLDBConection()
					.prepareStatement(sql);

			statement.setInt(1, deliverout.getAssetid());
			statement.setString(2, deliverout.getDeliverdepartment());
			statement.setString(3, deliverout.getDeliverstaff());
			statement.setString(4, deliverout.getDeliverdate());
			statement.setString(5, deliverout.getDeliveraddress());
			statement.setString(6, deliverout.getDeliverremark());
			statement.setString(7, deliverout.getDelivercertificate());
			statement.setString(8, deliverout.getDeliverrecordisnew());
			statement.setString(9, deliverout.getReturndate());
			statement.setString(10, deliverout.getReturnstaff());

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

			String sql = "update DeliverOut set DeliverRecordIsNew='no' " +
					"where DeliverRecordIsNew='newest'";
			
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
