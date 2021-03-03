package com.dca.test.restaurant.models.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cajeros")
public class Cajero implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private static final long serialversionUID = 1l;

    private String name;
    @Column(name = "last_name")

    private String lastName;

    @Column(name = "num_documento", unique = true)
    private String numDocumento;

}
