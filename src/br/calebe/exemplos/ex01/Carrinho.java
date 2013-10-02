//Bruno Vendramini Cordeiro   31063500
//Felipe Polachini Iandoli    31016138

package br.calebe.exemplos.ex01;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {

    private List<Produto> produtos;

    public Carrinho() {
        produtos = new ArrayList<>();
    }

    public void add(Produto produto) throws ProdutoNegativoExpected {
        if(produto.getPreco() < 0) throw new ProdutoNegativoExpected();
        else produtos.add(produto);
    }

    public Produto menorProduto() throws CarrinhoVazioExpected, ProdutoNegativoExpected {
        if (produtos.isEmpty()) {
            throw new CarrinhoVazioExpected();
        }
        Produto menor = produtos.get(0);
        for (Produto produto : produtos) {
            if (produto.getPreco() < menor.getPreco()) {
                menor = produto;
            }
        }
        return menor;
    }
    
    public List ListaCarrinho() throws CarrinhoVazioExpected {
        return produtos;
    }
    
    public void ImprimiCarrinho() throws CarrinhoVazioExpected, ProdutoNegativoExpected {
        for ( Produto produto : produtos)
               System.out.println(produto.getNome() + " - " + produto.getPreco());
    }
    
    public void RemoveProduto(Produto p){
        produtos.remove(p);
    }
    
    public double ValorTotal() throws ProdutoNegativoExpected{
        double valorTotal = 0.0;
        for ( Produto produto : produtos){
            valorTotal += produto.getPreco();
        }
        if(valorTotal < 0) throw new ProdutoNegativoExpected();
        return valorTotal;
    }
    
}
