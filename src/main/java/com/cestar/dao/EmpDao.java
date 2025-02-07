package com.cestar.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cestar.model.Employee;

public class EmpDao {

	// This method returns a Connection Object

	public Connection dbConnection() {

		// create a variable of return type Connection named as con

		Connection con = null;

		String url = "jdbc:mysql://localhost:3306/employee_db";

		String user = ""; // Enter database userName

		String pwd = "";  // Enter database password

		// Load the Mysql Driver

		try {
			Class.forName("com.mysql.jdbc.Driver");

			// call the getConnection() method from DriverManager Class
			// and pass the arguments in getConnection()

			con = DriverManager.getConnection(url, user, pwd);

			System.out.println("Connection Successfull Just Chill !!!");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;

	}

	public int insertRec(Employee emp_from_jsp_form) {

		// create a variable of return type int to store status of Query Fired

		int status = 0;

		// Call the dbConnection() Method to connect to db first

		Connection con = dbConnection();

		// Write sql query

		String sql = "insert into employee (id,name,contact,city,email) values (?,?,?,?,?)";

		// For a query with ? marks we use PreparedStatement

		try {

			PreparedStatement pstmt = con.prepareStatement(sql);

			// set the values for ? marks

			pstmt.setInt(1, emp_from_jsp_form.getId());

			pstmt.setString(2, emp_from_jsp_form.getName());

			pstmt.setString(3, emp_from_jsp_form.getContact());

			pstmt.setString(4, emp_from_jsp_form.getCity());

			pstmt.setString(5, emp_from_jsp_form.getEmail());

			// call the executeUpdate()

			status = pstmt.executeUpdate();

			if (status > 0) {

				System.out.println("Record Inserted to db successfully !!!");
			} else {

				System.out.println("Sorry Query Failed Try Again This is Life !!!");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;

	}

	public List<Employee> readRecs() {

		List<Employee> empz = new ArrayList<>();

		// Connect to db using dbConnection() method

		Connection con = dbConnection();

		String sql = "select * from employee";

		// For Select query we use Statement Interface

		try {
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {

				Employee emp_from_top_row = new Employee(rs.getInt("id"), rs.getString("name"), rs.getString("contact"),
						rs.getString("city"), rs.getString("email"));

				empz.add(emp_from_top_row);
			}

			System.out.println(empz);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return empz;

	}

	public Employee getRecbyId(int id_from_edit_btn) {

		Employee emp_to_edit = null;

		// connect to db

		Connection con = dbConnection();

		String sql = "select * from employee where id = ?";

		// For a query with ? mark we use Prepared Statement

		try {
			PreparedStatement pstmt = con.prepareStatement(sql);

			// set the values for ? marks

			pstmt.setInt(1, id_from_edit_btn);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {

				emp_to_edit = new Employee(rs.getInt("id"), rs.getString("name"), rs.getString("contact"),
						rs.getString("city"), rs.getString("email"));

				System.out.println(emp_to_edit);
			} else {

				System.out.println("Employee Record Not Found !!!");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp_to_edit;

	}

	public int updateRecById(int id_from_session, Employee updated_emp_from_update_dot_jsp) {

		int status = 0;

		Connection con = dbConnection();

		String sql = "update employee set id=? ,name=? ,contact=?,city=?,email=? where id=? ";

		try {

			PreparedStatement pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, updated_emp_from_update_dot_jsp.getId());

			pstmt.setString(2, updated_emp_from_update_dot_jsp.getName());

			pstmt.setString(3, updated_emp_from_update_dot_jsp.getContact());

			pstmt.setString(4, updated_emp_from_update_dot_jsp.getCity());

			pstmt.setString(5, updated_emp_from_update_dot_jsp.getEmail());

			pstmt.setInt(6, id_from_session);

			status = pstmt.executeUpdate();

			if (status > 0) {

				System.out.println("Record Updated");
			} else {

				System.out.println("Try Try Again This is Java");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;

	}

	public int deleteRec(int id_from_delete_btn) {

		int status = 0;

		Connection con = dbConnection();

		String sql = "delete from employee where id=? ";

		try {
			PreparedStatement pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, id_from_delete_btn);

			status = pstmt.executeUpdate();

			if (status > 0) {

				System.out.println("Record Deleted Successfully !!!");
			} else {

				System.out.println("Delete Query Failed !!!");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;

	}

}
