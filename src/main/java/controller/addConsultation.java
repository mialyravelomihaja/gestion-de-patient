package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Servlet implementation class addConsultation
 */
@WebServlet("/enregistrer")
public class addConsultation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nomPat = request.getParameter("nom");
		String prenomPat = request.getParameter("prenom");
		String agePat = request.getParameter("age");
		String telPat = request.getParameter("telephone");
		String date = request.getParameter("date");
		String resultat = request.getParameter("resultat");
		RequestDispatcher dispatcher =null;
		Connection con =null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestionConsultation","mialy","Mialy1012!");
			PreparedStatement pst = con.prepareStatement("insert into consultation(nomPat,prenomPat,agePat,telPat,date,resultat) values(?,?,?,?,?,?)");
			pst.setString(1, nomPat);
			pst.setString(2, prenomPat);
			pst.setString(3, agePat);
			pst.setString(4, telPat);
			pst.setString(5, date);
			pst.setString(6, resultat);
			
			int rowCount = pst.executeUpdate();
			dispatcher = request.getRequestDispatcher("registration.jsp");
			if(rowCount >0) {
				request.setAttribute("status", "success");
			}else {
				request.setAttribute("status", "failed");
			}
			
			dispatcher.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
			con.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	

}
