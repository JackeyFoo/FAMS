package dal.model;


public class RentOut {
	
	private int assetid = 0;
	private String rentdepartment = null;
	private String rentstaff = null;
	private String rentdate = null;
	private String forecastreturndate = null;
	private String renthandler = null;
	private String rentremark = null;
	private String rentrecordisnew = null;
	private String returndate = null;
	private String returnstaff = null;	
	
	public RentOut(int assetid, String rentdepartment, String rentstaff,
			String rentdate, String forecastreturndate, String renthandler,
			String rentremark, String rentrecordisnew, String returndate,
			String returnstaff) {
		super();
		this.assetid = assetid;
		this.rentdepartment = rentdepartment;
		this.rentstaff = rentstaff;
		this.rentdate = rentdate;
		this.forecastreturndate = forecastreturndate;
		this.renthandler = renthandler;
		this.rentremark = rentremark;
		this.rentrecordisnew = rentrecordisnew;
		this.returndate = returndate;
		this.returnstaff = returnstaff;
	}
	
	public int getAssetid() {
		return assetid;
	}
	public void setAssetid(int assetid) {
		this.assetid = assetid;
	}
	public String getRentdepartment() {
		return rentdepartment;
	}
	public void setRentdepartment(String rentdepartment) {
		this.rentdepartment = rentdepartment;
	}
	public String getRentstaff() {
		return rentstaff;
	}
	public void setRentstaff(String rentstaff) {
		this.rentstaff = rentstaff;
	}
	public String getRentdate() {
		return rentdate;
	}
	public void setRentdate(String rentdate) {
		this.rentdate = rentdate;
	}
	public String getForecastreturndate() {
		return forecastreturndate;
	}
	public void setForecastreturndate(String forecastreturndate) {
		this.forecastreturndate = forecastreturndate;
	}
	public String getRenthandler() {
		return renthandler;
	}
	public void setRenthandler(String renthandler) {
		this.renthandler = renthandler;
	}
	public String getRentremark() {
		return rentremark;
	}
	public void setRentremark(String rentremark) {
		this.rentremark = rentremark;
	}
	public String getRentrecordisnew() {
		return rentrecordisnew;
	}
	public void setRentrecordisnew(String rentrecordisnew) {
		this.rentrecordisnew = rentrecordisnew;
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
 * CREATE TABLE RentOut
(
	RentOutID Decimal(9) NOT NULL IDENTITY, --借出ID
	AssetID Decimal(9) NOT NULL, --资产ID，外键
	RentDepartment varchar(200) NOT NULL, --租用部门，100字以内
	RentStaff varchar(200) NOT NULL, --租用人员，100字以内
	RentDate SMALLDATETIME NOT NULL, --租用日期
	ForeCastReturnDate SMALLDATETIME NOT NULL, --预归还日期
	RentHandler varchar(200) NOT NULL, --经办人，100字以内
	RentRemark varchar(200), --备注，100字以内
	RentRecordIsNew varchar(10) NOT NULL, --记录是否最新，newest:最新，no:否
	ReturnDate SMALLDATETIME, --归还日期
	ReturnStaff varchar(200), --归还人员 200字以内
	
	PRIMARY KEY (RentOutID),
	FOREIGN KEY (AssetID) REFERENCES Assets(AssetID)
)
go
*/
