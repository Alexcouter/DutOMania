package JeuCode;

public class Joker {

	private String nom;
	private boolean dispo;

	public Joker(String nom, boolean dispo) {
		super();
		this.nom = nom;
		this.dispo = dispo;
	}


//	public void jokerMoitMoit (Question q){
//		String prop1 = null;
//		String prop2 = null;
//		int choix;
//
//		this.setDispo(false);
//		do{
//			choix = (int) Math.random()*4;
//			
//			switch(choix){
//			case 0 : prop1 = q.getProposition1();
//			break;
//			case 1 : prop1 = q.getProposition2();
//			break;
//			case 2 : prop1 = q.getProposition3();
//			break;
//			case 3 : prop1 = q.getProposition4();
//			break;
//			}	
//		}
//		while(prop1 == q.getReponse());
//		
//		do{
//			choix = (int) Math.random()*4;
//			
//			switch(choix){
//			case 0 : prop2 = q.getProposition1();
//			break;
//			case 1 : prop2 = q.getProposition2();
//			break;
//			case 2 : prop2 = q.getProposition3();
//			break;
//			case 3 : prop2 = q.getProposition4();
//			break;
//			}	
//		}
//		while(prop2 == q.getReponse() || prop2 == prop1);
//		
//
//
//	}



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
