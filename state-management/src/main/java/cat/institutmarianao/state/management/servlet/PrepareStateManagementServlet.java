package cat.institutmarianao.state.management.servlet;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import cat.institutmarianao.state.management.StateManagementMethod;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/prepare_state_management")
public class PrepareStateManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String field = request.getParameter("field");
		StateManagementMethod stateManagementMethod = StateManagementMethod
				.valueOf(request.getParameter("stateManagementMethod"));

		request.getSession().setAttribute("stateManagementMethod", stateManagementMethod);

		RequestDispatcher dispatcher;

		switch (stateManagementMethod) {
		case URL_REWRITE:
			dispatcher = request.getRequestDispatcher("/url_rewrite.jsp");
			request.setAttribute("field", field);
			break;
		case HIDDEN_FIELD:
			dispatcher = request.getRequestDispatcher("/hidden_field.jsp");
			request.setAttribute("field", field);
			break;
		case SESSION:
			dispatcher = request.getRequestDispatcher("/session.jsp");
			request.getSession().setAttribute("field", field);
			break;
		case COOKIE:
			dispatcher = request.getRequestDispatcher("/cookie.jsp");
			Cookie fieldCookie = new Cookie("field", URLEncoder.encode(field, StandardCharsets.UTF_8));
			response.addCookie(fieldCookie);
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + stateManagementMethod);
		}

		dispatcher.forward(request, response);
	}

}
