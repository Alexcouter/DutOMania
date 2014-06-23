package JeuCode;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.Random;

public class Jeu {
	private ListeQuestions listeQuestion = new ListeQuestions();
	protected Score score;
	
	public Jeu() {
		super();
		
		
	}
	
	public Question chargerQuestion(){
		return listeQuestion.getQuestionAleatoire();
		
	}
	public void enleverQuestionListe(Question q){
		listeQuestion.supprimerQuestion(q);
	}
	
	public Score getScore() {
		return score;
	}

	
	
	

}