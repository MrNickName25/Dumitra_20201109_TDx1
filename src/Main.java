import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws Exception {
		ArrayList<Orange>panier=new ArrayList<Orange>();
		Panier pan= new Panier();
		
//		panier.add(new Orange(-0.8,"Canada"));
		panier.add(new Orange(0.8,"France"));
		panier.add(new Orange(0.8,"Spain"));
		panier.add(new Orange(0.99,"USA"));
		panier.add(new Orange(0.99,"Argentina"));
		pan=new Panier(panier,6);
		
		Panier pan4=new Panier(panier,4);
		pan4.taille(panier);
		System.out.println(pan4.estPlein()+"  taille maximale");
		System.out.println(pan4.estVide()+"  panier est vide");

		header();		
		System.out.println(pan.toString());
		System.out.println("Le prix total du panier : "+pan.getPrix());
		
		Orange o1=new Orange(0.8,"Canada");
		Orange o2=new Orange(0.99,"USA");
		Orange o3=new Orange();
		o3=o1; 
		o1.equals(o2);
		o1.equals(o3);
		o1.toString();
		pan.ajoute(o1);
		header();		
		System.out.println(pan.toString());
		System.out.println("Le prix total du panier : "+pan.getPrix());
		
		pan.retire();
		header();		
		System.out.println(pan.toString());
		System.out.println("Le prix total du panier : "+pan.getPrix());
		
		pan.boycotPays("USA");
		header();		
		System.out.println(pan.toString());
		System.out.println("Le prix total du panier : "+pan.getPrix());
		
		Panier pan2= new Panier();
		pan2=new Panier(panier,10);
		
		Panier pan3= new Panier();
		pan3=new Panier(panier,panier.size());
		pan3.ajoute(o1);
		pan3.boycotPays("France");
		pan.equals(pan3);
		
		Panier pan1= new Panier();
		pan1.estVide();
		System.out.println(pan1.estVide()+"  panier est vide");
		
		pan.ajoute(o2);
		pan.equals(pan2);
		pan.equals(pan1);
		panier.equals(pan);
		pan.equals(panier);
		
	}
	
	public static void header() {
		System.out.println("Origin | Prix     ... de mon panier" );
	}
			
}
