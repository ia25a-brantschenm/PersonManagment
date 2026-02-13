

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Controller")
public class Controller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = null;
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("username".equals(cookie.getName())) {
                    name = cookie.getValue();
                    break;
                }
            }
        }

        // Name an JSP übergeben
        request.setAttribute("username", name);
        request.getRequestDispatcher("/form.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");

        if (username != null && !username.isEmpty()) {
            Cookie nameCookie = new Cookie("username", username);
            nameCookie.setMaxAge(10); //10 sekunden
            response.addCookie(nameCookie);
        }
        response.sendRedirect("Controller");
    }
}
