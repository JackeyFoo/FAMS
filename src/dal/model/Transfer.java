package dal.model;

import java.text.DecimalFormat;

import dal.dal.TransferDAO;
import dal.interfaces.ModelObject;


public class Transfer implements ModelObject {
	

	private int transferid = 0;
	private int assetid;
	private String transferdepartment = null;
	private String transferdate = null;
	private String transferhandler = null;
	private String transferremark = null;
	private String transferrecordisnew = "最新";
	private String transfercertificate = null;
	private String transferstatus = null;	
	
	public Transfer(){
		
	}
	
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
	
	
	public int getTransferid() {
		return transferid;
	}


	public void setTransferid(int transferid) {
		this.transferid = transferid;
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


	@Override
	public String getFormatID() {
		// TODO Auto-generated method stub
		if(transferid == 0){
			return new DecimalFormat("00000000").format(TransferDAO.getID());
		}else{
			return new DecimalFormat("00000000").format(transferid);
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
			result = this.getFormatAssetid();
			break;
		case 2:
			result = this.getTransferdepartment();
			break;
		case 3:
			result = this.getTransferdate();
			break;
		case 4:
			result = this.getTransferhandler();
			break;
		case 5:
			result = this.getTransferremark();
			break;
			/*
			 * case 6: result = this.getAssetcontract(); break;
			 */
		case 6:
			result = this.getTransferstatus();
			break;
			/*
			 * case 7: result = this.getAssetcontract(); break;
			 */
		case 7:
			result = this.getTransferrecordisnew();
			break;

		}
		return result;
	}

	@Override
	public String getFormatAssetid() {
		// TODO Auto-generated method stub
		return new DecimalFormat("00000000").format(assetid);
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
