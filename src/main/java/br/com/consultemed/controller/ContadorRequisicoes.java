package br.com.consultemed.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ContadorRequisicoes
 */
@WebServlet("/contadorRequisicoes")
public class ContadorRequisicoes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private int contador;
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		contador ++;
		
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		request.setAttribute("contador", contador);
		rd.forward(request, response);
		
		System.out.println("Contador" + contador);
		
	}

}
