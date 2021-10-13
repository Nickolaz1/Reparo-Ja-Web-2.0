package com.quazar.tcc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.quazar.tcc.dao.ClienteDao;
import com.quazar.tcc.dao.PrestadorServicoDao;
import com.quazar.tcc.dao.TelefoneDao;
import com.quazar.tcc.dao.UserDao;
import com.quazar.tcc.model.Cliente;
import com.quazar.tcc.model.PrestadorServico;
import com.quazar.tcc.model.Telefone;
import com.quazar.tcc.model.User;

@WebServlet(urlPatterns = {"/deletarCliente", "/deletarPrestador"})
public class DeletarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ClienteDao clienteDao = new ClienteDao();
	PrestadorServicoDao prestadorServicoDao = new PrestadorServicoDao();
	UserDao userDao = new UserDao();
	TelefoneDao telefoneDao = new TelefoneDao();
       
    public DeletarController() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getServletPath();
		if(url.equals("/deletarCliente")) {
			deletarCliente(request, response);
		}
		else if(url.equals("/deletarPrestador")) {
			deletarPrestador(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void deletarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cliente cliente = new Cliente(Long.parseLong(request.getParameter("id")));
		Telefone telefone = new Telefone(Long.parseLong(request.getParameter("id_fone")));
		User user = new User(Long.parseLong(request.getParameter("id_user")));
		clienteDao.deletarCliente(cliente);
		telefoneDao.deletarTelefone(telefone);
		userDao.deletarUser(user);
		response.sendRedirect("logout");
	}
	
	protected void deletarPrestador(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrestadorServico prestador = new PrestadorServico(Long.parseLong(request.getParameter("id")));
		Telefone telefone = new Telefone(Long.parseLong(request.getParameter("id_fone")));
		User user = new User(Long.parseLong(request.getParameter("id_user")));
		prestadorServicoDao.deletarPrestador(prestador);
		telefoneDao.deletarTelefone(telefone);
		userDao.deletarUser(user);
		response.sendRedirect("logout");
	}

}
