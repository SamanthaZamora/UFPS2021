package co.edu.ufps.entities;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@NamedQuery(name="Candidato.findAll", query="SELECT c FROM Candidato c")
public class Candidato implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String apellido;

	private String documento;

	private String nombre;

	private int numero;
	
	

	//bi-directional many-to-one association to Eleccion
	@ManyToOne
	@JoinColumn(name="eleccion")
	private Eleccion eleccionBean;

	//bi-directional many-to-one association to Voto
	@OneToMany(mappedBy="candidatoBean")
	private List<Voto> votos;

		public Eleccion getEleccionBean() {
		return this.eleccionBean;
	}

	public void setEleccionBean(Eleccion eleccionBean) {
		this.eleccionBean = eleccionBean;
	}

	public List<Voto> getVotos() {
		return this.votos;
	}

	public void setVotos(List<Voto> votos) {
		this.votos = votos;
	}

	public Voto addVoto(Voto voto) {
		getVotos().add(voto);
		voto.setCandidatoBean(this);

		return voto;
	}

	public Voto removeVoto(Voto voto) {
		getVotos().remove(voto);
		voto.setCandidatoBean(null);

		return voto;
	}

	public Candidato(String apellido, String documento, String nombre, int numero, Eleccion eleccionBean) {
		super();
		this.apellido = apellido;
		this.documento = documento;
		this.nombre = nombre;
		this.numero = numero;
		this.eleccionBean = eleccionBean;
	}
}