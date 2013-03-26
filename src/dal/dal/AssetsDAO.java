package dal.dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;

import dal.model.Assets;

public class AssetsDAO {

	public boolean insert(Assets asset) {

		try {
			String sql = "insert into Assets(AssetType, AssetName, AssetBrand, AssetModel,"
					+ "AssetNo, AssetPurchaseDate, AssetManufacturer, AssetDealer, AssetContract, "
					+ "AssetInDeliverStatus, AssetRunningStatus ) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement statement = SQLDBConnect.getSQLDBConection()
					.prepareStatement(sql);

			statement.setString(1, asset.getAssettype());
			statement.setString(2, asset.getAssetname());
			statement.setString(3, asset.getAssetbrand());
			statement.setString(4, asset.getAssetmodel());
			statement.setInt(5, asset.getAssetno());
			statement.setString(6, asset.getAssetpurchasedate());
			statement.setString(7, asset.getAssetManufacturer());
			statement.setString(8, asset.getAssetdealer());
			statement.setString(9, asset.getAssetcontract());
			statement.setString(10, asset.getAssetindeliverstatus());
			statement.setString(11, asset.getAssetrunningstatus());

			return statement.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public String getID() {
		int id = -1;
		
		try {

			Statement select = SQLDBConnect.getSQLDBConection()
					.createStatement();

			ResultSet result = select
					.executeQuery("SELECT   IDENT_CURRENT('Assets')");

			while (result.next()) { // process results one row at a time
				id = result.getInt(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new DecimalFormat("00000000").format(id);
	}
}
