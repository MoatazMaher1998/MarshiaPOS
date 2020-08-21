package Marshia;

import java.util.Date;

public class Customer {
	private	String Name;
	private	int Phone;
	private	String Address;
	public String getName() {
		return Name;
	}
	public int getPhone() {
		return Phone;
	}
	public String getAddress() {
		return Address;
	}
	public String getFacebookName() {
		return FacebookName;
	}
	public int getPreviousBalance() {
		return PreviousBalance;
	}
	public boolean isBlackList() {
		return BlackList;
	}
	public Date getVisitDate() {
		return VisitDate;
	}
	public void setName(String name) {
		Name = name;
	}
	public void setPhone(int phone) {
		Phone = phone;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public void setFacebookName(String facebookName) {
		FacebookName = facebookName;
	}
	public void setPreviousBalance(int previousBalance) {
		PreviousBalance = previousBalance;
	}
	public void setBlackList(boolean blackList) {
		BlackList = blackList;
	}
	public void setVisitDate(Date visitDate) {
		VisitDate = visitDate;
	}
	private	String FacebookName;
	private	int PreviousBalance;
	private	boolean BlackList;
    private	Date VisitDate;
}
