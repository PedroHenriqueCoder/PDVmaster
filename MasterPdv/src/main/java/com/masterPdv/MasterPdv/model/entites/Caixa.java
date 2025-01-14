package com.masterPdv.MasterPdv.model.entites;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_caixa")
public class Caixa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "transacao_id")
	private Transacao transacao;

	@Column(name = "ocupado")
	private boolean estaOcupado;

	@ManyToMany
	@JoinTable(joinColumns = @JoinColumn(name = "caixa.id"),
			   inverseJoinColumns = @JoinColumn(name = "atendente.id"))
	private Set<Atendente> atendente = new HashSet<>();
	
	@ManyToOne
	private Cliente cliente;
	
	@Column(name = "horario_atendimento")
	private LocalDateTime horarioAtendimento;

	private final static Integer[] valorMaximoDeCaixas = new Integer[9];
	
	public Caixa(Long id, Transacao transacao, boolean estaOcupado, Set<Atendente> atendente, Cliente cliente,
			LocalDateTime horarioAtendimento) {
		this.id = id;
		this.transacao = transacao;
		this.estaOcupado = estaOcupado;
		this.atendente = atendente;
		this.cliente = cliente;
		this.horarioAtendimento = horarioAtendimento;
	}

	public Transacao getTransacao() {
		return transacao;
	}

	public void setTransacao(Transacao transacao) {
		this.transacao = transacao;
	}

	public boolean isEstaOcupado() {
		return estaOcupado;
	}

	public void setEstaOcupado(boolean estaOcupado) {
		this.estaOcupado = estaOcupado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Atendente> getAtendente() {
		return atendente;
	}

	public void setAtendente(Set<Atendente> atendente) {
		this.atendente = atendente;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public LocalDateTime getHorarioAtendimento() {
		return horarioAtendimento;
	}

	public void setHorarioAtendimento(LocalDateTime horarioAtendimento) {
		this.horarioAtendimento = horarioAtendimento;
	}

	@Override
	public String toString() {
		return "Caixa [id=" + id + ", transacao=" + transacao + ", estaOcupado=" + estaOcupado + ", atendente="
				+ atendente + ", cliente=" + cliente + ", horarioAtendimento=" + horarioAtendimento + "]";
	}

	
}
