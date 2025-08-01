package com.gestion_vuelos.exercise_jpa.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

public class Pasajero extends Persona {

    /* atributos */
    @OneToMany
    @JoinColumn(name = "pasajero_id")
    private List<Pasaje> pasajes;

    @Column(nullable = true)
    private int cantidadVuelos;

    /* Metodos */
    protected Pasajero() {
        // constructor para jpa
    }

    public Pasajero(String nombre, Pasaporte pasaporte, int cantidadVuelos, List<Pasaje> pasajes) {
        super(nombre, pasaporte);
        this.cantidadVuelos = cantidadVuelos;
        this.pasajes = pasajes;
    }

    public List<Pasaje> getPasajes() {
        return pasajes;
    }

    public void setPasajes(List<Pasaje> pasajes) {
        this.pasajes = pasajes;
    }

    public int getCantidadVuelos() {
        return cantidadVuelos;
    }

    public void setCantidadVuelos(int cantidadVuelos) {
        this.cantidadVuelos = cantidadVuelos;
    }

}
