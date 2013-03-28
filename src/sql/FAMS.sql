--SQL Server默认不区分大小写
USE master
go

if exists(select * from sysdatabases where name='FAMS')
DROP DATABASE FAMS
go

--DROP DATABASE IF EXISTS FAMS;

CREATE DATABASE FAMS
go 
--character set utf8
--default character set utf8
--collate utf8_general_ci
--default collate utf8_general_ci;

--SET NAMES 'gbk';

USE FAMS
go

--创建资产表
CREATE TABLE Assets 
(
	AssetID Decimal(9) NOT NULL IDENTITY, --资产ID
	AssetType varchar(200) NOT NULL, --资产类型,100字以内
	AssetName varchar(200) NOT NULL, --资产名称，100字以内
	AssetBrand varchar(200) NOT NULL, --资产品牌，100字以内
	AssetModel varchar(100) NOT NULL, --资产型号，100字以内
	AssetNo Decimal(9) NOT NULL, --资产机号
	AssetPurchaseDate varchar(200) NOT NULL, --资产购入日期
	AssetManufacturer varchar(200) NOT NULL, --资产生产商，100字以内
	AssetDealer varchar(200) NOT NULL, --资产经销商,100字以内
	AssetContract ntext, --合同信息，图片路径
	AssetInDeliverStatus varchar(20) NOT NULL, --in:库中，out:出库，rent:借出，transfer:转移
	AssetRunningStatus varchar(20) NOT NULL, --normal:正常，maintain:维修，prediscard:预报废，discard:报废
	
	PRIMARY KEY (AssetID)
)
go

--创建出库表
--DROP TABLE IF EXISTS DeliverOut;

CREATE TABLE DeliverOut 
(
	DeliverOutID Decimal(9) NOT NULL IDENTITY, --出库ID
	AssetID Decimal(9) NOT NULL, --资产ID，外键
	DeliverDepartment varchar(200) NOT NULL, --领用部门，100字以内
	DeliverStaff varchar(200) NOT NULL, --领用人，100字以内
	DeliverDate varchar(200) NOT NULL, --领用日期
	DeliverAddress varchar(200) NOT NULL, --存在地址，100字以内
	DeliverRemark varchar(200), --备注，100字以内
	DeliverCertificate ntext NOT NULL, --出库凭证，图片路径
	DeliverRecordIsNew varchar(10) NOT NULL, --记录是否最新，newest:最新，no:否
	ReturnDate varchar(200), --归还日期
	ReturnStaff varchar(200), --归还人员 200字以内
	
	PRIMARY KEY (DeliverOutID),
	FOREIGN KEY (AssetID) REFERENCES Assets(AssetID)
)
go


--创建借出表
--DROP TABLE IF EXISTS RentOut;

CREATE TABLE RentOut
(
	RentOutID Decimal(9) NOT NULL IDENTITY, --借出ID
	AssetID Decimal(9) NOT NULL, --资产ID，外键
	RentDepartment varchar(200) NOT NULL, --租用部门，100字以内
	RentStaff varchar(200) NOT NULL, --租用人员，100字以内
	RentDate varchar(200) NOT NULL, --租用日期
	ForeCastReturnDate varchar(200) NOT NULL, --预归还日期
	RentHandler varchar(200) NOT NULL, --经办人，100字以内
	RentRemark varchar(200), --备注，100字以内
	RentCertificate ntext NOT NULL, --借出凭证，图片路径
	RentRecordIsNew varchar(10) NOT NULL, --记录是否最新，newest:最新，no:否
	ReturnDate varchar(200), --归还日期
	ReturnStaff varchar(200), --归还人员 200字以内
	
	PRIMARY KEY (RentOutID),
	FOREIGN KEY (AssetID) REFERENCES Assets(AssetID)
)
go

--创建转移表
--DROP TABLE IF EXISTS Transfer;

CREATE TABLE Transfer
(
	TransferID Decimal(9) NOT NULL IDENTITY, --转移ID
	AssetID Decimal(9) NOT NULL, --资产ID，外键
	TransferDepartment varchar(200) NOT NULL, --转移部门，100字以内
	TransferDate varchar(200) NOT NULL, --转移日期
	TransferHandler varchar(200) NOT NULL, --经办人，100字以内
	TransferRemark varchar(200), --备注，100字以内
	TransferCertificate ntext NOT NULL, --转移凭证，图片路径
	TransferStatus varchar(5), --in:局内转移，out：对外捐赠
	TransferRecordIsNew varchar(10) NOT NULL, --记录是否最新，newest:最新，no:否

	PRIMARY KEY (TransferID),
	FOREIGN KEY (AssetID) REFERENCES Assets(AssetID)
)
go

--创建维修表Maintain
--DROP TABLE IF EXISTS Maintain;

CREATE TABLE Maintain
(
	MaintainID Decimal(9) NOT NULL IDENTITY, --维修ID
	AssetID Decimal(9) NOT NULL, --资产ID，外键
	MaintainDepartment varchar(200) NOT NULL, --维修部门，100字以内
	DownDate varchar(200) NOT NULL, --故障日期
	MaintainHandler varchar(200) NOT NULL, --经办人，100字以内
	DownRemark varchar(200), --故障情况，100字以内
	DownPhenomenon varchar(200), --故障现象，100字以内
	MaintainProcess varchar(200) NOT NULL, --维修过程，100字以内
	DeviceStatus varchar(200) NOT NULL, --设备状况
	MaintainCost Decimal(9, 2) NOT NULL, --维修费用
	MaintainRecordIsNew varchar(10) NOT NULL, --记录是否最新，newest:最新，no:否

	PRIMARY KEY (MaintainID),
	FOREIGN KEY (AssetID) REFERENCES Assets(AssetID)
)
go 

--创建报废表
--DROP TABLE IF EXISTS Discard;

CREATE TABLE Discard
(
	DiscardID Decimal(9) NOT NULL IDENTITY, --报废ID
	AssetID Decimal(9) NOT NULL, --资产ID，外键
	DiscardDepartment varchar(200) NOT NULL, --报废部门，100字以内
	PreDiscardDate varchar(200) NOT NULL, --预报废时间
	DiscardDate varchar(200) NOT NULL, --报废时间
	DiscardReason varchar(200) NOT NULL, --报废原因
	DiscardCertificate ntext NOT NULL, --报废凭证，图片路径

	PRIMARY KEY (DiscardID),
	FOREIGN KEY (AssetID) REFERENCES Assets(AssetID)
)
go