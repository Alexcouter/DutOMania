package JeuCode;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
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

public class ListeQuestions {
	private ArrayList<Question> listeQuestions;

	public ListeQuestions() {
		super();
		listeQuestions = new ArrayList<Question>() ;
		System.out.println(getNombreQuestionsXML());
		for(int i = 0; i < getNombreQuestionsXML(); i++){
			System.out.println(i+" tour de boucle contructeur");
			ajouterQuestion(getQuestionXML(i));
			System.out.println(listeQuestions.get(i).getIntituleQuestion());
			
		}
		
	}
	public void supprimerQuestion(Question q){
		listeQuestions.remove(q);
		
	}
	
	public void ajouterQuestion(Question q){
		listeQuestions.add(q);
	}
	
	public Question getQuestion(int id){
		return listeQuestions.get(id);
	}
	
	public int getNombreQuestions(){
		return listeQuestions.size();
	}
	
	public Question getQuestionAleatoire(){
		Random r = new Random();
		int id = 1 + r.nextInt(getNombreQuestions() - 1);
//		int id = (int) (Math.random()*getNombreQuestionsXML()+1);
		return listeQuestions.get(id);
	}

	// Méthode retournant une question indentifiée par son id
	public Question getQuestionXML(int id) {
		final DocumentBuilderFactory factory = DocumentBuilderFactory
				.newInstance();
		Question res = null;
		System.out.println(id+" passé gans le getter");
		if(id > getNombreQuestionsXML() || id == 0){
			System.out.println("Erreur");
		}
		try {
			// Création d'un parseur
			DocumentBuilder builder = factory.newDocumentBuilder();

			// Création d'un objet de type Document contenant le fichier XML
			Document document = builder.parse(new File("src/questions.xml"));

			// Récupération de l'élément racine du document pour pouvoir
			// naviguer dedans
			Element racine = document.getDocumentElement();

			// Récupération de la liste des noeuds fils de questions (depuis
			// l'élément
			// racine);
			NodeList questionNoeuds = racine.getElementsByTagName("question");

			// Recupération de la question située au noeud passé en paramètre

			Element question = (Element) questionNoeuds.item(id);

			// Récupération de l'intitule de la question
			Element intitule = (Element) question.getElementsByTagName(
					"intitule").item(0);

			String intituleStr = intitule.getTextContent();

			// Recuperation des quatre propositions dans un tableau
			NodeList propositionsNoeuds = question
					.getElementsByTagName("proposition");

			String[] propositionsTab = new String[4];

			for (int i = 0; i < propositionsNoeuds.getLength(); i++) {
				Element proposition = (Element) question.getElementsByTagName(
						"proposition").item(i);
				propositionsTab[i] = proposition.getTextContent();
			}

			// Récuperation de l'id de la réponse
			Element reponse = (Element) question
					.getElementsByTagName("reponse").item(0);

			int reponseInt = Integer.parseInt(reponse.getTextContent());

			// Récupération du thème de la question
			String themeStr = question.getAttribute("theme");

			// Création d'un objet Question avec les attributs de la question
			// d'id choisi
			res = new Question(id, intituleStr, propositionsTab, reponseInt,
					themeStr);

		} catch (final ParserConfigurationException e) {
			e.printStackTrace();
		} catch (final SAXException e) {
			e.printStackTrace();
		} catch (final IOException e) {
			e.printStackTrace();
		}

		return res;

	}
	
	public static int getNombreQuestionsXML(){
		final DocumentBuilderFactory factory = DocumentBuilderFactory
				.newInstance();
		int res = 0;
		try {
			// Création d'un parseur
			DocumentBuilder builder = factory.newDocumentBuilder();

			// Création d'un objet de type Document contenant le fichier XML
			Document document = builder.parse(new File("src/questions.xml"));

			// Récupération de l'élément racine du document pour pouvoir
			// naviguer dedans
			Element racine = document.getDocumentElement();

			// Récupération de la liste des noeuds fils de questions (depuis
			// l'élément
			// racine);
			NodeList questionNoeuds = racine.getElementsByTagName("question");
			
			res = questionNoeuds.getLength();
		} catch (final ParserConfigurationException e) {
			e.printStackTrace();
		} catch (final SAXException e) {
			e.printStackTrace();
		} catch (final IOException e) {
			e.printStackTrace();
		}
		
		return res;
	}
	

}
