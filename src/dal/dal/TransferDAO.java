package dal.dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import dal.model.Transfer;

public class TransferDAO {

	public static boolean insert(Transfer transfer) {

		try {
			updateNewRecord(transfer.getAssetid());

			String sql = "insert into Transfer(AssetID, TransferDepartment, TransferDate, TransferHandler,"
					+ "TransferRemark, TransferCertificate, TransferStatus, TransferRecordIsNew) "
					+ "values(?, ?, ?, ?, ?, ?, ?, ?)";

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

			statement.execute();

			AssetsDAO.transfer(transfer.getAssetid());

			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public static boolean update(Transfer transfer) {

		try {

			String sql = "UPDATE Transfer SET TransferDepartment=?, TransferDate=?, TransferHandler=?,"
					+ "TransferRemark=?, TransferCertificate=?, TransferStatus=? WHERE TransferID=?";

			PreparedStatement statement = SQLDBConnect.getSQLDBConection()
					.prepareStatement(sql);

			statement.setString(1, transfer.getTransferdepartment());
			statement.setString(2, transfer.getTransferdate());
			statement.setString(3, transfer.getTransferhandler());
			statement.setString(4, transfer.getTransferremark());
			statement.setString(5, transfer.getTransfercertificate());
			statement.setString(6, transfer.getTransferstatus());
			statement.setInt(7, transfer.getTransferid());

			statement.execute();

			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	private static boolean updateNewRecord(int assetid) {

		PreparedStatement statement;
		try {

			String sql = "update Transfer set TransferRecordIsNew='否' "
					+ "where AssetID=? AND TransferRecordIsNew='最新'";

			statement = SQLDBConnect.getSQLDBConection().prepareStatement(sql);

			statement.setInt(1, assetid);

			statement.execute();

			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return false;
		}
	}

	public static int getID() {
		int id = -1;

		try {

			Statement select = SQLDBConnect.getSQLDBConection()
					.createStatement();

			ResultSet result = select
					.executeQuery("SELECT IDENT_CURRENT('Transfer')");

			while (result.next()) { // process results one row at a time
				id = result.getInt(1);
			}

			if (id == 1) {
				result = select.executeQuery("SELECT * FROM Transfer");

				if (!result.next()) {
					id = 0;
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return id + 1;
	}

	public static Transfer[] getAllTransfer() {

		try {

			Transfer[] transfers;
			int size = 0;
			int i = 0;

			Statement select = SQLDBConnect.getSQLDBConection()
					.createStatement();

			ResultSet result = select
					.executeQuery("SELECT COUNT(*) FROM Transfer, Assets WHERE Assets.AssetID = Transfer.AssetID and Assets.AssetInDeliverStatus='转移' AND Assets.AssetRunningStatus='正常'");

			while (result.next()) {
				size = result.getInt(1);
			}

			transfers = new Transfer[size];

			result = select
					.executeQuery("SELECT Transfer.* FROM Transfer, Assets WHERE Assets.AssetID = Transfer.AssetID and Assets.AssetInDeliverStatus='转移' AND Assets.AssetRunningStatus='正常'");

			while (result.next() && i < size) { // process results one row at a
												// time

				transfers[i] = new Transfer();

				transfers[i].setTransferid((result.getInt(1)));
				transfers[i].setAssetid(result.getInt(2));
				transfers[i].setTransferdepartment(result.getString(3));
				transfers[i].setTransferdate(result.getString(4));
				transfers[i].setTransferhandler(result.getString(5));
				transfers[i].setTransferremark(result.getString(6));
				transfers[i].setTransfercertificate(result.getString(7));
				transfers[i].setTransferstatus(result.getString(8));
				transfers[i].setTransferrecordisnew(result.getString(9));

				i++;
			}

			return transfers;

		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();

			return null;
		}

	}
	
	public static Transfer[] getTransferHistory(int id) {

		try {

			Transfer[] transfers;
			int size = 0;
			int i = 0;
			
			String sql = "SELECT COUNT(*) FROM Transfer WHERE AssetID=?";

			PreparedStatement statement = SQLDBConnect.getSQLDBConection()
					.prepareStatement(sql);

			statement.setInt(1, id);

			ResultSet result = statement.executeQuery();

			while (result.next()) {
				size = result.getInt(1);
			}

			transfers = new Transfer[size];

			sql = "SELECT * FROM Transfer WHERE AssetID=?";
			
			statement = SQLDBConnect.getSQLDBConection()
					.prepareStatement(sql);
			
			statement.setInt(1, id);
			
			result = statement.executeQuery();

			while (result.next() && i < size) { // process results one row at a
												// time

				transfers[i] = new Transfer();

				transfers[i].setTransferid((result.getInt(1)));
				transfers[i].setAssetid(result.getInt(2));
				transfers[i].setTransferdepartment(result.getString(3));
				transfers[i].setTransferdate(result.getString(4));
				transfers[i].setTransferhandler(result.getString(5));
				transfers[i].setTransferremark(result.getString(6));
				transfers[i].setTransfercertificate(result.getString(7));
				transfers[i].setTransferstatus(result.getString(8));
				transfers[i].setTransferrecordisnew(result.getString(9));

				i++;
			}

			return transfers;

		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();

			return null;
		}

	}
}
