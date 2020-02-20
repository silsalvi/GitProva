package creaUtente;
import login.db_connection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class login
 */
@WebServlet("/crea")
public class creaUtente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public creaUtente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			db_connection c = new db_connection();
			Connection con = c.db();
			PrintWriter pw = response.getWriter();
			doGet(request, response);
			String password= request.getParameter("password");
			String user =request.getParameter("username");
			String sql = "INSERT INTO utenti (user,password) VALUES (?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user);
			pstmt.setString(2, password);
			if(pstmt.executeUpdate() > 0)
				pw.print("<html><body><h3>utente inserito.</h3></body></html>");
			else
				pw.print("<html><body><h3>utente non inserito.</h3></body></html>");
		}catch (IllegalArgumentException | SQLException e) {
			e.printStackTrace();
		}
//		PrintWriter pw = response.getWriter();
//		pw.print("evviva");
	}
	
	

}
