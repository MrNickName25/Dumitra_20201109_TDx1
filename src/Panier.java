import java.util.ArrayList;

public class Panier {
	private ArrayList<Orange> panier=new ArrayList<Orange>();
	private int taillemax;
	/*
	 * new panier 5list8orange,10[
	 * quand tu ajoutes des 2lements ds le tableau  -- soit <10 -- aucun probleme
	 * soit sup ou egal a 10 -- taille maximale predefinie atteinte 
	 
	 */
	
	public Panier(ArrayList<Orange> panier, int taillemax) {
		this.panier = panier;
		this.taillemax=taillemax;
	}
	
	public int taille(ArrayList<Orange> panier) {
		return taillemax;
	}
	
	public Panier() { 
	}

	public boolean estPlein() {
		boolean result=false;
		if (panier.size()==this.taillemax) {
			result=true;
		}
		return result;
	}
	
	public boolean estVide() {
		return panier.isEmpty();
	}

	@Override
	public String toString() {
		String chaine="";
			for (Orange o:panier){
				chaine=chaine+"["+o.getPays()+" | "+o.getPrix()+"]";
			}
		return chaine;
	}
	
	public boolean equals(Object o){
		boolean test=false;

		if (o instanceof Panier){
			Panier p=(Panier) o;
			if (this.panier.size()!=p.panier.size()) {
				return test;
			}
			else {
				for (int i=0;i<this.panier.size();i++) {
					for (int j=0;j<p.panier.size();j++) { 
						if ((this.panier.get(i).getPrix()==p.panier.get(j).getPrix()) && (this.panier.get(i).getPays().equals(p.panier.get(j).getPays()))){
							test=true;
							break;
						}
						else
							test=false;
					}
					if (test==false)
						return test;
				}
				return test;
			}
		}
		else return test;
	} 
	
	
	public ArrayList<Orange> ajoute(Orange o) throws Exception{
		if(panier.size() <taillemax)
		panier.add(o);
		else
			System.out.println("Taille max de panier atteinte! Impossible de rajouter");
		return panier;
	}

	
	public ArrayList<Orange> retire(){
		int index = panier.size() - 1; 
        panier.remove(index);
		return panier;
	}
	
	public double getPrix() {
		double sum=0;
		for (int i=0;i<panier.size();i++) {
			sum=sum+panier.get(i).getPrix();
		}
		return sum;
	}
	
	public void boycotPays(String pays) {
		for (int i=0;i<this.panier.size();i++) {
			if(this.panier.get(i).getPays()==pays){
				this.panier.remove(i);
			}
		}
	}
}
