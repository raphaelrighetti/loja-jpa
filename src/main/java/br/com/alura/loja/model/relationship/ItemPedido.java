package br.com.alura.loja.model.relationship;

import br.com.alura.loja.model.pedido.Pedido;
import br.com.alura.loja.model.produto.Produto;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "ItemPedido")
@Table(name = "item_pedido")
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "preco_unitario")
    private BigDecimal precoUnitario;

    private Integer quantidade;

    @ManyToOne
    private Produto produto;

    @ManyToOne
    private Pedido pedido;

    public ItemPedido() {
    }

    public ItemPedido(Integer quantidade, Produto produto, Pedido pedido) {
        this.precoUnitario = produto.getPreco();
        this.quantidade = quantidade;
        this.produto = produto;
        this.pedido = pedido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
