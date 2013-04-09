package dal.model;

import java.text.DecimalFormat;

import dal.dal.MaintainDAO;
import dal.interfaces.ModelObject;

public class Maintain implements ModelObject {

	private int assetid;
	private int maintainid = 0;
	private String maintaindepartment = null;
	private String downdate = null;
	private String maintainhandler = null;
	private String downremark = null;
	private String downphenomenon = null;
	private String maintainprocess = null;
	private String maintainrecordisnew = "最新";
	private double maintaincost = 0;
	private String devicestatus = null;
	private String maintainfinisheddate = null;

	public Maintain() {

	}
	

	public Maintain(int assetid, String maintaindepartment, String downdate,
			String maintainhandler, String downremark, String downphenomenon,
			String maintainprocess, String maintainrecordisnew,
			double maintaincost, String devicestatus,
			String maintainfinisheddate) {
		super();
		this.assetid = assetid;
		this.maintaindepartment = maintaindepartment;
		this.downdate = downdate;
		this.maintainhandler = maintainhandler;
		this.downremark = downremark;
		this.downphenomenon = downphenomenon;
		this.maintainprocess = maintainprocess;
		this.maintainrecordisnew = maintainrecordisnew;
		this.maintaincost = maintaincost;
		this.devicestatus = devicestatus;
		this.maintainfinisheddate = maintainfinisheddate;
	}


	public int getMaintainid() {
		return maintainid;
	}

	public void setMaintainid(int maintainid) {
		this.maintainid = maintainid;
	}

	public int getAssetid() {
		return assetid;
	}

	public void setAssetid(int assetid) {
		this.assetid = assetid;
	}

	public String getMaintaindepartment() {
		return maintaindepartment;
	}

	public void setMaintaindepartment(String maintaindepartment) {
		this.maintaindepartment = maintaindepartment;
	}

	public String getDowndate() {
		return downdate;
	}

	public void setDowndate(String downdate) {
		this.downdate = downdate;
	}

	public String getMaintainhandler() {
		return maintainhandler;
	}

	public void setMaintainhandler(String maintanhandler) {
		this.maintainhandler = maintanhandler;
	}

	public String getDownremark() {
		return downremark;
	}

	public void setDownremark(String downremark) {
		this.downremark = downremark;
	}

	public String getDownphenomenon() {
		return downphenomenon;
	}

	public void setDownphenomenon(String downphenomenon) {
		this.downphenomenon = downphenomenon;
	}

	public String getMaintainprocess() {
		return maintainprocess;
	}

	public void setMaintainprocess(String maintainprocess) {
		this.maintainprocess = maintainprocess;
	}

	public String getMaintainrecordisnew() {
		return maintainrecordisnew;
	}

	public void setMaintainrecordisnew(String maintainrecordisnew) {
		this.maintainrecordisnew = maintainrecordisnew;
	}

	public double getMaintaincost() {
		return maintaincost;
	}

	public void setMaintaincost(double maintaincost) {
		this.maintaincost = maintaincost;
	}

	public String getDevicestatus() {
		return devicestatus;
	}

	public void setDevicestatus(String devicestatus) {
		this.devicestatus = devicestatus;
	}
	
	public String getMaintainfinisheddate() {
		return maintainfinisheddate;
	}

	public void setMaintainfinisheddate(String maintainfinisheddate) {
		this.maintainfinisheddate = maintainfinisheddate;
	}


	@Override
	public String getFormatID() {
		// TODO Auto-generated method stub

		if (maintainid == 0) {
			return new DecimalFormat("00000000").format(MaintainDAO.getID());
		} else {
			return new DecimalFormat("00000000").format(maintainid);
		}

	}

	@Override
	public String getFormatAssetid() {
		// TODO Auto-generated method stub
		return new DecimalFormat("00000000").format(assetid);
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
			result = this.getFormatAssetid();
			break;
		case 2:
			result = this.getMaintaindepartment();
			break;
		case 3:
			result = this.getDowndate();
			break;
		case 4:
			result = this.getMaintainhandler();
			break;
		case 5:
			result = this.getDownremark();
			break;
		case 6:
			result = this.getDownphenomenon();
			break;
		case 7:
			result = this.getMaintainprocess();
			break;
		case 8:
			result = this.getDevicestatus();
			break;
		case 9:
			result = this.getMaintaincost() + "";
			break;
		case 10:
			result = this.getMaintainrecordisnew();
			break;
			
		case 11:
			result = this.getMaintainfinisheddate();
			break;

		}
		return result;
	}

}
/*
 * CREATE TABLE Maintain ( MaintainID Decimal(9) NOT NULL IDENTITY, --维修ID
 * AssetID Decimal(9) NOT NULL, --资产ID，外键 MaintainDepartment varchar(200) NOT
 * NULL, --维修部门，100字以内 DownDate SMALLDATETIME NOT NULL, --故障日期 MaintainHandler
 * varchar(200) NOT NULL, --经办人，100字以内 DownRemark varchar(200), --故障情况，100字以内
 * DownPhenomenon varchar(200), --故障现象，100字以内 MaintainProcess varchar(200) NOT
 * NULL, --维修过程，100字以内 DeviceStatus varchar(200) NOT NULL, --设备状况 MaintainCost
 * Decimal(9, 2) NOT NULL, --维修费用 MaintainRecordIsNew varchar(10) NOT NULL,
 * --记录是否最新，newest:最新，no:否
 * 
 * PRIMARY KEY (MaintainID), FOREIGN KEY (AssetID) REFERENCES Assets(AssetID) )
 * go
 */