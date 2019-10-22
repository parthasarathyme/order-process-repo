package coms.etisalat.ops.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import coms.etisalat.ops.domain.User;
import coms.etisalat.ops.exception.UserException;
import coms.etisalat.ops.service.UserService;
import coms.etisalat.ops.service.UserServiceImpl;

@WebServlet("/register")
public class UserRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService service=new UserServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		try {
			User user=new User();
			populateUser(request,user);
			int n= service.addNewUser(user);
			out.println("<html><body><h1>"+"User:"+n+" added to database");
			out.println("</h1></body></html>");			
		}catch(UserException e) {
			e.printStackTrace();
		}
		
	}

	private void populateUser(HttpServletRequest request, User user) {
		user.setUserName(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setEmail(request.getParameter("email"));
		//user.setCreateDate(LocalDate.now());
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}