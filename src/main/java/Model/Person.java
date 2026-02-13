package Model;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

/**
 * Servlet implementation class personServlet
 */
@SuppressWarnings("unused")
@WebServlet("/person")
public class Person  {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private String firstname;
	private String lastname;
	private String uuid = UUID.randomUUID().toString();
	
	public static String standardRandom() {
		return UUID.randomUUID().toString();
	}
	
	public String getUuid() {
		return uuid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public Person(String firstname, String lastname, String uuid) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.uuid = uuid;
	}

}
