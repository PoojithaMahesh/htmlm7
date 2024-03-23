package studentwithhtmlm7.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import studentwithhtmlm7.dao.StudentDao;
import studentwithhtmlm7.dto.Student;

public class LoginServlet extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String email=req.getParameter("email");
	String password=req.getParameter("password");
	StudentDao dao=new StudentDao();
	List<Student> students=dao.getAllStudents();
	boolean value=false;
	String dbPassword=null;
	for(Student student:students) {
		if(email.equals(student.getEmail())) {
			value=true;
			dbPassword=student.getPassword();
			break;
		}
	}
	PrintWriter printWriter=resp.getWriter();
//	value=true email is exist with the student present in the database	
	if(value) {
//		value=true email exist then i need to check with the password
        if(password.equals(dbPassword)) {
//        	password matches
        	resp.sendRedirect("https://www.javatpoint.com/java-tutorial");
        }else {
        	RequestDispatcher dispatcher=req.getRequestDispatcher("login.html");
        	dispatcher.forward(req, resp);
        }
	}else {
//		value=false
		RequestDispatcher dispatcher=req.getRequestDispatcher("login.html");
    	dispatcher.forward(req, resp);
	}
	
	
	
	
	
	
	
	
}
}
