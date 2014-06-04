package JeuCode;

public class ScoreNormal extends Score {
	
	private int totalScore;
	
	public ScoreNormal(int score) {
		super(score);
		this.totalScore = 20;
	}
	
	public void miseAJourScore(ScoreNormal sn){
		sn.setScore(sn.getScore() + 1);
	}

	
	
	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}
}
