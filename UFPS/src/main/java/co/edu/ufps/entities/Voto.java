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
@NamedQuery(name="Voto.findAll", query="SELECT v FROM Voto v")
public class Voto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String enlace;

	@Temporal(TemporalType.DATE)
	private Date fechacreacion;

	@Temporal(TemporalType.DATE)
	private Date fechavoto;

	private String uuid;

	//bi-directional many-to-one association to Votante
	@ManyToOne
	@JoinColumn(name="votante")
	private Votante votanteBean;

	//bi-directional many-to-one association to Estamento
	@ManyToOne
	@JoinColumn(name="estamento")
	private Estamento estamentoBean;

	//bi-directional many-to-one association to Candidato
	@ManyToOne
	@JoinColumn(name="candidato")
	private Candidato candidatoBean;

	public Votante getVotanteBean() {
		return this.votanteBean;
	}

	public void setVotanteBean(Votante votanteBean) {
		this.votanteBean = votanteBean;
	}

	public Estamento getEstamentoBean() {
		return this.estamentoBean;
	}

	public void setEstamentoBean(Estamento estamentoBean) {
		this.estamentoBean = estamentoBean;
	}

	public Candidato getCandidatoBean() {
		return this.candidatoBean;
	}

	public void setCandidatoBean(Candidato candidatoBean) {
		this.candidatoBean = candidatoBean;
	}

}