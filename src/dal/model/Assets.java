package dal.model;

import java.text.DecimalFormat;

import dal.dal.AssetsDAO;
import dal.interfaces.ModelObject;

public class Assets implements ModelObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	/**
	 * 
	 */
	
	private int assetid = 0;
	private String assettype = null;
	private String assetname = null;
	private String assetbrand = null;
	private String assetmodel = null;
	private int assetno = 1;
	private String assetpurchasedate = null;
	private String assetManufacturer = null;
	private String assetdealer = null;
	private String assetcontract = null;
	private String assetindeliverstatus = "����";
	private String assetrunningstatus = "����";

	public Assets() {

	}

	public Assets(String assettype, String assetname, String assetbrand,
			String assetmodel, int assetno, String assetpurchasedate,
			String assetManufacturer, String assetdealer, String assetcontract,
			String assetindeliverstatus, String assetrunningstatus) {

		this.assettype = assettype;
		this.assetname = assetname;
		this.assetbrand = assetbrand;
		this.assetmodel = assetmodel;
		this.assetno = assetno;
		this.assetpurchasedate = assetpurchasedate;
		this.assetManufacturer = assetManufacturer;
		this.assetdealer = assetdealer;
		this.assetcontract = assetcontract;
		this.assetindeliverstatus = assetindeliverstatus;
		this.assetrunningstatus = assetrunningstatus;
	}

	public int getAssetid() {
		return assetid;
	}

	public void setAssetid(int assetid) {
		this.assetid = assetid;
	}

	public String getAssettype() {
		return assettype;
	}

	public void setAssettype(String assettype) {
		this.assettype = assettype;
	}

	public String getAssetname() {
		return assetname;
	}

	public void setAssetname(String assetname) {
		this.assetname = assetname;
	}

	public String getAssetbrand() {
		return assetbrand;
	}

	public void setAssetbrand(String assetbrand) {
		this.assetbrand = assetbrand;
	}

	public String getAssetmodel() {
		return assetmodel;
	}

	public void setAssetmodel(String assetmodel) {
		this.assetmodel = assetmodel;
	}

	public int getAssetno() {
		return assetno;
	}

	public void setAssetno(int assetno) {
		this.assetno = assetno;
	}

	public String getAssetpurchasedate() {
		return assetpurchasedate;
	}

	public void setAssetpurchasedate(String assetpurchasedate) {
		this.assetpurchasedate = assetpurchasedate;
	}

	public String getAssetManufacturer() {
		return assetManufacturer;
	}

	public void setAssetManufacturer(String assetManufacturer) {
		this.assetManufacturer = assetManufacturer;
	}

	public String getAssetdealer() {
		return assetdealer;
	}

	public void setAssetdealer(String assetdealer) {
		this.assetdealer = assetdealer;
	}

	public String getAssetcontract() {
		return assetcontract;
	}

	public void setAssetcontract(String assetcontract) {
		this.assetcontract = assetcontract;
	}

	public String getAssetindeliverstatus() {
		return assetindeliverstatus;
	}

	public void setAssetindeliverstatus(String assetindeliverstatus) {
		this.assetindeliverstatus = assetindeliverstatus;
	}

	public String getAssetrunningstatus() {
		return assetrunningstatus;
	}

	public void setAssetrunningstatus(String assetrunningstatus) {
		this.assetrunningstatus = assetrunningstatus;
	}

	@Override
	public String getFormatID() {
		// TODO Auto-generated method stub
		if (assetid == 0) {
			return new DecimalFormat("00000000").format(AssetsDAO.getID());
		} else {
			return new DecimalFormat("00000000").format(assetid);
		}
	}

	@Override
	public String getValue(int i) {
		// TODO Auto-generated method stub
		String result = "";

		switch (i) {
		case 0:
			result = this.getFormatID();
			break;
		case 1:
			result = this.getAssettype();
			break;
		case 2:
			result = this.getAssetname();
			break;
		case 3:
			result = this.getAssetbrand();
			break;
		case 4:
			result = this.getAssetmodel();
			break;
		case 5:
			result = this.getAssetno() + "";
			break;
		case 6:
			result = this.getAssetpurchasedate();
			break;
		case 7:
			result = this.getAssetManufacturer();
			break;
		case 8:
			result = this.getAssetdealer();
			break;
		/*
		 * case 9: result = this.getAssetcontract(); break;
		 */
		case 9:
			result = this.getAssetindeliverstatus();
			break;
		case 10:
			result = this.getAssetrunningstatus();
			break;

		}
		return result;
	}

	@Override
	public String getFormatAssetid() {
		// TODO Auto-generated method stub
		if (assetid == 0) {
			return new DecimalFormat("00000000").format(AssetsDAO.getID());
		} else {
			return new DecimalFormat("00000000").format(assetid);
		}
	}

}
/*
 * --�����ʲ��� CREATE TABLE Assets ( AssetID Decimal(9) NOT NULL IDENTITY, --�ʲ�ID
 * AssetType varchar(200) NOT NULL, --�ʲ�����,100������ AssetName varchar(200) NOT
 * NULL, --�ʲ����ƣ�100������ AssetBrand varchar(200) NOT NULL, --�ʲ�Ʒ�ƣ�100������
 * AssetModel varchar(100) NOT NULL, --�ʲ��ͺţ�100������ AssetNo Decimal(9) NOT NULL,
 * --�ʲ����� AssetPurchaseDate DATETIME NOT NULL, --�ʲ��������� AssetManufacturer
 * varchar(200) NOT NULL, --�ʲ������̣�100������ AssetDealer varchar(200) NOT NULL,
 * --�ʲ�������,100������ AssetContract varchar(200), --��ͬ��Ϣ��ͼƬ·�� AssetInDeliverStatus
 * char NOT NULL, --I:���У�O:���⣬R:�����T:ת�� AssetRunningStatus char NOT NULL,
 * --N:������M:ά�ޣ�P:Ԥ���ϣ�D:����
 * 
 * PRIMARY KEY (AssetID) ) go
 */
