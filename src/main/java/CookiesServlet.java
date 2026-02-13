
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Cookie;

/**
 * Servlet implementation class HelloWorldServlet
 */
@WebServlet("/Cookie")
public class CookiesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = null;
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("user".equals(cookie.getName())) {
                    name = cookie.getValue();
                    break;
                }
            }
        }

        request.setAttribute("username", name);
        request.getRequestDispatcher("/Login.jsp").forward(request, response);
    }
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String name = "a";
		String password = "b";
		
		String inputName = request.getParameter("name");
		String inputPassword = request.getParameter("password");
		
		if(password.equals(inputPassword) && name.equals(inputName)) {
			System.out.println("Hallo "+name);
			Cookie namecookie = new Cookie("user", name);
			namecookie.setMaxAge(30);
			response.addCookie(namecookie);
		}
		response.sendRedirect("Cookie");	
	}
	
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().println("<html><body><h1>Hello World</h1></body></html>");
	}*/

}
