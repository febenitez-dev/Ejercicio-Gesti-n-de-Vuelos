package com.gestion_vuelos.exercise_jpa.model;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Avion {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(length = 30, nullable = false)
   private String modelo;


@Column(length = 100, nullable = false)
   private String aerolinea;

   @OneToMany(mappedBy = "avion")
   private List<Asiento> ListaAsientos;

   @OneToMany(mappedBy = "avion")
   private List<Vuelo> ListaVuelos;

   @CreationTimestamp
   private LocalDateTime altaSistema;

   @UpdateTimestamp
   private LocalDateTime ultimaModificacion;
   
   public Avion(){}

    public Long getId() {
        return id;
    }

    public String getModelo() {
        return modelo;
    }

    public String getAerolinea() {
        return aerolinea;
    }

    public List<Asiento> getListaAsientos() {
        return ListaAsientos;
    }

    public List<Vuelo> getListaVuelos() {
        return ListaVuelos;
    }

    public LocalDateTime getAltaSistema() {
        return altaSistema;
    }

    public LocalDateTime getUltimaModificacion() {
        return ultimaModificacion;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }

    public void setAltaSistema(LocalDateTime altaSistema) {
        this.altaSistema = altaSistema;
    }

    public void setUltimaModificacion(LocalDateTime ultimaModificacion) {
        this.ultimaModificacion = ultimaModificacion;
    }



}



/*
 -ID
-Str Modelo
-Str aerolinea

-Lista asientos
-Lista vuelos

@CreateTimeStamp
-altaSistema

@UpdateTimeStamp
-actualizacionSistema
 */


/*
Como desarrollador necesito crear la entidad del  Avión con todos sus atributos y relaciones

Usar @‌Column(length, nullable, unique)
Para Auditoria
Agregar @‌CreationTimestamp y @‌UpdateTimestamp en las clase Avion


Considerar:
Asientos
Stand by: Piloto, Vuelos
 */