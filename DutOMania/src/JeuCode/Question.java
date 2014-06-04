package JeuCode;

import java.util.Arrays;

public class Question {
	private int idQuestion;
	private String intituleQuestion;
	private String[] propositions = new String[4];
	private int reponse;
	private String theme;
	
	public Question(int idQuestion, String intituleQuestion,
			String[] propositions, int reponse, String theme) {
		super();
		this.idQuestion = idQuestion;
		this.intituleQuestion = intituleQuestion;
		this.propositions = propositions;
		this.reponse = reponse;
		this.theme = theme;
	}

	public boolean checkReponse(int reponse){
		if(reponse == this.getReponse()){
			return true;
		}
		else {
			return false;
		}
	}

	public int getIdQuestion() {
		return idQuestion;
	}

	public String getIntituleQuestion() {
		return intituleQuestion;
	}

	public String getProposition(int numProp) {
		return this.propositions[numProp];
	}

	public int getReponse() {
		return reponse;
	}

	public String getTheme() {
		return theme;
	}

	@Override
	public String toString() {
		return "Question [idQuestion=" + idQuestion + ", intituleQuestion="
				+ intituleQuestion + ", propositions="
				+ Arrays.toString(propositions) + ", reponse=" + reponse
				+ ", theme=" + theme + "]";
	}
	
}
