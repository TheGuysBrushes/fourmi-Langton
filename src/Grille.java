import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Grille extends JFrame implements ActionListener {
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
	private JLabel noir; //a changer en JLabel
	private JLabel blanc;//a changer en JLabel
	
	
	public Grille() {
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
		this.setSize(650,600);
		this.configuration.add(this.configurer);
		this.add(this.configuration, BorderLayout.NORTH);
		
		this.interfaceg.add(this.go);
		this.interfaceg.add(this.pause);
		this.interfaceg.add(this.fast);
		this.interfaceg.add(this.remove);
		this.interfaceg.setLayout(new GridLayout(1,4));
		this.add(this.interfaceg, BorderLayout.SOUTH);
		
		this.add(this.grille, BorderLayout.CENTER);
		this.grille.setSize(500,500);
		this.grille.setLayout(new GridLayout(50,50));
		this.setResizable(false);
		
		
		Case[][] tableauCase = new Case[100][100];
		Fourmi f = new Fourmi();
		f.setDirection(1);
		f.setAbs(4);
		f.setOrd(1);
		
		for (int i=1; i<=30;i++){
			for (int j=1; j<=31;j++){
				tableauCase[i][j]=new Case();
			}
		}
		f.actionArrive(tableauCase);
		tableauCase[3][3].setColor(true);
		for (int tmp=00;tmp<5;tmp++){
		for (int i=1; i<=10;i++){
			for (int j=1; j<=11;j++){/*TODO mettre un suel nom pour la couleur de case-> un suel if*/
				if(!tableauCase[i][j].getCouleur()){
					blanc = new JLabel(Integer.toString(i)+Integer.toString(j));
					blanc.setBackground(Color.white);
					blanc.setOpaque(true);
					grille.add(blanc);
					
					if(tableauCase[i][j].getNombreFourmis()>0){
						blanc.setText("Four ");
					}
				}
				else {
					noir = new JLabel("");
					noir.setBackground(Color.gray);
					noir.setOpaque(true);
					grille.add(noir);
					
					if(tableauCase[i][j].getNombreFourmis()>0){
						noir.setText("         /\\ ");
					}
				}
			}
		}
		f.actionDepart(tableauCase);
		f.deplacement(tableauCase);
		f.actionArrive(tableauCase);
		/*try{
		    Thread.sleep(3000);
		}catch(InterruptedException e){
		    System.out.println("got interrupted!");
		}*/
		}
		
	}
	
	private void buildEvents() {
		
	}


	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public boolean contient(coordonnee positionFourmi) {
		// TODO Auto-generated method stub
		return false;
	}
}

