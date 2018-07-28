package com.cg.dao;

public interface IQueryMapper {
	public String Insert ="INSERT INTO Account( name,email,mobileno,balance) VALUES(?, ?, ?, ?)";
	public String getLastMobNo="SELECT MAX(mobileno) FROM Account";
	public String getAcc="SELECT * FROM Account WHERE mobileno= ?";
	public String getBal="SELECT balance FROM Account WHERE mobileno=?";
}
