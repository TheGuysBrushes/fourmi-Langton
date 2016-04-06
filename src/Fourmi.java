/**
 * La classe Fourmi décrit le comportement de la fourmi classique
 * @author flodavid
 * @version 0.2
 */

public class Fourmi implements IFourmi{
	/**
	 * typeFourmi indique le type de la fourmi de X à Y
	 */
	private int typeFourmi;
	/**
	 * direction indique vers quelle case la fourmi va se déplacer
	 * 0 pour Nord, 1 pour Est, 2 pour Sud, 3 pour Ouest 
	 */
	private int direction;
	// TODO Description positionF
	// TODO Définition coordonnees
	/**
	 * 
	 */
	private coordonnee positionFourmi;
	/**
	 * mort est un boolean qui indique si la fourmit est dans l'état mort ou non
	 */
	private boolean mort;
	/**
	 * couleurCaseActuel stocke la couleur de la case quand la fourmi est arrivée
	 */
	private boolean couleurCaseActuel;
	
	public Fourmi(){
	// TODO creation constructeur fourmi
		typeFourmi=0;
		coordonnee positionFourmiInit= new coordonnee(0,0);
		this.positionFourmi=positionFourmiInit;
		// TODO random direction? direction=;
	}
	
	/**
	 * 
	 * @return le type de la fourmi
	 */
	public int getTypeF(){
		return typeFourmi;
	}
	
	/**
	 * 
	 * @param quartDeTour indique le nombre de quart de tour a ajouter/retirer à la direction de la fourmi (sens des aiguilles d'une montre)
	 */
	
	public void setDirection(int quartDeTour){
		direction+=quartDeTour;
		while (direction > 3)
			direction-=4;
		while (direction < 0)
			direction+=4;
	}
	

	public void setAbs(int x) {
		// TODO Verifier method
		positionFourmi.setAbs(x);
	}
	
	public void setOrd(int y) {
		// TODO Verifier method
		positionFourmi.setOrd(y);
	}

	private void checkEtat(Grille g) {
		// TODO Auto-generated method stub
		if (!g.contient(this.positionFourmi))
			this.mort=true;
	}
	
	@Override
	public void actionDepart(Case[][] c) {
		if (!this.couleurCaseActuel){
			c[positionFourmi.getAbs()][positionFourmi.getOrd()].setColor(true);
			this.setDirection(1);
		}
		else {
			c[positionFourmi.getAbs()][positionFourmi.getOrd()].setColor(false);
			this.setDirection(-1);
		}
		c[positionFourmi.getAbs()][positionFourmi.getOrd()].moinsNombreFourmis(1);
	}

	@Override
	public void deplacement(Case[][] c) {
		// TODO Verifier checkEtat, grille est un tableau de cases
		if (this.direction==0)
			this.setAbs(-1);
		if (this.direction==1)
			this.setAbs(1);
		if (this.direction==2)
			this.setAbs(1);
		if (this.direction==3)
			this.setAbs(-1);
		//this.checkEtat(g);
	}



	@Override
	public void actionArrive(Case[][] c) {
		// TODO definir type Case
		this.couleurCaseActuel=c[positionFourmi.getAbs()][positionFourmi.getOrd()].getCouleur();
		c[positionFourmi.getAbs()][positionFourmi.getOrd()].plusNombreFourmis(1);
	}
}
