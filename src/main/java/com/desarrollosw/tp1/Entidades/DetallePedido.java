package com.desarrollosw.tp1.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetallePedido extends BaseEntity{

    private int cantidad;
    private double subtotal;

    @ManyToOne()
    @JoinColumn(name="producto_id")
    private Producto producto;
}
