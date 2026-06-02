package com.user.genericfunctions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class databaseConnection {
	
	
	public List<List<String>> getdatafromdb(String query) {

		List<List<String>> result = new ArrayList<>();
		try (Connection con = connectdatabase();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query);) {
			
			
			int columnCount = rs.getMetaData().getColumnCount();

	        while (rs.next()) {

	            List<String> row = new ArrayList<>();

	            for (int i = 1; i <= columnCount; i++) {
	                row.add(rs.getString(i));
	            }

	            result.add(row);
	        }
			

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
	
	public Connection connectdatabase() {

        String url =
            "jdbc:postgresql://localhost:5432/studentdb";

        String username = "postgres";
        String password = "dev@123";
        Connection con;
        try {
        	Class.forName("org.postgresql.Driver");
        	
            con =
                DriverManager.getConnection(
                    url,
                    username,
                    password
                );

            System.out.println("Connected Successfully");
            return con;

        } catch(Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }

}
