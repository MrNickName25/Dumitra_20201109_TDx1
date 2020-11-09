import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class OrangeTest {
	Panier p0;
	Panier p1,p2,p3=new Panier();
	ArrayList<Orange>panier;
	ArrayList<Orange>panier1;
	Orange o0;
	Orange o1,o2,o3,o5;
	 
	
	@Before
	public void setup() throws Exception {
		o1=new Orange(0.8,"France");
		o2=o1;
		o3=new Orange(0.9,"Spain");
		o5=new Orange(0.55,"Chile");
		panier=new ArrayList<Orange>();
		panier1=new ArrayList<Orange>();
		
	}

	@Test
	public void testPanierNull() {
		assertNull(p0);
	}

	@Test
	public void testOrangeNull() {
		assertNull(o0);
	}

	@Test (expected = Exception.class)
	public void testPrixOrangePasNegatif() throws Exception {
		Orange o4=new Orange(-0.8,"Spain");
	}
	
	@Test
	public void testConstructeurVide() {
		Panier p10 =new Panier(panier,1);
		assertTrue(p10.estVide());
	}
	
	@Test
	public void testAjoutOrange() throws Exception {
		panier.add(o1);
		Panier p1 =new Panier(panier,2);
		Panier p4 =new Panier(panier1,2);
		p4.ajoute(o3);
		assertFalse(p1.equals(p4));
	}
	
	@Test
	public void testOrangeEgales() {
		assertEquals(o1,o2);
	}
	
	@Test
	public void testPaniersEgaux() throws Exception {
		p1=new Panier(panier,5);
		p3=new Panier(panier1,5);
		p1.ajoute(o3);p1.ajoute(o2);
		p3.ajoute(o1);p3.ajoute(o3);
		assertEquals(p1,p3);
	}
	
	@Test
	public void testTailleMaxPanier() throws Exception {
		panier.add(o1);
		panier.add(o3);

		p2 =new Panier(panier,2);
		assertEquals(2,p2.taille(panier));
	}
	
	@Test
	public void testEstPlein() throws Exception {
		panier.add(o1);
		panier.add(o3);
		p2 =new Panier(panier,2);
		assertTrue(p2.estPlein());
	}

	@Test
	public void testRetire() throws Exception {
		panier.add(o1);
		panier1=panier;
		Panier p7=new Panier(panier1,1);
		panier.add(o3);
		
		p2 =new Panier(panier,2);
		p2.retire();
		assertTrue(p2.equals(p7));
	}
	
	@Test
	public void testPrixTotal() {
		panier.add(o1);
		panier.add(o5);
		p2 =new Panier(panier,2);
		assertTrue(1.35==p2.getPrix());
	}

	@Test
	public void testBoycotPays() {
		panier.add(o1);
		panier.add(o5);
		p2=new Panier(panier,5);
		p2.boycotPays("France");
		panier1.add(o5);
		p3=new Panier(panier1,5);
		assertEquals(p3,p2);
	}
}
