package cat.institutmarianao.post.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import cat.institutmarianao.post.servlet.ejb.impl.PostBeanLocal;
import jakarta.annotation.Resource;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;

@WebServlet("/post")
public class Post2Servlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Resource
	private Validator validator;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Validator 2 Servlet</title>");
			out.println("</head>");
			out.println("<body>");

			String mail = request.getParameter("email");
			String age = request.getParameter("age");
			String message = request.getParameter("message");

			PostBeanLocal bean = (PostBeanLocal) new InitialContext().lookup("java:global/post-servlet/PostBean");

			bean.setMessage(message);
			bean.setEmail(mail);
			bean.setAge(age);

			out.println("<h1>Submitted data from form</h1>");
			out.println("<p>Email: <q><cite>" + bean.getEmail() + "</cite></q></p>");
			out.println("<p>Age: <q><cite>" + bean.getAge() + "</cite></q></p>");
			out.println("<p>Message: <q><cite>" + bean.getMessage() + "</cite></q></p>");

			out.println("<h1>Validations:</h1>");
			for (ConstraintViolation<PostBeanLocal> c : validator.validate(bean)) {
				out.println("<p>" + c.getMessage() + "</p>");
			}

			out.println("</body>");
			out.println("</html>");
		} catch (NamingException ex) {
			Logger.getLogger(PostBeanLocal.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
