package com.gestion_vuelos.exercise_jpa.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Pasaporte {

    //@‌CreationTimestamp y @‌UpdateTimestamp
    @Id
    @GeneratedValue
    Long id;
    String numeroPasaporte;
    String nacionalidad;
    LocalDate fechaVencimiento;
    LocalDate fechaEmision;
    @CreationTimestamp
    LocalDate fechaCreacion;
    @UpdateTimestamp
    LocalDate fechaActualizacion;

    public Pasaporte() {}

    public Pasaporte(String numeroPasaporte,
                    String nacionalidad,
                    String fechaVencimiento,
                    String fechaEmision) {}

    private void setFechaVencimiento(LocalDate fechaVencimiento) {
            if (fechaVencimiento.isAfter(LocalDate.now())){
                this.fechaVencimiento = fechaVencimiento;
            }
    }

    private void setFechaEmision(LocalDate fechaEmision) {
            if (fechaEmision.isBefore(fechaVencimiento)){
                this.fechaEmision = fechaEmision;
            }
    }
    void actualizar(LocalDate fechaVencimiento, LocalDate fechaEmision) {
            setFechaVencimiento(fechaVencimiento);
            setFechaEmision(fechaEmision);
    }
}
