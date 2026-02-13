

import java.io.IOException;

import java.util.List;
import java.util.ArrayList;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorldServlet
 */
@WebServlet("/Liste")
public class ListeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	public ArrayList<String> tester() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Marco");
		names.add("David");
		names.add("Giona");
		names.add("Christian");
		
		for(String name : names) {
			System.out.println(name);
		}
		return names;
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().println("<html><body><h1>"+ tester()+ "</h1>"
				+ ""
				+ ""
				+ "</body></html>");
	}

}
