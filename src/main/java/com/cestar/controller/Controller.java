package com.cestar.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.cestar.dao.EmpDao;
import com.cestar.model.Employee;

@WebServlet("/")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	EmpDao dao = new EmpDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		response.setContentType("text/html");

		String url = request.getServletPath();

		switch (url) {

		case "/create": {

			create(request, response);

			break;
		}

		case "/read": {

			read(request, response);

			break;
		}

		case "/edit": {

			edit(request, response);

			break;
		}

		case "/update": {

			update(request, response);

//			out.print("<h2 style='color:red;'>Servlet URL : " + url + "</h2><br>");
//			out.print("<h2 style='color:red;'>Welcome From Update Record Page !!!</h2>");
			break;
		}

		case "/delete": {

			delete(request, response);

			break;
		}

		}

	}

	protected void create(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		response.setContentType("text/html");

		int id = Integer.parseInt(request.getParameter("e_id"));

		String name = request.getParameter("e_name");

		String contact = request.getParameter("e_con");

		String city = request.getParameter("e_city");

		String email = request.getParameter("e_email");

		// Now Pass these variables to Employee Contructor to create a new Employee
		// Object

		Employee emp_from_form = new Employee(id, name, contact, city, email);

		// Create the Object of EmpDao to call its method insertRecord()

		EmpDao dao = new EmpDao();

		// pass emp_from_form to isertRec() method as argument

		int status = dao.insertRec(emp_from_form);

		if (status > 0) {

			out.print("<h2 style='color:green;text-align:center;'> Record Saved to db successfully!! </h2>");
		} else {

			out.print("<h2 style='color:red;text-align:center;'>Query Failed due to an error</h2>");
		}

	}

	// 1- get the Employee Records from dao class
	// 2- create an HTTP Session Object
	// 3- set the employee data as attribute to Http Session Object
	// 4- send the User to Display.jsp page

	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// call the dao class readRecd() to get data of Employees from db

		List<Employee> empz_list = dao.readRecs();

		// create HttpSession Object to store and pass data to web pages

		HttpSession session = request.getSession();

		// pass this list to HttpSession as an attribte

		session.setAttribute("empz_from_db", empz_list);

		// send the user to display.jsp page

		RequestDispatcher rd = request.getRequestDispatcher("display.jsp");

		rd.forward(request, response);

	}

	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id_from_edit_btn = Integer.parseInt(request.getParameter("emp_id"));

		// pass this id as argument to dao.getRecById()

		Employee emp_to_edit = dao.getRecbyId(id_from_edit_btn);

		// Create HttpSession Object

		HttpSession session = request.getSession();

		session.setAttribute("employee_to_edit", emp_to_edit);

		session.setAttribute("current_id", id_from_edit_btn);

		RequestDispatcher rd = request.getRequestDispatcher("edit.jsp");

		rd.forward(request, response);

	}

	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("e_id"));

		String name = request.getParameter("e_name");

		String contact = request.getParameter("e_con");

		String city = request.getParameter("e_city");

		String email = request.getParameter("e_email");

		// Now Pass these variables to Employee Contructor to create a new Employee
		// Object

		Employee updated_emp = new Employee(id, name, contact, city, email);

		// get the old id of this employee from HttpSession Object

		HttpSession session = request.getSession();

		int old_id_from_session = (int) session.getAttribute("current_id");

		// Create the Object of EmpDao to call its method updateRecById
		// and pass two arguments updated_emp and old_id_from_session

		EmpDao dao = new EmpDao();

		dao.updateRecById(old_id_from_session, updated_emp);

		read(request, response);

	}

	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id_to_del = Integer.parseInt(request.getParameter("emp_id"));

		// call the dao class delete method and pass this id_to_del as argument

		dao.deleteRec(id_to_del);

		read(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
