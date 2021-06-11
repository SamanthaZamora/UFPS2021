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

import co.edu.ufps.entities.Votante;

import co.edu.ufps.dao.EleccionDao;
import co.edu.ufps.dao.EstamentoDao;
import co.edu.ufps.dao.GenericDao;
import co.edu.ufps.dao.TipoDao;
import co.edu.ufps.dao.VotanteDao;
import co.edu.ufps.entities.Eleccion;
import co.edu.ufps.entities.Estamento;
import co.edu.ufps.entities.Tipodocumento;


@WebServlet("/")
public class VotanteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private GenericDao newvotante;
	private GenericDao newTipo;
	private GenericDao newEleccion;
	private GenericDao newEstamento;
	
    public VotanteServlet() {
        super();      
    }

    public void init(ServletConfig config) throws ServletException {
		this.newvotante = new VotanteDao();
		this.newTipo = new TipoDao();
		this.newEleccion = new EleccionDao();
		this.newEstamento = new EstamentoDao();
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

	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//
		RequestDispatcher dispatcher = request.getRequestDispatcher("votanteR.jsp");
	
		List<Estamento> e = newEstamento.list();
		request.setAttribute("estamento", e);
		
		List<Tipodocumento> tipo= newTipo.list();
		request.setAttribute("tipodocumento", tipo);
		
		List<Eleccion> elec = newEleccion.list();
		request.setAttribute("eleccion", elec);
		
		for (Tipodocumento tipodocumento : tipo) {
			System.out.println(tipodocumento.getDescripcion());
		}
		
		dispatcher.forward(request, response);
	}

	private void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
		Tipodocumento tipodocumento = (Tipodocumento) newTipo.find(Integer.parseInt(request.getParameter("tipodocumento")));
		
		String documento = request.getParameter("documento");
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");
		
		Eleccion eleccion = (Eleccion) newEleccion.find(Integer.parseInt(request.getParameter("eleccion")));
		
		Votante votante = new Votante(nombre, email, documento, tipodocumento, eleccion);

		newvotante.insert(votante);
		response.sendRedirect("list");
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)	throws SQLException, ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		Votante votante =  (Votante) newvotante.find(id);

		List<Estamento> e = newEstamento.list();
		request.setAttribute("estamento", e);
		
		List<Tipodocumento> tipo= newTipo.list();
		request.setAttribute("tipodocumento", tipo);
		
		List<Eleccion> elec = newEleccion.list();
		request.setAttribute("eleccion", elec);
		
		request.setAttribute("Votante", votante);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("votanteR.jsp");		
		dispatcher.forward(request, response);
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");
		String documento = request.getParameter("documento");
		
		Tipodocumento tipodocumento = (Tipodocumento) newTipo.find(Integer.parseInt(request.getParameter("tipodocumento")));
		Eleccion eleccion = (Eleccion) newEleccion.find(Integer.parseInt(request.getParameter("eleccion")));
		
		Votante votante = new Votante(documento, email, nombre, tipodocumento, eleccion);
		votante.setId(id);
		
		newvotante.update(votante);
		response.sendRedirect("list");
	}
	
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		Votante votante = (Votante) newvotante.find(id);
		
		newvotante.delete(votante);
		response.sendRedirect("list");
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
		
		List<Votante> listaVotante = newvotante.list();
		
		request.setAttribute("listaVotante", listaVotante);
		RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		doGet(request, response);
	}

}
