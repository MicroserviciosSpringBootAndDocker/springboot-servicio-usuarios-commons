package com.rodriguez.springboot.app.commons.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true, length = 20)
	private String username;
	@Column(length = 60)
	private String password;
	private boolean enabled;
	private String nombre;
	private String apellido;
	@Column(unique = true, length = 100)
	private String email;
	
	
	//validacion de error o intentos de securidad y se vulve a compilar el jar mvnw clean install
	public Integer intentos;
	
	
	//si se desea crear la tabla intermedia
	
	@JoinTable(name="usuarios_roles" , 
	joinColumns = @JoinColumn(name="usuario_id"),
	inverseJoinColumns = @JoinColumn(name="rol_id"),
	uniqueConstraints = {@UniqueConstraint(columnNames = {"usuario_id","rol_id"})}) 
	@ManyToMany(fetch=FetchType.LAZY)
	private List<Role> roles;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
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


	public boolean isEnabled() {
		return enabled;
	}


	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public List<Role> getRoles() {
		return roles;
	}


	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}


	public Integer getIntentos() {
		return intentos;
	}


	public void setIntentos(Integer intentos) {
		this.intentos = intentos;
	}



	

}