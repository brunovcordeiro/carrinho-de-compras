//Bruno Vendramini Cordeiro   31063500
//Felipe Polachini Iandoli    31016138

package br.calebe.exemplos.ex01;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Before;
import org.junit.Test;

public class CarrinhoTest {

    private Carrinho carrinho;

    @Before
    public void criandoCarrinho() {
        carrinho = new Carrinho();
    }

    @Test(expected = CarrinhoVazioExpected.class)
    public void colocandoZeroProduto() throws CarrinhoVazioExpected, ProdutoNegativoExpected {
        Produto menor;
        menor = carrinho.menorProduto();
        Assert.assertEquals(null, menor);
    }

    @Test
    public void colocandoUmProduto() throws CarrinhoVazioExpected, ProdutoNegativoExpected {
        Produto livro = new Produto("Java em 24 horas", 50.00);
        carrinho.add(livro);
        Produto menor;
        menor = carrinho.menorProduto();
        Assert.assertEquals(livro, menor);
    }

    @Test
    public void colocandoMaisProdutos() throws CarrinhoVazioExpected, ProdutoNegativoExpected {
        Produto livro = new Produto("Java em 24 horas", 50.00);
        carrinho.add(livro);
        Produto deitel = new Produto("Java: como programar", 150.00);
        carrinho.add(deitel);
        Produto menor;
        menor = carrinho.menorProduto();
        Assert.assertEquals(livro, menor);
    }

    @Test
    public void identidadeDeProdutos() throws CarrinhoVazioExpected, ProdutoNegativoExpected {
        Produto original = new Produto("Java em 24 horas", 50.00);
        carrinho.add(original);
        Produto copia = new Produto("Java em 24 horas", 50.00);
        original = carrinho.menorProduto();
        Assert.assertEquals(original, copia);
    }
    
    @Test
    public void ListaProdutoCarrinho() throws CarrinhoVazioExpected, ProdutoNegativoExpected { //Adiciona no carrinho lista de produto negativo e imprimi causando erro
        Produto anel = new Produto("Anel",1000);
        Produto celular = new Produto("Iphone" , 5000);
        Produto mouse = new Produto ("Mouse" , 500);
        carrinho.add(mouse);
        carrinho.add(celular);
        carrinho.add(anel);
        Assert.assertNotNull(carrinho.ListaCarrinho());
        carrinho.ImprimiCarrinho();
        
    }
    
    @Test
    public void ListaProdutoCarrinhoNegativo() throws CarrinhoVazioExpected, ProdutoNegativoExpected { //Adiciona no carrinho lista de produto negativo e imprimi causando erro
        Produto anel = new Produto("Anel",1000);
        Produto celular = new Produto("Iphone" , 5000);
        Produto mouse = new Produto ("Mouse" , -500);
        carrinho.add(mouse);
        carrinho.add(celular);
        carrinho.add(anel);
        Assert.assertNotNull(carrinho.ListaCarrinho());
        carrinho.ImprimiCarrinho();
        
    }
    
    @Test
    public void RemoveProdutoCarrinho () throws ProdutoNegativoExpected, CarrinhoVazioExpected{
        Produto anel = new Produto("Anel",1000);
        Produto celular = new Produto("Iphone" , 5000);
        Produto mouse = new Produto ("Mouse" , 500);
        carrinho.add(mouse);
        carrinho.add(celular);
        carrinho.add(anel);
        carrinho.RemoveProduto(anel);
        List<Produto> p = new ArrayList<>();
        p = carrinho.ListaCarrinho();
        for (Produto produto : p){
            Assert.assertNotSame(produto , anel);
        }        
    }
    
    @Test public void TotalCompraCarrinho() throws ProdutoNegativoExpected{
        Produto anel = new Produto("Anel",1000);
        Produto celular = new Produto("Iphone" , 5000);
        Produto mouse = new Produto ("Mouse" , 500);
        carrinho.add(mouse);
        carrinho.add(celular);
        carrinho.add(anel);
        Double ValorTotal;
        ValorTotal = carrinho.ValorTotal();
        Assert.assertNotNull(ValorTotal);      
    }
    
}
