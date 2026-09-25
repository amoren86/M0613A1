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
	private static final String LOOSE_HTML = "loose.html";

	private static final String WIN_HTML = "win.html";

	private static final String GUESS_COLOR_HTML = "guess_color.html";

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
		// redirect(request, response);
		forward(request, response);
	}

	private void redirect(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// L'usuari ha seleccionat un color i ho ha enviat.
		String paramColor = request.getParameter("color");

		if (paramColor == null) {
			response.sendRedirect(GUESS_COLOR_HTML);
		} else if (initColor.equalsIgnoreCase(paramColor)) {
			response.sendRedirect(WIN_HTML);
		} else {
			response.sendRedirect(LOOSE_HTML);
		}
	}

	private void forward(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// L'usuari ha seleccionat un color i ho ha enviat.
		String paramColor = request.getParameter("color");

		if (paramColor == null) {
			request.getRequestDispatcher(GUESS_COLOR_HTML).forward(request, response);
		} else if (initColor.equalsIgnoreCase(paramColor)) {
			request.getRequestDispatcher(WIN_HTML).forward(request, response);
		} else {
			request.getRequestDispatcher(LOOSE_HTML).forward(request, response);
		}
	}
}
