package com.masterPdv.MasterPdv.model.entites;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;

import com.masterPdv.MasterPdv.security.Permissao;

public class Atendente extends Usuario {

	private Long id;
	private String nomeCompleto;
	private Double salario;
	private Integer numeroFaltas;
	private boolean ouveFalta;
	private Integer[] numeroFila = new Integer[9];

	public Atendente(Long id, String nomeCompleto, Double salario, Integer numeroFaltas, boolean ouveFalta,
			Integer[] numeroFila) {
		if(numeroFila.length > 9) throw new IllegalArgumentException("O tamanho máximo da fila é 9.");
		this.id = id;
		this.nomeCompleto = nomeCompleto;
		this.salario = salario;
		this.numeroFaltas = numeroFaltas;
		this.ouveFalta = ouveFalta;
		this.numeroFila = numeroFila;
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

	public Integer[] getNumeroFila() {
		return numeroFila;
	}

	public void setNumeroFila(Integer[] numeroFila) {
		this.numeroFila = numeroFila;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Arrays.hashCode(numeroFila);
		result = prime * result + Objects.hash(id, nomeCompleto);
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
		return Objects.equals(id, other.id) && Objects.equals(nomeCompleto, other.nomeCompleto)
				&& Arrays.equals(numeroFila, other.numeroFila);
	}

	public void adicionarAtendenteFila(int idAtendente) {
		for(Integer atendente : numeroFila) {
			if(atendente != null  && atendente.equals(idAtendente)) {
	            throw new IllegalStateException("O atendente já está na fila.");
			}
		}
	
		for(int i = 0; i < numeroFila.length; i++) {
			if(numeroFila[i] == null) {
				numeroFila[i] = idAtendente;
				return;
			}
		}

		throw new IllegalStateException("A fila já atingiu o tamanho máximo de 9.");
	}

	public void removerAtendenteFila(int idAtendente) {
		for (int i = 0; i < numeroFila.length; i++) {
			if(numeroFila[i] != null && numeroFila[i].equals(idAtendente))
			if (numeroFila[i] != null) {
				numeroFila[i] = null;
				return;
			}
		}

		throw new IllegalStateException("A fila já atingiu o tamanho máximo de 9.");

	}

	@Override
	public String toString() {
		return "Atendente [id=" + id + ", nomeCompleto=" + nomeCompleto + ", salario=" + salario + ", numeroFaltas="
				+ numeroFaltas + ", ouveFalta=" + ouveFalta + ", numeroFila=" + Arrays.toString(numeroFila) + "]";
	}

}
