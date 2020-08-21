package Marshia;

import java.util.Date;

public class Order {
	int Number;
	String Name;
	int Mobile;
	String FacebookName;
	String Address;
	Date date;
	String ItemDecribtion;
	int Paid;
	int Discount;
	public int getNumber() {return Number;}
	public String getName() {return Name;}
	public int getMobile() {return Mobile;}
	public String getFacebookName() {return FacebookName;}
	public String getAddress() {return Address;}
	public Date getDate() {return date;}
	public String getItemDecribtion() {return ItemDecribtion;}
	public int getPaid() {return Paid;}
	public int getDiscount() {return Discount;}
	public void setNumber(int number) {Number = number;}
	public void setName(String name) {Name = name;}
	public void setMobile(int mobile) {Mobile = mobile;}
	public void setFacebookName(String facebookName) {FacebookName = facebookName;}
	public void setAddress(String address) {Address = address;}
	public void setDate(Date date) {this.date = date;}
	public void setItemDecribtion(String itemDecribtion) {ItemDecribtion = itemDecribtion;}
	public void setPaid(int paid) {Paid = paid;}
	public void setDiscount(int discount) {Discount = discount;}
}
