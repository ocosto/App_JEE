package pack2;

import jakarta.servlet.http.HttpServlet;
 
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import pack1.User;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AuthenticationServlet")
public class AuthentificationServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext cntx = getServletContext();

		PrintWriter out = response.getWriter();

		String login = request.getParameter("login");
		String password = request.getParameter("password");

		ArrayList<User> users = (ArrayList<User>) cntx.getAttribute("listusers");

		if (users != null && !users.isEmpty()) {
			User foundUser = null;
			for (User it : users) {
				if (it.getPassword().equals(password) && it.getLogin().equals(login)) {
					foundUser = it;
					break;
				}
			}

			if (foundUser != null) {
				request.getSession().setAttribute("connecteduser", foundUser);
				request.getRequestDispatcher("home.jsp").forward(request, response);
				return;
				
			} else {
				out.print("Login ou mot de passe incorrects");

			}
		} else {
			out.print("Login ou mot de passe incorrects");
		}

	}

}
