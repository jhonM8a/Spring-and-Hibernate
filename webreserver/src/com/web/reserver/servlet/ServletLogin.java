package com.web.reserver.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet(description = "Servlet para manipular las peticiones de login", urlPatterns = { "/abc123" })
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServletLogin() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String usuario = request.getParameter("usuario"); //Esta indicando que lo que tiene la peticion en usuario lo asigne
		String empresa = request.getParameter("empresa");
		PrintWriter escritor = response.getWriter();// Con este se puede escribir en la respuesta
		
		if(usuario != null && empresa!=null) {
			if (empresa.equals("web")) {
				escritor.println("Bienvenido a la web");	
			}else {
				escritor.println("Bienvenido");
			}
		}else {
			escritor.println("Uusuario incorrecto");
		}
		
		escritor.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
