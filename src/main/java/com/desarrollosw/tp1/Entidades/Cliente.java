package com.desarrollosw.tp1.Entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cliente extends BaseEntity{
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name="persona_id")
    private List<Domicilio> domicilios=new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name="persona_id")
    private List<Pedido> pedidos= new ArrayList<>();

    public void agregarDomicilio(Domicilio domicilio){
        domicilios.add(domicilio);
    }

    public void agregarPedido(Pedido pedido){
        pedidos.add(pedido);
    }
}
