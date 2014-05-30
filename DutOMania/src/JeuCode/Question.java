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

	public void checkReponse(){
		
	}

	@Override
	public String toString() {
		return "Question [idQuestion=" + idQuestion + ", intituleQuestion="
				+ intituleQuestion + ", propositions="
				+ Arrays.toString(propositions) + ", reponse=" + reponse
				+ ", theme=" + theme + "]";
	}
	
}
