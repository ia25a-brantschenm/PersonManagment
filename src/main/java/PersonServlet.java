
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.Period;

/**
 * Servlet implementation class HelloWorldServlet
 */
@WebServlet("/Buzzcut")
public class PersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public String MAKENAMEBIG(HttpServletRequest request){
		String stringo = request.getParameter("name");
		if (stringo != null && !stringo.isBlank()) {
			return stringo.toUpperCase();
		}
		else {
			return "no Name Provided";
		}
	}
	
	public String age(HttpServletRequest request){
		String datum = request.getParameter("bday");
		if(datum!=null&& !datum.isBlank()) {
			LocalDate datumfr = LocalDate.parse(datum);
			
			LocalDate birthDate = LocalDate.of(datumfr.getYear(),datumfr.getMonth(),datumfr.getDayOfMonth());
			LocalDate currentDate = LocalDate.now();
			Period age = Period.between(birthDate, currentDate);
			return "You are " + age.getYears() + 
	                " years, " + age.getMonths() + 
	                " months, and " + age.getDays() + 
	                " days old.";
		}
		else {
			return "Valid Date PLSSS";
		}
		
	}
	
	
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().println("<html><head><Title>Buzz</Title><link rel='stylesheet' type='text/css' href='Style.css'></head><body><h1>Zeug eingeben</h1>"
				+ "        <form>\r\n"
				+ "            <label for=\"name\">Name:</label>\r\n"
				+ "            <input type=\"text\" id=\"name\" name=\"name\"><br><br>\r\n"
				+ "            <label for=\"Year\">Birthday:</label>\r\n"
				+ "            <input type=\"date\" id=\"bday\" name=\"bday\"><br><br>\r\n"
				+ "            <input type=\"submit\" value=\"Submit\">\r\n"
				+ "        </form>"
				+ "<h2> "+ MAKENAMEBIG(request) +" </h2>"
				+ "<h2> "+ age(request) +"  </h2>"
				+ "</body></html>");
	}

}
