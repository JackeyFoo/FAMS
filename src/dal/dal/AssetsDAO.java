package dal.dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;


import dal.model.Assets;

public class AssetsDAO {

	public static boolean insert(Assets asset) {

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

	public static String getID() {
		int id = -1;
		
		try {

			Statement select = SQLDBConnect.getSQLDBConection()
					.createStatement();

			ResultSet result = select
					.executeQuery("SELECT IDENT_CURRENT('Assets')");

			while (result.next()) { // process results one row at a time
				id = result.getInt(1);
			}
			
			if(id == 1){
				result = select
						.executeQuery("SELECT * FROM Assets");
				
				if(!result.next()) {
					id = 0;
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new DecimalFormat("00000000").format(id + 1);
	}
	
	public static Assets[] getAll(){
		
		try {
			
			Assets[] assets;
			int size = 0;
			int i = 0;
			
			Statement select = SQLDBConnect.getSQLDBConection()
					.createStatement();
			
			ResultSet result = select
					.executeQuery("SELECT COUNT(*) FROM Assets");
			
			while (result.next()) {
				size = result.getInt(1);
			}

			assets = new Assets[size];
					
			result = select
					.executeQuery("SELECT * FROM Assets");

			while (result.next() && i < size) { // process results one row at a time
				
				assets[i] = new Assets();
				
				assets[i].setAssetid(result.getInt(1) + "");
				assets[i].setAssettype(result.getString(2));
				assets[i].setAssetname(result.getString(3));
				assets[i].setAssetbrand(result.getString(4));
				assets[i].setAssetmodel(result.getString(5));
				assets[i].setAssetno(result.getInt(6));
				assets[i].setAssetpurchasedate(result.getString(7));
				assets[i].setAssetManufacturer(result.getString(8));
				assets[i].setAssetdealer(result.getString(9));
				assets[i].setAssetcontract(result.getString(10));
				assets[i].setAssetindeliverstatus(result.getString(11));
				assets[i].setAssetrunningstatus(result.getString(12));
				
				i++;
			}
			
			return assets;
			

		} catch (SQLException e) {
			
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return null;
		}
		
	}
}
