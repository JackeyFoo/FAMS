package dal.dal;


import java.sql.PreparedStatement;
import java.sql.SQLException;

import dal.model.Assets;


public class AssetsDAO {

	public boolean insert(Assets asset) {
		
		try {
			String sql = "insert into Assets(AssetType, AssetName, AssetBrand, AssetModel,"
				+ "AssetNo, AssetPurchaseDate, AssetManufacturer, AssetDealer, AssetContract, "
				+ "AssetInDeliverStatus, AssetRunningStatus ) value(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
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
}
