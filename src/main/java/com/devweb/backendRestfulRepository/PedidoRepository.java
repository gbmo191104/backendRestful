package com.devweb.backendRestfulRepository;

import com.devweb.backendRestful.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByIdCliente(Long idCliente);
    List<Pedido> findByIdsProdutosContaining(Long idProduto);
}