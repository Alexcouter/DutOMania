package JeuCode;

public class ScoreSurvie extends Score{
	
	private int nbVies;
	
	public ScoreSurvie(int nbVies) {
		super();
		this.nbVies = nbVies;
	}

	public void miseAJourScore(ScoreSurvie ss){
		ss.setScore(getScore() + 10);
	}
	
	public void miseAJourVies(ScoreSurvie ss){
		ss.setNbVies(getNbVies() - 1);
	}

	public int getNbVies() {
		return nbVies;
	}

	public void setNbVies(int nbVies) {
		this.nbVies = nbVies;
	}

}
