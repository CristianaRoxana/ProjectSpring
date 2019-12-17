package com.servlets;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
/**
 * Servlet implementation class LoginServlet
 */
import com.admin.*;
import com.admin.dao.AdminDAO;
import com.admin.dao.impl.JdbcAdminDAO;
import com.admin.model.Admin;



@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
@Autowired
AdminDAO adminDAO;
private WebApplicationContext webApplicationContext;
    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
	   // adminDAO=(AdminDAO)context.getBean("AdminDAO");
	   
	   
			//HttpSession session=request.getSession();
			//session.setAttribute("name", name);
			//response.sendRedirect("home.jsp");
			
		/*RequestDispatcher requestDispatcher;
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Admin admin1=adminDAO.getAdmin(email, password);
		
		
		
		if(email.equals("roxana@yahoo.com")) {
			//HttpSession session=request.getSession();
			//session.setAttribute("name", name);
			//response.sendRedirect("home.jsp");
			response.getWriter().append("LOGIN ADMINISTRATOR SUCCESSFULLY");
		}
		else
		{
			//response.getWriter().append("ERROR LOGIN ");	
			response.sendRedirect("logout.jsp");
		}
		

		ApplicationContext context = 
        		new ClassPathXmlApplicationContext("Spring-Module.xml");
        	 
            CustomerDAO customerDAO = (CustomerDAO) context.getBean("customerDAO");
          // Customer customer = new Customer(1, "mkyong",28);
            Customer customer = new Customer(9, "numept7",9);
            customerDAO.insert(customer);
        	
            Customer customer1 = customerDAO.findByCustomerId(7);
          
            System.out.println(customer1.getCustId());
            System.out.println(customer1.getAge());
            System.out.println((customer1.getName()).toString());
            
            
            
    }*/
		int k=0;
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		 AdminDAO adminDAO =( AdminDAO)context.getBean("AdminDAO");
		 Admin admin=new Admin();
		 //adminDAO.insert(admin);
		 //adminDAO.findByAdminId(admin.getAdmId());
		 adminDAO.getAdmin(email, password);
		//admin.setAdminId(k);k++;
         admin.setEmail(email);
         admin.setPassword(password);
         //adminDAO.insert(admin);
		
       PrintWriter out = response.getWriter();  
        //System.out.println(admin.getEmail());
       // System.out.println(admin.getPassword());
     String adminEmail="roxana@yahoo.com";
     String parola="roxana";
         if(email.equalsIgnoreCase(adminEmail) && password.equalsIgnoreCase(parola)) {//response.getWriter().append("LOGIN ADMINISTRATOR SUCCESSFULLY");
        	// adminDAO.delete(admin); 
        	// response.getWriter().append("LOGIN ADMINISTRATOR SUCCESSFULLY");
        	 
        	 adminDAO.getAdmin(email, password);
        	 out.print("Buna Adminule     "+ admin.getEmail()+" ");out.print(admin.getPassword());// request.getRequestDispatcher("home.jsp").forward(request, response);
         }
     	else
		{
			//response.getWriter().append("ERROR LOGIN ");	
			response.sendRedirect("logout.jsp");
		}
	
	}

	}


