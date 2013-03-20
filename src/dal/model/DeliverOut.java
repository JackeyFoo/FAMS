package dal.model;


public class DeliverOut {

	private int assetid = 0;
	private String deliverdepartment = null;
	private String deliverstaff = null;
	private String deliverdate = null;
	private String deliveraddress = null;
	private String deliverremark = null;
	private String delivercertificate = null;
	private String deliverrecordisnew = null;
	private String returndate = null;
	private String returnstaff = null;	
	
	
	public DeliverOut(int assetid, String deliverdepartment,
			String deliverstaff, String deliverdate, String deliveraddress,
			String deliverremark, String delivercertificate,
			String deliverrecordisnew, String returndate, String returnstaff) {
		super();
		this.assetid = assetid;
		this.deliverdepartment = deliverdepartment;
		this.deliverstaff = deliverstaff;
		this.deliverdate = deliverdate;
		this.deliveraddress = deliveraddress;
		this.deliverremark = deliverremark;
		this.delivercertificate = delivercertificate;
		this.deliverrecordisnew = deliverrecordisnew;
		this.returndate = returndate;
		this.returnstaff = returnstaff;
	}
	
	public int getAssetid() {
		return assetid;
	}
	
	public void setAssetid(int assetid) {
		this.assetid = assetid;
	}

	public String getDeliverdepartment() {
		return deliverdepartment;
	}
	public void setDeliverdepartment(String deliverdepartment) {
		this.deliverdepartment = deliverdepartment;
	}
	public String getDeliverstaff() {
		return deliverstaff;
	}
	public void setDeliverstaff(String deliverstaff) {
		this.deliverstaff = deliverstaff;
	}
	public String getDeliverdate() {
		return deliverdate;
	}
	public void setDeliverdate(String deliverdate) {
		this.deliverdate = deliverdate;
	}
	public String getDeliveraddress() {
		return deliveraddress;
	}
	public void setDeliveraddress(String deliveraddress) {
		this.deliveraddress = deliveraddress;
	}
	public String getDeliverremark() {
		return deliverremark;
	}
	public void setDeliverremark(String deliverremark) {
		this.deliverremark = deliverremark;
	}
	public String getDelivercertificate() {
		return delivercertificate;
	}
	public void setDelivercertificate(String delivercertificate) {
		this.delivercertificate = delivercertificate;
	}
	public String getDeliverrecordisnew() {
		return deliverrecordisnew;
	}
	public void setDeliverrecordisnew(String deliverrecordisnew) {
		this.deliverrecordisnew = deliverrecordisnew;
	}
	public String getReturndate() {
		return returndate;
	}
	public void setReturndate(String returndate) {
		this.returndate = returndate;
	}
	public String getReturnstaff() {
		return returnstaff;
	}
	public void setReturnstaff(String returnstaff) {
		this.returnstaff = returnstaff;
	}

}
/*
CREATE TABLE DeliverOut 
(
	DeliverOutID Decimal(9) NOT NULL IDENTITY, --����ID
	AssetID Decimal(9) NOT NULL, --�ʲ�ID�����
	DeliverDepartment varchar(200) NOT NULL, --���ò��ţ�100������
	DeliverStaff varchar(200) NOT NULL, --�����ˣ�100������
	DeliverDate SMALLDATETIME NOT NULL, --��������
	DeliverAddress varchar(200) NOT NULL, --���ڵ�ַ��100������
	DeliverRemark varchar(200), --��ע��100������
	DeliverCertificate varchar(200) NOT NULL, --����ƾ֤��ͼƬ·��
	DeliverRecordIsNew varchar(10) NOT NULL, --��¼�Ƿ����£�newest:���£�no:��
	ReturnDate SMALLDATETIME, --�黹����
	ReturnStaff varchar(200), --�黹��Ա 200������
	
	PRIMARY KEY (DeliverOutID),
	FOREIGN KEY (AssetID) REFERENCES Assets(AssetID)
)
go
*/