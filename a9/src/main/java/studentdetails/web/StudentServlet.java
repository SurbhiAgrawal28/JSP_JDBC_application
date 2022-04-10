package studentdetails.web;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentdetails.bean.Student;
import studentdetails.database.StudentDao;


@WebServlet("/")
public class StudentServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
    private StudentDao userDAO;

    public void init() {
        userDAO = new StudentDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertUser(request, response);
                    break;
                case "/delete":
                    deleteUser(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateUser(request, response);
                    break;
                default:
                    listUser(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
    	System.out.println("Check");
        List < Student > listUser = userDAO.selectAllUsers();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Student existingUser = userDAO.selectUser(id);
        System.out.println(existingUser.getCgpa());
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
        request.setAttribute("user", existingUser);
        dispatcher.forward(request, response);

    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
    	String empName = request.getParameter("sName");
        String empId = request.getParameter("sId");
        String dob = request.getParameter("dob");
        String dept = request.getParameter("dept");
        String semester = request.getParameter("semester");
        String spec = request.getParameter("spec");
        String cgpa = request.getParameter("cgpa");

        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
		try {
			date = formatter.parse(dob);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        Student employee = new Student(empName, Integer.parseInt(empId), date, dept, Integer.parseInt(semester), spec, Double.parseDouble(cgpa));
        

        try {
            userDAO.insertUser(employee);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        response.sendRedirect("list");
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
    	String empName = request.getParameter("sName");
        String empId = request.getParameter("sId");
        String dob = request.getParameter("dob");
        String dept = request.getParameter("dept");
        String semester = request.getParameter("semester");
        String spec = request.getParameter("spec");
        String cgpa = request.getParameter("cgpa");

        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
		try {
			date = formatter.parse(dob);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        Student employee = new Student(empName, Integer.parseInt(empId), date, dept, Integer.parseInt(semester), spec, Double.parseDouble(cgpa));
        System.out.println(employee.getCgpa());
        userDAO.updateUser(employee);
        System.out.println("User updated");
        response.sendRedirect("list");
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        userDAO.deleteUser(id);
        response.sendRedirect("list");

    }

}
