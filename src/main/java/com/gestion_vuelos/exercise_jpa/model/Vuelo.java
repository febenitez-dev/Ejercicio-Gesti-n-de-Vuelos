package com.gestion_vuelos.exercise_jpa.model;

import jakarta.persistence.*;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import org.hibernate.annotations.*;

import java.time.*;


@Entity
@Table(name = "vuelo")
@NamedQueries(value = {
        @NamedQuery(name = "SelectAllFromVuelos", query = "SELECT v FROM Vuelo v"),
        @NamedQuery(name ="", query = "SELECT v FROM Vuelo v  WHERE v.piloto = :id")
})

public class Vuelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 8, nullable = false, name = "codigo_vuelo")
    private String codigoVuelo;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "avion")
    private Avion avion;

    @OneToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "piloto")
    private Piloto piloto;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "aeropuerto_origen")
    private Aeropuerto origen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aeropuerto_destino")
    private Aeropuerto destino;

    @Column(nullable = false)
    private LocalDateTime fecha;

    @Column(nullable = false)
    private int duracionHoras;

    @CreationTimestamp
    private LocalDate fechaCreacion;

    @UpdateTimestamp
    private LocalDateTime fechaModificacion;

    public Vuelo() {}

    public Vuelo(Long id, String codigoVuelo, Avion avion, Piloto piloto, Aeropuerto origen, Aeropuerto destino, LocalDateTime fecha, int duracionHoras) {
        this.id = id;
        this.codigoVuelo = codigoVuelo;
        this.avion = avion;
        this.piloto = piloto;
        this.origen = origen;
        this.destino = destino;
        this.fecha = fecha;
        this.duracionHoras = duracionHoras;
    }

    public Long getId() {
        return id;
    }

    public String getCodigoVuelo() {
        return codigoVuelo;
    }

    public void setCodigoVuelo(String codigoVuelo) {
        this.codigoVuelo = codigoVuelo;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public Piloto getPiloto() {
        return piloto;
    }

    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }

    public Aeropuerto getOrigen() {
        return origen;
    }

    public void setOrigen(Aeropuerto origen) {
        this.origen = origen;
    }

    public Aeropuerto getDestino() {
        return destino;
    }

    public void setDestino(Aeropuerto destino) {
        this.destino = destino;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public int getDuracionHoras() {
        return duracionHoras;
    }

    public void setDuracionHoras(int duracionHoras) {
        this.duracionHoras = duracionHoras;
    }
}
