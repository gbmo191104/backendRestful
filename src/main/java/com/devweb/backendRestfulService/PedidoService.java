package com.devweb.backendRestfulService;

import com.devweb.backendRestful.Pedido;
import com.devweb.backendRestfulRepository.PedidoRepository;
import com.devweb.backendRestfulRepository.ClienteRepository;
import com.devweb.backendRestfulRepository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public Pedido salvar(Pedido pedido) {
        if (!clienteRepository.existsById(pedido.getIdCliente())) {
            throw new IllegalArgumentException("Cliente inválido");
        }
        if (pedido.getIdsProdutos() == null || pedido.getIdsProdutos().isEmpty()) {
            throw new IllegalArgumentException("Pedido deve conter ao menos um produto");
        }
        pedido.getIdsProdutos().forEach(idProduto -> {
            if (!produtoRepository.existsById(idProduto)) {
                throw new IllegalArgumentException("Produto inválido: " + idProduto);
            }
        });
        return pedidoRepository.save(pedido);
    }

    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> buscarPorId(Long id) {
        return pedidoRepository.findById(id);
    }

    public List<Pedido> buscarPorIdCliente(Long idCliente) {
        return pedidoRepository.findByIdCliente(idCliente);
    }

    public List<Pedido> buscarPorIdProduto(Long idProduto) {
        return pedidoRepository.findByIdsProdutosContaining(idProduto);
    }
}