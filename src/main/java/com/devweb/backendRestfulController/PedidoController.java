package com.devweb.backendRestfulController;

import com.devweb.backendRestful.Pedido;
import com.devweb.backendRestfulService.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public Pedido criar(@RequestBody Pedido pedido) {
        return pedidoService.salvar(pedido);
    }

    @GetMapping
    public List<Pedido> listarTodos() {
        return pedidoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Pedido buscarPorId(@PathVariable Long id) {
        return pedidoService.buscarPorId(id).orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }

    @GetMapping("/cliente/{idCliente}")
    public List<Pedido> buscarPorIdCliente(@PathVariable Long idCliente) {
        return pedidoService.buscarPorIdCliente(idCliente);
    }

    @GetMapping("/produto/{idProduto}")
    public List<Pedido> buscarPorIdProduto(@PathVariable Long idProduto) {
        return pedidoService.buscarPorIdProduto(idProduto);
    }
}
