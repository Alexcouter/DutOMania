package JeuCode;

public class Joker {

	private String nom;
	private boolean dispo;

	public Joker(String nom, boolean dispo) {
		super();
		this.nom = nom;
		this.dispo = dispo;
	}


	public void jokerMoitMoit (Question q){
		int prop1 = 0;
		int prop2 = 0;
		int choix;

		this.setDispo(false);
		do{
			choix = (int) Math.random()*4;
			
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
		}
		while(prop1 == q.getReponse());
		
		do{
			choix = (int) Math.random()*4;
			
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
		}
		while(prop2 == q.getReponse() || prop2 == prop1);
		
		q.enleverProposition(prop1);
		q.enleverProposition(prop2);


	}



	public void joker42(ScoreNormal sn){
		this.setDispo(false);
		sn.miseAJourScore(sn);

	}

	public boolean isDispo() {
		return dispo;
	}

	public void setDispo(boolean dispo) {
		this.dispo = dispo;
	}

}
