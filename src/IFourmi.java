import java.awt.Graphics;


public interface IFourmi {
	public void actionDepart(Case[][] c);
	public void deplacement(Case[][] c,coordonnee maxGrille);	//TODO grille est un tableau de cases
	public void actionArrive(Case[][] c);
	public boolean estMort();
	public void paintComponent(Graphics g);

}
