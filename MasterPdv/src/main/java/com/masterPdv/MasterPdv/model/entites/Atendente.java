package com.masterPdv.MasterPdv.model.entites;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_atendente")
public class Atendente extends Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome_completo")
	private String nomeCompleto;

	private Double salario;

	@Column(name = "quantidade_faltas")
	private Integer numeroFaltas;

	@Column(name = "freq_vendas")
	private Integer quantidadeVendas;

	@Column(name = "houve_falta")
	private boolean ouveFalta;

	private Set<Caixa> caixas = new HashSet<>();

	public Atendente(Long id, String nomeCompleto, Double salario, Integer numeroFaltas, Integer quantidadeVendas,
			boolean ouveFalta, Set<Caixa> caixas) {
		super();
		this.id = id;
		this.nomeCompleto = nomeCompleto;
		this.salario = salario;
		this.numeroFaltas = numeroFaltas;
		this.quantidadeVendas = quantidadeVendas;
		this.ouveFalta = ouveFalta;
		this.caixas = caixas;
	}

	public Atendente() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public Integer getQuantidadeVendas() {
		return quantidadeVendas;
	}

	public void setQuantidadeVendas(Integer quantidadeVendas) {
		this.quantidadeVendas = quantidadeVendas;
	}

	public Integer getNumeroFaltas() {
		return numeroFaltas;
	}

	public void setNumeroFaltas(Integer numeroFaltas) {
		this.numeroFaltas = numeroFaltas;
	}

	public boolean isOuveFalta() {
		return ouveFalta;
	}

	public void setOuveFalta(boolean ouveFalta) {
		this.ouveFalta = ouveFalta;
	}

	public Set<Caixa> getCaixas() throws Exception {
		if (caixas.isEmpty())
			throw new Exception("Não há atendes na caixa!");
		return caixas;
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return super.getEmail();
	}

	@Override
	public void setEmail(String email) {
		// TODO Auto-generated method stub
		super.setEmail(email);
	}

	@Override
	public Integer getTelephone() {
		// TODO Auto-generated method stub
		return super.getTelephone();
	}

	@Override
	public void setTelephone(Integer telephone) {
		// TODO Auto-generated method stub
		super.setTelephone(telephone);
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return super.getUsername();
	}

	@Override
	public void setUsername(String username) {
		// TODO Auto-generated method stub
		super.setUsername(username);
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return super.getPassword();
	}

	@Override
	public void setPassword(String password) {
		// TODO Auto-generated method stub
		super.setPassword(password);
	}

	@Override
	public Set<Permissao> getPermissoes() {
		// TODO Auto-generated method stub
		return super.getPermissoes();
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(id);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atendente other = (Atendente) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Atendente [id=" + id + ", nomeCompleto=" + nomeCompleto + ", salario=" + salario + ", numeroFaltas="
				+ numeroFaltas + ", ouveFalta=" + ouveFalta + ", caixas=" + caixas + "]";
	}

}
