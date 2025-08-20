package main.java.list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompra {

    private List<Item> itens;

    public CarrinhoDeCompra() {
        this.itens = new ArrayList<>();
    }

    //Adicionar
    public void adicionarItem(String nome, double preco, int quantidade) {
        itens.add(new Item(nome, preco, quantidade));
    }

    //Remover (pelo nome)
    public void removerItem(String nome) {
        itens.removeIf(item -> item.getNome().equalsIgnoreCase(nome));
    }

    //Calcular valor total
    public double calcularValorTotal() {
        double total = 0;
        for (Item item : itens) {
            total += item.getValorTotal();
        }
        return total;
    }

    //Exibe itens
    public void exibirItens() {
        if (itens.isEmpty()) {
            System.out.println("O carrinho está vazio.");
        } else {
            for (Item item : itens) {
                System.out.println(item);
            }
        }
    }

    //Main==================================
    public static void main(String[] args) {
        CarrinhoDeCompra carrinho = new CarrinhoDeCompra();

        carrinho.adicionarItem("Notebbok", 3500.00, 1);
        carrinho.adicionarItem("Mouse", 120.00, 2);
        carrinho.adicionarItem("Teclado", 250.00, 1);

        System.out.println("Itens no carrinho:");
        carrinho.exibirItens();

        System.out.println("\nvalor total: R$ " + carrinho.calcularValorTotal());

        carrinho.removerItem("Mouse");
        System.out.println("\nApós remover o Mouse:");
        carrinho.exibirItens();

        System.out.println("\nValor total atualizado: R$ " + carrinho.calcularValorTotal());
    }
}
