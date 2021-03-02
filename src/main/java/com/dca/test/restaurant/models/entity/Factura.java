package com.dca.test.restaurant.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Factura implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private static final long serialversionUID = 1l;

    @Column(name = "id_casher")
    @OneToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler","name","lastName","numDocumento"})
    Cajero casher;

    @Column(name = "nom_client")
    private String nomClient;

    @Column(name = "num_documento")
    private String numDocumento;

    @Column(name = "fecha")
    private LocalDate createAt;

    private double precio;//variable que tendra el valor total de la factura

    private double pago;//variable que nos indica cuanto pago el cliente

    private double vuelto;

    @Column(unique = true)
    private long codigoFactura;

    @OneToMany
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    List<Venta> ventas;

}
