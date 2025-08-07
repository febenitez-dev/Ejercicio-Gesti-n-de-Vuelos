package com.gestion_vuelos.exercise_jpa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Pasaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vuelo_pasaje", referencedColumnName = "id")
    private Vuelo vuelo;

    @ManyToOne
    @JoinColumn(name = "pasajero_id", referencedColumnName = "id") // consultar esto
    private Pasajero pasajero;

    @OneToOne
    @JoinColumn(name = "asiento_id", referencedColumnName = "id")
    private Asiento asiento;

    @Column(nullable = false)
    private double precio;

    public Pasaje(Long id, Vuelo vuelo, Pasajero pasajero, Asiento asiento, double precio) {
        this.id = id;
        this.vuelo = vuelo;
        this.pasajero = pasajero;
        this.asiento = asiento;
        this.precio = precio;
    }

    public Long getId() {
        return id;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }
}
