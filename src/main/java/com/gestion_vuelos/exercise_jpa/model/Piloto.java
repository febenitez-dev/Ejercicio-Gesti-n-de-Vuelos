package com.gestion_vuelos.exercise_jpa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity
public class Piloto extends Persona {

    @Column(nullable = false, length = 30, name = "matricula")
    private String matricula;

    @Column(nullable = false, name = "cant_vuelos")
    private int cantidadDeVuelos;

    @Column(nullable = false, name = "horas_vuelo")
    private int horasDeVuelo;

    @OneToOne(mappedBy = "piloto") // consultar si el propietario de la relacion es vuelo o es piloto
    private Vuelo vuelo;

    public Piloto() {
        // constructor para jpa
    }

    public Piloto(String nombre, Pasaporte pasaporte, String matricula, int cantidadDeVuelos, int horasDeVuelo) {
        super(nombre, pasaporte);
        this.matricula = matricula;
        this.cantidadDeVuelos = cantidadDeVuelos;
        this.horasDeVuelo = horasDeVuelo;
    }

    public String getmatricula() {
        return matricula;
    }

    public void setmatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getcantidadDeVuelos() {
        return cantidadDeVuelos;
    }

    public void setcantidadDeVuelos(int cantidadDeVuelos) {
        this.cantidadDeVuelos = cantidadDeVuelos;
    }

    public int gethorasDeVuelo() {
        return horasDeVuelo;
    }

    public void sethorasDeVuelo(int horasDeVuelo) {
        this.horasDeVuelo = horasDeVuelo;
    }

}
