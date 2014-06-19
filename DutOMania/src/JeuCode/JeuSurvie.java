package JeuCode;

public class JeuSurvie extends Jeu {
	private ScoreSurvie score;
	private int difficulte;
	
	public JeuSurvie(/*ScoreSurvie score*/) {
		super();
		this.score = new ScoreSurvie(0);
//		this.difficulte = 0;
				
	}
	
	
	public void gererVies(){
		score.miseAJourVies();
	}


	public int getDifficulte() {
		return difficulte;
	}


	public void setDifficulte(int difficulte) {
		this.difficulte = difficulte;
		
		switch(this.difficulte){
		case 1 : score.setNbVies(5);
		break;
		
		case 2 : score.setNbVies(3);
		break;
		
		case 3 : score.setNbVies(1);
		}
	}

	
	public int nbVieRestante(){
		return score.getNbVies();
		
	}

	

}
