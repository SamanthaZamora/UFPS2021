package co.edu.ufps.entities;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@NamedQuery(name = "Votante.findAll", query = "SELECT v FROM Votante v")
public class Votante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String documento;

	private String email;

	private String nombre;

	// bi-directional many-to-one association to Tipodocumento
	@ManyToOne
	@JoinColumn(name = "tipodocumento")
	private Tipodocumento tipodocumentoBean;

	// bi-directional many-to-one association to Eleccion
	@ManyToOne
	@JoinColumn(name = "eleccion")
	private Eleccion eleccionBean;

	// bi-directional many-to-one association to Voto
	@OneToMany(mappedBy = "votanteBean")
	private List<Voto> votos;

	public Tipodocumento getTipodocumentoBean() {
		return this.tipodocumentoBean;
	}

	public void setTipodocumentoBean(Tipodocumento tipodocumentoBean) {
		this.tipodocumentoBean = tipodocumentoBean;
	}

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
		voto.setVotanteBean(this);

		return voto;
	}

	public Voto removeVoto(Voto voto) {
		getVotos().remove(voto);
		voto.setVotanteBean(null);

		return voto;
	}

	public Votante(String documento, String email, String nombre, Tipodocumento tipodocumentoBean,
			Eleccion eleccionBean) {
		super();
		this.documento = documento;
		this.email = email;
		this.nombre = nombre;
		this.tipodocumentoBean = tipodocumentoBean;
		this.eleccionBean = eleccionBean;
	}

}