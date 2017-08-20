/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.M;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 181100053
 */
public class PessoaTest {
    
    public PessoaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setCodPessoa method, of class Pessoa.
     */
    @Test
    public void testSetCodPessoa() {
        Pessoa p = new Pessoa("1","neimar","d","s");  
        System.out.println("setCodPessoa");     
        String result = p.getCodPessoa();
        String result1 = p.getNome();
        String result2 = p.getCodTipo();
        String result3 = p.getSexo();
        
        assertEquals("1", result);
        assertEquals("neimar", result1);
        assertEquals("d", result2);
        assertEquals("s", result3);           
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    
    
}
