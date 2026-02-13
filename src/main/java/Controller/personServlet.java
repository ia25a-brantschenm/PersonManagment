package Controller;

import java.util.ArrayList;

import Model.Person;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.PersonService;

import java.io.IOException;

/**
 * Servlet implementation class personServlet
 */
@WebServlet("/personServlet")
public class personServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	/*
	@Override
	public void init()throws ServletException{
		Person p1 = new Person("Marco","Brantschen");
		Person p2 = new Person("David","Garcia");
		Person p3 = new Person("Giona","Despotovic");
		Person p4 = new Person("Kavin","Jyoti");
		PersonService.add(p1);
		PersonService.add(p2);
		PersonService.add(p3);
		PersonService.add(p4);
	}
	/*
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("PersonList", PersonService.getPersons());
		request.getRequestDispatcher("/listPerson.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String uuid = request.getParameter("uuid");
		
		Person find = new Person(firstname, lastname,uuid);
		
		if(uuid != null) {
			PersonService.updatePerson(firstname, lastname,uuid);
			request.getRequestDispatcher("/Main.jsp").forward(request, response);
		}
		else {
			PersonService.insertPerson(firstname, lastname, uuid);
			request.getRequestDispatcher("/Main.jsp").forward(request, response);
		}
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uuid = request.getParameter("uuid");
		System.out.println("im do delete: " + uuid);
		PersonService.dropPerson(uuid);

		
	}
	

	
}
