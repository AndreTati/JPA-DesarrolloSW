# JPA-DesarrolloSW
Trabajo Práctico desarrollado para la cátedra Desarrollo de Software de Ingeniería en Sistemas de Información - UTN FRM

# Desarrollo de la lógica
El Trabajo Práctico de JPA fue desarrollado de la siguiente manera
1- Primero creamos la calse BaseEntity anotada con @MappedSuperclass para indicar que no debe persistirse como tal sino que va a ser heredada por las otras entidades para poder implementar un Id genérico.
2- Luego creamos las clases correspondientes al diagrama de clases utilizando anotaciones de la librería Lombok como @Data, @NoArgsConstructor, @AllArgsConstructor. Además extienden de BaseEntity y también inluye la anotación @Entity para indicar que corresponde a una tabla de la base de datos.
3- Siguiendo las relaciones y navegabilidad del diagrama de clases incluimos las anotaciones @OneToOne, @OneToMany e indicamos donde debían estar las FK de las entidades relacionadas
4- Agregamos los repositorios correspondientes a las entidades creadas. Estas clases deben ser interfaces e implementar JPA Repository para poder utilizar los métodos de JPA a la hora de persistir los datos.
5- En el main implementamos la lógica de guardado en la base de datos de la siguiente manera:
    a) Comenzamos con Rubro y Producto, debido a la relación se puede persistir ambos en la misma transacción
    b) Luego persistimos un cliente con sus domicilios y pedidos incluidos. Dentro del pedido se encuentra el detalle del              pedido y la factura correspondiente.
6- Para poder utilizar los repositorios en la clase donde se implementa el método main declaramos un objeto de tipo Repository que utilizamos anotado con @Autowired. Esta técnica conocida como inyección de dependencia posibilita utilizar repositorios sin necesidad de establecer relaciones con ellos.

# Concluciones
Utilizar Spring Boot, JPA y Lombok en el desarrollo de aplicaciones es una experiencia enriquecedora que conlleva varios aprendizajes:

-  Spring Boot simplifica el proceso de configuración y desarrollo de aplicaciones Java, lo que acelera la velocidad de desarrollo. Además, Lombok reduce la cantidad de código boilerplate, lo que permite escribir menos código y centrarse en la lógica empresarial.

-  JPA (Java Persistence API) facilita la gestión de la capa de persistencia, permitiendo mapear objetos Java a tablas de bases de datos de manera sencilla. Esto simplifica las operaciones de lectura y escritura en la base de datos y mejora la eficiencia en el manejo de datos.

-  Inyección de dependencias y contenedor IoC: Spring Boot utiliza el principio de inversión de control (IoC) y la inyección de dependencias para administrar componentes y sus dependencias.






