
public class Case {
	// TODO verifier implementation
	//private coordonnee positionCase;
	private boolean couleur;
	private int nombreFourmis;
	
	public Case (){
		couleur=false;
		nombreFourmis=0;
	}
	public boolean getCouleur(){
		return couleur;
	}
	
	public void setColor(boolean nouvelleCouleur){
		couleur=nouvelleCouleur;
	}
	
	public void plusNombreFourmis(int addition){
		/*Ajoute $addition fourmis dans un objet case*/
		nombreFourmis=nombreFourmis+addition;
	}
	
	public void moinsNombreFourmis(int soustraction){
		/*Enleve $soustraction fourmis dans un objet case*/
		nombreFourmis=nombreFourmis-soustraction;
	}
	
	public int getNombreFourmis(){
		return nombreFourmis;
	}
}