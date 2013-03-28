package dal.model;

import java.text.DecimalFormat;

import dal.interfaces.ModelObject;

public class DeliverOut implements ModelObject {

	private int assetid;
	private int deliveroutid;

	private String deliverdepartment = null;
	private String deliverstaff = null;
	private String deliverdate = null;
	private String deliveraddress = null;
	private String deliverremark = null;
	private String delivercertificate = null;
	private String deliverrecordisnew = null;
	private String returndate = null;
	private String returnstaff = null;

	public DeliverOut() {

	}

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

	public int getDeliveroutid() {
		return deliveroutid;
	}

	public void setDeliveroutid(int deliveroutid) {
		this.deliveroutid = deliveroutid;
	}

	public String getFormatID() {
		return new DecimalFormat("00000000").format(deliveroutid);
	}

	public int getAssetid() {
		return assetid;
	}

	public String getFormatAssetid() {

		return new DecimalFormat("00000000").format(assetid);
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
			result = this.getDeliverdepartment();
			break;
		case 3:
			result = this.getDeliverstaff();
			break;
		case 4:
			result = this.getDeliverdate();
			break;
		case 5:
			result = this.getDeliveraddress();
			break;
		case 6:
			result = this.getDeliverremark();
			break;
/*		case 7:
			result = this.getDelivercertificate();
			break;*/
		case 7:
			result = this.getDeliverrecordisnew();
			break;
		}
		return result;
	}

}
/*
 * CREATE TABLE DeliverOut ( DeliverOutID Decimal(9) NOT NULL IDENTITY, --出库ID
 * AssetID Decimal(9) NOT NULL, --资产ID，外键 DeliverDepartment varchar(200) NOT
 * NULL, --领用部门，100字以内 DeliverStaff varchar(200) NOT NULL, --领用人，100字以内
 * DeliverDate SMALLDATETIME NOT NULL, --领用日期 DeliverAddress varchar(200) NOT
 * NULL, --存在地址，100字以内 DeliverRemark varchar(200), --备注，100字以内
 * DeliverCertificate varchar(200) NOT NULL, --出库凭证，图片路径 DeliverRecordIsNew
 * varchar(10) NOT NULL, --记录是否最新，newest:最新，no:否 ReturnDate SMALLDATETIME,
 * --归还日期 ReturnStaff varchar(200), --归还人员 200字以内
 * 
 * PRIMARY KEY (DeliverOutID), FOREIGN KEY (AssetID) REFERENCES Assets(AssetID)
 * ) go
 */