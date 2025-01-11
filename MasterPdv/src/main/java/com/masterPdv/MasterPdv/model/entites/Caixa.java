package com.masterPdv.MasterPdv.model.entites;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
	private Atendente atendente;
	
	
	
	
	
}
