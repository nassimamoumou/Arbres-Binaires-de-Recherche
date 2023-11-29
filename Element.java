import java.lang.Math;

public class Element {

	private int cle ;
	private double contenu ;

	public Element(){
		this.cle = (int)(Math.random() * 100);
        this.contenu= Math.random() * 100;
	}

	public Element(int _cle, double _contenu){                 
		this.cle=_cle;
		this.contenu=_contenu;
	}

	public int getCle(){
		return cle;
	}
	public double getContenu(){
		return contenu;
	}

	public void setCle(int n_cle){
		this.cle = n_cle;
	}
	public void setContenu(double n_contenu){
		this.contenu = n_contenu;
	}


	public String toString(){
		return " Clé : " + cle + " -> Contenu : " + contenu;
	}

}
