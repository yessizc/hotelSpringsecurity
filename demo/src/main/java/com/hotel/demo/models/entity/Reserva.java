package com.hotel.demo.models.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Reservas")
public class Reserva  implements Serializable{
	
	private static final long serialVersionUID=1L;
	
	@Id
	//con esta etiqueta se genera el id de forma automatica
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	//esta etiqueta es para crear la columna donde va a estar el id
	@Column(name="id")
	private Long id;
	
	@Column(name="FechaIngreso")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date FechaIngreso;
	
	@Column(name="FechaSalida")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date FechaSalida;
	
	@OneToMany( cascade = CascadeType.ALL)
    @JoinColumn(name = "Idusuario")
	private List<Usuario> usuario;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="Idfactura")
	private Factura factura;


	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFechaIngreso() {
		return FechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		FechaIngreso = fechaIngreso;
	}

	public Date getFechaSalida() {
		return FechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		FechaSalida = fechaSalida;
	}

	public List<Usuario> getUsuario() {
		return usuario;
	}

	public void setUsuario(List<Usuario> usuario) {
		this.usuario = usuario;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}
	
	
	
	
	
	

}
