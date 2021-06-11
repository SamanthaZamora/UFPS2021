package co.edu.ufps.util;

import java.util.List;

import co.edu.ufps.dao.EstamentoDao;
import co.edu.ufps.entities.Estamento;

public class Prueba {
	public static void main(String[] args) {
		
		EstamentoDao et = new EstamentoDao();
		
		List<Estamento> listaEsta = et.list();
		for (Estamento t : listaEsta) {
			System.out.println(t.getDescripcion());
		}
	}
}
