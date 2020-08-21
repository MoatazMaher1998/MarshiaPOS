package Marshia;

import java.util.Date;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Item {
private SimpleIntegerProperty Code;
private	SimpleStringProperty Name;
private	SimpleStringProperty Category;
private	SimpleStringProperty Color; 
private	int Sold; 
private	int Current;
private	SimpleStringProperty Size;
private	int Damaged;
private	SimpleIntegerProperty Price1;
private	SimpleIntegerProperty Price2; 
private	Date EnteryDate;
public Item(int code, String name, String category, String color, String size, int price1, int price2) {
	super();
	Code = new SimpleIntegerProperty(code);
	Name =  new SimpleStringProperty(name);
	Category = new SimpleStringProperty(category);
	Color = new SimpleStringProperty(color);
	Size = new SimpleStringProperty(size);
	Price1 = new SimpleIntegerProperty(price1);
	Price2 = new SimpleIntegerProperty(price2);
}
public int getCode() {
	return Code.get();
}
public String getName() {
	return Name.get();
}
public String getCategory() {
	return Category.get();
}
public String getColor() {
	return Color.get();
}
public int getSold() {
	return Sold;
}
public int getCurrent() {
	return Current;
}
public String getSize() {
	return Size.get();
}
public int getDamaged() {
	return Damaged;
}
public int getPrice1() {
	return Price1.get();
}
public int getPrice2() {
	return Price2.get();
}
public Date getEnteryDate() {
	return EnteryDate;
}
public void setCode(int code) {
	Code = new SimpleIntegerProperty(code);
}
public void setName(String name) {
	Name = new SimpleStringProperty(name);
}
public void setCategory(String category) {
	Category = new SimpleStringProperty(category);
}
public void setColor(String color) {
	Color = new SimpleStringProperty(color);
}
public void setSold(int sold) {
	Sold = sold;
}
public void setCurrent(int current) {
	Current = current;
}
public void setSize(String size) {
	Size = new SimpleStringProperty(size);
}
public void setDamaged(int damaged) {
	Damaged = damaged;
}
public void setPrice1(int price1) {
	Price1 = new SimpleIntegerProperty(price1);
}
public void setPrice2(int price2) {
	Price2 = new SimpleIntegerProperty(price2);
}
public void setEnteryDate(Date enteryDate) {
	EnteryDate = enteryDate;
}
}
