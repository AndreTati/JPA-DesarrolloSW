package com.desarrollosw.tp1.Entidades;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Factura extends BaseEntity {

    private int numero;
    private Date fecha;
    private double descuento;
    private String tipoPago;
    private int total;


}
