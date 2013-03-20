package dal.model;



public class Assets{
	
	private String assettype = null;
	private String assetname = null;
	private String assetbrand = null;
	private String assetmodel = null;
	private int assetno = 0;
	private String assetpurchasedate = null;
	private String assetManufacturer = null;
	private String assetdealer = null;
	private String assetcontract = null;
	private String assetindeliverstatus = "";
	private String assetrunningstatus = "";	
	
	
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

}
/*
--�����ʲ���
CREATE TABLE Assets 
(
	AssetID Decimal(9) NOT NULL IDENTITY, --�ʲ�ID
	AssetType varchar(200) NOT NULL, --�ʲ�����,100������
	AssetName varchar(200) NOT NULL, --�ʲ����ƣ�100������
	AssetBrand varchar(200) NOT NULL, --�ʲ�Ʒ�ƣ�100������
	AssetModel varchar(100) NOT NULL, --�ʲ��ͺţ�100������
	AssetNo Decimal(9) NOT NULL, --�ʲ�����
	AssetPurchaseDate DATETIME NOT NULL, --�ʲ���������
	AssetManufacturer varchar(200) NOT NULL, --�ʲ������̣�100������
	AssetDealer varchar(200) NOT NULL, --�ʲ�������,100������
	AssetContract varchar(200), --��ͬ��Ϣ��ͼƬ·��
	AssetInDeliverStatus char NOT NULL, --I:���У�O:���⣬R:�����T:ת��
	AssetRunningStatus char NOT NULL, --N:������M:ά�ޣ�P:Ԥ���ϣ�D:����
	
	PRIMARY KEY (AssetID)
)
go
*/
