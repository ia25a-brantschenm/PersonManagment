package service;

import java.sql.*;
import java.util.ArrayList;

import DBConnector.DBConnector;
import Model.Person;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;

public class PersonService extends HttpServlet {
	

    /*
	public static ArrayList<Person> getPersons(){
		return persons;
	}
	*/
	
    public static ArrayList<Person> getPersons() {
    	ArrayList<Person> persons = new ArrayList<Person>();
        String sql = "SELECT * FROM Person";
        try (Connection conn = DBConnector.getInstance().getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Person p = new Person(
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("uuid")
                );
                persons.add(p);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return persons;
    }
    public static void insertPerson(String firstname, String lastname, String uuid) {
    	


        try {

            String url = "jdbc:mysql://localhost:3306/personmanagment";
            String username = "root"; 
            String password = "KavinGlazzer12!";
            Connection connection = DriverManager.getConnection(url, username, password);
            connection.setAutoCommit(false);
            String insertSQL = "INSERT INTO Person (firstname, lastname, uuid) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
            System.out.println("Autocommit = " + connection.getAutoCommit());

            preparedStatement.setString(1, firstname);


            preparedStatement.setString(2, lastname);
            
            preparedStatement.setString(3, Person.standardRandom());

            int updatedRowCount = preparedStatement.executeUpdate();
            if (updatedRowCount == 1) {
                connection.commit();
                System.out.println("Data inserted successfully.");
            } else {
                connection.rollback();
                System.out.println("An error occurred while inserting new data.");
            }
            preparedStatement.close();


            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    

	public static void dropPerson(String uuid) {
    	


        try {
            String jdbcUrl = "jdbc:mysql://localhost:3306/personManagment?user=root";
            Connection connection = DriverManager.getConnection(jdbcUrl, "root", "KavinGlazzer12!");
            connection.setAutoCommit(false);
            String sql = "DELETE FROM Person WHERE uuid = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, uuid);
            System.out.println("Autocommit = " + connection.getAutoCommit());
            int rowsDeleted = preparedStatement.executeUpdate();

            if (rowsDeleted > 0) {
                connection.commit();
                System.out.println("A row was deleted successfully.");
            }
            else{
                connection.rollback();
            }

            preparedStatement.close();

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    
    public static void updatePerson(String firstname, String lastname, String uuid) {


        try {
            String jdbcUrl = "jdbc:mysql://localhost:3306/personManagment?user=root";
            Connection connection = DriverManager.getConnection(jdbcUrl, "root", "KavinGlazzer12!");
            connection.setAutoCommit(false);
            String sql = "UPDATE Person SET firstname = ?, lastname = ? WHERE uuid = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, firstname);
            preparedStatement.setString(2, lastname);
            preparedStatement.setString(3, uuid);
            System.out.println("Autocommit = " + connection.getAutoCommit());
            int rowsDeleted = preparedStatement.executeUpdate();

            if (rowsDeleted > 0) {
                connection.commit();
                System.out.println("A row was deleted successfully.");
            }
            else{
                connection.rollback();
            }

            preparedStatement.close();

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	/*
	public static void add(Person person) {
		PersonService.persons.add(person);
	}
    public static void add(String firstName, String lastName) {
    	PersonService.persons.add(new Person(firstName, lastName));
    }
    
	public static void del(Person person) {
		PersonService.persons.remove(person);
	}
    public static void del(String firstName, String lastName) {
    	PersonService.persons.remove(new Person(firstName, lastName));
    }
    public static void del(String uuid) {
    	for(Person p : persons) {
    		System.out.println(p.getUuid());
    		if(uuid.equals(p.getUuid())) {
    			persons.remove(p);
    		}
    	}
    }
    public static void update(String uuid, String newFirstName, String newSurName) {
    	for(Person p : persons) {
    		if(uuid.equals(p.getUuid())) {
    			p.setFirstname(newFirstName);
    			p.setLastname(newSurName);
    		}
    		
    	}
    }
    */
    

    
}

