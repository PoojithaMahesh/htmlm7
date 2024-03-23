package studentwithhtmlm7.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentwithhtmlm7.dao.StudentDao;
import studentwithhtmlm7.dto.Student;

public class UpdateServlet extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
Student student=new Student();
student.setAddress(req.getParameter("address"));
student.setEmail(req.getParameter("email"));
student.setName(req.getParameter("name"));
student.setPassword(req.getParameter("password"));
student.setPhone(Long.parseLong(req.getParameter("phone")));

PrintWriter printWriter=resp.getWriter();

StudentDao dao=new StudentDao();
Student dbStudent=dao.updateStudent(Integer.parseInt(req.getParameter("id")),student);
if(dbStudent!=null) {
	printWriter.print("Data Updated Successfully");
}else {
	printWriter.print("Sorry Id Is not present");
}



}
}
