package dal.model;


public class Maintain {
	private int assetid = 0;
	private String maintaindepartment = null;
	private String downdate = null;
	private String maintanhandler = null;
	private String downremark = null;
	private String downphenomenon = null;
	private String maintainprocess = null;
	private String maintainrecordisnew = null;
	private int maintaincost = 0;
	private String devicestatus = null;	
	
	public Maintain(int assetid, String maintaindepartment, String downdate,
			String maintanhandler, String downremark, String downphenomenon,
			String maintainprocess, String maintainrecordisnew,
			int maintaincost, String devicestatus) {
		super();
		this.assetid = assetid;
		this.maintaindepartment = maintaindepartment;
		this.downdate = downdate;
		this.maintanhandler = maintanhandler;
		this.downremark = downremark;
		this.downphenomenon = downphenomenon;
		this.maintainprocess = maintainprocess;
		this.maintainrecordisnew = maintainrecordisnew;
		this.maintaincost = maintaincost;
		this.devicestatus = devicestatus;
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
	public String getMaintanhandler() {
		return maintanhandler;
	}
	public void setMaintanhandler(String maintanhandler) {
		this.maintanhandler = maintanhandler;
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
	public int getMaintaincost() {
		return maintaincost;
	}
	public void setMaintaincost(int maintaincost) {
		this.maintaincost = maintaincost;
	}
	public String getDevicestatus() {
		return devicestatus;
	}
	public void setDevicestatus(String devicestatus) {
		this.devicestatus = devicestatus;
	}

}
/*
CREATE TABLE Maintain
(
	MaintainID Decimal(9) NOT NULL IDENTITY, --ά��ID
	AssetID Decimal(9) NOT NULL, --�ʲ�ID�����
	MaintainDepartment varchar(200) NOT NULL, --ά�޲��ţ�100������
	DownDate SMALLDATETIME NOT NULL, --��������
	MaintainHandler varchar(200) NOT NULL, --�����ˣ�100������
	DownRemark varchar(200), --���������100������
	DownPhenomenon varchar(200), --��������100������
	MaintainProcess varchar(200) NOT NULL, --ά�޹��̣�100������
	DeviceStatus varchar(200) NOT NULL, --�豸״��
	MaintainCost Decimal(9, 2) NOT NULL, --ά�޷���
	MaintainRecordIsNew varchar(10) NOT NULL, --��¼�Ƿ����£�newest:���£�no:��
	
	PRIMARY KEY (MaintainID),
	FOREIGN KEY (AssetID) REFERENCES Assets(AssetID)
)
go 
*/