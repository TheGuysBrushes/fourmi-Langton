import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
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
	private coordonnee maxGrille;
	private Case[][] tableauCase;
	
	
	public Fenetre() {
		super("Ou est la fourmi ?");
		this.buildComponent();
		this.buildInterface();
		this.buildEvents();
	}
	
	private void buildComponent() {
		configuration = new JPanel();
		configurer = new JButton("Configurer");
		interfaceg = new JPanel ();
		go = new JButton(">");
		pause = new JButton ("||");
		fast = new JButton (">>");
		remove = new JButton ("|<");
		grille = new JPanel();
		maxGrille = new coordonnee(10,10);
		tableauCase = new Case[100][100];
		
	}
	
	private void buildInterface(){
		
		//construction de la fenetre JFrame
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
		GridLayout gl= new GridLayout(maxGrille.getAbs(),0/*inutile*/,1,1);
		this.grille.setLayout(gl);
		grille.removeAll();
		this.add(this.grille, BorderLayout.CENTER);
		//TODO voir taille avec set??? taille colonnes et lignes
		
	}
		
		
	private void buildEvents() {
		//this.buildInterface();
	}
	
	public void lancerDeplacementsFourmis(){
		Fourmi f = new Fourmi(2,2);
		f.setDirection(1);

		JPanel blanc;
		JPanel noir;
		
		for (int i=1; i<=90;i++){
			for (int j=1; j<=90;j++){
				tableauCase[i][j]=new Case();
			}
		}
		f.actionArrive(tableauCase);
		tableauCase[1][3].setCouleur(true);
		for (int tmp=0;tmp<800;tmp++){
			for (int j=1; j<=maxGrille.getAbs();j++){
				for (int i=1; i<=maxGrille.getOrd();i++){
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
			 	Thread.sleep(100);
			}catch(InterruptedException e){
			    System.out.println("got interrupted!");
			}
			grille.removeAll();
			
				f.actionDepart(tableauCase);
				f.deplacement(tableauCase,maxGrille);
				f.actionArrive(tableauCase);
				if(f.estMort())
					f=new Fourmi(1,1);
		}		
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
