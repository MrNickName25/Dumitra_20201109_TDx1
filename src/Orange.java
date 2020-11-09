import java.util.Objects;

public class Orange {
	private double prix;
	private String pays;

	public double getPrix() {
		return prix;
	}
	
	public void setPrix(double prix) throws Exception {
		if (prix<0) {
			throw new Exception("Le prix ne peut pas etre negatif"); 
		}
		else this.prix = prix;
	}

	public String getPays() {
		return pays;
	}
	
	public Orange(double prix, String pays) throws Exception {
		setPrix(prix);
		this.pays = pays;
	}

	public Orange() {
	}

	@Override
	public String toString() {
		return pays +" | " + prix;
	}
	
	@Override
	public boolean equals(Object o){
		if (o instanceof Orange){
			Orange org=(Orange) o;
			return org.getPays()==this.getPays() && Objects.equals(org.getPrix(), this.getPrix());
		}
		else 
				return false;
	}
	
}
