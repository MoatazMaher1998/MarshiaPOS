package Marshia;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.event.ChangeListener;

import org.controlsfx.control.textfield.TextFields;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;


public class MainPageController implements Initializable {
			static int discount;
			Database MyData;
			@FXML
			TextField Code = new TextField();
			@FXML
			TextField Category = new TextField();
			@FXML
			TextField Name = new TextField();
			@FXML
			TextField Color = new TextField();
			@FXML
			TextField Size = new TextField();
			@FXML
			TextField CSName = new TextField();
			@FXML
			TextField CSFacebookName = new TextField();
			@FXML
			TextField PhoneNumber = new TextField();
			@FXML
			TextField Address = new TextField();
			@FXML
			TextField Discount = new TextField();
			@FXML
			TextField PreviousBalance = new TextField();
			@FXML
			TextField Representative = new TextField();
			@FXML
			TextField OrderID = new TextField();
			@FXML
			Label Total = new Label();
			@FXML
			TextField Paid = new TextField();
			@FXML
			AnchorPane SellAnchorPane = new AnchorPane();
			@FXML
			AnchorPane WarehouseAnchorPane = new AnchorPane();
			@FXML
			AnchorPane ReportsAnchorPane = new AnchorPane();
			@FXML
			AnchorPane ReturnAnchorpane = new AnchorPane();
			@FXML
			AnchorPane CustomersAnchorPane = new AnchorPane();
			@FXML
			ToggleGroup MainButtons = new ToggleGroup();
			@FXML
			ToggleButton Sell = new ToggleButton();
			@FXML
			ToggleButton Warehouse = new ToggleButton();
			@FXML
			ToggleButton Reports = new ToggleButton();
			@FXML
			ToggleButton Customers = new ToggleButton();
			@FXML
			ToggleButton Return = new ToggleButton();
			@FXML
			ToggleButton Price1 = new ToggleButton();
			@FXML
			ToggleButton Price2 = new ToggleButton();
			@FXML
			ToggleGroup Prices = new ToggleGroup();
			@FXML
			RadioButton DamageRadioButton = new RadioButton();
			@FXML
			RadioButton ReturnRadioButton = new RadioButton();
			@FXML
			ToggleGroup DamageorReturn = new ToggleGroup();
			@FXML
			DatePicker DateFrom = new DatePicker();
			@FXML
			DatePicker DateTo = new DatePicker();
			@FXML
			Label PriceLabel = new Label();
			@FXML
			Label CurrentLabel = new Label();
			ObservableList<Item> ViewList = FXCollections.observableArrayList();
			@FXML
			private TableView<Item> OrdersTableView;
			@FXML
			public TableColumn<Item, Integer> code;
			@FXML
			public TableColumn<Item, String> category;
			@FXML
			public TableColumn<Item, String> name;
			@FXML
			public TableColumn<Item, String> color;
			@FXML
			public TableColumn<Item, String> size;
			@FXML
			public TableColumn<Item, String> price;
			@FXML
			CheckBox RepCheckBox = new CheckBox();
			@FXML
			ListView<String> RepList = new ListView<String>();
			ObservableList<String> RepObList = FXCollections.observableArrayList();
			private int TotalToBePaid = 0;
			private int flag = 0;
		@FXML 
		private void RepList() throws SQLException {
			if(RepList.getSelectionModel().getSelectedItem()==null) {}
			else {
				int i;
			String[] x = RepList.getSelectionModel().getSelectedItem().split("~");
			ResultSet Rs = MyData.Mystat.executeQuery("SELECT * FROM rep where OrderNumber = "+ x[1]);
			Rs.next();
			i=Rs.getInt("NumberOfItems");
			x[0] = Rs.getString("Items");
			x[0] = x[0].replace("[",",");
			x[0] = x[0].replace("]",",");
			x[0] = x[0].replaceAll(" ","");
			x    = x[0].split(",");
			for(int y =1 ;y <= i ; y++ ) {
		      Code.setText(x[y]);
		      
		   //   onEnterAnchorpan(null);
			}
//			x=x[0].split("  ");
//			System.out.println(x[1]);
		}

		}
			
		@FXML 
		private void Discount() {
			discount = Integer.parseInt(Discount.getText());
			
			
			
		}

		@FXML
		private void CallRepresentative() {
				if (RepCheckBox.isSelected() == true) {
					Representative.setVisible(true);
				}
				if (RepCheckBox.isSelected() == false) {
					Representative.setVisible(false);

				}
			}
			@FXML
			private void PopNoMix() {
				if (MainButtons.getSelectedToggle().equals(Sell) == true) {
					ReturnAnchorpane.setVisible(false);
					SellAnchorPane.setVisible(true);
					WarehouseAnchorPane.setVisible(false);
					CustomersAnchorPane.setVisible(false);
					ReportsAnchorPane.setVisible(false);
				} else if (MainButtons.getSelectedToggle().equals(Warehouse) == true) {
					ReturnAnchorpane.setVisible(false);
					SellAnchorPane.setVisible(false);
					WarehouseAnchorPane.setVisible(true);
					CustomersAnchorPane.setVisible(false);
					ReportsAnchorPane.setVisible(false);
				} else if (MainButtons.getSelectedToggle().equals(Reports) == true) {
					ReturnAnchorpane.setVisible(false);
					SellAnchorPane.setVisible(false);
					WarehouseAnchorPane.setVisible(false);
					CustomersAnchorPane.setVisible(false);
					ReportsAnchorPane.setVisible(true);
				} else if (MainButtons.getSelectedToggle().equals(Customers) == true) {
					ReturnAnchorpane.setVisible(false);
					SellAnchorPane.setVisible(false);
					WarehouseAnchorPane.setVisible(false);
					CustomersAnchorPane.setVisible(true);
					ReportsAnchorPane.setVisible(false);
				} else if (MainButtons.getSelectedToggle().equals(Return) == true) {
					ReturnAnchorpane.setVisible(true);
					SellAnchorPane.setVisible(false);
					WarehouseAnchorPane.setVisible(false);
					CustomersAnchorPane.setVisible(false);
					ReportsAnchorPane.setVisible(false);
				}

			}

		private void StartUp(Statement Mystatement) throws SQLException {
				Price1.setToggleGroup(Prices);
				Price2.setToggleGroup(Prices);
				DateFrom.setValue(java.time.LocalDate.now());
				DateTo.setValue(java.time.LocalDate.now());
				Return.setToggleGroup(MainButtons);
				Sell.setToggleGroup(MainButtons);
				Warehouse.setToggleGroup(MainButtons);
				Reports.setToggleGroup(MainButtons);
				Customers.setToggleGroup(MainButtons);
				ReturnRadioButton.setToggleGroup(DamageorReturn);
				DamageRadioButton.setToggleGroup(DamageorReturn);
				MyData = new Database(Mystatement);
				code.setCellValueFactory(new PropertyValueFactory<>("Code"));
				category.setCellValueFactory(new PropertyValueFactory<>("Category"));
				name.setCellValueFactory(new PropertyValueFactory<>("Name"));
				color.setCellValueFactory(new PropertyValueFactory<>("Color"));
				size.setCellValueFactory(new PropertyValueFactory<>("Size"));
				price.setCellValueFactory(new PropertyValueFactory<>("Price1"));
				Total.setText("0");
				Discount.setText("0");
				PreviousBalance.setText("0");

				Discount.textProperty().addListener(new ChangeListener<String>() {
					@Override
					public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
						if (!arg2.matches("\\d*")) {
							Discount.setText(arg2.replaceAll("[^\\d]", ""));
						}
					}
				});
				Code.textProperty().addListener(new ChangeListener<String>() {
					@Override
					public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
						if (!arg2.matches("\\d*")) {
							Code.setText(arg2.replaceAll("[^\\d]", ""));
						}
					}
				});
				Paid.textProperty().addListener(new ChangeListener<String>() {
					@Override
					public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
						if (!arg2.matches("\\d*")) {
							Paid.setText(arg2.replaceAll("[^\\d]", ""));
						}
					}
				});
				PhoneNumber.textProperty().addListener(new ChangeListener<String>() {
					@Override
					public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
						if (!arg2.matches("\\d*")) {
							PhoneNumber.setText(arg2.replaceAll("[^\\d]", ""));
						}
					}
				});
				ResultSet Rs = MyData.Mystat.executeQuery("select max(Number) from orders");
				Rs.next();
				OrderID.setText(Rs.getInt(1)+1+"");
				Rs = MyData.Mystat.executeQuery("select * from orders where ItemDecribtion <> 'null'");
				while(Rs.next()) {
					RepObList.add(Rs.getString("ItemDecribtion"));
				}
						RepList.setItems(RepObList);
						
				
			}

		@FXML
		private void onEnterAnchorpan2() throws SQLException {
				if (Name.getText().equals("") == true || Category.getText().equals("") == true
						|| Color.getText().equals("") == true || Size.getText().equals("") == true) {
					Alert alert = new Alert(Alert.AlertType.ERROR);
					alert.setContentText("Item Doesn't Exist");
					alert.setHeaderText(null);
					alert.showAndWait();
				} else {
					Item Passer = null;
					if (Prices.getSelectedToggle().equals(Price2) == true) {
						Passer = new Item(Integer.parseInt(Code.getText()), Name.getText(), Category.getText(), Color.getText(),
								Size.getText(),
								Integer.parseInt(MyData.GetColoumn("items", "Price2",
										"category = '" + Category.getText() + "'" + " and Name = '" + Name.getText() + "'"
												+ " and Color = '" + Color.getText() + "'" + " and Size = '" + Size.getText()
												+ "'")
										.get(0)),
								Integer.parseInt(MyData.GetColoumn("items", "Price2",
										"category = '" + Category.getText() + "'" + " and Name = '" + Name.getText() + "'"
												+ " and Color = '" + Color.getText() + "'" + " and Size = '" + Size.getText()
												+ "'")
										.get(0)));
					}
					if (Prices.getSelectedToggle().equals(Price1) == true) {
						Passer = new Item(Integer.parseInt(Code.getText()), Name.getText(), Category.getText(), Color.getText(),
								Size.getText(),
								Integer.parseInt(MyData.GetColoumn("items", "Price1",
										"category = '" + Category.getText() + "'" + " and Name = '" + Name.getText() + "'"
												+ " and Color = '" + Color.getText() + "'" + " and Size = '" + Size.getText()
												+ "'")
										.get(0)),
								Integer.parseInt(MyData.GetColoumn("items", "Price2",
										"category = '" + Category.getText() + "'" + " and Name = '" + Name.getText() + "'"
												+ " and Color = '" + Color.getText() + "'" + " and Size = '" + Size.getText()
												+ "'")
										.get(0)));
					}
					ViewList.add(Passer);
					OrdersTableView.setItems(ViewList);
					Code.setText("");
					Name.setText("");
					Category.setText("");
					Color.setText("");
					Size.setText("");
					TotalToBePaid += Passer.getPrice1();
					Total.setText(String.valueOf(TotalToBePaid));
					CurrentLabel.setText("");
					PriceLabel.setText("");
					MyData.Mystat.executeUpdate(
							"UPDATE items SET Current = Current -1 WHERE Code = " + Passer.getCode() + " and Current > 0");
					MyData.Mystat.executeUpdate("UPDATE items SET Sold = Sold + 1 WHERE Code = " + Passer.getCode());

				}
			}
		@FXML
		private void onEnterAnchorpan(KeyEvent ke) throws SQLException {
			// Discount here
				if (ke.getCode().toString().equals("CONTROL") == true) {
					if (RepCheckBox.isSelected() == true) {
						RepCheckBox.setSelected(false);
						CallRepresentative();
						CSName.requestFocus();
					} else {
						RepCheckBox.setSelected(true);
						CallRepresentative();
						Representative.requestFocus();
					}
				}
				if (ke.getCode().toString().equals("DELETE") == true) {
					MyData.Mystat.executeUpdate("UPDATE items SET Current = Current + 1 WHERE Code = "
							+ OrdersTableView.getSelectionModel().getSelectedItem().getCode());
					MyData.Mystat.executeUpdate("UPDATE items SET Sold = Sold - 1 WHERE Code = "
							+ OrdersTableView.getSelectionModel().getSelectedItem().getCode() + " and Sold > 0");
					CurrentLabel.setText("");
					PriceLabel.setText("");
					TotalToBePaid -= OrdersTableView.getSelectionModel().getSelectedItem().getPrice1();
					Total.setText(String.valueOf(TotalToBePaid));
					ViewList.remove(OrdersTableView.getSelectionModel().getSelectedItem());
					OrdersTableView.setItems(ViewList);}
				
			
				if (ke.getCode().toString().equals("ENTER") == true) {
					if (Discount.isFocused()) {TotalToBePaid = TotalToBePaid - Integer.parseInt(Discount.getText()); Total.setText(TotalToBePaid+"");}
					if (Paid.isFocused() == true || Representative.isFocused()==true) {Procced();} 
					else if (Size.isFocused() == true || Price1.isFocused() == true || Price2.isFocused() == true) {
						
						if (CurrentLabel.getText().equals("[0] Pieces") == true) {
							Alert alert = new Alert(Alert.AlertType.ERROR);
							alert.setContentText("Item not Avaiable!!");
							alert.setHeaderText(null);
							alert.showAndWait();
							Code.setText("");
							Name.setText("");
							Category.setText("");
							Color.setText("");
							Size.setText("");
							Code.requestFocus();
							PriceLabel.setText("");
							CurrentLabel.setText("");					
						}
						else {
						if (Name.getText().equals("") == true || Category.getText().equals("") == true
								|| Color.getText().equals("") == true || Size.getText().equals("") == true) {
							Alert alert = new Alert(Alert.AlertType.ERROR);
							alert.setContentText("Missing Information");
							alert.setHeaderText(null);
							alert.showAndWait();
						}

						Item Passer = null;
						if (Prices.getSelectedToggle().equals(Price2) == true) {
							Passer = new Item(Integer.parseInt(Code.getText()), Name.getText(), Category.getText(),
									Color.getText(), Size.getText(),
									Integer.parseInt(MyData.GetColoumn("items", "Price2",
											"category = '" + Category.getText() + "'" + " and Name = '" + Name.getText() + "'"
													+ " and Color = '" + Color.getText() + "'" + " and Size = '"
													+ Size.getText() + "'")
											.get(0)),
									Integer.parseInt(MyData.GetColoumn("items", "Price2",
											"category = '" + Category.getText() + "'" + " and Name = '" + Name.getText() + "'"
													+ " and Color = '" + Color.getText() + "'" + " and Size = '"
													+ Size.getText() + "'")
											.get(0)));
						}
						if (Prices.getSelectedToggle().equals(Price1) == true) {
							Passer = new Item(Integer.parseInt(Code.getText()), Name.getText(), Category.getText(),
									Color.getText(), Size.getText(),
									Integer.parseInt(MyData.GetColoumn("items", "Price1",
											"category = '" + Category.getText() + "'" + " and Name = '" + Name.getText() + "'"
													+ " and Color = '" + Color.getText() + "'" + " and Size = '"
													+ Size.getText() + "'")
											.get(0)),
									Integer.parseInt(MyData.GetColoumn("items", "Price2",
											"category = '" + Category.getText() + "'" + " and Name = '" + Name.getText() + "'"
													+ " and Color = '" + Color.getText() + "'" + " and Size = '"
													+ Size.getText() + "'")
											.get(0)));
						}
						ViewList.add(Passer);
						OrdersTableView.setItems(ViewList);
						Code.setText("");
						Name.setText("");
						Category.setText("");
						Color.setText("");
						Size.setText("");
						TotalToBePaid += Passer.getPrice1();
						Total.setText(String.valueOf(TotalToBePaid));
						MyData.Mystat.executeUpdate(
								"UPDATE items SET Current = Current -1 WHERE Code = " + Passer.getCode() + " and Current > 0");
						MyData.Mystat.executeUpdate("UPDATE items SET Sold = Sold + 1 WHERE Code = " + Passer.getCode());
						Code.requestFocus();
						PriceLabel.setText("");
						CurrentLabel.setText("");}
					} else if (Code.isFocused() == true) {
						if (Code.getText().equals("") == true) {
							Alert alert = new Alert(Alert.AlertType.ERROR);
							alert.setContentText("Enter Code!");
							alert.setHeaderText(null);
							alert.showAndWait();
						} else if (MyData.GetColoumn("items", "Code", "Code = '" + Integer.parseInt(Code.getText()) + "'")
								.isEmpty() == true) {
							Alert alert = new Alert(Alert.AlertType.ERROR);
							alert.setContentText("Item Doesn't Exist");
							alert.setHeaderText(null);
							alert.showAndWait();
							Code.setText("");
						} else {
							Category.setText(
									MyData.GetColoumn("items", "Category", "Code = '" + Integer.parseInt(Code.getText()) + "'")
											.get(0));
							Name.setText(MyData.GetColoumn("items", "Name", "Code = '" + Integer.parseInt(Code.getText()) + "'")
									.get(0));
							Color.setText(MyData
									.GetColoumn("items", "Color", "Code = '" + Integer.parseInt(Code.getText()) + "'").get(0));
							Size.setText(MyData.GetColoumn("items", "Size", "Code = '" + Integer.parseInt(Code.getText()) + "'")
									.get(0));
							Size.requestFocus();
							Sizesuggestions();
						}
					} else if (PhoneNumber.isFocused() == true) {
						if (MyData.GetColoumn("customer", "Phone", "Phone = " + PhoneNumber.getText()).isEmpty() == true
								|| PhoneNumber.getText().equals("") == true) {
							Alert alert = new Alert(Alert.AlertType.ERROR);
							alert.setContentText("Customer Doesn't Exist!");
							alert.setHeaderText(null);
							alert.showAndWait();
							flag = 0;
						} else {
							flag = 1;
							CSName.setText(MyData.GetColoumn("customer", "Name", "Phone = " + PhoneNumber.getText()).get(0));
							Address.setText(
									MyData.GetColoumn("customer", "Address", "Phone = " + PhoneNumber.getText()).get(0));
							CSFacebookName.setText(
									MyData.GetColoumn("customer", "FacebookName", "Phone = " + PhoneNumber.getText()).get(0));
							PreviousBalance.setText(MyData
									.GetColoumn("customer", "PreviousBalance", "Phone = " + PhoneNumber.getText()).get(0));
							Paid.requestFocus();
						}

					}

				}
				if (ke.getCode().toString().equals("ALT")) {
					if (PhoneNumber.isFocused() == false) {
						PhoneNumber.requestFocus();
					}
				}
			}

		@FXML
		private void Procced() throws SQLException {
				if (CSName.getText().equals("") == true || CSFacebookName.getText().equals("") == true
						|| Address.getText().equals("") == true || PhoneNumber.getText().equals("") == true
						|| Discount.getText().equals("") == true || Paid.getText().equals("") == true) {

					Alert alert = new Alert(Alert.AlertType.ERROR);
					alert.setContentText("Missing Customer's Information");
					alert.setHeaderText(null);
					alert.showAndWait();
				}

				if (Integer.parseInt(Discount.getText()) > Integer.parseInt(Total.getText())) {
					Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
					alert.setContentText("Discount value bigger than total!"+"\n"+"Proceed?");
					alert.setHeaderText(null);
					alert.showAndWait();}

					int balance = -Integer.parseInt(Paid.getText()) - Integer.parseInt(Discount.getText()) + Integer.parseInt(Total.getText())
							+ Integer.parseInt(PreviousBalance.getText());
					if (flag == 0) {
						MyData.Mystat.executeUpdate("INSERT INTO customer values('" + CSName.getText() + "' ,"
								+ PhoneNumber.getText() + "," + "'" + Address.getText() + "' ,'" + CSFacebookName.getText()
								+ "' ," + balance + ", false ,'" + java.time.LocalDate.now() + "')");
					} else if (flag == 1) {
						MyData.Mystat.executeUpdate("UPDATE customer SET VisitDate = '" + java.time.LocalDate.now()
								+ "', PreviousBalance = "+ balance + " WHERE Phone =" + PhoneNumber.getText());
					}
					flag = 0;
					MyData.Mystat.executeUpdate(
							"insert into Orders(Name,Mobile,Address,FacebookName,Date,ItemDecribtion,Paid,Discount) values('"
									+ CSName.getText() + "'," + PhoneNumber.getText() + ",'" + Address.getText() + "','"
									+ CSFacebookName.getText() + "','" + java.time.LocalDate.now() + "','" + "null" + "',"
									+ Paid.getText() + "," + Discount.getText() + ")");
					ArrayList<Integer> pass = new ArrayList<Integer>();
					int i = 0;
					while(code.getCellData(i) != null) {
					pass.add(code.getCellData(i));i++;}
					MyData.Mystat.executeUpdate("INSERT INTO rep(OrderNumber,Items,NumberOfItems) values( "+OrderID.getText()+", '"+pass.toString()+"' , "+pass.size()+" )");
					
					
					ViewList.clear();
					OrdersTableView.setItems(ViewList);
					TotalToBePaid = 0;
					
					if (RepCheckBox.isSelected() == true) {
						MyData.Mystat.executeUpdate("UPDATE Orders SET ItemDecribtion = '" + Representative.getText() + "  "+ PhoneNumber.getText() + "  " + "  " + Name.getText() + "  " + Address.getText() +"  "+"~"+OrderID.getText()+"~ '"+ " WHERE Number = "+ OrderID.getText());
						ResultSet myRS = MyData.Mystat.executeQuery("select * from Orders Where Number ="+ OrderID.getText());
						myRS.next();
						RepObList.add(myRS.getString("ItemDecribtion"));
						RepList.setItems(RepObList);
						Representative.setText("");
						Representative.setVisible(false);
						RepCheckBox.setSelected(false);
									}

				
					ResultSet myRS = MyData.Mystat.executeQuery("select max(Number) from orders");
					myRS.next();
					OrderID.setText(myRS.getInt(1)+1+"");
					
				CSName.setText("");
				CSFacebookName.setText("");
				PhoneNumber.setText("");
				Address.setText("");
				PreviousBalance.setText("0");
				Discount.setText("0");
				Paid.setText("");
				Total.setText("0");
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setContentText("Order Saved !");
				alert.setHeaderText(null);
				alert.showAndWait();
				

			}

			@FXML
		private void Sizesuggestions() throws SQLException {
				ArrayList<String> Suggestions = new ArrayList<>();
				Suggestions = MyData.GetColoumn("items", "Size", "category = '" + Category.getText() + "'" + " and Name = '"
						+ Name.getText() + "'" + " and Color = '" + Color.getText() + "'");
				TextFields.bindAutoCompletion(Size, Suggestions);
				if (MyData
						.GetColoumn("items", "Code",
								"category = '" + Category.getText() + "'" + " and Name = '" + Name.getText() + "'"
										+ " and Color = '" + Color.getText() + "'" + " and Size = '" + Size.getText() + "'")
						.isEmpty() == true) {
				} else {
					Code.setText(MyData
							.GetColoumn("items", "Code",
									"category = '" + Category.getText() + "'" + " and Name = '" + Name.getText() + "'"
											+ " and Color = '" + Color.getText() + "'" + " and Size = '" + Size.getText() + "'")
							.get(0));
				}
				if (Prices.getSelectedToggle().equals(Price1) == true) {
					PriceLabel.setText(MyData
							.GetColoumn("items", "Price1",
									"category = '" + Category.getText() + "'" + " and Name = '" + Name.getText() + "'"
											+ " and Color = '" + Color.getText() + "'" + " and Size = '" + Size.getText() + "'")
							.toString() + " L.E");
				}
				if (Prices.getSelectedToggle().equals(Price2) == true) {
					PriceLabel.setText(MyData
							.GetColoumn("items", "Price2",
									"category = '" + Category.getText() + "'" + " and Name = '" + Name.getText() + "'"
											+ " and Color = '" + Color.getText() + "'" + " and Size = '" + Size.getText() + "'")
							.toString() + " L.E");
				}
				CurrentLabel.setText(MyData
						.GetColoumn("items", "Current",
								"category = '" + Category.getText() + "'" + " and Name = '" + Name.getText() + "'"
										+ " and Color = '" + Color.getText() + "'" + " and Size = '" + Size.getText() + "'")
						.toString() + " Pieces");
			}

			@FXML
			private void Categorysuggestions() throws SQLException {
				ArrayList<String> Suggestions = new ArrayList<>();
				Suggestions = MyData.GetColoumn("items", "Category", null);
				TextFields.bindAutoCompletion(Category, Suggestions);

			}

			@FXML
			private void ColorSuggestions() throws SQLException {
				ArrayList<String> Suggestions = new ArrayList<>();
				Suggestions = MyData.GetColoumn("items", "Color",
						"category = '" + Category.getText() + "'" + " and Name = '" + Name.getText() + "'");
				TextFields.bindAutoCompletion(Color, Suggestions);

			}

			@FXML
			private void Namesuggestions() throws SQLException {
				ArrayList<String> Suggestions = new ArrayList<>();
				Suggestions = MyData.GetColoumn("items", "Name", "category = '" + Category.getText() + "'");
				TextFields.bindAutoCompletion(Name, Suggestions);

			}

			private Statement Connect() throws SQLException {
				Connection MyConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/marshiastores", "root",
						"Swimnread98@");
				Statement MyStatment = MyConnection.createStatement();
				return MyStatment;
			}

			@Override
			public void initialize(URL arg0, ResourceBundle arg1) {
				try {
					StartUp(Connect());
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}


		}

