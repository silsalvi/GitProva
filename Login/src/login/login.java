package login;

import java.io.IOException;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    
        // Initialize all the information regarding 
        // Database Connection 
      
    

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
		// TODO Auto-generated method stub
		doGet(request, response);
		String password= request.getParameter("password");
		String user =request.getParameter("username");
		System.out.println("User:"+user+"\npassword:"+password);
		
		db_connection c = new db_connection();
		Connection con = c.db();
		try {
			Statement st = con.createStatement();
			String sql = "SELECT * FROM utenti where user='"+user+"' && password='"+password+"'";
			System.out.println(sql);
			ResultSet rs;
			rs = st.executeQuery(sql);
			if(rs.next()) 
			{ 
				System.out.print("ok");
				response.getWriter().append("Acceso consentito");
				response.sendRedirect("benvenuto.html");

			} 
			else 
			{
				System.out.print("no ok");

				response.getWriter().append("Accesso negato");
			}
		} catch (SQLException s) {
			
		}
		
	}

}
