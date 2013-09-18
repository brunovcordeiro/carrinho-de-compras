/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.calebe.exemplos.ex01;

import org.junit.Assert;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Before;
import org.junit.Test;


/**
 *
 * @author 31063500
 */
public class ProdutoTest {
    
    private Produto anel;
    private Produto celular;

    @Before
    public void CriandProduto() {
        
        anel = new Produto("Anel",1000);
        celular = new Produto("Iphone" , 5000);
        
    }
    
    @Test
    public void TesteGetPreco() throws ProdutoNegativoExpected{
        anel.getPreco();
        Assert.assertNotNull(anel);
    }
    
    @Test
    public void TestaEquals(){
        Assert.assertFalse(anel.equals(anel));
    }
    
    
}