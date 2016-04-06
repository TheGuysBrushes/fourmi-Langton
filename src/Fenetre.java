import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Fenetre extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5084098446231875212L;
	private JPanel configuration;
	private JPanel interfaceg;
	private JButton configurer;
	private JButton go;
	private JButton pause;
	private JButton fast;
	private JButton remove;
	private JPanel grille;
	private JPanel blanc;	//mettre JPanel
	private JPanel noir;	//mettre JPanel
	
	public Fenetre() {
		//this.setVisible(true);
		this.buildComponent();
		this.buildInterface();
		this.buildEvents();
	}
	
	private void buildComponent() {
		this.configuration = new JPanel();
		this.configurer = new JButton("Configurer");
		this.interfaceg = new JPanel ();
		this.go = new JButton(">");
		this.pause = new JButton ("||");
		this.fast = new JButton (">>");
		this.remove = new JButton ("|<");
		this.grille = new JPanel();
		/*this.blanc = new JLabel("O");
		this.noir = new JLabel("X");*/
	}
	
	private void buildInterface(){
		
		
		this.setLayout(new BorderLayout());
		this.setSize(300,360);
		this.setResizable(false);
		
		//Creation button Configurer
		this.configuration.add(this.configurer);
		this.add(this.configuration, BorderLayout.NORTH);
		
		//Construction des boutons de l'interface en bas
		this.interfaceg.add(this.go);
		this.interfaceg.add(this.pause);
		this.interfaceg.add(this.fast);
		this.interfaceg.add(this.remove);
		this.interfaceg.setLayout(new GridLayout(1,4));
		this.add(this.interfaceg, BorderLayout.SOUTH);
		
		//Construction de la grille
		GridLayout gl= new GridLayout(10,0/*inutile*/,1,1);
		this.grille.setLayout(gl);
		grille.removeAll();
		this.add(this.grille, BorderLayout.CENTER);
		//this.grille.setSize(500,500);
		
		Case[][] tableauCase = new Case[100][100];
		Fourmi f = new Fourmi(5,5);
		f.setDirection(1);
		/*f.setAbs(4);
		f.setOrd(2);*/
		/*fourmi_gauche = new Fourmi();
						fourmi_gauche.setDirection(2);
						fourmi_gauche.setOpaque(true);*/
		
		
		for (int i=1; i<=90;i++){
			for (int j=1; j<=90;j++){
				tableauCase[i][j]=new Case();
			}
		}
		f.actionArrive(tableauCase);
		tableauCase[1][3].setCouleur(true);
		for (int tmp=0;tmp<800;tmp++){
			for (int j=1; j<=10;j++){
				for (int i=1; i<=10;i++){
					if(tableauCase[i][j].getNombreFourmis()>0){
						
						grille.add(f);
						if(!tableauCase[i][j].getCouleur()){
							f.setBackground(Color.white);
						}
						else {
							f.setBackground(Color.gray);
						}
					}
					else { 						// cases sans fourmis
						if(!tableauCase[i][j].getCouleur()){
								blanc = new JPanel();
								blanc.setBackground(Color.white);
								grille.add(blanc);
						}
						else {
								noir = new JPanel();
								noir.setBackground(Color.gray);
								noir.setOpaque(true);
								grille.add(noir);
						}
					}			
				}
			}
			this.setVisible(true);
			try{
			 	Thread.sleep(010);
			}catch(InterruptedException e){
			    System.out.println("got interrupted!");
			}
			grille.removeAll();
			
			
			
				
				
				
				f.actionDepart(tableauCase);
				f.deplacement(tableauCase);
				f.actionArrive(tableauCase);
		/**/
			
		}		
			
		/**/
		
	}
		
	
	private void buildEvents() {
		//this.buildInterface();
	}


	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public boolean contient(coordonnee positionFourmi) {
		// TODO Auto-generated method stub
		return false;
	}
}

