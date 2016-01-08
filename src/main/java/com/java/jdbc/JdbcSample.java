package com.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcSample {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		// jdbc:sqlserver://localhost:1433;sendStringParametersAsUnicode=false
		try (Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=XYZ_COMPANY",
				"sa", "$9Lserver"); Statement stmt = conn.createStatement();) {
			try (ResultSet rs = stmt.executeQuery("select * from EMPLOYEE");) {

				List<Employee> empList = new ArrayList<Employee>();
				while (rs.next()) {
					Employee emp = new Employee();
					emp.setId(rs.getString(1));
					emp.setName(rs.getString(2));
					emp.setSalary(rs.getInt(3));
					emp.setDepartment(rs.getString(4));
					empList.add(emp);
				}
			}

		} catch (SQLException sqe) {
			throw sqe;
		}

	}

}
