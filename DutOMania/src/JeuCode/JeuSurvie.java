package JeuCode;

public class JeuSurvie extends Jeu {
	private ScoreSurvie score;
	private int difficulte;
	
	public JeuSurvie(ScoreSurvie score, int difficulte) {
		super();
		this.score = score;
		this.difficulte = difficulte;
		
		switch(this.difficulte){
		case 1 : score = new ScoreSurvie(5);
		break;
		case 2 : score = new ScoreSurvie(3);
		break;
		case 3 : score = new ScoreSurvie(1);
		}
		
	}
	
	
	public void gererScoreSurvie(){
		score.miseAJourScore();
	}

}
