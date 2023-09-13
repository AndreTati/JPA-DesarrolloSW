package com.desarrollosw.tp1.Entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pedido extends BaseEntity{

    private String estado;
    private Date fecha;
    private String tipoEnvio;
    private double total;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name="pedido_id")
    private List<DetallePedido> detallesPedido = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pedido_id")
    private Factura factura;

    public void agregarDetallePedido(DetallePedido detallePedido){
        detallesPedido.add(detallePedido);
    }
}
