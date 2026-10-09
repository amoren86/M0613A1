package cat.institutmarianao.state.management.servlet;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({ "/prepare_state_management" })
public class PrepareStateManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String field = request.getParameter("field");
		String prepareMethod = request.getParameter("prepare_method");

		switch (prepareMethod) {
		case "prepare_url_rewrite":
			// Nothing to do here
		case "prepare_hidden_field":
			request.setAttribute("field", field);
			request.getRequestDispatcher( prepareMethod + ".jsp").forward(request, response);
			break;
		case "prepare_session":
			request.getSession().setAttribute("field", field);
			response.sendRedirect( prepareMethod + ".jsp");
			break;
		case "prepare_cookie":
			Cookie fieldCookie = new Cookie("field", URLEncoder.encode(field, StandardCharsets.UTF_8));
			response.addCookie(fieldCookie);
			response.sendRedirect(prepareMethod + ".jsp");
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + prepareMethod);
		}

	}
}
