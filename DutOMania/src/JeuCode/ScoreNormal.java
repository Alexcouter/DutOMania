package JeuCode;

public class ScoreNormal extends Score {
	
	private int totalScore;
	
	public ScoreNormal() {
		super();
		this.totalScore = 20;
	}
	
	public void miseAJourScore(){
		this.setScore(this.getScore() + 1);
	}

	
	
	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}
}
