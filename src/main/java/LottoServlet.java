
import java.io.IOException;
import java.util.Random;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorldServlet
 */
@WebServlet("/GAMBLING")
public class LottoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		Random r = new Random();
		int r1 = r.nextInt(1,42);
		int r2 = r.nextInt(1,42);
		int r3 = r.nextInt(1,42);
		int r4 = r.nextInt(1,42);
		int r5 = r.nextInt(1,42);
		int r6 = r.nextInt(1,42);
		
		
		request.setAttribute("ball1", r1);
		request.setAttribute("ball2", r2);
		request.setAttribute("ball3", r3);
		request.setAttribute("ball4", r4);
		request.setAttribute("ball5", r5);
		request.setAttribute("ball6", r6);
		request.getRequestDispatcher("Lotto.jsp").forward(request, response);
		
		
		
		

	}
	
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().println("<html><body><h1>Hello World</h1></body></html>");
	}*/

}
