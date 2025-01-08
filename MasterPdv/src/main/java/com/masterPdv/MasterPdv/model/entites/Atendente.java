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
	
	@Column(name = "houve_falta")
	private boolean ouveFalta;
	
	private Set<Caixa> caixas = new HashSet<>();

	public Atendente() {

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

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public void adicionarAtendenteFila(int idAtendente) {
		for (Integer atendente : numeroFila) {
			if (atendente != null && atendente.equals(idAtendente)) {
				throw new IllegalStateException("O(a) atendente já está na fila.");
			}
		}

		for (int i = 0; i < numeroFila.length; i++) {
			if (numeroFila[i] == null) {
				numeroFila[i] = idAtendente;
				return;
			}
		}

		throw new IllegalStateException("A fila já atingiu o tamanho máximo de 9.");
	}

	public void removerAtendenteFila(int idAtendente) {
		for (int i = 0; i < numeroFila.length; i++) {
			if (numeroFila[i] != null && numeroFila[i].equals(idAtendente))
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
