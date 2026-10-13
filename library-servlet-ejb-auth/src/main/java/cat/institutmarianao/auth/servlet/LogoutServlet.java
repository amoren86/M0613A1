package cat.institutmarianao.auth.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Invalidate the session and log out the user
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}

		try {
			request.logout();
		} catch (ServletException e) {
		}

		// Redirect to the home page after logout
		response.sendRedirect("");
	}
}