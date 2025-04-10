package com.kaique.lojaVirtual.domain.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "tb_usuario")
public class Usuario implements UserDetails {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String login;
	private String senha;

	/**
	 * Especifica que o campo deve ser mapeado como uma data sem informação de hora
	 * no banco de dados. O tipo `TemporalType.DATE` armazena apenas a data (ano,
	 * mês e dia) e não inclui a hora, minuto ou segundo.
	 */
	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	private Date dataAtuaSenha;

	@JoinColumn(name = "pessoa_id")
	@ManyToOne
	private Pessoa pessoa;

	@ManyToOne
	@JoinColumn(name = "empresa_id")
	private PessoaJuridica empresa;

	@ManyToMany
	@JoinTable(name = "tb_usuario_acesso", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "acesso_id"))
	private List<Acesso> acessos = new ArrayList<>();

	public Usuario() {
	}

	public Usuario(Long id, String login, String senha, Date dataAtuaSenha, Pessoa pessoa, PessoaJuridica empresa,
			List<Acesso> acessos) {
		this.id = id;
		this.login = login;
		this.senha = senha;
		this.dataAtuaSenha = dataAtuaSenha;
		this.pessoa = pessoa;
		this.empresa = empresa;
		this.acessos = acessos;
	}

	public boolean validaAcesso(String acesso) {
		return this.getAcessos().stream()
				.anyMatch(a -> a.getDescricao().equalsIgnoreCase(acesso));
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return acessos;
	}

	@Override
	public String getPassword() {
		return senha;
	}

	@Override
	public String getUsername() {
		return login;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Date getDataAtuaSenha() {
		return dataAtuaSenha;
	}

	public void setDataAtuaSenha(Date dataAtuaSenha) {
		this.dataAtuaSenha = dataAtuaSenha;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public PessoaJuridica getEmpresa() {
		return empresa;
	}

	public void setEmpresa(PessoaJuridica empresa) {
		this.empresa = empresa;
	}

	public List<Acesso> getAcessos() {
		return acessos;
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
}
