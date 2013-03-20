package dal.model;


public class Transfer {
	private int assetid = 0;
	private String transferdepartment = null;
	private String transferdate = null;
	private String transferhandler = null;
	private String transferremark = null;
	private String transferrecordisnew = null;
	private String transfercertificate = null;
	private String transferstatus = null;	
	
	public Transfer(int assetid, String transferdepartment,
			String transferdate, String transferhandler, String transferremark,
			String transferrecordisnew, String transfercertificate,
			String transferstatus) {
		super();
		this.assetid = assetid;
		this.transferdepartment = transferdepartment;
		this.transferdate = transferdate;
		this.transferhandler = transferhandler;
		this.transferremark = transferremark;
		this.transferrecordisnew = transferrecordisnew;
		this.transfercertificate = transfercertificate;
		this.transferstatus = transferstatus;
	}
	
	
	public int getAssetid() {
		return assetid;
	}
	public void setAssetid(int assetid) {
		this.assetid = assetid;
	}
	public String getTransferdepartment() {
		return transferdepartment;
	}
	public void setTransferdepartment(String transferdepartment) {
		this.transferdepartment = transferdepartment;
	}
	public String getTransferdate() {
		return transferdate;
	}
	public void setTransferdate(String transferdate) {
		this.transferdate = transferdate;
	}
	public String getTransferhandler() {
		return transferhandler;
	}
	public void setTransferhandler(String transferhandler) {
		this.transferhandler = transferhandler;
	}
	public String getTransferremark() {
		return transferremark;
	}
	public void setTransferremark(String transferremark) {
		this.transferremark = transferremark;
	}
	public String getTransferrecordisnew() {
		return transferrecordisnew;
	}
	public void setTransferrecordisnew(String transferrecordisnew) {
		this.transferrecordisnew = transferrecordisnew;
	}
	public String getTransfercertificate() {
		return transfercertificate;
	}
	public void setTransfercertificate(String transfercertificate) {
		this.transfercertificate = transfercertificate;
	}
	public String getTransferstatus() {
		return transferstatus;
	}
	public void setTransferstatus(String transferstatus) {
		this.transferstatus = transferstatus;
	}

	
}
/*
 CREATE TABLE Transfer
(
	TransferID Decimal(9) NOT NULL IDENTITY, --转移ID
	AssetID Decimal(9) NOT NULL, --资产ID，外键
	TransferDepartment varchar(200) NOT NULL, --转移部门，100字以内
	TransferDate SMALLDATETIME NOT NULL, --转移日期
	TransferHandler varchar(200) NOT NULL, --经办人，100字以内
	TransferRemark varchar(200), --备注，100字以内
	TransferCertificate varchar(200) NOT NULL, --转移凭证，图片路径
	TransferStatus varchar(5), --in:局内转移，out：对外捐赠
	TransferRecordIsNew varchar(10) NOT NULL, --记录是否最新，newest:最新，no:否

	PRIMARY KEY (TransferID),
	FOREIGN KEY (AssetID) REFERENCES Assets(AssetID)
)
go
*/
