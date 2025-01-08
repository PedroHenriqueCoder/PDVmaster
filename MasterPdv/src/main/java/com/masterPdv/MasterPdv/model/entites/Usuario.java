package com.masterPdv.MasterPdv.model.entites;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String email;
	private Integer telephone;
	private String username;
	private String password;

	@ManyToMany
	@JoinTable(name = "tb_permissoes_usuario", 
	joinColumns = @JoinColumn(name = "usuario.id"),
	inverseJoinColumns = @JoinColumn(name = "permissoes.id"))
	private Set<Permissao> permissoes = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getTelephone() {
		return telephone;
	}

	public void setTelephone(Integer telephone) {
		this.telephone = telephone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Permissao> getPermissoes() {
		return permissoes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", email=" + email + ", telephone=" + telephone + ", username=" + username
				+ ", password=" + password + ", permissoes=" + permissoes + "]";
	}

}
