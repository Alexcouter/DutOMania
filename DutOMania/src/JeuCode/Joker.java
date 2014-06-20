package JeuCode;

import javax.swing.JButton;

public class Joker {

	private String nom;
	private boolean dispo;

	public Joker(String nom, boolean dispo) {
		super();
		this.nom = nom;
		this.dispo = dispo;
	}


	public void jokerMoitMoit (Question q, JButton b1, JButton b2, JButton b3, JButton b4){
		int prop1 = 0;
		int prop2 = 0;
		int choix;
		this.setDispo(false);
		System.out.println("enlève une rep");
		do{
			choix = (int) (Math.random()*4);
			System.out.println(choix);
			
			switch(choix){
			case 0 : prop1 = 1;
			break;
			case 1 : prop1 = 2;
			break;
			case 2 : prop1 = 3;
			break;
			case 3 : prop1 = 4;
			break;
			}	
			System.out.println("pas encore");
		}
		while(prop1 == q.getReponse());
		System.out.println("fait, 2ème");
		
		do{
			choix = (int) (Math.random()*4);
			System.out.println(choix);
			
			switch(choix){
			case 0 : prop2 = 1;
			break;
			case 1 : prop2 = 2;
			break;
			case 2 : prop2 = 3;
			break;
			case 3 : prop2 = 4;
			break;
			}	
			System.out.println("deuxième pas encore");
		}
		while(prop2 == q.getReponse() || prop2 == prop1);
		System.out.println("fait");
		
//		q.enleverProposition(prop1);
//		q.enleverProposition(prop2);
		if(prop1 == 1 || prop2 == 1)
			b1.setEnabled(false);
		if(prop1 == 2 || prop2 == 2)
			b2.setEnabled(false);
		if(prop1 == 3 || prop2 == 3)
			b3.setEnabled(false);
		if(prop1 == 4 || prop2 == 4)
			b4.setEnabled(false);
System.out.println("fini");

	}



	public void joker42(ScoreNormal sn){
		this.setDispo(false);
		sn.miseAJourScore();

	}

	public boolean isDispo() {
		return dispo;
	}

	public void setDispo(boolean dispo) {
		this.dispo = dispo;
	}

}
