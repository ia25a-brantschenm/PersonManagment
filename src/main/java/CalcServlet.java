
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorldServlet
 */
@WebServlet("/calc")
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @throws ServletException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String num1 = request.getParameter("nr1");
		String num2 = request.getParameter("nr2");
		String op = request.getParameter("op");
		
		Integer nr1 = null, nr2 = null, result = null;
		String error = null;
		
		try {
			nr1 = Integer.parseInt(num1);
			nr2 = Integer.parseInt(num2);
		
		
		switch(op) {
			case "/":
				if(nr2 != 0) {
					result = nr1 / nr2;
				} else {
					System.out.println("Bro....   ._.");
					error = "Nah this cant be 0frfr";
				}
				
				break;
			case "-":
				result=  nr1 - nr2;
				break;
			case "+":
				result = nr1 + nr2;
				break;
			case "*":
				result = nr1 * nr2;
				break;
			case "%":
				result = nr1 % nr2;	
				break;
			default:
				error = "Wrong op";
				break;
		}
		}catch(NumberFormatException e) {
			error = "Enter real thing";
		}
		
		request.setAttribute("nr1", nr1);
		request.setAttribute("nr2", nr2);
		request.setAttribute("op", op);
		request.setAttribute("result", result);
		request.getRequestDispatcher("Res.jsp").forward(request, response);
		
		
		
		

	}
	
	
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().println("<html><head><Title>Buzz</Title><link rel='stylesheet' type='text/css' href='Style.css'></head><body><h1>Zeug eingeben</h1>"
				+ "        <form>\r\n"
				+ "            <label for=\"nr1\">Number 1 :</label>\r\n"
				+ "            <input type=\"number\" id=\"nr1\" name=\"nr1\"><br><br>\r\n"
				+ "            <label for=\"nr2\">Number 2 :</label>\r\n"
				+ "            <input type=\"number\" id=\"nr2\" name=\"nr2\"><br><br>\r\n"
				+ "            <label for=\"op\">Operator:</label>\r\n"
				+ "            <input type=\"text\" id=\"op\" name=\"op\"><br><br>\r\n"
				+ "            <input type=\"submit\" value=\"Submit\">\r\n"
				+ "        </form>"
				+ "</body></html>");
	}*/

}
