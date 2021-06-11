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
@NamedQuery(name = "Eleccion.findAll", query = "SELECT e FROM Eleccion e")
public class Eleccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String cargo;

	@Temporal(TemporalType.DATE)
	private Date fechafin;

	@Temporal(TemporalType.DATE)
	private Date fechainicio;

	private String nombre;

	// bi-directional many-to-one association to Candidato
	@OneToMany(mappedBy = "eleccionBean")
	private List<Candidato> candidatos;

	// bi-directional many-to-one association to Estamento
	@OneToMany(mappedBy = "eleccionBean")
	private List<Estamento> estamentos;

	// bi-directional many-to-one association to Votante
	@OneToMany(mappedBy = "eleccionBean")
	private List<Votante> votantes;

	public List<Candidato> getCandidatos() {
		return this.candidatos;
	}

	public void setCandidatos(List<Candidato> candidatos) {
		this.candidatos = candidatos;
	}

	public Candidato addCandidato(Candidato candidato) {
		getCandidatos().add(candidato);
		candidato.setEleccionBean(this);

		return candidato;
	}

	public Candidato removeCandidato(Candidato candidato) {
		getCandidatos().remove(candidato);
		candidato.setEleccionBean(null);

		return candidato;
	}

	public List<Estamento> getEstamentos() {
		return this.estamentos;
	}

	public void setEstamentos(List<Estamento> estamentos) {
		this.estamentos = estamentos;
	}

	public Estamento addEstamento(Estamento estamento) {
		getEstamentos().add(estamento);
		estamento.setEleccionBean(this);

		return estamento;
	}

	public Estamento removeEstamento(Estamento estamento) {
		getEstamentos().remove(estamento);
		estamento.setEleccionBean(null);

		return estamento;
	}

	public List<Votante> getVotantes() {
		return this.votantes;
	}

	public void setVotantes(List<Votante> votantes) {
		this.votantes = votantes;
	}

	public Votante addVotante(Votante votante) {
		getVotantes().add(votante);
		votante.setEleccionBean(this);

		return votante;
	}

	public Votante removeVotante(Votante votante) {
		getVotantes().remove(votante);
		votante.setEleccionBean(null);

		return votante;
	}

	public Eleccion(String cargo, Date fechafin, Date fechainicio, String nombre) {
		super();
		this.cargo = cargo;
		this.fechafin = fechafin;
		this.fechainicio = fechainicio;
		this.nombre = nombre;
	}
	
	

}