package Marshia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Database {
	Statement Mystat;
public Database(Statement Mystatement) {
	Mystat = Mystatement;
}


public ArrayList<String> GetColoumn(String TableName,String ColoumnName,String Condition) throws SQLException {
	    ResultSet myRS; 
		ArrayList<String> passer = new ArrayList<String>();
		if(Condition==null) { myRS = Mystat.executeQuery("select DISTINCT "+ColoumnName+" from "+TableName);}
		else { myRS = Mystat.executeQuery("select DISTINCT "+ColoumnName+" from "+TableName+" where "+Condition);}
       while(myRS.next()) {passer.add(myRS.getString(ColoumnName));}
    	return passer;	
	}
}
