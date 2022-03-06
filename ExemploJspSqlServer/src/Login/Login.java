package Login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet(urlPatterns = {"/Login", "/login"})
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String login = "", senha = "";
    
    public Login() {
        super();
        
    }

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getParameter("login");
		request.getParameter("senha");
		login = request.getParameter("login");
		senha = request.getParameter("senha");
		HttpSession sessao;
		if(login.equals("admin") && senha.equals("admin"))
		{
			sessao = request.getSession(true);
			sessao.setAttribute("login", login);
			sessao.setAttribute("senha", senha);
			sessao.setMaxInactiveInterval(30);
			response.sendRedirect("/ExemploJspSqlServer/ListarCidades");
			
		}
		else
		{
			response.sendRedirect("LoginInvalido.html");
			
		}
	}

}
