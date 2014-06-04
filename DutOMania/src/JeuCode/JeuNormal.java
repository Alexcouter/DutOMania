package JeuCode;

public class JeuNormal extends Jeu {
	private ScoreNormal score;

	public JeuNormal() {
		super();
		this.score = score;
	}
	
	public void augmenterScore(){
		score.setScore(score.getScore()+1);
	}
	
}
