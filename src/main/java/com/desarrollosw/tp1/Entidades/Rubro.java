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
public class Rubro extends BaseEntity{

    private String denominador;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name="rubro_id")
    private List<Producto> productos=new ArrayList<>();


    public void agregarProductos(Producto producto){
        productos.add(producto);
    }
}
