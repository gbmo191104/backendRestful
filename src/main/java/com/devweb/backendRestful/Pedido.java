package com.devweb.backendRestful;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long idCliente;

    @ElementCollection
    @Column(nullable = false)
    private List<Long> idsProdutos;
}
