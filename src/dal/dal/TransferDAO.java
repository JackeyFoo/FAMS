package dal.dal;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import dal.model.Transfer;


public class TransferDAO {
	public boolean insert(Transfer transfer) {

		try {
			updateNewRecord(transfer.getAssetid());
			
			String sql = "insert into Transfer(AssetID, TransferDepartment, TransferDate, TransferHandler,"
					+ "TransferRemark, TransferCertificate, TransferStatus, TransferRecordIsNew) "
					+ "value(?, ?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement statement = SQLDBConnect.getSQLDBConection()
					.prepareStatement(sql);

			statement.setInt(1, transfer.getAssetid());
			statement.setString(2, transfer.getTransferdepartment());
			statement.setString(3, transfer.getTransferdate());
			statement.setString(4, transfer.getTransferhandler());
			statement.setString(5, transfer.getTransferremark());
			statement.setString(6, transfer.getTransfercertificate());
			statement.setString(7, transfer.getTransferstatus());
			statement.setString(8, transfer.getTransferrecordisnew());

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

			String sql = "update Transfer set TransferRecordIsNew='no' " +
					"where TransferRecordIsNew='newest'";
			
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
