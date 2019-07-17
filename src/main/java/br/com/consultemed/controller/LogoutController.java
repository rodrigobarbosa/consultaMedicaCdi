package br.com.consultemed.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.consultemed.utils.Constantes;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/logout")
public class LogoutController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		if(session != null) {
			session.invalidate();
		}
		RequestDispatcher rd = request.getRequestDispatcher(Constantes.LOGIN);
		request.setAttribute("ateLogo", Constantes.OBRIGADO);
		rd.forward(request, response);
	}

}
