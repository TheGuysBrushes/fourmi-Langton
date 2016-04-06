import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;
/**/
/**
 * La classe Fourmi décrit le comportement de la fourmi classique
 * @author flodavid, rcharlot
 * @version 0.4
 */

public class Fourmi extends JPanel implements IFourmi{

	private static final long serialVersionUID = 1L;
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
			typeFourmi = 3;
			// TODO position de depart selon ???
			/*coordonnee positionFourmiInit= new coordonnee(x,y);
			this.positionFourmi=positionFourmiInit;*/
			// TODO random direction? direction=;
			direction = 0;
			mort = false;
		}
	
	public Fourmi(int x, int y){
	// TODO creation constructeur fourmi
		typeFourmi = 3;
		// TODO position de depart selon ???
		coordonnee positionFourmiInit= new coordonnee(x,y);
		this.positionFourmi=positionFourmiInit;
		// TODO random direction? direction=;
		direction = 0;
		mort = false;
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
	
	public boolean estMort(){
		return mort;
	}

	public void calculMort(coordonnee maxGrille) {
		if(positionFourmi.getAbs()<=0 || positionFourmi.getAbs()>=maxGrille.getAbs() || positionFourmi.getOrd()<=0 || positionFourmi.getOrd()>=maxGrille.getOrd()){
			System.out.println("La fourmi est morte");
			mort=true;
		}
	}
	
	public void actionDepart(Case[][] c) {
		if (!this.couleurCaseActuel){
			c[positionFourmi.getAbs()][positionFourmi.getOrd()].setCouleur(true);
			this.setDirection(1);
		}
		else {
			c[positionFourmi.getAbs()][positionFourmi.getOrd()].setCouleur(false);
			this.setDirection(-1);
		}
		c[positionFourmi.getAbs()][positionFourmi.getOrd()].moinsNombreFourmis(1);
	}


	public void deplacement(Case[][] c, coordonnee maxGrille) {
		// TODO Verifier checkEtat, grille est un tableau de cases
		if (this.direction==0)
			this.positionFourmi.setOrd(this.positionFourmi.getOrd()-1);
		if (this.direction==1)
			this.positionFourmi.setAbs(this.positionFourmi.getAbs()+1);
		if (this.direction==2)
			this.positionFourmi.setOrd(this.positionFourmi.getOrd()+1);
		if (this.direction==3)
			this.positionFourmi.setAbs(this.positionFourmi.getAbs()-1);
		this.calculMort(maxGrille);
	}


	public void actionArrive(Case[][] c) {
		//cannibales
		if(!estMort()){
			this.couleurCaseActuel=c[positionFourmi.getAbs()][positionFourmi.getOrd()].getCouleur();
			c[positionFourmi.getAbs()][positionFourmi.getOrd()].plusNombreFourmis(1);
		}
	}
	
	 public void paintComponent(Graphics g){
        super.paintComponent(g);
        int[] posAbs; 
        int[] posOrd;
        switch (this.direction){
        case 0 :// Fourmi orientee vers le haut
	        	posAbs = new int[]{5,0,10};
	        	posOrd = new int[]{0,10,10};
	        
        	break;
        case 1 :{ // Fourmi orientee vers la droite
	        	posAbs = new int[]{11,1,1};
	        	posOrd = new int[]{5,0,10};
	        }
        	break;
        case 2 :{
	        	posAbs = new int[] {6,1,11};
	        	posOrd = new int[]{10,0,0};
	        }
        	break;
        case 3 : {// Fourmi orientee vers la gauche
        	posAbs = new int[]{1,11,11};
        	posOrd = new int[]{5,0,10};
        	}
        	break;
        default: {
        		posAbs = new int[]{5,5,5};
	    		posOrd = new int[]{5,5,5};
        	}
        }
        switch (this.typeFourmi){
        case 1 :
        	g.setColor(Color.red);
        break;
        case 2 :
        	g.setColor(Color.green);
        break;
        case 3 :
        	g.setColor(Color.blue);
        break;
        default : 
        	g.setColor(Color.black);
        }
        g.fillPolygon(posAbs, posOrd, 3);
	 }


}
