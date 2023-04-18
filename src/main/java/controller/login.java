package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class login
 */
//@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String utilisateur = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher=null;
		Connection con;
		System.out.println("here");
		
		try {
			System.out.println("1: "+utilisateur+" "+password);
			Class.forName("com.mysql.cj.jdbc.Driver");
			//System.out.println("2");
			con =DriverManager.getConnection("jdbc:mysql://localhost:3306/gestionConsultation","mialy","Mialy1012!");
			//System.out.println("3");
			PreparedStatement pst = con.prepareStatement("select * from admin where utilisateur = ? and password = ?");
			pst.setString(1, utilisateur);
			pst.setString(2, password);
			//System.out.println("4");
			ResultSet rs = pst.executeQuery();
//			System.out.println("Test: "+rs.getString("utilisateur"));
			
			while(rs.next()) {
				if(rs.getString("utilisateur").equals(utilisateur) && rs.getString("password").equals(password)) {
					session.setAttribute("nom", rs.getString("utilisateur"));
					dispatcher = request.getRequestDispatcher("index.jsp");
				}else {
					request.setAttribute("status", "failed");
					dispatcher = request.getRequestDispatcher("login.jsp");
				}
			}
			
//			if(rs.next()) {
//				session.setAttribute("nom", rs.getString("nomPat"));
//				dispatcher = request.getRequestDispatcher("index.jsp");
//				
//			}else {
//				
//				request.setAttribute("status", "failed");
//				dispatcher = request.getRequestDispatcher("login.jsp");
//			}
			dispatcher.forward(request, response);
			
		}catch(Exception e) {
			System.out.println(e);
			
		}
	}

}
