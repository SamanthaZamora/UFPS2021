package co.edu.ufps.cotroller;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import co.edu.ufps.dao.EleccionDao;
import co.edu.ufps.dao.GenericDao;
import co.edu.ufps.entities.Eleccion;


@WebServlet("/EleccionServlet")
public class EleccionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private GenericDao newEleccion;
	private SimpleDateFormat sdfTime;
	private SimpleDateFormat sdf;
	
    
    public EleccionServlet() {
        super();
     }
    
    public void init(ServletConfig config) throws ServletException {
    	sdfTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		this.newEleccion = new EleccionDao();
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
			case "edit":
				showEditForm(request, response);
				break;
			case "/update":
				update(request, response);
				break;
			default:
				list(request, response);
				break;
			}
		} catch (SQLException | ParseException ex) {
			throw new ServletException(ex);
		}
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)	throws ServletException, SQLException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("eleccionR.jsp");
		dispatcher.forward(request, response);
	}
	
	private void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException, ParseException {
		String nombre = request.getParameter("nombre");
		Date dateI = sdf.parse(request.getParameter("fechainicio"));
		Date dateF = sdf.parse(request.getParameter("fechafin"));
		
		String strI = sdfTime.format(dateI);
		String strF = sdfTime.format(dateF);
		
		Timestamp fechainicio = Timestamp.valueOf(strI);
		Timestamp fechafin = Timestamp.valueOf(strF);
		
		String cargo = request.getParameter("cargo");
		
		Eleccion eleccion = new Eleccion(cargo, fechafin, fechainicio, nombre);
		newEleccion.insert(eleccion);
		response.sendRedirect("list");
	}
	

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)	throws ServletException, SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		Eleccion eleccion = (Eleccion) newEleccion.find(id);
		request.setAttribute("eleccion", eleccion);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("eleccionR.jsp");
		dispatcher.forward(request, response);
	}

	private void update(HttpServletRequest request, HttpServletResponse response)	throws ServletException, SQLException, IOException, ParseException {
		int id = Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		Date dateI = sdf.parse(request.getParameter("fechainicio"));
		Date dateF = sdf.parse(request.getParameter("fechafin"));
		
		String strI = sdfTime.format(dateI);
		String strF = sdfTime.format(dateF);
		
		Timestamp fechainicio = Timestamp.valueOf(strI);
		Timestamp fechafin = Timestamp.valueOf(strF);
		String cargo = request.getParameter("cargo");
		
		Eleccion eleccion = new Eleccion(cargo, fechafin, fechainicio, nombre);
		eleccion.setId(id);
		newEleccion.update(eleccion);
		response.sendRedirect("list");
	}
		
	private void delete(HttpServletRequest request, HttpServletResponse response)	throws ServletException, SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Eleccion eleccion = (Eleccion) newEleccion.find(id);
		
		newEleccion.delete(eleccion);
		list(request, response);
	}

	private void list(HttpServletRequest request, HttpServletResponse response)	throws ServletException, SQLException, IOException {
		List<Eleccion> listaEleccion = newEleccion.list();
		request.setAttribute("listaEleccion", listaEleccion);
		RequestDispatcher dispatcher = request.getRequestDispatcher("listE.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
