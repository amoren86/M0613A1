package cat.institutmarianao.state.management.servlet;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

import cat.institutmarianao.state.management.StateManagementMethod;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/retrieve_state_management")
public class RetrieveStateManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		getFieldAndShow(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		getFieldAndShow(request, response);
	}

	private void getFieldAndShow(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		StateManagementMethod stateManagementMethod = (StateManagementMethod) request.getSession()
				.getAttribute("stateManagementMethod");

		switch (stateManagementMethod) {
		case URL_REWRITE:
			// Continue like HIDDEN_FIELD case
		case HIDDEN_FIELD:
			request.setAttribute("field", request.getParameter("field"));
			break;
		case SESSION:
			// Do nothing, cause session is accessible in the JSP page
			break;
		case COOKIE:
			String field = null;
			if (request.getCookies() != null) {
				for (var cookie : request.getCookies()) {
					if ("field".equals(cookie.getName())) {
						field = URLDecoder.decode(cookie.getValue(), StandardCharsets.UTF_8);
						break;
					}
				}
			}

			request.setAttribute("field", field);
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + stateManagementMethod);
		}

		request.getRequestDispatcher("/show_field.jsp").forward(request, response);
	}
}
