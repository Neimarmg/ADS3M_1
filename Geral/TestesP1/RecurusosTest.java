package TestesP1;
//http://junit.sourceforge.net/javadoc/org/junit/Assert.html
import static org.junit.Assert.*;
import java.util.*;
import junit.framework.Assert;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import app.Recurusos;


@RunWith(JUnit4.class)
public class RecurusosTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Passei por aqui @BeforeClass");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Passei por aqui @AfterClass");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Passei por aqui @Before");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Passei por aqui  @After");
	}

	@Test
	public void test() {
		double valor = Recurusos.fibonacci(1);
		assertEquals("Teste = 1.",1,valor,0);
		
		valor = Recurusos.fibonacci(0);
		assertEquals("Teste = 0.",1,valor,0);
		
		valor = Recurusos.fibonacci(2);
		assertEquals("Teste = 2.",1,valor,0);
		
		valor = Recurusos.fibonacci(8);
		assertEquals("Teste = 8.",21,valor,0);
		
	}

}
