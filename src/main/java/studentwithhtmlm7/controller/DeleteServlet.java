package studentwithhtmlm7.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentwithhtmlm7.dao.StudentDao;
import studentwithhtmlm7.dto.Student;

public class DeleteServlet extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id=Integer.parseInt(req.getParameter("id"));
	
	StudentDao dao=new StudentDao();
	Student student=dao.deleteStudentById(id);
	PrintWriter printWriter=resp.getWriter();
	if(student!=null) {
//		student id is present and deleted successfully
		printWriter.print("Data deleted sueccessfully");
	}else {
		printWriter.print("Sorry Id is not present");
	}
	
	
	
	
}
}
