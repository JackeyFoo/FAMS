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
	TransferID Decimal(9) NOT NULL IDENTITY, --ת��ID
	AssetID Decimal(9) NOT NULL, --�ʲ�ID�����
	TransferDepartment varchar(200) NOT NULL, --ת�Ʋ��ţ�100������
	TransferDate SMALLDATETIME NOT NULL, --ת������
	TransferHandler varchar(200) NOT NULL, --�����ˣ�100������
	TransferRemark varchar(200), --��ע��100������
	TransferCertificate varchar(200) NOT NULL, --ת��ƾ֤��ͼƬ·��
	TransferStatus varchar(5), --in:����ת�ƣ�out���������
	TransferRecordIsNew varchar(10) NOT NULL, --��¼�Ƿ����£�newest:���£�no:��

	PRIMARY KEY (TransferID),
	FOREIGN KEY (AssetID) REFERENCES Assets(AssetID)
)
go
*/
