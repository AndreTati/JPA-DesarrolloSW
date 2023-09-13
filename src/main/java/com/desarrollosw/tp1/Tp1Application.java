package com.desarrollosw.tp1;

import com.desarrollosw.tp1.Entidades.*;
import com.desarrollosw.tp1.Repository.ClienteRepository;
import com.desarrollosw.tp1.Repository.PedidoRepository;
import com.desarrollosw.tp1.Repository.ProductoRepository;
import com.desarrollosw.tp1.Repository.RubroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Date;

@SpringBootApplication
public class Tp1Application {

	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	RubroRepository rubroRepository;

	public static void main(String[] args) {
		SpringApplication.run(Tp1Application.class, args);	}

	@Bean
	CommandLineRunner init(ClienteRepository clienteR, RubroRepository rubroR){
		return args -> {
			System.out.println("Guardando datos......");

			Producto producto= Producto.builder()
					.denominacion("Pizza muzzarella")
					.precioCompra(1000)
					.precioVenta(1500)
					.stockActual(25)
					.stockMinimo(5)
					.tiempoEstimadoCocina(30)
					.unidadMedida("unidad")
					.tipo("Manufacturado")
					.receta("Tomate, queso muzzarella")
					.build();

			Rubro rubro= Rubro.builder()
					.denominador("Pizzas")
					.productos(new ArrayList<>())
					.build();

			rubro.agregarProductos(producto);

			rubroRepository.save(rubro);

			DetallePedido detallePedido= DetallePedido.builder()
					.producto(producto)
					.cantidad(2)
					.subtotal(3000)
					.build();

			Pedido pedido= Pedido.builder()
					.total(1500)
					.estado("Entregado")
					.fecha(new Date())
					.tipoEnvio("Delivery")
					.detallesPedido(new ArrayList<>())
					.build();
			pedido.agregarDetallePedido(detallePedido);

			Factura factura= Factura.builder()
					.total(3000)
					.descuento(0)
					.fecha(new Date())
					.numero(25565)
					.tipoPago("Efectivo")
					.build();

			pedido.setFactura(factura);

			Cliente cliente= Cliente.builder()
					.nombre("Pepe")
					.apellido("Honguito")
					.email("pepeH@gmail.com")
					.telefono("")
					.domicilios(new ArrayList<>())
					.pedidos(new ArrayList<>())
					.build();
			Domicilio domicilio=Domicilio.builder()
					.calle("San Martin")
					.numero("123")
					.build();
			cliente.agregarDomicilio(domicilio);
			cliente.agregarPedido(pedido);

			clienteRepository.save(cliente);



		};
	}

}
