package JeuCode;

public class JeuNormal extends Jeu {

	public JeuNormal() {
		super();
		this.score = new ScoreNormal();
	}
	
//	public void augmenterScore(){
//		if(score instanceof ScoreNormal)
//			((ScoreNormal) score).miseAJourScore();		
//	}
	
	public int totalScore(){
		return 0;
	}
	
}
