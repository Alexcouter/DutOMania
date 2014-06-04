package JeuCode;

public class ScoreSurvie extends Score{
	
	private int nbVies;
	
	public ScoreSurvie(int nbVies) {
		super();
		this.nbVies = nbVies;
	}

	public void miseAJourScore(){
		this.setScore(this.getScore() + 10);
	}
	
	public void miseAJourVies(){
		this.setNbVies(this.getNbVies() - 1);
	}

	public int getNbVies() {
		return nbVies;
	}

	public void setNbVies(int nbVies) {
		this.nbVies = nbVies;
	}

}
