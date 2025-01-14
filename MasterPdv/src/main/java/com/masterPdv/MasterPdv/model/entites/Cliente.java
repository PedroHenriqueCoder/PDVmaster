package com.masterPdv.MasterPdv.model.entites;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_clientes")
public class Cliente extends Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "horario_transacou")
	private LocalDateTime horarioDeVistacao;

	@Column(name = "foi_pago")
	private boolean pagou;
	
	@Column(name = "compra_finalizada")
	private boolean finalizou;

	@OneToOne
	private Transacao transacao;

	@Column(name = "total_pagar")
	private BigDecimal valorApagar;

	public Cliente(Long id, LocalDateTime horarioDeVistacao, boolean pagou, boolean finalizou, Transacao transacao,
			BigDecimal valorApagar) {
		super();
		this.id = id;
		this.horarioDeVistacao = horarioDeVistacao;
		this.pagou = pagou;
		this.finalizou = finalizou;
		this.transacao = transacao;
		this.valorApagar = valorApagar;
	}

	public Cliente() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isPagou() {
		return pagou;
	}

	public void setPagou(boolean pagou) {
		this.pagou = pagou;
	}

	public LocalDateTime getHorarioDeVistacao() {
		return horarioDeVistacao;
	}

	public void setHorarioDeVistacao(LocalDateTime horarioDeVistacao) {
		this.horarioDeVistacao = horarioDeVistacao;
	}

	public Transacao getTransacao() {
		return transacao;
	}

	public void setTransacao(Transacao transacao) {
		this.transacao = transacao;
	}

	public BigDecimal getValorApagar() {
		return valorApagar;
	}

	public void setValorApagar(BigDecimal valorApagar) {
		this.valorApagar = valorApagar;
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
	
	

	public boolean foiFinalizado() {
		return finalizou;
	}

	public void setfoiFinalizado(boolean finalizou) {
		this.finalizou = finalizou;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
	public Cliente clientePreDefifinidoParaTransacoes(Cliente clientePadrao) {
		Cliente cliente = new Cliente();
		cliente.setId(0L);
		cliente.setUsername("Cliente");
		cliente.setPassword("0000");
		cliente.setPagou(false);
		cliente.setfoiFinalizado(false);
		cliente.setHorarioDeVistacao(LocalDateTime.now());
		cliente.setValorApagar(BigDecimal.ZERO);
		return cliente;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", horarioDeVistacao=" + horarioDeVistacao + ", pagou=" + pagou + ", transacao="
				+ transacao + ", valorApagar=" + valorApagar + "]";
	}

}
