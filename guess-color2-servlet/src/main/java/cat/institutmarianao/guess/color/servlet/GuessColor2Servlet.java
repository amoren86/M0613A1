package cat.institutmarianao.guess.color.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/guess-color", initParams = { @WebInitParam(name = "color", value = "red") })
public class GuessColor2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String initColor;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	@Override
	public void init() throws ServletException {
		initColor = getServletConfig().getInitParameter("color");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// L'usuari ha seleccionat un color i ho ha enviat.
		String paramColor = request.getParameter("color");

		if (paramColor == null) {
			response.sendRedirect("guess_color.html");
		} else if (initColor.equalsIgnoreCase(paramColor)) {
			response.sendRedirect("win.html");
		} else {
			response.sendRedirect("loose.html");
		}
	}
}
