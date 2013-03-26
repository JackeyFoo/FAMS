package dal.model;

import dal.interfaces.ModelObject;



public class Assets implements ModelObject{
	
	private String assetid = null;
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
	
	
	public Assets(){
		
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
	
	public String getAssetid(){
		return assetid;
	}
	
	public void setAssetid(String assetid){
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
	public String getID() {
		// TODO Auto-generated method stub
		return this.assetid;
	}

}
/*
--创建资产表
CREATE TABLE Assets 
(
	AssetID Decimal(9) NOT NULL IDENTITY, --资产ID
	AssetType varchar(200) NOT NULL, --资产类型,100字以内
	AssetName varchar(200) NOT NULL, --资产名称，100字以内
	AssetBrand varchar(200) NOT NULL, --资产品牌，100字以内
	AssetModel varchar(100) NOT NULL, --资产型号，100字以内
	AssetNo Decimal(9) NOT NULL, --资产机号
	AssetPurchaseDate DATETIME NOT NULL, --资产购入日期
	AssetManufacturer varchar(200) NOT NULL, --资产生产商，100字以内
	AssetDealer varchar(200) NOT NULL, --资产经销商,100字以内
	AssetContract varchar(200), --合同信息，图片路径
	AssetInDeliverStatus char NOT NULL, --I:库中，O:出库，R:借出，T:转移
	AssetRunningStatus char NOT NULL, --N:正常，M:维修，P:预报废，D:报废
	
	PRIMARY KEY (AssetID)
)
go
*/
