package dal.dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import dal.model.RentOut;


public class RentOutDAO {

	public static boolean insert(RentOut rentout) {
		
		try {
			updateNewRecord(rentout.getAssetid());
			
			String sql = "insert into RentOut(AssetID, RentDepartment, RentStaff, RentDate,"
				+ "ForeCastReturnDate, RentHandler, RentRemark, RentCertificate, RentRecordIsNew, ReturnDate, "
				+ "ReturnStaff) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement statement = SQLDBConnect.getSQLDBConection()
					.prepareStatement(sql);
			
			statement.setInt(1, rentout.getAssetid());
			statement.setString(2, rentout.getRentdepartment());
			statement.setString(3, rentout.getRentstaff());
			statement.setString(4, rentout.getRentdate());
			statement.setString(5, rentout.getForecastreturndate());
			statement.setString(6, rentout.getRenthandler());
			statement.setString(7, rentout.getRentremark());
			statement.setString(8, rentout.getRentcertificate());
			statement.setString(9, rentout.getRentrecordisnew());
			statement.setString(10, rentout.getReturndate());
			statement.setString(11, rentout.getReturndate());
			
			statement.execute();
			
			AssetsDAO.rentOut(rentout.getAssetid());
			
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	
	public static boolean update(RentOut rentout) {
		
		try {
			
			String sql = "UPDATE RentOut SET RentDepartment=?, RentStaff=?, RentDate=?,"
				+ "ForeCastReturnDate=?, RentHandler=?, RentRemark=?, RentCertificate=?, ReturnDate=?, "
				+ "ReturnStaff=? WHERE RentOutID=?";
			
			PreparedStatement statement = SQLDBConnect.getSQLDBConection()
					.prepareStatement(sql);
			
			
			statement.setString(1, rentout.getRentdepartment());
			statement.setString(2, rentout.getRentstaff());
			statement.setString(3, rentout.getRentdate());
			statement.setString(4, rentout.getForecastreturndate());
			statement.setString(5, rentout.getRenthandler());
			statement.setString(6, rentout.getRentremark());
			statement.setString(7, rentout.getRentcertificate());
			statement.setString(8, rentout.getReturndate());
			statement.setString(9, rentout.getReturndate());
			statement.setInt(10, rentout.getRentoutid());
			
			statement.execute();
			
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	private static boolean updateNewRecord(int assetid) {
		
		try {

			String sql = "update RentOut set RentRecordIsNew='否' "
					+ "where AssetID=? AND RentRecordIsNew='最新'";

			PreparedStatement statement = SQLDBConnect.getSQLDBConection()
					.prepareStatement(sql);

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
					.executeQuery("SELECT IDENT_CURRENT('RentOut')");

			while (result.next()) { // process results one row at a time
				id = result.getInt(1);
			}

			if (id == 1) {
				result = select.executeQuery("SELECT * FROM RentOut");

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
	
	public static RentOut[] getAllRentOut() {

		try {

			RentOut[] rentouts;
			int size = 0;
			int i = 0;

			Statement select = SQLDBConnect.getSQLDBConection()
					.createStatement();

			ResultSet result = select
					.executeQuery("SELECT COUNT(*) FROM RentOut, Assets WHERE Assets.AssetID = RentOut.AssetID and Assets.AssetInDeliverStatus='借出'");

			while (result.next()) {
				size = result.getInt(1);
			}

			rentouts = new RentOut[size];

			result = select
					.executeQuery("SELECT RentOut.* FROM RentOut, Assets WHERE Assets.AssetID = RentOut.AssetID and Assets.AssetInDeliverStatus='借出'");

			while (result.next() && i < size) { // process results one row at a
												// time

				rentouts[i] = new RentOut();

				rentouts[i].setRentoutid(result.getInt(1));
				rentouts[i].setAssetid(result.getInt(2));
				rentouts[i].setRentdepartment(result.getString(3));
				rentouts[i].setRentstaff(result.getString(4));
				rentouts[i].setRentdate(result.getString(5));
				rentouts[i].setForecastreturndate(result.getString(6));
				rentouts[i].setRenthandler(result.getString(7));
				rentouts[i].setRentremark(result.getString(8));
				rentouts[i].setRentcertificate(result.getString(9));
				rentouts[i].setRentrecordisnew(result.getString(10));
				rentouts[i].setReturndate(result.getString(11));
				rentouts[i].setReturnstaff(result.getString(12));

				i++;
			}

			return rentouts;

		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();

			return null;
		}

	}

	
	public static RentOut[] getRentOutHistory(int id) {

		try {

			RentOut[] rentouts;
			int size = 0;
			int i = 0;

			
			String sql = "SELECT COUNT(*) FROM RentOut WHERE AssetID=?";

			PreparedStatement statement = SQLDBConnect.getSQLDBConection()
					.prepareStatement(sql);

			statement.setInt(1, id);

			ResultSet result = statement.executeQuery();

			while (result.next()) {
				size = result.getInt(1);
			}

			rentouts = new RentOut[size];

			sql = "SELECT * FROM RentOut WHERE AssetID=?";
			
			statement = SQLDBConnect.getSQLDBConection()
					.prepareStatement(sql);
			
			statement.setInt(1, id);
			
			result = statement.executeQuery();

			while (result.next() && i < size) { // process results one row at a
												// time

				rentouts[i] = new RentOut();

				rentouts[i].setRentoutid(result.getInt(1));
				rentouts[i].setAssetid(result.getInt(2));
				rentouts[i].setRentdepartment(result.getString(3));
				rentouts[i].setRentstaff(result.getString(4));
				rentouts[i].setRentdate(result.getString(5));
				rentouts[i].setForecastreturndate(result.getString(6));
				rentouts[i].setRenthandler(result.getString(7));
				rentouts[i].setRentremark(result.getString(8));
				rentouts[i].setRentcertificate(result.getString(9));
				rentouts[i].setRentrecordisnew(result.getString(10));
				rentouts[i].setReturndate(result.getString(11));
				rentouts[i].setReturnstaff(result.getString(12));

				i++;
			}

			return rentouts;

		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();

			return null;
		}

	}
}
