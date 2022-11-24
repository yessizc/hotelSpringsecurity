package com.hotel.demo.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Reserva_Habitacion")
public class Reserva_Habitacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "idReserva")
    private Long idReserva;

    @Column(name = "idHabitacion")
    private Long idHabitacion;

    public Reserva_Habitacion(){}

    public Reserva_Habitacion(Long id, Long idReserva, Long idHabitacion) {
        this.id = id;
        this.idReserva = idReserva;
        this.idHabitacion = idHabitacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Long idReserva) {
        this.idReserva = idReserva;
    }

    public Long getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(Long idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    
}
