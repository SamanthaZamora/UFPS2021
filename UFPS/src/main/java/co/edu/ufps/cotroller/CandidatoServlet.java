package co.edu.ufps.cotroller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import co.edu.ufps.dao.CandidatoDao;
import co.edu.ufps.dao.EleccionDao;
import co.edu.ufps.dao.EstamentoDao;
import co.edu.ufps.dao.GenericDao;
import co.edu.ufps.dao.TipoDao;
import co.edu.ufps.dao.VotanteDao;
import co.edu.ufps.entities.Candidato;
import co.edu.ufps.entities.Eleccion;
import co.edu.ufps.entities.Votante;


@WebServlet("/CandidatoServlet")
public class CandidatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private GenericDao newvoto;
	private GenericDao newEleccion;
	private GenericDao newCandidato;
    
    public CandidatoServlet() {
        super();
       
    }
    
    public void init(ServletConfig config) throws ServletException {
		this.newvoto = new VotanteDao();
		this.newEleccion = new EleccionDao();
		this.newCandidato = new CandidatoDao();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		
		System.out.println(action);

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insert(request, response);
				break;
			case "/delete":
				delete(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				update(request, response);
				break;
			default:
				list(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void showNewForm(HttpServletRequest request,HttpServletResponse response ) throws ServletException, IOException{
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("candidatoR.jsp");
		
		List<Eleccion> listaEleccion = newEleccion.list();
		request.setAttribute("listaEleccion", listaEleccion);
		
		
		dispatcher.forward(request,response);
	}

	private void insert(HttpServletRequest request,HttpServletResponse response ) throws ServletException, SQLException, IOException{
		
		String documento =  request.getParameter("documento");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		
		Eleccion eleccion = (Eleccion) newEleccion.find(Integer.parseInt(request.getParameter("eleccion")));

		int numero = Integer.parseInt(request.getParameter("numero"));
		
		Candidato candidato = new Candidato (documento, nombre, apellido,  numero, eleccion);	
		newCandidato.insert(candidato);
		
		response.sendRedirect("list");
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		Candidato candidatoActual = (Candidato) newCandidato.find(id);
		
		List<Eleccion> listaEleccion = newEleccion.list();
		request.setAttribute("listaEleccion", listaEleccion);
		
		request.setAttribute("candidato",candidatoActual);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/candidatoR.jsp");
		dispatcher.forward(request,response);		
	}

	private void update(HttpServletRequest request,HttpServletResponse response ) throws ServletException, SQLException, IOException{
		
		int id = Integer.parseInt(request.getParameter("id")); 	
		
		String documento =  request.getParameter("documento");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		
		Eleccion eleccion = (Eleccion) newEleccion.find(Integer.parseInt(request.getParameter("eleccion")));
		
		int numero = Integer.parseInt(request.getParameter("numero"));
		
		Candidato candidato = new Candidato (documento, nombre, apellido,  numero,eleccion);
		candidato.setId(id);
		
		newCandidato.update(candidato);
		response.sendRedirect("list");
	}
	
	private void delete(HttpServletRequest request,HttpServletResponse response ) throws ServletException, SQLException, IOException{
		int id = Integer.parseInt(request.getParameter("id")); 	

		Candidato candidato = (Candidato) newCandidato.find(id);
		
		newCandidato.delete(candidato);		
		response.sendRedirect("list");
	}
	
	private void list(HttpServletRequest request,HttpServletResponse response ) throws ServletException, SQLException, IOException{
		
		List<Candidato> listCandidatos  = newCandidato.list();
		request.setAttribute( "listCandidatos", listCandidatos);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("listC.jsp");
		dispatcher.forward(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
