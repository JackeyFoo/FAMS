package dal.model;

import java.text.DecimalFormat;
import dal.dal.DiscardDAO;
import dal.interfaces.ModelObject;


public class Discard implements ModelObject {
	
	private int assetid;
	private int discardid = 0;

	private String discarddepartment = null;
	private String prediscarddate = null;
	private String discarddate = null;
	private String discardreason = null;
	private String discardcertificate = null;
	
	public Discard(){
		
	}
	
	public Discard(int assetid, String discarddepartment,
			String prediscarddate, String discarddate, String discardreason,
			String discardcertificate) {
		super();
		this.assetid = assetid;
		this.discarddepartment = discarddepartment;
		this.prediscarddate = prediscarddate;
		this.discarddate = discarddate;
		this.discardreason = discardreason;
		this.discardcertificate = discardcertificate;
	}
	
	
	public int getDiscardid() {
		return discardid;
	}

	public void setDiscardid(int discardid) {
		this.discardid = discardid;
	}

	
	public int getAssetid() {
		return assetid;
	}
	public void setAssetid(int assetid) {
		this.assetid = assetid;
	}
	public String getDiscarddepartment() {
		return discarddepartment;
	}
	public void setDiscarddepartment(String discarddepartment) {
		this.discarddepartment = discarddepartment;
	}
	public String getPrediscarddate() {
		return prediscarddate;
	}
	public void setPrediscarddate(String prediscarddate) {
		this.prediscarddate = prediscarddate;
	}
	public String getDiscarddate() {
		return discarddate;
	}
	public void setDiscarddate(String discarddate) {
		this.discarddate = discarddate;
	}
	public String getDiscardreason() {
		return discardreason;
	}
	public void setDiscardreason(String discardreason) {
		this.discardreason = discardreason;
	}
	public String getDiscardcertificate() {
		return discardcertificate;
	}
	public void setDiscardcertificate(String discardcertificate) {
		this.discardcertificate = discardcertificate;
	}

	@Override
	public String getFormatID() {
		// TODO Auto-generated method stub
		if (discardid == 0) {
			return new DecimalFormat("00000000").format(DiscardDAO.getID());
		} else {
			return new DecimalFormat("00000000").format(discardid);
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
			result = this.getDiscarddepartment();
			break;
		case 3:
			result = this.getDiscarddate();
			break;
		case 4:
			result = this.getDiscardreason();
			break;
/*		case 5:
			result = this.getDiscardcertificate();
			break;
	*/
		}
		return result;
	}

	
}
/*
CREATE TABLE Discard
(
	DiscardID Decimal(9) NOT NULL IDENTITY, --����ID
	AssetID Decimal(9) NOT NULL, --�ʲ�ID�����
	DiscardDepartment varchar(200) NOT NULL, --���ϲ��ţ�100������
	PreDiscardDate SMALLDATETIME NOT NULL, --Ԥ����ʱ��
	DiscardDate SMALLDATETIME NOT NULL, --����ʱ��
	DiscardReason varchar(200) NOT NULL, --����ԭ��
	DiscardCertificate varchar(200) NOT NULL, --����ƾ֤��ͼƬ·��

	PRIMARY KEY (DiscardID),
	FOREIGN KEY (AssetID) REFERENCES Assets(AssetID)
)
go
*/